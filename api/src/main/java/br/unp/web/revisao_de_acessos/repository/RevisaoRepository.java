package br.unp.web.revisao_de_acessos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unp.web.revisao_de_acessos.entity.Revisao;

public interface RevisaoRepository extends JpaRepository<Revisao, Long> {

}
