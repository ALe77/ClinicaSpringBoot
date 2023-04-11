package com.dh.proyectoFinal3.controller;

import com.dh.proyectoFinal3.entity.Odontologo;
import com.dh.proyectoFinal3.exeption.OdontologoNoEncontradoExeption;
import com.dh.proyectoFinal3.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping({"/odontologos"})
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(this.odontologoService.registrarOdontologo(odontologo));
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos(){
        return ResponseEntity.ok(this.odontologoService.listarOdontologos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id){
        ResponseEntity<String> respuesta = null;
        if (odontologoService.buscarPorId(id).isPresent()){
            this.odontologoService.eliminarOdontologo(id);
            respuesta = new ResponseEntity<>("Se elimino el edondologo de la base de datos" , HttpStatus.NO_CONTENT);
        }
        else{
            respuesta = new ResponseEntity<>("No existe un odontologo con el id "+ id , HttpStatus.NOT_FOUND);
        }
        return respuesta;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Odontologo> modificarOdontologo(@PathVariable Long id, @RequestBody Odontologo odontologo){
        try {
            return this.odontologoService.modificarOdontologo(id, odontologo);
        } catch (OdontologoNoEncontradoExeption e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
