package com.vtsoft.vts.model.request;

import com.vtsoft.vts.model.Orden;

import java.time.Instant;

public class VentaRequest {

    private Long idVenta;

    private Orden orden;

    private Double total;

    private Instant fecha;

    public VentaRequest() {
        //constructor
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }
}
