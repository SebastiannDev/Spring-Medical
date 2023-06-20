package com.alura.clinica.administrador.Service.Imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alura.clinica.administrador.Dto.Medico.ListMedicoDto;
import com.alura.clinica.administrador.Dto.Medico.RegisterMedicoDto;
import com.alura.clinica.administrador.Dto.Medico.ResponseMedicoDto;
import com.alura.clinica.administrador.Model.Medico;
import com.alura.clinica.administrador.Repository.MedicoRepository;
import com.alura.clinica.administrador.Service.IMedicoService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImpMedicoService implements IMedicoService {

    private final MedicoRepository medicoRepository;

    @Override
    public List<ListMedicoDto> getAllMedics() {
        var listMedics = medicoRepository.findAll(Sort.by("nombre"));

        return listMedics.stream().map(medic -> new ListMedicoDto(medic))
        .collect(Collectors.toList());        
    }

    @Override
    public ListMedicoDto getOneMedic(Long id) {
        var medic = medicoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return new ListMedicoDto(medic);
    }

    @Override
    public ListMedicoDto createMedic(RegisterMedicoDto medic) {
        var saveMedic = new Medico();

        saveMedic.setNombre(medic.nombre());
        saveMedic.setEmail(medic.email());

        return null; //[trace] 
    }

    @Override
    public ListMedicoDto editMedic(Long id, ListMedicoDto medicoDto) {
        throw new UnsupportedOperationException("Unimplemented method 'editMedic'");
    }

    @Override
    public ResponseMedicoDto deleteMedic(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteMedic'");
    }
    
}
