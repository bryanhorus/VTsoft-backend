package com.vtsoft.vts.service;

import com.vtsoft.vts.model.Orden;
import com.vtsoft.vts.repository.OrdenRepository;
import com.vtsoft.vts.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Orden saveOrden(Orden orden){

        return ordenRepository.save(orden);
    }

    public Orden updateOrden(Orden orden){
        return  ordenRepository.save(orden);
    }

    public List<Orden> getAllOrden(){
        return ordenRepository.findAll();
    }

    public Orden findByIdOrden(Long idOrden){
        return ordenRepository.findByIdOrden(idOrden);
    }

    public void deleteOrdenById(Long id){
        ordenRepository.deleteById(id);
    }
}
