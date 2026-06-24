package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.ProveedorService;
import com.Tienda.Addidas.model.Proveedor;

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
@RequestMapping("api/proveedor")
public class ProveedorController {
    @Autowired private ProveedorService service;
    @GetMapping public List<Proveedor> listarTodos(){ return service.listarTodos(); }
    
    @PostMapping public ResponseEntity<Proveedor> guardar(@RequestBody Proveedor prove){
        return ResponseEntity.status(201).body(service.guardar(prove));
    }

    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}