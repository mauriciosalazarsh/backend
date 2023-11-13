package com.example.proyectodbp.Back.Controllers;

import com.example.proyectodbp.Back.Entities.Producto;
import com.example.proyectodbp.Back.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @GetMapping("/") // Se obtienen todos los usuarios
    public List<Producto> getAllProductos()
    {
        return productoService.getAllProducts();
    }
    @GetMapping("/availables") // Se obtienen todos los productos disponibles
    public List<Producto> getAllProductosDisponibles()
    {
        return productoService.getAllProductsAvailables();
    }
    @GetMapping("/{id}") // Se obtiene un producto específico
    public ResponseEntity<Producto> getProductoByID(@PathVariable Long id)
    {
        Optional<Producto> product = productoService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @PostMapping("/") // Se crea un producto
    public String createProducto(@RequestBody Producto producto) {
        productoService.createProducto(producto);
        return "Producto creado";
    }

}
