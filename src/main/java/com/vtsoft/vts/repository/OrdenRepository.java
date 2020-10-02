package com.vtsoft.vts.repository;

import com.vtsoft.vts.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository  extends JpaRepository<Orden , Long> {

    Orden getByIdOrden(Long id);
}
