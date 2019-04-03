package com.study.stock.service.vo;

import java.io.Serializable;

/**
 *
 */
public class ProductoServiceInVO implements Serializable {
    private static final long serialVersionUID = 3394971324359963048L;
    private String codigoProducto;
    private Integer cantidad;

    public ProductoServiceInVO() {
    }

    public ProductoServiceInVO(String codigoProducto, Integer cantidad) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoServiceInVO{" +
                "codigoProducto='" + codigoProducto + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
