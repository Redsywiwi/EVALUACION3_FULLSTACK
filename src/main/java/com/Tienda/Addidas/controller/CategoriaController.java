package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.Categoria;

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
@RequestMapping("api/categoria")
@Tag(name = "Categorias", description = "Operaciones relacionadas a las categorias")
public class CategoriaController {
    @Autowired private CategoriaService service;

    @GetMapping
    @Operation(summary = "Listar todas las categorias", description = "Obtiene todas las categorias presentes en la base de datos")
    public List<Categoria> listarTodos(){
        return service.listarTodos(); 
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Categoria", description = "Obtiene una categoria especifica en base a su id")
    public Categoria findById(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Crear Categoria", description = "Crea una categoria")
    public Categoria createCategoria(@RequestBody Categoria c){
        return service.guardar(c);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Categoria", description = "Actualiza una categoria existente con su id")
    public Categoria updateCategoria(@PathVariable Long id, @RequestBody Categoria Nuevacategoria) {
        return service.actualizar(id, Nuevacategoria);
    }

    @Operation(summary = "Borrar categoria", description = "Borra la categoria especificada de la base de datos")
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
