package com.study.stock.rest;

import com.study.stock.rest.vo.ProductoInVO;
import com.study.stock.rest.vo.ProductoOutVO;
import com.study.stock.service.ProductoService;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RequestMapping("/stock")
@RestController
public class StockRestController {

    @Autowired
    ProductoService productoService;

    @GetMapping(value = "/allProductos")
    public List<ProductoOutVO> getAllProductos(){
        return productoService.allProductos();
    }

    @GetMapping(value = "/findProducto", consumes = {MediaType.APPLICATION_JSON})
    public ProductoOutVO getProducto(@RequestBody ProductoInVO producto){
        return productoService.getProducto(producto.getCodigoProducto());
    }
}
