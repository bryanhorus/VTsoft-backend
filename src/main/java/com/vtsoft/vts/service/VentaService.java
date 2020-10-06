package com.vtsoft.vts.service;

import com.vtsoft.vts.model.Venta;
import com.vtsoft.vts.repository.OrdenRepository;
import com.vtsoft.vts.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    public Venta saveVenta(Venta venta){

        return ventaRepository.save(venta);
    }

    public Venta updateVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    public List<Venta> getAllVenta(){
        return ventaRepository.findAll();
    }

    public Venta findByIdVenta(Long idVenta){
        return ventaRepository.findByIdVenta(idVenta);
    }

    public void deleteVentaById(Long id){
        ventaRepository.deleteById(id);
    }

}
