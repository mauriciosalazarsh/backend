package com.example.proyectodbp.Security.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.example.proyectodbp.Back.Entities.CarritoCompra;
import com.example.proyectodbp.Back.Entities.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {
    @Id
    @GeneratedValue
    Integer id;

    @Basic
    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String lastname;

    String firstname;
    String country;
    String password;

    @Enumerated(EnumType.STRING)
    Role role;

    Long dni;
    String region;
    String provincia;
    String distrito;
    String fotoUrl;
    String telefonoNro;

    @OneToMany
    @JsonIgnore // Para evitar que se cree un loop infinito
    private Set<CarritoCompra> carritos;

    @OneToMany
    @JsonIgnore // Cuando se haga un post de usuario, no será necesario que se envíen los productos que vende
    private Set<Producto> productosPorVender;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Getter y Setter para los nuevos atributos de Usuario
    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getTelefonoNro() {
        return telefonoNro;
    }

    public void setTelefonoNro(String telefonoNro) {
        this.telefonoNro = telefonoNro;
    }

    public void setCarritos(Set<CarritoCompra> carritos) {
        this.carritos = carritos;
    }
    public Set<CarritoCompra> getCarritos() {
        return carritos;
    }

    public void setProductosPorVender(Set<Producto> productosPorVender) {
        this.productosPorVender = productosPorVender;
    }
    public Set<Producto> getProductosPorVender() {
        return productosPorVender;
    }


}
