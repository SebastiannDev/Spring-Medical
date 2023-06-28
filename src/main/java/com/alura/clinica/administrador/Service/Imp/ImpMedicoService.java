package com.alura.clinica.administrador.Service.Imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alura.clinica.administrador.Dto.Medico.MedicDto;
import com.alura.clinica.administrador.Dto.Medico.ResponseMedicDto;
import com.alura.clinica.administrador.Dto.Medico.ResponseMessage;
import com.alura.clinica.administrador.Model.Direccion;
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
    public List<ResponseMedicDto> getAllMedics() {
        var listMedics = medicoRepository.findAll(Sort.by("nombre"));

        return listMedics.stream().map(medic -> new ResponseMedicDto(medic))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseMedicDto getOneMedic(Long id) {
        var medic = medicoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return new ResponseMedicDto(medic);
    }

    @Override
    public ResponseMedicDto createMedic(MedicDto medic) {
        var entityMedic = new Medico(medic); // transform dto to entity
        var savedMedic = medicoRepository.save(entityMedic); // get the response of JPA
        return new ResponseMedicDto(savedMedic); // transform the response JPA to dto.
    }

    @Override
    public ResponseMedicDto editMedic(Long id, MedicDto medicoDto) {
        var entityFounded = medicoRepository.findById(id);

        if (!entityFounded.isPresent()) {
            throw new EntityNotFoundException();
        }

        Medico entityMedic = new Medico(id, medicoDto.nombre(), medicoDto.email(), medicoDto.identificacion(),
                medicoDto.telefono(), medicoDto.activo(), new Direccion(medicoDto.direccionDto()),
                medicoDto.especialidad());

        var updatedMedic = medicoRepository.save(entityMedic);
        return new ResponseMedicDto(updatedMedic);
    }

    @Override
    public ResponseMessage deleteMedic(Long id) {
        medicoRepository.deleteById(id);
        return new ResponseMessage("Entity deleted", "Succes" + id);
    }

}
