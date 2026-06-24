package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.Cliente;
import com.Tienda.Addidas.model.Pedido;

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
@RequestMapping("api/pedido")
@Tag(name = "Pedidos", description = "Operaciones relacionadas a los pedidos")
public class PedidoController {
    @Autowired 
    private PedidoService service;


    @GetMapping 
    @Operation(summary = "Listar Pedidos", description = "Lista a todos los pedidos que existen en la base de datos")
    public List<Pedido> listarTodos(){ 
        return service.listarTodos(); 
    }
    

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pedidos", description = "Busca un pedido por su id")
    public Pedido findbyId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary="Crear Pedido",description = "Crea un pedido en la base de datos")
    public Pedido createPedido(@RequestBody Pedido pe){
        return service.guardar(pe);
    }


    @PutMapping("/id")
    @Operation(summary = "Actualizar Pedido", description = "Actualiza un pedido existente en la base de datos con su id")
    public Pedido updatePedido (@PathVariable Long id, @RequestBody Pedido nuevPedido){
        return service.actualizar(id, nuevPedido);
    }

    @Operation (summary = "Borrar Pedido", description = "Borra un pedido de la base de datos")
    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}