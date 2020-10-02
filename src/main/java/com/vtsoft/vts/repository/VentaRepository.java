package com.vtsoft.vts.repository;

import com.vtsoft.vts.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            "id_Venta, " +
            "total, " +
            "fecha_v, " +
            "fk_orden_id " +
            "FROM venta " +
            "WHERE id_Venta =:idVenta")
    Venta findByIdVenta(@Param(value = "idVenta") Long idVenta);

}
