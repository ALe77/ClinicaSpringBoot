package com.dh.proyectoFinal3.service;

import com.dh.proyectoFinal3.entity.Odontologo;
import com.dh.proyectoFinal3.exeption.OdontologoNoEncontradoExeption;
import com.dh.proyectoFinal3.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;
    public Odontologo registrarOdontologo(Odontologo odontologo){
        return this.odontologoRepository.save(odontologo);
    }
    public List<Odontologo> listarOdontologos(){
        return this.odontologoRepository.findAll();
    }
    public void eliminarOdontologo(Long id){this.odontologoRepository.deleteById(id);}
    public Optional<Odontologo> buscarPorId(Long id){return this.odontologoRepository.findById(id);}

    public ResponseEntity<Odontologo> modificarOdontologo(Long id, Odontologo odontologo) throws OdontologoNoEncontradoExeption {
        ResponseEntity<Odontologo> respuesta = null;
        Optional<Odontologo> resultadoBusqueda = buscarPorId(id);
        if (id != null && resultadoBusqueda.isPresent()){
            odontologo.setId(resultadoBusqueda.get().getId());
            odontologoRepository.save(odontologo);
            respuesta = new ResponseEntity<>(odontologo, HttpStatus.ACCEPTED);
            return respuesta;
        }
        else{
            throw new OdontologoNoEncontradoExeption("No se encontro el odontologo con el id proporcionado");
        }
    }
}
