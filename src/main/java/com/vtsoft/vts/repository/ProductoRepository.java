package com.vtsoft.vts.repository;

import com.vtsoft.vts.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            "id_producto, " +
            "descripcion, " +
            "cantidad, " +
            "img_url, " +
            "valor " +
            "FROM producto " +
            "WHERE id_producto =:idProducto")
    Producto findByIdProducto(@Param(value = "idProducto") Long idProducto);

    Producto  getByIdProducto(Long id);
}
