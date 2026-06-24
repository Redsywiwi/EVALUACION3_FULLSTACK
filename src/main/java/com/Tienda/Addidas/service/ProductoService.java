package com.Tienda.Addidas.service;
import com.Tienda.Addidas.model.Producto;
import com.Tienda.Addidas.repository.ProductoRepository;
import com.Tienda.Addidas.exception.ProductoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado con ID: " + id));
    }

    public Producto guardar(Producto pro) {
        return productoRepository.save(pro);
    }

    public Producto actualizar(Long id, Producto NuevoProducto) {
        Producto existente = buscarPorId(id);
        existente.setId(NuevoProducto.getId());
        existente.setCategoria(NuevoProducto.getCategoria());
        existente.setNombre(NuevoProducto.getNombre());
        existente.setPrecio(NuevoProducto.getPrecio());
        existente.setSku(NuevoProducto.getSku());
        return productoRepository.save(existente);
    }

    public void eliminar(Long id) {
        Producto existente = buscarPorId(id);
        productoRepository.delete(existente);
    }
}