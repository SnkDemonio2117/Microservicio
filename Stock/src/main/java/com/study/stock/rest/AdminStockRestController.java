package com.study.stock.rest;

import com.study.stock.rest.vo.ProductoInVO;
import com.study.stock.rest.vo.ProductoOutVO;
import com.study.stock.service.ProductoService;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RequestMapping("admin/stock")
@RestController
public class AdminStockRestController {

    @Autowired
    ProductoService productoService;

    @PostMapping(value = "/cargarProductoStock", consumes = {MediaType.APPLICATION_JSON})
    public ProductoOutVO cargarStock(@RequestBody ProductoInVO cargarProducto){
        return productoService.cargarStockProducto(cargarProducto);
    }
}
