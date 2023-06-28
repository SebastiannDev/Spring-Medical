package com.alura.clinica.administrador.Model;

import com.alura.clinica.administrador.Dto.Medico.MedicDto;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String identificacion;
    private String telefono;
    private Boolean activo;

    @Embedded
    private Direccion direccion;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    public Medico(MedicDto dtoMedic){
        this.nombre = dtoMedic.nombre();
        this.email = dtoMedic.email();
        this.identificacion = dtoMedic.identificacion();
        this.telefono = dtoMedic.telefono();
        this.activo = true;

        this.direccion = new Direccion(dtoMedic.direccionDto());
        this.especialidad = dtoMedic.especialidad();
    }
}
