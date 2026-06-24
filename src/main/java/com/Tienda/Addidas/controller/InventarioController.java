package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.InventarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.Cliente;
import com.Tienda.Addidas.model.Inventario;

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
@Tag(name = "Inventario", description = "Operaciones relacionadas al Inventario")
@RequestMapping("api/inventario")
public class InventarioController {

    @Autowired 
    private InventarioService service;
    
    @Operation(summary = "Listar Inventario", description = "Lista todo el inventario registrado en la base de datos")   
    @GetMapping 
    public List<Inventario> listarTodos(){ 
        return service.listarTodos(); 
    }


    @GetMapping("/{id}")
    @Operation(summary = "Buscar Inventario", description = "Busca un producto del inventario por su id")
    public Inventario findbyId(@PathVariable Long id){
        return service.buscarPorId(id);
    }


    @PostMapping
    @Operation(summary="Crear Inventario",description = "Crea un producto de inventario")
    public Inventario createInventario (@RequestBody Inventario inv){
        return service.guardar(inv);
    }


    @PutMapping("/id")
    @Operation(summary = "Actualizar Inventario", description = "Actualiza el inventario existente en la base de datos con su id")
    public Inventario updateInventario (@PathVariable Long id, @RequestBody Inventario NuevoInventario){
        return service.actualizar(id, NuevoInventario);
    }

    @Operation (summary = "Borrar Inventario", description = "Borra un producto de inventario de la base de datos")
    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}