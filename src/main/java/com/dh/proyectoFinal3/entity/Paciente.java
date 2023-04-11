package com.dh.proyectoFinal3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @SequenceGenerator(
            name ="secuencia_paciente",
            sequenceName = "secuencia_paciente",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia_paciente"
    )
    private Long id;
    private String nombre;
    private String apellido;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "domicilio_id",
            referencedColumnName = "id"
    )
    private Domicilio domicilio;
    private String dni;
    private LocalDate fechaAlta;
    @OneToMany(
            mappedBy = "paciente",
            fetch = FetchType.LAZY
    )
    private Set<Turno> turnos = new HashSet();
}
