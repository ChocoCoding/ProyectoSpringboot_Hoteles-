package com.example.reservas.DTO;
import com.example.reservas.entities.Habitacion;
import com.example.reservas.entities.Tipo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CrearHabitacionDTO {
    private int numero_habitacion;
    private Tipo tipo;
    private BigDecimal precio;
    private Boolean disponible;
    private Integer idHotel;


    public CrearHabitacionDTO(Habitacion habitacion) {
        this.numero_habitacion = habitacion.getNumero_habitacion();
        this.tipo = habitacion.getTipo();
        this.precio = habitacion.getPrecio();
        this.disponible = habitacion.getDisponible();
        this.idHotel = habitacion.getHotel().getHotel_id();
    }

}
