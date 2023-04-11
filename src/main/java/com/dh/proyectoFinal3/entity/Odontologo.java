package com.dh.proyectoFinal3.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @SequenceGenerator(
            name ="secuencia_odontologo",
            sequenceName = "secuencia_odontologo",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia_odontologo"
    )
    private Long id;
    private String matricula;
    private String nombre;
    private String apellido;
    @OneToMany(
            mappedBy = "odontologo",
            fetch = FetchType.LAZY
    )
    private Set<Turno> turnos = new HashSet();

}
