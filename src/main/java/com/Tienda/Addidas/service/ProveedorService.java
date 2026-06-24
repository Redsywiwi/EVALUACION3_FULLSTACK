package com.Tienda.Addidas.service;
import com.Tienda.Addidas.model.Proveedor;
import com.Tienda.Addidas.repository.ProveedorRepository;
import com.Tienda.Addidas.exception.ProveedorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    public Proveedor buscarPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new ProveedorNotFoundException("Proveedor no encontrado con ID: " + id));
    }

    public Proveedor guardar(Proveedor provee) {
        return proveedorRepository.save(provee);
    }

    public Proveedor actualizar(Long id, Proveedor NuevoProveedor) {
        Proveedor existente = buscarPorId(id);
        existente.setId(NuevoProveedor.getId());
        existente.setDireccion(NuevoProveedor.getDireccion());
        existente.setNombre(NuevoProveedor.getNombre());
        existente.setRut(NuevoProveedor.getRut());
        return proveedorRepository.save(existente);
    }

    public void eliminar(Long id) {
        Proveedor existente = buscarPorId(id);
        proveedorRepository.delete(existente);
    }
}
