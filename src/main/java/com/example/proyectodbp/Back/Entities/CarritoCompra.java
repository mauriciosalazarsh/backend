package com.example.proyectodbp.Back.Entities;

import com.example.proyectodbp.Security.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "CarritoCompra")
public class CarritoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User comprador;


    @OneToMany
    @JsonIgnore
    private Set<Producto> productos;


    // Constructores
    public CarritoCompra() {
    }
    public CarritoCompra(Long id,
                         User comprador,
                         Set<Producto> productos) {
        this.id = id;
        this.comprador = comprador;
        this.productos = productos;
    }
    // Getters
    public Long getId() {
        return id;
    }
    public User getComprador() {
        return comprador;
    }
    public Set<Producto> getProductos() {
        return productos;
    }
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setComprador(User comprador) {
        this.comprador = comprador;
    }
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
