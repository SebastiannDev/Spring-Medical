package com.alura.clinica.administrador.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.clinica.administrador.Dto.Medico.MedicDto;
import com.alura.clinica.administrador.Dto.Medico.ResponseMedicDto;
import com.alura.clinica.administrador.Dto.Medico.ResponseMessage;
import com.alura.clinica.administrador.Service.IMedicoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/medico")
@RequiredArgsConstructor
public class MedicoController {

    private final IMedicoService medicoService;

    @GetMapping("/welcome")
    String welcome(){
        return "Hello, Api Full Rest for medic transactions.";
    }

    @GetMapping("/")
    public ResponseEntity<List<ResponseMedicDto>> getAllMedics(){
        var medics = medicoService.getAllMedics();
        return ResponseEntity.ok().body(medics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMedicDto> getMedic(@PathVariable Long id){
        var medic = medicoService.getOneMedic(id);
        return ResponseEntity.ok().body(medic);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseMedicDto> postMethodName(@RequestBody MedicDto medic) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMedicDto> putMethodName(@PathVariable Long id, @RequestBody MedicDto medic) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteMedic (@PathVariable Long id){
        return null;
    }
    
}
