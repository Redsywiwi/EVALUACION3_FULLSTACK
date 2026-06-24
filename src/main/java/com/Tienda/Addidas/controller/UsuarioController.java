package com.Tienda.Addidas.controller;
import com.Tienda.Addidas.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.Tienda.Addidas.model.Cliente;
import com.Tienda.Addidas.model.Usuario;

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
@RequestMapping("api/usuario")
@Tag(name = "Usuarios", description = "Operaciones relacionadas a los Usuarios")
public class UsuarioController {
    @Autowired 
    private UsuarioService service;
    @GetMapping 


    @Operation(summary = "Listar Usuarios", description = "Lista a todos los usuarios que existen en la base de datos")
    public List<Usuario> listarTodos(){
        return service.listarTodos();
        }
    
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Usuario", description = "Busca un usuario por su id")
    public Usuario findbyId(@PathVariable Long id){
        return service.buscarPorId(id);
    }


    @PostMapping
    @Operation(summary="Crear Usuario",description = "Crea un usuario en la base de datos")
    public Usuario createUsuario (@RequestBody Usuario usuario){
        return service.guardar(usuario);
    }


    @PutMapping("/id")
    @Operation(summary = "Actualizar Usuario", description = "Actualiza un Usuario existente en la base de datos con su id")
    public Usuario updateUsuario (@PathVariable Long id, @RequestBody Usuario nuevoUsuario){
        return service.actualizar(id, nuevoUsuario);
    }

    @Operation (summary = "Borrar Usuario", description = "Borra un usuario de la base de datos")
    @DeleteMapping("/id") public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}