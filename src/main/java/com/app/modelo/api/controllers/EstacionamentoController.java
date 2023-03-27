package com.app.modelo.api.controllers;

import com.app.modelo.api.dtos.CarroDto;
import com.app.modelo.api.dtos.EstacionamentoDto;
import com.app.modelo.api.entities.CarroModel;
import com.app.modelo.api.entities.EstacionamentoModel;
import com.app.modelo.api.services.CarroService;
import com.app.modelo.api.services.EstacionamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/estacionamento")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<Object> saveEstacionamento(@RequestBody @Valid EstacionamentoDto estacionamentoDto){

        System.out.println(estacionamentoDto.getCarro().getId());
        Optional<CarroModel> carroModelOptional = carroService.findById(estacionamentoDto.getCarro().getId());
        if(carroModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado");
        }
        var estacionamentoModel = new EstacionamentoModel();
        BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
        estacionamentoModel.setDataInicial(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        return ResponseEntity.status(HttpStatus.CREATED).body(estacionamentoService.save(estacionamentoModel));
    }

    @GetMapping
    public ResponseEntity<List<EstacionamentoModel>> getAllEstacionamento(){
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.findall());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEstacionamento(@PathVariable(value = "id") Long id){
        Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.findById(id);
        if(estacionamentoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEstacionamento(@PathVariable(value = "id") Long id,
                                                       @RequestBody @Valid EstacionamentoDto estacionamentoDto){
        Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.findById(id);
        if(estacionamentoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        }
        var estacionamentoModel = new EstacionamentoModel();
        BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
        estacionamentoModel.setId(estacionamentoModel.getId());
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.save(estacionamentoModel));
    }

}
