package com.study.stock.service;

import com.study.stock.service.vo.ProductoServiceInVO;
import com.study.stock.service.vo.ProductoServiceOutVO;

public interface AlmacenRestClientService {
    ProductoServiceOutVO obtenerProducto(ProductoServiceInVO producto);
}
