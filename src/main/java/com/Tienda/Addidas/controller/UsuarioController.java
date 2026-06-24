package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.UsuarioService;
import com.Tienda.Addidas.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;





@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    @Autowired private UsuarioService service;
    @GetMapping public List<Usuario> listarTodos(){ return service.listarTodos(); }
    
    @PostMapping public ResponseEntity<Usuario> guardar(@RequestBody Usuario u){
        return ResponseEntity.status(201).body(service.guardar(u));
    }

    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}