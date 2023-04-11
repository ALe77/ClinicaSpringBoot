package com.dh.proyectoFinal3.controller;

import com.dh.proyectoFinal3.entity.Turno;
import com.dh.proyectoFinal3.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/turnos"})
public class TurnoController {
    @Autowired
    TurnoService turnoService;
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(this.turnoService.registrarTurno(turno));
    }
}
