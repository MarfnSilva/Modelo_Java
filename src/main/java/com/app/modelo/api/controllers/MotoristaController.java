package com.app.modelo.api.controllers;

import com.app.modelo.api.dtos.MotoristaDto;
import com.app.modelo.api.entities.CarroModel;
import com.app.modelo.api.entities.MotoristaModel;
import com.app.modelo.api.services.CarroService;
import com.app.modelo.api.services.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/motorista")
public class MotoristaController {
    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<Object> saveMotorista(@RequestBody @Valid MotoristaDto motoristaDto){
        if (motoristaService.existsByCpf(motoristaDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF já cadastrado.");
        }
        var motoristaModel = new MotoristaModel();
        BeanUtils.copyProperties(motoristaDto, motoristaModel);
        return ResponseEntity.status(HttpStatus.OK).body(motoristaService.save(motoristaModel));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOneMotorista(@PathVariable(value = "id") Long id){
        Optional<MotoristaModel> motoristaModelOptional = motoristaService.findById(id);
        if(motoristaModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista não encontrado no Sistema.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(motoristaModelOptional.get());
    }

    @GetMapping
    public ResponseEntity<List<MotoristaModel>> getAllMotorista(){
        return ResponseEntity.status(HttpStatus.OK).body(motoristaService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMotorista(@PathVariable(value = "id") Long id){
        Optional<MotoristaModel> motoristaModelOptional = motoristaService.findById(id);
        if(motoristaModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista não encontrado no Sistema.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Motorista: " + motoristaModelOptional.get().getNome() + "deletado com sucesso." );
    }

    @PutMapping("/{d}")
    public ResponseEntity<Object> updateMotorista(@PathVariable(value = "id") Long id,
                                                  @RequestBody @Valid MotoristaDto motoristaDto){
        Optional<MotoristaModel> motoristaModelOptional = motoristaService.findById(id);
        if(motoristaModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista não encontrado no Sistema");
        }
        var motoristaModel = new MotoristaModel();
        BeanUtils.copyProperties(motoristaDto, motoristaModel);
        motoristaModel.setId(motoristaModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(motoristaService.save(motoristaModel));
    }

}
