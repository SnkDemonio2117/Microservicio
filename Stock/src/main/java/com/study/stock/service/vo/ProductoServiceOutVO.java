package com.study.stock.service.vo;

import java.io.Serializable;

/**
 *
 */
public class ProductoServiceOutVO implements Serializable {
    private static final long serialVersionUID = -3532497544387366822L;
    private String codigoProducto;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Boolean activo;

    public ProductoServiceOutVO() {
    }

    public ProductoServiceOutVO(String codigoProducto, String nombre, String descripcion, Integer cantidad, Boolean activo) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.activo = activo;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ProductoServiceOutVO{" +
                "codigoProducto='" + codigoProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", activo=" + activo +
                '}';
    }
}
