package com.practice.spring.monolitic.controllers;

import com.practice.spring.monolitic.dto.HotelDTO;
import com.practice.spring.monolitic.dto.SimpleCRUDResponseDTO;
import com.practice.spring.monolitic.services.contract.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.hotelService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> findAll(){
        return ResponseEntity.ok().body(this.hotelService.findAll());
    }

    @PostMapping
    public ResponseEntity<SimpleCRUDResponseDTO> save(@RequestBody HotelDTO hotelDTO){
        return ResponseEntity.ok().body(this.hotelService.save(hotelDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleCRUDResponseDTO> update(@RequestBody HotelDTO hotelDTO, @PathVariable Long id){
        return ResponseEntity.ok().body(this.hotelService.update(id, hotelDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimpleCRUDResponseDTO> deleteById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.hotelService.deleteById(id));
    }
}
