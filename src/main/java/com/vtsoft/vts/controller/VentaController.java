package com.vtsoft.vts.controller;

import com.vtsoft.vts.exception.ListEmptyException;
import com.vtsoft.vts.exception.ModelFoundException;
import com.vtsoft.vts.exception.ModelNotFoundException;
import com.vtsoft.vts.model.Venta;
import com.vtsoft.vts.model.request.VentaRequest;
import com.vtsoft.vts.service.VentaService;
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
@RequestMapping("/venta")
@Api(tags = "Venta")
public class VentaController {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private VentaService ventaService;

    @PostMapping("/insert")
    @ApiOperation(value = "Insert Venta", response = Venta.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public Venta saveAntenna(@RequestBody VentaRequest ventaRequest) {

        Venta venta = modelMapper.map(ventaRequest, Venta.class);
        return ventaService.saveVenta(venta);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update Venta ", response = Venta.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public Venta updateAntena(@RequestBody VentaRequest ventaRequest) {
        Venta venta = modelMapper.map(ventaRequest, Venta.class);
        return ventaService.updateVenta(venta);
    }

    @GetMapping("/get/all")
    @ApiOperation(value = "Get All Venta ", response = Venta.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public List<Venta> getAllVenta() {
        if(ventaService.getAllVenta().isEmpty()){
            throw new ListEmptyException("La lista de las ventas se encuentra vacia.");
        }
        return ventaService.getAllVenta();
    }

    @GetMapping(path = "/find")
    @ApiOperation(value = "Find Venta By Id", response = Venta.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public Venta findByIdAntena(@RequestParam(name = "idVenta") Long idVenta) throws Exception{
        Venta venta = ventaService.findByIdVenta(idVenta);
        if (venta == null){
            throw  new ModelNotFoundException("La venta que desea buscar no existe");
        }
        return ventaService.findByIdVenta(idVenta); }

    @DeleteMapping("/delete/id")
    @ApiOperation(value = "Delete Antenna ", response = Venta.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Access denied"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token")})
    public void deleteAntenna(@RequestParam(name = "id") Long id) {
        Venta venta = ventaService.findByIdVenta(id);
        if(venta==null){
            throw new ModelNotFoundException("La venta que desea eliminar no existe");
        }
        ventaService.deleteVentaById(id);
        throw new ModelFoundException("La venta ha sido eliminada satisfactoriamente.");
    }
}
