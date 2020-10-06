package com.vtsoft.vts.controller;

import com.vtsoft.vts.exception.ListEmptyException;
import com.vtsoft.vts.exception.ModelFoundException;
import com.vtsoft.vts.exception.ModelNotFoundException;
import com.vtsoft.vts.model.Orden;
import com.vtsoft.vts.model.request.OrdenRequest;
import com.vtsoft.vts.service.OrdenService;
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
@RequestMapping("/orden")
@Api(tags = "Orden")
public class OrdenController {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private OrdenService ordenService;

    @PostMapping("/insert")
    @ApiOperation(value = "Insert Orden", response = Orden.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public Orden saveOrden(@RequestBody OrdenRequest ordenRequest) {

        Orden orden = modelMapper.map(ordenRequest, Orden.class);
        return ordenService.saveOrden(orden);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update Orden", response = Orden.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public Orden updateOrden(@RequestBody OrdenRequest ordenRequest) {

        Orden orden = modelMapper.map(ordenRequest, Orden.class);
        return ordenService.updateOrden(orden);
    }

    @GetMapping("/get/all")
    @ApiOperation(value = "Get All Orden ", response = Orden.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public List<Orden> getAllOrden() {
        if(ordenService.getAllOrden().isEmpty()){
            throw new ListEmptyException("La lista de las ordenes se encuentra vacia.");
        }
        return ordenService.getAllOrden();
    }

    @GetMapping(path = "/find")
    @ApiOperation(value = "Find Orden By Id", response = Orden.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public Orden findByIdVenta(@RequestParam(name = "idOrden") Long idOrden) throws Exception{
        Orden orden = ordenService.findByIdOrden(idOrden);
        if (orden == null){
            throw  new ModelNotFoundException("La orden que desea buscar no existe");
        }
        return ordenService.findByIdOrden(idOrden); }

    @DeleteMapping("/delete/id")
    @ApiOperation(value = "Delete Orden ", response = Orden.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public void deleteVenta(@RequestParam(name = "id") Long id) {
        Orden orden = ordenService.findByIdOrden(id);
        if(orden==null){
            throw new ModelNotFoundException("La orden que desea eliminar no existe");
        }
        ordenService.deleteOrdenById(id);
        throw new ModelFoundException("La orden ha sido eliminada satisfactoriamente.");
    }
}
