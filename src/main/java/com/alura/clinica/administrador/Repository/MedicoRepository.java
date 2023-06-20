package com.alura.clinica.administrador.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.clinica.administrador.Model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
