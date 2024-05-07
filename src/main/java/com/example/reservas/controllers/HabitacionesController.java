package com.example.reservas.controllers;

import com.example.reservas.DTO.CrearHabitacionDTO;
import com.example.reservas.entities.Habitacion;
import com.example.reservas.services.HabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reservas/habitacion")
@RequiredArgsConstructor
public class HabitacionesController {

    private final HabitacionService habitacionService;

    //TODO no ingresa la idHotel
    @PostMapping
    public ResponseEntity<String> crearHabitacion(@RequestBody Habitacion habitacion){
        habitacionService.crearHabitacion(habitacion);
        return ResponseEntity.status(HttpStatus.CREATED).body("La habitacion ha sido creada");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable Integer id, @RequestBody Habitacion habitacionActualizada){
      Optional<Habitacion> habitacion = habitacionService.findById(id);
        if (habitacion.isPresent()){
            habitacionActualizada.setHabitacion_id(id);
            habitacionService.update(habitacionActualizada);
            return ResponseEntity.ok(habitacionActualizada);
        }else return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarHabitacion(@PathVariable Integer id){
        boolean eliminado = habitacionService.eliminarHabitacion(id);
        if (eliminado){
            return ResponseEntity.ok("Se ha eliminado la habitacion");
        }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la habitacion");
    }



}
