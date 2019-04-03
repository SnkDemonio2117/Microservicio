package com.study.almacen.rest;

import com.study.almacen.domain.Producto;
import com.study.almacen.rest.vo.ProductoInVo;
import com.study.almacen.service.ProductoService;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RequestMapping("admin/almacen")
@RestController
public class AdminAlmacenRestController {

    @Autowired
    ProductoService productoService;

    @PostMapping(value = "/createProducto", consumes = {MediaType.APPLICATION_JSON})
    public Boolean createProducto(@RequestBody ProductoInVo producto){
       return productoService.createProducto(producto.getCodigoProducto(),producto.getNombre(),producto.getDescripcion(),
                producto.getCantidad(),producto.getActivo());
    }

    @PostMapping(value = "/updateProducto", consumes = {MediaType.APPLICATION_JSON})
    public Boolean updateProducto(@RequestBody ProductoInVo producto){
        return productoService.updateProducto(producto.getCodigoProducto(),producto.getNombre(),producto.getDescripcion(),
                producto.getCantidad(),producto.getActivo());
    }

    @PostMapping(value = "/deleteProducto", consumes = {MediaType.APPLICATION_JSON})
    public Boolean deleteProducto(@RequestBody ProductoInVo producto){
        return productoService.deleteProducto(producto.getCodigoProducto());
    }
}
