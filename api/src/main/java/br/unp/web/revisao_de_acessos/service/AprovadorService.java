package br.unp.web.revisao_de_acessos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unp.web.revisao_de_acessos.entity.Aprovador;
import br.unp.web.revisao_de_acessos.repository.AprovadorRepository;

@Service
public class AprovadorService {

    private final AprovadorRepository aprovadorRepository;

    @Autowired
    public AprovadorService(AprovadorRepository aprovadorRepository) {
        this.aprovadorRepository = aprovadorRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Aprovador aprovador){
    	aprovadorRepository.save(aprovador);
    }
    
    @Transactional(readOnly = true)
    public List<Aprovador> getList() {
        return aprovadorRepository.findAll();
    }

}
