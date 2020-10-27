package com.vtsoft.vts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long idOrden;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    private Instant fecha;

    @Column(name = "cant")
    private Integer cantidad;

    @ManyToMany
    @JoinTable(name = "orden_producto"
    ,joinColumns = @JoinColumn(name = "fk_orden")
    ,inverseJoinColumns = @JoinColumn(name = "fk_producto"))
    private Set<Producto> producto;



    public Orden() {
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


    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }

   /* public Double calcularImporte(){

        for (Producto product : producto) {

            importe = cantidad.doubleValue() * product.getValor();
        }
        return importe ;
    }*/

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
