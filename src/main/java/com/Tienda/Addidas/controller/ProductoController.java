package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.Cliente;
import com.Tienda.Addidas.model.Producto;

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
@Tag(name = "Producto", description = "Operaciones relacionadas a los productos")
@RequestMapping("api/producto")
public class ProductoController {
    @Autowired 
    private ProductoService service;



    @GetMapping 
    @Operation(summary = "Listar Productos", description = "Lista a todos los productos que existen en la base de datos")
    public List<Producto> listarTodos(){ 
        return service.listarTodos(); 
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Producto", description = "Busca un producto por su id")
    public Producto findbyId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary="Crear Producto",description = "Crea un producto en la base de datos")
    public Producto createProducto (@RequestBody Producto pro){
        return service.guardar(pro);
    }

    @PutMapping("/id")
    @Operation(summary = "Actualizar Producto", description = "Actualiza un producto existente en la base de datos con su id")
    public Producto updateProducto (@PathVariable Long id, @RequestBody Producto NuevoProducto){
        return service.actualizar(id, NuevoProducto);
    }

    @Operation (summary = "Borrar Producto", description = "Borra un Producto de la base de datos")
    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}