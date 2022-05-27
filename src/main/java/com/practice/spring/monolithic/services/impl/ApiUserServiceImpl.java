package com.practice.spring.monolithic.services.impl;

import com.practice.spring.monolithic.errorHandler.exception.ItemNotFoundException;
import com.practice.spring.monolithic.errorHandler.exception.ItemsNotMatchQueryException;
import com.practice.spring.monolithic.services.contract.ApiUserService;
import com.practice.spring.monolithic.dto.ApiUserDTO;
import com.practice.spring.monolithic.dto.SimpleCRUDResponseDTO;
import com.practice.spring.monolithic.model.ApiUser;
import com.practice.spring.monolithic.repositories.ApiUserRepository;
import com.practice.spring.monolithic.util.GlobalHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApiUserServiceImpl implements ApiUserService {
    private ApiUserRepository apiUserRepository;
    private ModelMapper modelMapper;

    public ApiUserServiceImpl(ApiUserRepository apiUserRepository, ModelMapper modelMapper) {
        this.apiUserRepository = apiUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiUserDTO findById(Long id) {
        Optional<ApiUser> apiUser = this.apiUserRepository.findById(id);
        if (!apiUser.isPresent())
            throw new ItemNotFoundException("ApiUser", id.toString());

        return this.modelMapper.map(apiUser.get(), ApiUserDTO.class);
    }

    @Override
    public List<ApiUserDTO> findAll() {
        List<ApiUser> apiUsers = this.apiUserRepository.findAll();
        if (apiUsers.isEmpty())
            throw new ItemsNotMatchQueryException("ApiUsers");

        return apiUsers.stream()
                .map(apiUser -> this.modelMapper.map(apiUser, ApiUserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SimpleCRUDResponseDTO save(ApiUserDTO apiUserDTO) {
        ApiUser apiUser = this.modelMapper.map(apiUserDTO, ApiUser.class);
        apiUser = this.apiUserRepository.save(apiUser);
        return GlobalHelper.createResponse(
                "ApiUser",
                apiUser.getId().toString(),
                GlobalHelper.CRUDActionType.CREATED
        );
    }

    @Override
    public SimpleCRUDResponseDTO update(Long id, ApiUserDTO apiUserDTO) {
        if(!this.apiUserRepository.existsById(id))
            throw new ItemNotFoundException("ApiUser", id.toString());
        ApiUser apiUser = this.modelMapper.map(apiUserDTO, ApiUser.class);
        apiUser.setId(id);
        apiUser = this.apiUserRepository.save(apiUser);
        return GlobalHelper.createResponse(
                "ApiUser",
                apiUser.getId().toString(),
                GlobalHelper.CRUDActionType.UPDATED
        );
    }

    @Override
    public SimpleCRUDResponseDTO deleteById(Long id) {
        Optional<ApiUser> apiUser = this.apiUserRepository.findById(id);

        if(!apiUser.isPresent())
            throw new ItemNotFoundException("Hotel", id.toString());

        this.apiUserRepository.deleteById(id);
        return GlobalHelper.createResponse(
                "Hotel",
                id.toString(),
                GlobalHelper.CRUDActionType.DELETED
        );
    }
}
