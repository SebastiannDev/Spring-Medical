package com.alura.clinica.administrador.Model;

import com.alura.clinica.administrador.Dto.Medico.DireccionDto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Direccion {

    private String calle;
    private String numero;
    private String pais;
    private String ciudad;

    public Direccion(DireccionDto direccionDto) {
        this.calle = direccionDto.calle();
        this.numero = direccionDto.numero();
        this.pais = direccionDto.pais();
        this.ciudad = direccionDto.ciudad();
    }
}
