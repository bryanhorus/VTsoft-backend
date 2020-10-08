package com.vtsoft.vts.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_orden")
    List<Orden> orden;

    @Column(name = "total")
    private Double total;

    @Column(name = "fecha_v")
    private Instant fecha;

    public Venta() {
        orden = new ArrayList<Orden>();
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public List<Orden> getOrden() {
        return orden;
    }

    public void addOrden(Orden item){
        orden.add(item);
    }

    public void setOrden(List<Orden> orden) {
        this.orden = orden;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Double getTotalv(){

        for (Orden ordenproducto : orden) {
            total += ordenproducto.calcularImporte();
        }
        return total;
    }
}
