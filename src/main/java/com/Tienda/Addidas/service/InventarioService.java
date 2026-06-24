package com.Tienda.Addidas.service;
import com.Tienda.Addidas.model.Inventario;
import com.Tienda.Addidas.repository.InventarioRepository;
import com.Tienda.Addidas.exception.InventarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> listarTodos() {
        return inventarioRepository.findAll();
    }

    public Inventario buscarPorId(Long id) {
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new InventarioNotFoundException("Inventario no encontrado con ID: " + id));
    }

    public Inventario guardar(Inventario inv) {
        return inventarioRepository.save(inv);
    }

    public Inventario actualizar(Long id, Inventario NuevoInventario) {
        Inventario existente = buscarPorId(id);
        existente.setId(NuevoInventario.getId());
        existente.setCantidad(NuevoInventario.getCantidad());
        existente.setNombre(NuevoInventario.getNombre());
        existente.setProveedor(NuevoInventario.getProveedor());
        return inventarioRepository.save(existente);
    }

    public void eliminar(Long id) {
        Inventario existente = buscarPorId(id);
        inventarioRepository.delete(existente);
    }
}