package br.jus.tjrn.esb.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.tjrn.esb.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findById(Long id);
    public Usuario findByUsername(String username);
    List<Usuario> findByUsername(String username, Sort sort);
}
