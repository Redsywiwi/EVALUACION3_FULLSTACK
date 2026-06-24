package com.Tienda.Addidas.service;
import com.Tienda.Addidas.model.Pago;
import com.Tienda.Addidas.repository.PagoRepository;
import com.Tienda.Addidas.exception.PagoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    public Pago buscarPorId(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new PagoNotFoundException("Pago no encontrado con ID: " + id));
    }

    public Pago guardar(Pago pag) {
        return pagoRepository.save(pag);
    }

    public Pago actualizar(Long id, Pago NuevoPago) {
        Pago existente = buscarPorId(id);
        existente.setId(NuevoPago.getId());
        existente.setMonto(NuevoPago.getMonto());
        return pagoRepository.save(existente);
    }

    public void eliminar(Long id) {
        Pago existente = buscarPorId(id);
        pagoRepository.delete(existente);
    }
}