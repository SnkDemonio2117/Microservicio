package com.study.almacen.service;

import com.study.almacen.rest.vo.ProductoInVo;
import com.study.almacen.rest.vo.ProductoOutVo;
import java.util.List;

/**
 *
 */
public interface ProductoService {
    Boolean createProducto(String codigoProducto, String nombre, String descripcion, Integer cantidad, Boolean activo);

    Boolean updateProducto(String codigoProducto, String nombre, String descripcion, Integer cantidad, Boolean activo);

    Boolean deleteProducto(String codigoProducto);

    ProductoOutVo getProducto(String codigoProducto);

    List<ProductoOutVo> allProductos();

    ProductoOutVo provideProducto(ProductoInVo produto);
}
