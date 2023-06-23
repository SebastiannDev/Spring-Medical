package com.alura.clinica.administrador.Service;

import java.util.List;

import com.alura.clinica.administrador.Dto.Medico.MedicDto;
import com.alura.clinica.administrador.Dto.Medico.ResponseMedicDto;
import com.alura.clinica.administrador.Dto.Medico.ResponseMessage;

public interface IMedicoService {
    
    public List<ResponseMedicDto> getAllMedics();                    // GET
    public ResponseMedicDto getOneMedic(Long id);                   // GET
    public ResponseMedicDto createMedic(MedicDto medic);            // POST
    public ResponseMedicDto editMedic(Long id, MedicDto medic);     // PUT
    public ResponseMessage deleteMedic(Long id);                   // DELETE
}
