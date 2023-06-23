package com.alura.clinica.administrador.Dto.Medico;

import com.alura.clinica.administrador.Model.Especialidad;

public record MedicDto(String nombre, String email, String identificacion, String telefono, Boolean activo,
        DireccionDto direccionDto, Especialidad especialidad) {
}
