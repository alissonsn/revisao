package br.jus.tjrn.esb.controller;

import br.jus.tjrn.esb.entity.Usuario;
import br.jus.tjrn.esb.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UsuarioController {
    private final UsuarioService userDetailsService;

    @Autowired
    public UsuarioController(UsuarioService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> getList() {
        return ResponseEntity.ok(userDetailsService.getList());
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid Usuario user) {
        userDetailsService.save(user);
        return ResponseEntity.ok(user);
    }


    @RequestMapping(value = "update/password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePass(@RequestBody @Valid Usuario user) {
        userDetailsService.updatePassword(user);
        return ResponseEntity.ok(user);
    }


    @RequestMapping(value = "{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok(userDetailsService.getUser(username));
    }




}
