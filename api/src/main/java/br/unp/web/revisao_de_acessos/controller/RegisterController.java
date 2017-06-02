package br.unp.web.revisao_de_acessos.controller;

import br.unp.web.revisao_de_acessos.entity.Usuario;
import br.unp.web.revisao_de_acessos.service.UsuarioDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/register")
public class RegisterController {
    private final UsuarioDetailsServiceImpl userDetailsService;

    @Autowired
    public RegisterController(UsuarioDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody @Valid Usuario user) {
        userDetailsService.setUser(user);
        return ResponseEntity.ok(user);
    }

}
