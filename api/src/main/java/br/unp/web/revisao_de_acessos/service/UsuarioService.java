package br.unp.web.revisao_de_acessos.service;

import br.unp.web.revisao_de_acessos.entity.Usuario;
import br.unp.web.revisao_de_acessos.repository.UsuarioRepository;
import br.unp.web.revisao_de_acessos.security.model.factory.UserFactory;
import br.unp.web.revisao_de_acessos.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository userRepository) {
        this.usuarioRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserFactory.create(getUser(username));
    }

    @Transactional(readOnly = true)
    public Usuario getUser(String username) {
        Usuario user;
        if (username.equalsIgnoreCase("admin")) {
            user = getAdmin();
        } else {
            user = usuarioRepository.findByUsername(username);
        }
        if(user==null){
            throw new RuntimeException("Usuario ("+username+") não foi encontrado");
        }
        return user;
    }

    private Usuario getAdmin() {
        Usuario user = new Usuario();
        user.setUsername("admin");
        user.setPassword("$2a$10$jbfBfx4zmbtPzgsB0QFudut6cHWUHwYH8spzDVGHldrdbXyKCSWOa");
        user.setAuthorities("ROLE_ADMIN");
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> getList() {
        return usuarioRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Usuario user){
        if(user.getId()==null || user.getId().equals(0)){
            if(usuarioRepository.findByUsername(user.getUsername())!=null || user.getPassword().equalsIgnoreCase("admin")){
                throw new RuntimeException("Login já está em uso");
            }
            user.setPassword(Util.enconder(user.getPassword()));
        }
        
        user.setAuthorities("ROLE_USER");
        usuarioRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePassword(Usuario user){
        user.setLastPasswordReset(new Date());
        user.setPassword(Util.enconder(user.getPassword()));
        usuarioRepository.save(user);
    }

}
