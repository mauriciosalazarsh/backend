package com.example.proyectodbp.Back.Repositories;

import com.example.proyectodbp.Back.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findAllByDisponible(boolean disponible); // Esta es una función que se genera automáticamente
    // porque se llama findAllBy{Nombre del atributo}. Lo que hace esta función es buscar todos los productos
    // que tengan el atributo disponible en true.

}
