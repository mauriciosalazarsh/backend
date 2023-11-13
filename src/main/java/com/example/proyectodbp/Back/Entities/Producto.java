package com.example.proyectodbp.Back.Entities;

import com.example.proyectodbp.Security.User.User;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Producto")
public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;
    private String nombre;
    private String descripcion;
    private String fotoUrl;
    private double precio;
    private Date fechaPublicacion;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User vendedor;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CarritoCompra carroCompra;
    private Boolean disponible; // Avisa si esta disponible para la venta o ya no
    // Constructores
    public Producto(){}
    public Producto(Long id,
                    String nombre,
                    String descripcion,
                    String fotoUrl,
                    double precio,
                    Date fechaPublicacion,
                    User vendedor,
                    CarritoCompra carroCompra,
                    Boolean disponible){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoUrl = fotoUrl;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.vendedor = vendedor;
        this.carroCompra = carroCompra;
        this.disponible = disponible;
    }
    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public double getPrecio() {
        return precio;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public User getVendedor() {
        return vendedor;
    }

    public CarritoCompra getCarroCompra() {
        return carroCompra;
    }
    public Boolean getDisponible() {
        return disponible;
    }
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public void setVendedor(User vendedor) {
        this.vendedor = vendedor;
    }
    public void setCarroCompra(CarritoCompra carroCompra) {
        this.carroCompra = carroCompra;
    }
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
