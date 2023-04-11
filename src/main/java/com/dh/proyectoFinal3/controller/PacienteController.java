package com.dh.proyectoFinal3.controller;

import com.dh.proyectoFinal3.entity.Paciente;
import com.dh.proyectoFinal3.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pacientes"})
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(this.pacienteService.registrarPaciente(paciente));
    }
}
