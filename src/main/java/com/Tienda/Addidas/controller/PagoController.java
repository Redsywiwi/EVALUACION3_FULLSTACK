package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.PagoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.Cliente;
import com.Tienda.Addidas.model.Pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;





@RestController
@RequestMapping("api/pago")
@Tag(name = "Pago", description = "Operaciones relacionadas a los Pagos")
public class PagoController {
    @Autowired 
    private PagoService service;


    @Operation(summary = "Listar Pagos", description = "Lista todos los pagos que existen en la base de datos")
    @GetMapping 
    public List<Pago> listarTodos(){ 
        return service.listarTodos(); 
    }
    

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Pago", description = "Busca un pago por su id")
    public Pago findbyId(@PathVariable Long id){
        return service.buscarPorId(id);
    }


    @PostMapping
    @Operation(summary="Crear Pago",description = "Crea un pago en la base de datos")
    public Pago createpPago (@RequestBody Pago pag){
        return service.guardar(pag);
    }


    @PutMapping("/id")
    @Operation(summary = "Actualizar Pago", description = "Actualiza un pago existente en la base de datos con su id")
    public Pago updatepPago (@PathVariable Long id, @RequestBody Pago nuevPago){
        return service.actualizar(id, nuevPago);
    }

    @Operation (summary = "Borrar Pago", description = "Borra un pago de la base de datos")
    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
