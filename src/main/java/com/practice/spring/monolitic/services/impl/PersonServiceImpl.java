package com.practice.spring.monolitic.services.impl;

import com.practice.spring.monolitic.dto.PersonDTO;
import com.practice.spring.monolitic.dto.SimpleCRUDResponseDTO;
import com.practice.spring.monolitic.errorHandler.exception.ItemNotFoundException;
import com.practice.spring.monolitic.errorHandler.exception.ItemsNotMatchQueryException;
import com.practice.spring.monolitic.model.Person;
import com.practice.spring.monolitic.repositories.PersonRepository;
import com.practice.spring.monolitic.services.contract.PersonService;
import com.practice.spring.monolitic.util.GlobalHelper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private ModelMapper modelMapper;

    public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonDTO findById(Long id) {
        Optional<Person> person = this.personRepository.findById(id);
        if (!person.isPresent())
            throw new ItemNotFoundException("Person", id.toString());

        return this.modelMapper.map(person.get(),PersonDTO.class);
    }

    @Override
    public List<PersonDTO> findAll() {
        List<Person> persons = this.personRepository.findAll();
        if(persons.isEmpty())
            throw new ItemsNotMatchQueryException("Persons");

        return persons.stream()
                .map(person -> this.modelMapper.map(person, PersonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SimpleCRUDResponseDTO save(PersonDTO personDTO) {
        Person person = this.modelMapper.map(personDTO, Person.class);
        person = this.personRepository.save(person);
        return GlobalHelper.createResponse(
                "Person",
                person.getId().toString(),
                GlobalHelper.CRUDActionType.CREATED
        );
    }

    @Override
    public SimpleCRUDResponseDTO update(Long id, PersonDTO personDTO) {
        if(!this.personRepository.existsById(id))
            throw new ItemNotFoundException("Person", id.toString());

        Person person = this.modelMapper.map(personDTO, Person.class);
        person.setId(id);
        this.personRepository.save(person);
        return GlobalHelper.createResponse(
                "Person", id.toString(),
                GlobalHelper.CRUDActionType.UPDATED
        );
    }

    @Override
    public SimpleCRUDResponseDTO deleteById(Long id) {
        if(!this.personRepository.existsById(id))
            throw new ItemNotFoundException("Peron", id.toString());
        return GlobalHelper.createResponse(
                "Person",
               id.toString(),
                GlobalHelper.CRUDActionType.DELETED
        );
    }
}
