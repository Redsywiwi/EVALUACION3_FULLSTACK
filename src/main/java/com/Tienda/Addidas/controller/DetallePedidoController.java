package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.DetallePedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.DetallePedido;

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
@RequestMapping("api/detalle-pedido")
@Tag(name= "Detalle Pedidos", description = "Operaciones relacionadas a los Detalles de pedidos")
public class DetallePedidoController {
    @Autowired 
    private DetallePedidoService service;
    
    
    @GetMapping 
    @Operation (summary = "Listar Detalles", description = "Lista todos los detalles existentes en la base de datos")
    public List<DetallePedido> listarTodos(){ 
        return service.listarTodos(); 
    }
    

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Detalle", description = "Busca un detalle por su id")
    public DetallePedido findbyid(@PathVariable Long id){
        return service.buscarPorId(id);
    }


    @PostMapping
    @Operation(summary = "Crear detalle", description = "Crea un detalle para la base de datos")
    public DetallePedido createdetallepPedido(@RequestBody DetallePedido d){
        return service.guardar(d);
    }


    @PutMapping
    @Operation(summary = "Actualizar detalle", description = "Actualiza un detalle existente en la base de datos")
    public DetallePedido updaDetallePedido (@PathVariable Long id, @RequestBody DetallePedido NuevoDetalle){
        return service.actualizar(id, NuevoDetalle);
    }


    @Operation(summary = "Borrar Detalle", description = "Borra un detalle existente de la base de datos")
    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}