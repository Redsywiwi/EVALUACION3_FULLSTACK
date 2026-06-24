package com.Tienda.Addidas.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Tienda.Addidas.model.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {

}
