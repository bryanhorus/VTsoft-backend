package com.vtsoft.vts.repository;

import com.vtsoft.vts.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdenRepository  extends JpaRepository<Orden , Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            "id_Orden, " +
            "estado, " +
            "fecha, " +
            "fk_producto_id " +
            "FROM orden " +
            "WHERE id_Orden =:idOrden")
    Orden findByIdOrden(@Param(value = "idOrden") Long idOrden);

    Orden getByIdOrden(Long id);
}
