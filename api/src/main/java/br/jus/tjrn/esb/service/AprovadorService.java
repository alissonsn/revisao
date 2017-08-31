package br.jus.tjrn.esb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.jus.tjrn.esb.entity.Aprovador;
import br.jus.tjrn.esb.repository.AprovadorRepository;

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
