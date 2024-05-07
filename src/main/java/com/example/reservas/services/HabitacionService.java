package com.example.reservas.services;

import com.example.reservas.entities.Habitacion;
import com.example.reservas.repositories.HabitacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    public void crearHabitacion(Habitacion habitacion){
        habitacionRepository.save(habitacion);
    }

    public Optional<Habitacion> findById(Integer id){
        return habitacionRepository.findById(id);
    }

    public void update(Habitacion habitacion){
        habitacionRepository.save(habitacion);
    }


    public boolean eliminarHabitacion(int id){
        Optional<Habitacion> habitacion = habitacionRepository.findById(id);
        if (habitacion.isPresent()){
            habitacionRepository.delete(habitacion.get());
            return true;
        }
        else return false;
    }



}



