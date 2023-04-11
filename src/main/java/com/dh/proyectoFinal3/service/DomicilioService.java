package com.dh.proyectoFinal3.service;

import com.dh.proyectoFinal3.entity.Domicilio;
import com.dh.proyectoFinal3.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;
    public Domicilio registrarDomicilio(Domicilio domicilio){
        return this.domicilioRepository.save(domicilio);
    }
}
