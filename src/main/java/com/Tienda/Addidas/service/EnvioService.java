package com.Tienda.Addidas.service;
import com.Tienda.Addidas.model.Envio;
import com.Tienda.Addidas.repository.EnvioRepository;
import com.Tienda.Addidas.exception.EnvioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> listarTodos() {
        return envioRepository.findAll();
    }

    public Envio buscarPorId(Long id) {
        return envioRepository.findById(id)
                .orElseThrow(() -> new EnvioNotFoundException("Envio no encontrado con ID: " + id));
    }

    public Envio guardar(Envio env) {
        return envioRepository.save(env);
    }

    public Envio actualizar(Long id, Envio Nuevoenvio) {
        Envio existente = buscarPorId(id);
        existente.setId(Nuevoenvio.getId());
        existente.setEstado(Nuevoenvio.getEstado());
        existente.setDireccion(Nuevoenvio.getDireccion());
        existente.setFecha(Nuevoenvio.getFecha());
        return envioRepository.save(existente);
    }

    public void eliminar(Long id) {
        Envio existente = buscarPorId(id);
        envioRepository.delete(existente);
    }
}