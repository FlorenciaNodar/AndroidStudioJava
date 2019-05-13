package com.example.fnodar.nodarflorencia;

public class Producto {

    private String nombre;
    private Integer cantidad;
    private Double precioUnidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precioUnidad;
    }

    public void setPrecio(Double precio) {
        this.precioUnidad = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }



    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precioUnidad +
                ", cantidad=" + cantidad +
                '}';
    }
}
