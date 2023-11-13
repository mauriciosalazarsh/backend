package com.example.proyectodbp.Back.Controllers;

import com.example.proyectodbp.Back.Services.CarritoCompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.proyectodbp.Back.Entities.CarritoCompra;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CarritoCompraController {

    @Autowired
    private CarritoCompraService carritoCompraService;
    @GetMapping("/all") // Se obtienen todos los usuarios
    public List<CarritoCompra> getAllCarritos()
    {
        return carritoCompraService.getAllCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoCompra> getCarritoById(@PathVariable Long id)
    {
        carritoCompraService.getCartById(id);

        if (carritoCompraService.getCartById(id).isPresent()) {
            return new ResponseEntity<>(carritoCompraService.getCartById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/") // Se crea un producto
    public String createCart(@RequestBody CarritoCompra carritoCompra)
    {
        carritoCompraService.createCarritoCompra(carritoCompra);
        return "Carrito de compra creado";
    }
}
