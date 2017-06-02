package br.unp.web.revisao_de_acessos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unp.web.revisao_de_acessos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
