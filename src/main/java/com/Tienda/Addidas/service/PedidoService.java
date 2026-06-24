package com.Tienda.Addidas.service;
import com.Tienda.Addidas.model.Pedido;
import com.Tienda.Addidas.repository.PedidoRepository;
import com.Tienda.Addidas.exception.PedidoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException("Pedido no encontrado con ID: " + id));
    }

    public Pedido guardar(Pedido ped) {
        return pedidoRepository.save(ped);
    }

    public Pedido actualizar(Long id, Pedido Nuevopedido) {
        Pedido existente = buscarPorId(id);
        existente.setId(Nuevopedido.getId());
        existente.setCantidad(Nuevopedido.getCantidad());
        existente.setDireccion(Nuevopedido.getDireccion());
        existente.setEstado(Nuevopedido.getEstado());
        return pedidoRepository.save(existente);
    }

    public void eliminar(Long id) {
        Pedido existente = buscarPorId(id);
        pedidoRepository.delete(existente);
    }
}

