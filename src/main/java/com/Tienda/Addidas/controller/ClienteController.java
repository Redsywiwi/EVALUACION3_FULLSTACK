package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.Cliente;

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
@RequestMapping("api/cliente")
@Tag(name = "Clientes", description = "Operaciones relacionadas a los clientes")
public class ClienteController {
    @Autowired 
    private ClienteService service;


    @GetMapping 
    @Operation(summary = "Listar clientes", description = "Lista a todos los clientes que existen en la base de datos")
    public List<Cliente> listarTodos(){ 
        return service.listarTodos(); 
    }


    @GetMapping("/{id}")
    @Operation(summary = "Buscar Cliente", description = "Busca un cliente por su id")
    public Cliente findbyId(@PathVariable Long id){
        return service.buscarPorId(id);
    }


    @PostMapping
    @Operation(summary="Crear Cliente",description = "Crea un cliente en la base de datos")
    public Cliente createCliente (@RequestBody Cliente cli){
        return service.guardar(cli);
    }


    @PutMapping("/id")
    @Operation(summary = "Actualizar Cliente", description = "Actualiza un cliente existente en la base de datos con su id")
    public Cliente updatecCliente (@PathVariable Long id, @RequestBody Cliente Nuevocliente){
        return service.actualizar(id, Nuevocliente);
    }


    @Operation (summary = "Borrar Cliente", description = "Borra un cliente de la base de datos")
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
