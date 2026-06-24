package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.ProductoService;
import com.Tienda.Addidas.model.Producto;

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
@RequestMapping("api/producto")
public class ProductoController {
    @Autowired private ProductoService service;
    @GetMapping public List<Producto> listarTodos(){ return service.listarTodos(); }
    
    @PostMapping public ResponseEntity<Producto> guardar(@RequestBody Producto pro){
        return ResponseEntity.status(201).body(service.guardar(pro));
    }

    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}