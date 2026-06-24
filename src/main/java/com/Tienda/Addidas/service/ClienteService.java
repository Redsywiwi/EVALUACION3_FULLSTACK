package com.Tienda.Addidas.service;
import com.Tienda.Addidas.model.Cliente;
import com.Tienda.Addidas.repository.ClienteRepository;
import com.Tienda.Addidas.exception.ClienteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado con ID: " + id));
    }

    public Cliente guardar(Cliente cli) {
        return clienteRepository.save(cli);
    }

    public Cliente actualizar(Long id, Cliente Nuevocliente) {
        Cliente existente = buscarPorId(id);
        existente.setId(Nuevocliente.getId());
        existente.setNombres(Nuevocliente.getNombres());
        existente.setApellido(Nuevocliente.getApellido());
        existente.setCorreo(Nuevocliente.getCorreo());
        existente.setRut(Nuevocliente.getRut());
        existente.setContacto(Nuevocliente.getContacto());
        return clienteRepository.save(existente);
    }

    public void eliminar(Long id) {
        Cliente existente = buscarPorId(id);
        clienteRepository.delete(existente);
    }
}