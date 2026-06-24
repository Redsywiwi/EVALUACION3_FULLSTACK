package com.Tienda.Addidas.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Tienda.Addidas.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
