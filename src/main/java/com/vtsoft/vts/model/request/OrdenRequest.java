package com.vtsoft.vts.model.request;

import com.vtsoft.vts.model.Producto;

import java.time.Instant;
import java.util.List;

public class  OrdenRequest {


    private Long idOrden;

    private String estado;

    private Instant fecha;

    private List<Producto> producto;

    public OrdenRequest() {
        //constructor
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
}
