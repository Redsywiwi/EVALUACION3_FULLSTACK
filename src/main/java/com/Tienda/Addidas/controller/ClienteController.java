package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.ClienteService;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.Cliente;

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
@RequestMapping("api/cliente")
@Tag(name = "Clientes", description = "Operaciones relacionadas a los clientes")
public class ClienteController {
    @Autowired private ClienteService service;
    @GetMapping public List<Cliente> listarTodos(){ return service.listarTodos(); }
    
    @PostMapping public ResponseEntity<Cliente> guardar(@RequestBody Cliente cl){
        return ResponseEntity.status(201).body(service.guardar(cl));
    }

    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
