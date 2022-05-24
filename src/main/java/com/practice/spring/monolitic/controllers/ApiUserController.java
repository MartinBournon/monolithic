package com.practice.spring.monolitic.controllers;

import com.practice.spring.monolitic.dto.ApiUserDTO;
import com.practice.spring.monolitic.dto.SimpleCRUDResponseDTO;
import com.practice.spring.monolitic.services.contract.ApiUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class ApiUserController {
    private ApiUserService apiUserService;

    public ApiUserController(ApiUserService apiUserService) {
        this.apiUserService = apiUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiUserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.apiUserService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ApiUserDTO>> findAll(){
        return ResponseEntity.ok().body(this.apiUserService.findAll());
    }

    @PostMapping
    public ResponseEntity<SimpleCRUDResponseDTO> save(@RequestBody @Validated  ApiUserDTO apiUserDTO){
        return ResponseEntity.ok().body(this.apiUserService.save(apiUserDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleCRUDResponseDTO> update(@RequestBody @Validated ApiUserDTO apiUserDTO,@PathVariable Long id){
        return ResponseEntity.ok().body(this.apiUserService.update(id, apiUserDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimpleCRUDResponseDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(this.apiUserService.deleteById(id));
    }
}
