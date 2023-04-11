package com.dh.proyectoFinal3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "domicilios")
public class Domicilio {
    @Id
    @SequenceGenerator(
            name ="secuencia_domicilio",
            sequenceName = "secuencia_domicilio",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia_domicilio"
    )
    private Long id;
    private String calle;
    private String numero;
    private String barrio;
    private String localidad;
    private String provincia;
}
