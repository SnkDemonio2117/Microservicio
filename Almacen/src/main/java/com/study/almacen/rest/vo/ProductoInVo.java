package com.study.almacen.rest.vo;

import java.io.Serializable;

/**
 *
 */
public class ProductoInVo implements Serializable {
    private static final long serialVersionUID = -7453539013293594701L;

    private String codigoProducto;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Boolean activo;

    public ProductoInVo() {
    }

    public ProductoInVo(String codigoProducto, String nombre, String descripcion, Integer cantidad, Boolean activo) {
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
        return "ProductoInVo{" +
                "codigoProducto='" + codigoProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", activo=" + activo +
                '}';
    }
}
