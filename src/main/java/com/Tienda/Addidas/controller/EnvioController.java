package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.EnvioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.Tienda.Addidas.model.Envio;

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
@RequestMapping("api/envio")
@Tag(name="Envio", description = "Operaciones Relacionadas con los envios")
public class EnvioController {
    @Autowired 
    private EnvioService service;


    
    @GetMapping 
    @Operation(summary = "Listar Envios", description = "Lista todos los envios de la base de datos")
    public List<Envio> listarTodos(){ 
        return service.listarTodos(); 
    }
    

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Envio", description = "Busca un envio por su id")
    public Envio findbyId(@PathVariable Long id){
        return service.buscarPorId(id);
    }


    @PostMapping
    @Operation(summary="Crear Envio",description = "Crea un Envio en la base de datos")
    public Envio createEnvio (@RequestBody Envio env){
        return service.guardar(env);
    }


    @PutMapping("/id")
    @Operation(summary = "Actualizar Envio", description = "Actualiza un Envio existente en la base de datos con su id")
    public Envio updateEnvio (@PathVariable Long id, @RequestBody Envio Nuevoenvio){
        return service.actualizar(id, Nuevoenvio);
    }

    @Operation (summary = "Borrar Envio", description = "Borra un Envio de la base de datos")
    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}