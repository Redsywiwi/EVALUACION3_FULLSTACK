package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.EnvioService;
import com.Tienda.Addidas.model.Envio;

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
@RequestMapping("api/envio")
public class EnvioController {
    @Autowired private EnvioService service;
    @GetMapping public List<Envio> listarTodos(){ return service.listarTodos(); }
    
    @PostMapping public ResponseEntity<Envio> guardar(@RequestBody Envio e){
        return ResponseEntity.status(201).body(service.guardar(e));
    }

    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}