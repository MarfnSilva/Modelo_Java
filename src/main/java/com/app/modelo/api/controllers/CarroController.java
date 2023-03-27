package com.app.modelo.api.controllers;


import com.app.modelo.api.dtos.CarroDto;
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
@RequestMapping(value = "/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<Object> saveCarro(@RequestBody @Valid CarroDto carroDto){
        if(carroService.existsByPlaca(carroDto.getPlaca())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Placa já cadastrada no Sistema");
        }
//        Optional<MotoristaModel> motoristaModelOptional = motoristaService.findById(carroDto.getMotorista().getId());
//        if(motoristaModelOptional.isEmpty()){
//            return ResponseEntity.status(HttpStatus.OK).body("Motorista não encontrado");
//        }
        var carroModel = new CarroModel();
        BeanUtils.copyProperties(carroDto, carroModel);
        return ResponseEntity.status(HttpStatus.OK).body(carroService.save(carroModel));
    }

    @GetMapping
    public ResponseEntity<List<CarroModel>> getAllCarro(){
        return ResponseEntity.status(HttpStatus.OK).body(carroService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOneCarro(@PathVariable(value = "id")Long id){
        Optional<CarroModel> carroModelOptional = carroService.findById(id);
        if(carroModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(carroModelOptional.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCarro(@PathVariable(value = "id")Long id){
        Optional<CarroModel> carroModelOptional = carroService.findById(id);
        if(carroModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Carro de Placa " + carroModelOptional.get().getPlaca() + " Deletado com Sucesso");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCarro(@PathVariable(value = "id") Long id,
                                              @RequestBody @Valid CarroDto carroDto){
        Optional<CarroModel> carroModelOptional = carroService.findById(id);
        if(carroModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado.");
        }
        var carroModel = new CarroModel();
        BeanUtils.copyProperties(carroDto, carroModel);
        carroModel.setId(carroModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(carroService.save(carroModel));
    }

}
