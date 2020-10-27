package com.vtsoft.vts.controller;

import com.vtsoft.vts.exception.ListEmptyException;
import com.vtsoft.vts.exception.ModelFoundException;
import com.vtsoft.vts.exception.ModelNotFoundException;
import com.vtsoft.vts.model.Producto;
import com.vtsoft.vts.model.request.ProductoRequest;
import com.vtsoft.vts.service.ProductoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
@Api(tags = "Producto")
public class ProductoController {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProductoService productoService;

    @PostMapping("/insert")
    @ApiOperation(value = "Insert Producto", response = Producto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public Producto saveProducto(@RequestBody ProductoRequest productoRequest) {

        Producto producto = modelMapper.map(productoRequest, Producto.class);
        return productoService.saveProducto(producto);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update Producto", response = Producto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public Producto updateProducto(@RequestBody ProductoRequest productoRequest) {

        Producto producto = modelMapper.map(productoRequest, Producto.class);
        return productoService.updateProducto(producto);
    }

    @GetMapping("/get/all")
    @ApiOperation(value = "Get All Producto ", response = Producto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public List<Producto> getAllProducto() {
        if(productoService.getAllProducto().isEmpty()){
            throw new ListEmptyException("La lista de los productos se encuentra vacia.");
        }
        return productoService.getAllProducto();
    }

    @GetMapping(path = "/find")
    @ApiOperation(value = "Find Producto By Id", response = Producto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public Producto findByIdProducto(@RequestParam(name = "idProducto") Long idProducto) throws Exception{
        Producto producto = productoService.findByIdProducto(idProducto);
        if (producto == null){
            throw  new ModelNotFoundException("el producto que desea buscar no existe");
        }
        return productoService.findByIdProducto(idProducto); }

    @DeleteMapping("/delete/id")
    @ApiOperation(value = "Delete Producto ", response = Producto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public void deleteProducto(@RequestParam(name = "id") Long id) {
        Producto producto = productoService.findByIdProducto(id);
        if(producto==null){
            throw new ModelNotFoundException("El producto que desea eliminar no existe");
        }
        productoService.deleteProductoById(id);
        throw new ModelFoundException("El producto ha sido eliminado satisfactoriamente.");
    }
}
