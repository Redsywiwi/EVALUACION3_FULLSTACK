package com.Tienda.Addidas.service;
import com.Tienda.Addidas.model.Categoria;
import com.Tienda.Addidas.repository.CategoriaRepository;
import com.Tienda.Addidas.exception.CategoriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException("Categoria no encontrada con ID: " + id));
    }

    public Categoria guardar(Categoria cat) {
        return categoriaRepository.save(cat);
    }

    public Categoria actualizar(Long id, Categoria Nuevacategoria) {
        Categoria existente = buscarPorId(id);
        existente.setId(Nuevacategoria.getId());
        existente.setNombre(Nuevacategoria.getNombre());
        existente.setDescripcion(Nuevacategoria.getDescripcion());
        return categoriaRepository.save(existente);
    }

    public void eliminar(Long id) {
        Categoria existente = buscarPorId(id);
        categoriaRepository.delete(existente);
    }
}