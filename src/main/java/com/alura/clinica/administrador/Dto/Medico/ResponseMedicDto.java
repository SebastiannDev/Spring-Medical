package com.alura.clinica.administrador.Dto.Medico;

import com.alura.clinica.administrador.Model.Especialidad;
import com.alura.clinica.administrador.Model.Medico;

public record ResponseMedicDto(String nombre, String email, String identificacion, String telefono, Boolean activo,
        DireccionDto direccionDto, Especialidad especialidad) {

    public ResponseMedicDto(Medico medic) {
        this(medic.getNombre(), medic.getEmail(), medic.getIdentificacion(), medic.getTelefono(), medic.getActivo(),
                new DireccionDto(medic.getDireccion()), medic.getEspecialidad());
    }
}
