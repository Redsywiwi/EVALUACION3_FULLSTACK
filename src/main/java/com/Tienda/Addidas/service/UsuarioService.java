package com.Tienda.Addidas.service;

import com.Tienda.Addidas.model.Usuario;
import com.Tienda.Addidas.repository.UsuarioRepository;
import com.Tienda.Addidas.exception.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con ID: " + id));
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario nuevoUsuario) {
        Usuario existente = buscarPorId(id);
        existente.setId(nuevoUsuario.getId());
        existente.setNombres(nuevoUsuario.getNombres());
        existente.setApellidos(nuevoUsuario.getApellidos());
        existente.setTelefono(nuevoUsuario.getTelefono());
        existente.setCorreo(nuevoUsuario.getCorreo());
        existente.setRut(nuevoUsuario.getRut());
        return usuarioRepository.save(existente);
    }

    public void eliminar(Long id) {
        Usuario existente = buscarPorId(id);
        usuarioRepository.delete(existente);
    }
}