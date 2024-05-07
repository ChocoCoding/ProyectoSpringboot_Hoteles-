package com.example.reservas.services;

import com.example.reservas.entities.Reserva;
import com.example.reservas.repositories.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;


}
