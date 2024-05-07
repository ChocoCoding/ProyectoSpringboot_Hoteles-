package com.example.reservas.services;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.example.reservas.entities.Hotel;
import com.example.reservas.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public void guardar(Hotel hotel){
        hotelRepository.save(hotel);
    }

    public Hotel findById(Integer id){
        return hotelRepository.findById(id).orElse(null);
    }

    public boolean delete(Integer id){
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isPresent()){
            hotelRepository.delete(hotel.get());
            return true;
        }else return false;
    }

    public Integer obtenerIdApartirNombre(String nombre){
        return hotelRepository.obtenerIdApartirNombre(nombre);
    }

    public String obtenerNombreAPartirId(Integer hotelId){
        return hotelRepository.obtenerNombreAPartirId(hotelId);
    }


}
