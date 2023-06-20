package com.alura.clinica.administrador.Service;

import java.util.List;

import com.alura.clinica.administrador.Dto.Medico.ListMedicoDto;
import com.alura.clinica.administrador.Dto.Medico.RegisterMedicoDto;
import com.alura.clinica.administrador.Dto.Medico.ResponseMedicoDto;

public interface IMedicoService {
    
    public List<ListMedicoDto> getAllMedics();                  // GET
    public ListMedicoDto getOneMedic(Long id);                  // GET
    public ListMedicoDto createMedic(RegisterMedicoDto medic);                         // POST
    public ListMedicoDto editMedic(Long id, ListMedicoDto medic);   // PUT
    public ResponseMedicoDto deleteMedic(Long id);          // DELETE
}
