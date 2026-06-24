package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.InventarioService;
import com.Tienda.Addidas.model.Inventario;

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
@RequestMapping("api/inventario")
public class InventarioController {
    @Autowired private InventarioService service;
    @GetMapping public List<Inventario> listarTodos(){ return service.listarTodos(); }
    
    @PostMapping public ResponseEntity<Inventario> guardar(@RequestBody Inventario i){
        return ResponseEntity.status(201).body(service.guardar(i));
    }

    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}