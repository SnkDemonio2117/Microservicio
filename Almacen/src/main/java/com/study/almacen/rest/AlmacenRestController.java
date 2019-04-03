package com.study.almacen.rest;

import com.study.almacen.rest.vo.ProductoInVo;
import com.study.almacen.rest.vo.ProductoOutVo;
import com.study.almacen.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RequestMapping(value = "almacen", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class AlmacenRestController {

    @Autowired
    ProductoService productoService;

    @GetMapping(value = "/findProducto", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ProductoOutVo getProducto(@RequestBody ProductoInVo producto) {
        return productoService.getProducto(producto.getCodigoProducto());
    }

    @GetMapping("/allProductos")
    public List<ProductoOutVo> getAllProductos(){
        return productoService.allProductos();
    }

    @PostMapping(value = "/provideProducto", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ProductoOutVo provideProducto(@RequestBody ProductoInVo produto){
        return productoService.provideProducto(produto);
    }
}
