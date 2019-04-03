package com.study.almacen.repository;

import com.study.almacen.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findByCodigoProducto(String codigoProducto);
    List<Producto> findAllByActivoTrue();
}
