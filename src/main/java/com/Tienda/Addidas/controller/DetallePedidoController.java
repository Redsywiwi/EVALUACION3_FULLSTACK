package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.DetallePedidoService;
import com.Tienda.Addidas.model.DetallePedido;

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
@RequestMapping("api/detalle-pedido")
public class DetallePedidoController {
    @Autowired private DetallePedidoService service;
    @GetMapping public List<DetallePedido> listarTodos(){ return service.listarTodos(); }
    
    @PostMapping public ResponseEntity<DetallePedido> guardar(@RequestBody DetallePedido d){
        return ResponseEntity.status(201).body(service.guardar(d));
    }

    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}