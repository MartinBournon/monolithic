package com.practice.spring.monolithic.controllers;

import com.practice.spring.monolithic.dto.PersonDTO;
import com.practice.spring.monolithic.dto.SimpleCRUDResponseDTO;
import com.practice.spring.monolithic.services.contract.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.personService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll(){
        return ResponseEntity.ok().body(this.personService.findAll());
    }

    @PostMapping
    public ResponseEntity<SimpleCRUDResponseDTO> save(@RequestBody @Validated PersonDTO personDTO){
        return ResponseEntity.ok().body(this.personService.save(personDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleCRUDResponseDTO> update(@PathVariable Long id, @RequestBody @Validated PersonDTO personDTO){
        return ResponseEntity.ok().body(this.personService.update(id, personDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimpleCRUDResponseDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(this.personService.deleteById(id));
    }
}
