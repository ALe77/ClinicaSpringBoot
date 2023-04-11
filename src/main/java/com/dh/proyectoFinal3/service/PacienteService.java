package com.dh.proyectoFinal3.service;

import com.dh.proyectoFinal3.entity.Paciente;
import com.dh.proyectoFinal3.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    public Paciente registrarPaciente(Paciente paciente){
        return this.pacienteRepository.save(paciente);
    }
}
