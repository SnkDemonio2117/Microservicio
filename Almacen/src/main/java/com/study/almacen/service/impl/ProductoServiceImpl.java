package com.study.almacen.service.impl;

import com.study.almacen.domain.Producto;
import com.study.almacen.repository.ProductoRepository;
import com.study.almacen.rest.vo.ProductoInVo;
import com.study.almacen.rest.vo.ProductoOutVo;
import com.study.almacen.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    @Override
    @Transactional
    public Boolean createProducto(String codigoProducto, String nombre, String descripcion, Integer cantidad, Boolean activo) {
        Producto nuevoProducto = new Producto(codigoProducto, nombre, descripcion, cantidad, activo);
        try {
            productoRepository.save(nuevoProducto);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean updateProducto(String codigoProducto, String nombre, String descripcion, Integer cantidad, Boolean activo) {
        Producto productoEncontrado = productoRepository.findByCodigoProducto(codigoProducto);

        if( productoEncontrado == null){
            return false;
        }

        productoEncontrado.setNombre(nombre);
        productoEncontrado.setDescripcion(descripcion);
        productoEncontrado.setCantidad(cantidad);
        productoEncontrado.setActivo(activo);
        try {
            productoRepository.save(productoEncontrado);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteProducto(String codigoProducto) {
        Producto productoEncontrado = productoRepository.findByCodigoProducto(codigoProducto);

        if( productoEncontrado == null){
            return false;
        }
        productoEncontrado.setActivo(false);
        try {
            productoRepository.save(productoEncontrado);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public ProductoOutVo getProducto(String codigoProducto) {
        Producto productoEncontrado = productoRepository.findByCodigoProducto(codigoProducto);

        if( productoEncontrado == null){
            return null;
        }

        return new ProductoOutVo(productoEncontrado.getCodigoProducto(),productoEncontrado.getNombre(),
                productoEncontrado.getDescripcion(),productoEncontrado.getCantidad(),productoEncontrado.getActivo());
    }

    @Override
    public List<ProductoOutVo> allProductos() {
        List<Producto> productos = productoRepository.findAllByActivoTrue();
        if (productos == null){
            return new ArrayList<>();
        }
        List<ProductoOutVo> productoOutVos = new ArrayList<>();
        for (Producto producto: productos) {
            productoOutVos.add(new ProductoOutVo(producto.getCodigoProducto(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getCantidad(),
                    producto.getActivo()));
        }
        return productoOutVos;
    }

    @Override
    @Transactional
    public ProductoOutVo provideProducto(ProductoInVo produto) {
        ProductoOutVo productoEncontrado = this.getProducto(produto.getCodigoProducto());

        if (productoEncontrado == null || !productoEncontrado.getActivo()){
            return null;
        }

        if (produto.getCantidad() <= productoEncontrado.getCantidad()){
            Integer cantudadFinal = produto.getCantidad() - productoEncontrado.getCantidad();
            this.updateProducto(productoEncontrado.getCodigoProducto(),productoEncontrado.getNombre(),
                    productoEncontrado.getDescripcion(),cantudadFinal,productoEncontrado.getActivo());
            return this.getProducto(produto.getCodigoProducto());
        }
        return null;
    }
}
