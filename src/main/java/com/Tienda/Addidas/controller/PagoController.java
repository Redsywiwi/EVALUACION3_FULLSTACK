package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.PagoService;
import com.Tienda.Addidas.model.Pago;

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
@RequestMapping("api/pago")
public class PagoController {
    @Autowired private PagoService service;
    @GetMapping public List<Pago> listarTodos(){ return service.listarTodos(); }
    
    @PostMapping public ResponseEntity<Pago> guardar(@RequestBody Pago p){
        return ResponseEntity.status(201).body(service.guardar(p));
    }

    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
