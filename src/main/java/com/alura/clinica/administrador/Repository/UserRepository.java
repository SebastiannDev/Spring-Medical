package com.alura.clinica.administrador.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.clinica.administrador.Model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    
}
