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

import br.unp.web.revisao_de_acessos.entity.Revisao;
import br.unp.web.revisao_de_acessos.service.RevisaoService;

/**
 * 
 * @author Alisson Nascimento
 *
 */
@RestController
@RequestMapping("api/revisao")
public class RevisaoController {
    private final RevisaoService revisaoService;

    @Autowired
    public RevisaoController(RevisaoService revisaoServiceImpl) {
        this.revisaoService = revisaoServiceImpl;
    }
    
    @RequestMapping( value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> getList() {
    	return ResponseEntity.ok(revisaoService.getList());
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody @Valid Revisao revisao) {
    	revisaoService.save(revisao);
        return ResponseEntity.ok(revisao);
    }

}
