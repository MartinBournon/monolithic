package com.practice.spring.monolitic.services.impl;

import com.practice.spring.monolitic.dto.HotelDTO;
import com.practice.spring.monolitic.dto.SimpleCRUDResponseDTO;
import com.practice.spring.monolitic.errorHandler.exception.ItemNotFoundException;
import com.practice.spring.monolitic.errorHandler.exception.ItemsNotMatchQueryException;
import com.practice.spring.monolitic.model.Hotel;
import com.practice.spring.monolitic.repositories.HotelRepository;
import com.practice.spring.monolitic.services.contract.HotelService;
import com.practice.spring.monolitic.util.GlobalHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;
    private ModelMapper modelMapper;

    public HotelServiceImpl(HotelRepository hotelRepository, ModelMapper modelMapper) {
        this.hotelRepository = hotelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HotelDTO findById(Long id) {
        Optional<Hotel> hotel = this.hotelRepository.findById(id);
        if(!hotel.isPresent())
            throw new ItemNotFoundException("hotel", id.toString());
        return this.modelMapper.map(hotel.get(),HotelDTO.class);
    }

    @Override
    public List<HotelDTO> findAll() {
        List<Hotel> hotels = this.hotelRepository.findAll();
        if(hotels.isEmpty())
            throw new ItemsNotMatchQueryException("hotels");

        return hotels.stream()
                .map(hotel -> this.modelMapper.map(hotel, HotelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SimpleCRUDResponseDTO save(HotelDTO hotelDTO) {
        Hotel hotel = this.modelMapper.map(hotelDTO, Hotel.class);
        hotel = this.hotelRepository.save(hotel);
        return GlobalHelper.createResponse(
                "Hotel",
                hotel.getId().toString(),
                GlobalHelper.CRUDActionType.CREATED
        );
    }

    @Override
    public SimpleCRUDResponseDTO update(Long id, HotelDTO hotelDTO) {
        if(!this.hotelRepository.existsById(id))
            throw new ItemNotFoundException("Hotel", id.toString());

        Hotel hotel = this.modelMapper.map(hotelDTO, Hotel.class);
        hotel.setId(id);

        hotel = this.hotelRepository.save(hotel);
        return GlobalHelper.createResponse(
                "Hotel",
                hotel.getId().toString(),
                GlobalHelper.CRUDActionType.UPDATED
        );
    }

    @Override
    public SimpleCRUDResponseDTO deleteById(Long id) {
        Optional<Hotel> hotel = this.hotelRepository.findById(id);

        if(!hotel.isPresent())
            throw new ItemNotFoundException("Hotel", id.toString());

        this.hotelRepository.deleteById(id);
        return GlobalHelper.createResponse(
                "Hotel",
                id.toString(),
                GlobalHelper.CRUDActionType.DELETED
        );
    }
}
