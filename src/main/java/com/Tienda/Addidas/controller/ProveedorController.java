package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.ProveedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.Cliente;
import com.Tienda.Addidas.model.Proveedor;

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
@RequestMapping("api/proveedor")
@Tag(name = "Proveedor", description = "Operaciones relacionadas a los proveedores")
public class ProveedorController {
    @Autowired 
    private ProveedorService service;


    @Operation(summary = "Listar proveedores", description = "Lista a todos los proveedores que existen en la base de datos")
    @GetMapping 
    public List<Proveedor> listarTodos(){ 
        return service.listarTodos(); 
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Buscar proveedor", description = "Busca un proveedor por su id")
    public Proveedor findbyId(@PathVariable Long id){
        return service.buscarPorId(id);
    }


    @PostMapping
    @Operation(summary="Crear Proveedor",description = "Crea un proveedor en la base de datos")
    public Proveedor createProveedor (@RequestBody Proveedor provee){
        return service.guardar(provee);
    }


    @PutMapping("/id")
    @Operation(summary = "Actualizar Proveedor", description = "Actualiza un Proveedor existente en la base de datos con su id")
    public Proveedor updateProveedor (@PathVariable Long id, @RequestBody Proveedor nuevoProveedor){
        return service.actualizar(id, nuevoProveedor);
    }


    @Operation (summary = "Borrar Proveedor", description = "Borra un proveedor de la base de datos")
    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}