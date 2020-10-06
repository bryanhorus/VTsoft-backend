package com.vtsoft.vts.repository;

import com.vtsoft.vts.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

    Producto  getByIdProducto(Long id);
}
