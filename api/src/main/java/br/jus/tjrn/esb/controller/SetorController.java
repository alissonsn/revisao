package br.jus.tjrn.esb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tjrn.esb.entity.Setor;
import br.jus.tjrn.esb.service.SetorService;

/**
 * 
 * @author Alisson Nascimento
 *
 */
@RestController
@RequestMapping("api/setor")
public class SetorController {
    private final SetorService setorService;

    @Autowired
    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @RequestMapping( value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> getList() {
    	return ResponseEntity.ok(setorService.getList());
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody @Valid Setor revisao) {
    	setorService.save(revisao);
        return ResponseEntity.ok(revisao);
    }
    

}
