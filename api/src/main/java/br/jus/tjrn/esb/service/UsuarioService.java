package br.jus.tjrn.esb.service;

import br.jus.tjrn.esb.entity.Usuario;
import br.jus.tjrn.esb.repository.UsuarioRepository;
import br.jus.tjrn.esb.security.model.factory.UserFactory;
import br.jus.tjrn.esb.security.model.security.SecUser;
import br.jus.tjrn.esb.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
    
    @Transactional(readOnly = true)
    public List<Usuario> getList(String nome) {
        return usuarioRepository.findByUsername(nome, new Sort(Sort.Direction.DESC, "username"));
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
    
    public Usuario getUsuarioLogado() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
          return null;
        }
        
        Long id = ((SecUser) authentication.getPrincipal()).getId();

        return usuarioRepository.findById(id);
    }

}
