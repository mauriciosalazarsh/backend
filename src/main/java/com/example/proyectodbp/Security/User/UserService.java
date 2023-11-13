package com.example.proyectodbp.Security.User;

import com.example.proyectodbp.Back.Entities.CarritoCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectodbp.Back.Entities.Producto;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsuarios()
    {
        return userRepository.findAll();
    }
    public Optional<User> getUsuarioById(Long id)
    {
        return userRepository.findById(id);
    }

    public Set<CarritoCompra> getCarritosByUsuario(Long id)
    {
        return Objects.requireNonNull(userRepository.findById(id).orElse(null)).getCarritos();
    }

    public Set<Producto> getVentasPendientes(Long id){
        return Objects.requireNonNull(userRepository.findById(id).orElse(null)).getProductosPorVender();
    }

    // Función para crear a un nuevo usuario
    public void createUsuario(User usuario)
    {
        userRepository.save(usuario);
    }
}
