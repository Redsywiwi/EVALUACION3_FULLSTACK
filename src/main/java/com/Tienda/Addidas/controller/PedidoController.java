package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.PedidoService;
import com.Tienda.Addidas.model.Pedido;

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
@RequestMapping("api/pedido")
public class PedidoController {
    @Autowired private PedidoService service;
    @GetMapping public List<Pedido> listarTodos(){ return service.listarTodos(); }
    
    @PostMapping public ResponseEntity<Pedido> guardar(@RequestBody Pedido pe){
        return ResponseEntity.status(201).body(service.guardar(pe));
    }

    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}