package com.vtsoft.vts.service;

import com.vtsoft.vts.model.Producto;
import com.vtsoft.vts.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public Producto saveProducto(Producto producto){

        return productoRepository.save(producto);
    }

    public Producto updateProducto(Producto producto){
        return  productoRepository.save(producto);
    }

    public List<Producto> getAllProducto(){
        return productoRepository.findAll();
    }

    public Producto findByIdProducto(Long idProducto){
        return productoRepository.findByIdProducto(idProducto);
    }

    public void deleteProductoById(Long id){
        productoRepository.deleteById(id);
    }
}
