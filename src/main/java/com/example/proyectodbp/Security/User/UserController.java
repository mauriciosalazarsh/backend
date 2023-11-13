package com.example.proyectodbp.Security.User;

import com.example.proyectodbp.Back.Entities.CarritoCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.proyectodbp.Back.Entities.Producto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService usuarioService;
    @GetMapping("/") // Se obtienen todos los usuarios
    public List<User> getAllUsuarios()
    {
        return usuarioService.getAllUsuarios();
    }
    @GetMapping("/{id}") // Se obtiene el perfil del usuario
    public ResponseEntity<User> getUsuario(@PathVariable Long id)
    {
        Optional<User> usuarioOptional = usuarioService.getUsuarioById(id);

        return usuarioOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/products/{id}/purchased") // Se obtienen todos las compras realizadas por el usuario
    public Set<CarritoCompra> getComprasUsuario(@PathVariable Long id) {
        return usuarioService.getCarritosByUsuario(id);
    }

    @GetMapping("/products/{id}/sale") // Se obtienen todos las ventas pendientes del usuario
    public Set<Producto> getVentasPendientesPorUsuario(@PathVariable Long id) {
        return usuarioService.getVentasPendientes(id);
    }

    @PostMapping("/")
    public String createUsuario(@RequestBody User user) {
        usuarioService.createUsuario(user);
        return "Usuario creado";
    }
}
