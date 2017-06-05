package br.unp.web.revisao_de_acessos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unp.web.revisao_de_acessos.entity.Aprovador;

public interface AprovadorRepository extends JpaRepository<Aprovador, Long> {

}
