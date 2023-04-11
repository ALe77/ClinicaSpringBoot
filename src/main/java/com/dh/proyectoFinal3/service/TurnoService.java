package com.dh.proyectoFinal3.service;

import com.dh.proyectoFinal3.entity.Turno;
import com.dh.proyectoFinal3.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;
    public Turno registrarTurno(Turno turno){
        return this.turnoRepository.save(turno);
    }
}
