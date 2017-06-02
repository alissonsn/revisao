package br.unp.web.revisao_de_acessos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unp.web.revisao_de_acessos.entity.Revisao;
import br.unp.web.revisao_de_acessos.repository.RevisaoRepository;

@Service
public class RevisaoServiceImpl {

    private final RevisaoRepository revisaoRepository;

    @Autowired
    public RevisaoServiceImpl(RevisaoRepository revisaoRepository) {
        this.revisaoRepository = revisaoRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Revisao revisao){
        revisaoRepository.save(revisao);
    }

}
