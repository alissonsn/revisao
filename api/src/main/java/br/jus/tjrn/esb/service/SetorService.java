package br.jus.tjrn.esb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.jus.tjrn.esb.entity.Setor;
import br.jus.tjrn.esb.repository.SetorRepository;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    @Autowired
    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Setor setor){
        setorRepository.save(setor);
    }
    
    @Transactional(readOnly = true)
    public List<Setor> getList() {
        return setorRepository.findAll();
    }

}
