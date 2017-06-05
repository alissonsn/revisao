package br.unp.web.revisao_de_acessos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.unp.web.revisao_de_acessos.entity.Setor;
import br.unp.web.revisao_de_acessos.service.SetorService;

/**
 * 
 * @author Alisson Nascimento
 *
 */
@RestController
@RequestMapping("api/aprovador")
public class AprovadorController {
    private final SetorService setorService;

    @Autowired
    public AprovadorController(SetorService setorService) {
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
