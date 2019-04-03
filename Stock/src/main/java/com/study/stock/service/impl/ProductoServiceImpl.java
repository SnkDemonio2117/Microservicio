package com.study.stock.service.impl;

import com.study.stock.domain.Producto;
import com.study.stock.repository.ProductoRepository;
import com.study.stock.rest.vo.ProductoInVO;
import com.study.stock.rest.vo.ProductoOutVO;
import com.study.stock.service.ProductoService;
import com.study.stock.service.vo.ProductoServiceInVO;
import com.study.stock.service.vo.ProductoServiceOutVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    AlmacenRestClientServiceImpl almacenRestClientService;

    @Override
    public List<ProductoOutVO> allProductos() {
        List<Producto> productos = productoRepository.findAll();
        if (productos == null){
            return new ArrayList<>();
        }
        List<ProductoOutVO> productoOutVos = new ArrayList<>();
        for (Producto producto: productos) {
            productoOutVos.add(new ProductoOutVO(producto.getCodigoProducto(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getCantidad(),
                    producto.getActivo()));
        }
        return productoOutVos;
    }

    @Override
    public ProductoOutVO getProducto(String codigoProducto) {
        Producto productoEncontrado = productoRepository.findByCodigoProducto(codigoProducto);

        if( productoEncontrado == null){
            return null;
        }

        return new ProductoOutVO(productoEncontrado.getCodigoProducto(),productoEncontrado.getNombre(),
                productoEncontrado.getDescripcion(),productoEncontrado.getCantidad(),productoEncontrado.getActivo());
    }

    @Override
    public ProductoOutVO cargarStockProducto(ProductoInVO cargarProducto) {
        ProductoServiceInVO productoServiceInVO = new ProductoServiceInVO(cargarProducto.getCodigoProducto(),
                cargarProducto.getCantidad());

        ProductoServiceOutVO productoServiceOutVO = almacenRestClientService.obtenerProducto(productoServiceInVO);

        return (productoServiceOutVO == null) ? null : new ProductoOutVO(productoServiceOutVO.getCodigoProducto(),productoServiceOutVO.getNombre(),
                productoServiceOutVO.getDescripcion(),productoServiceOutVO.getCantidad(),productoServiceOutVO.getActivo());
    }
}
