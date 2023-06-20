package com.alura.clinica.administrador.Dto.Medico;

import com.alura.clinica.administrador.Model.Direccion;

public record DireccionDto(String calle, String numero, String pais, String ciudad) {

    public DireccionDto(Direccion direccion) {
       this(direccion.getCalle(), direccion.getNumero(), direccion.getPais(), direccion.getCiudad());
    }
}
