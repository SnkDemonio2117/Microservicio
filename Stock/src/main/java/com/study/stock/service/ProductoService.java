package com.study.stock.service;

import com.study.stock.rest.vo.ProductoInVO;
import com.study.stock.rest.vo.ProductoOutVO;
import java.util.List;

public interface ProductoService {
    List<ProductoOutVO> allProductos();
    ProductoOutVO getProducto(String codigoProducto);
    ProductoOutVO cargarStockProducto(ProductoInVO cargarProducto);
}
