package com.example.reservas.controllers;


import com.example.reservas.entities.Hotel;
import com.example.reservas.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas/hotel")
@RequiredArgsConstructor
public class HotelesController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<String> crearHotel(@RequestBody Hotel hotel){
        hotelService.guardar(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Se ha creado el hotel");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> actualizarHotel(@PathVariable Integer id,@RequestBody Hotel hotelActualizado){
        Hotel hotel = hotelService.findById(id);
        if (hotel!=null){
            hotelActualizado.setHotel_id(id);
            hotelService.guardar(hotelActualizado);
            return  ResponseEntity.ok().body("Se ha modificado el hotel correctamente");
        }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido modificar el hotel");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarHotel(@PathVariable Integer id){
        boolean eliminado = hotelService.delete(id);
        if (eliminado){
            return ResponseEntity.ok("Se ha eliminado el Hotel");
        }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el hotel para eliminarlo");
    }

    @PostMapping("/id/{nombre}")
    public ResponseEntity<Integer> obtenerIdApartirNombre(@PathVariable String nombre){
        Integer idHotel = hotelService.obtenerIdApartirNombre(nombre);
        return ResponseEntity.ok(idHotel);

    }

    @PostMapping("/nombre/{idHotel}")
    public ResponseEntity<String> obtenerNombreAPartirId(@PathVariable Integer idHotel){
        String nombre = hotelService.obtenerNombreAPartirId(idHotel);
        return ResponseEntity.ok(nombre);

    }

}
