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

import br.unp.web.revisao_de_acessos.entity.Aprovador;
import br.unp.web.revisao_de_acessos.service.AprovadorService;

/**
 * 
 * @author Alisson Nascimento
 *
 */
@RestController
@RequestMapping("api/aprovador")
public class AprovadorController {
    private final AprovadorService aprovadorService;

    @Autowired
    public AprovadorController(AprovadorService setorService) {
        this.aprovadorService = setorService;
    }

    @RequestMapping( value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> getList() {
    	return ResponseEntity.ok(aprovadorService.getList());
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody @Valid Aprovador aprovador) {
    	aprovadorService.save(aprovador);
        return ResponseEntity.ok(aprovador);
    }
    
}
