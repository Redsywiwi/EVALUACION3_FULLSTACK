package com.Tienda.Addidas.service;
import com.Tienda.Addidas.model.DetallePedido;
import com.Tienda.Addidas.repository.DetallePedidoRepository;
import com.Tienda.Addidas.exception.DetallePedidoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> listarTodos() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedido buscarPorId(Long id) {
        return detallePedidoRepository.findById(id)
                .orElseThrow(() -> new DetallePedidoNotFoundException("Detalle no encontrada con ID: " + id));
    }

    public DetallePedido guardar(DetallePedido detped) {
        return detallePedidoRepository.save(detped);
    }

    public DetallePedido actualizar(Long id, DetallePedido NuevoDetalle) {
        DetallePedido existente = buscarPorId(id);
        existente.setId(NuevoDetalle.getId());
        existente.setNombre(NuevoDetalle.getNombre());
        existente.setFecha(NuevoDetalle.getFecha());
        return detallePedidoRepository.save(existente);
    }

    public void eliminar(Long id) {
        DetallePedido existente = buscarPorId(id);
        detallePedidoRepository.delete(existente);
    }
}
