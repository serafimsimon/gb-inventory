package ru.gb.inventory.itactive.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.inventory.itactive.converters.ProducerConverter;
import ru.gb.inventory.itactive.dto.ProducerDto;
import ru.gb.inventory.itactive.exceptions.ResourceNotFoundException;
import ru.gb.inventory.itactive.services.implementations.ProducerServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/producers")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerServiceImpl producerService;
    private final ProducerConverter producerConverter;

    @GetMapping
    public List<ProducerDto> findAll() {
        return producerService.findAll().stream()
                .map(producerConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProducerDto findById(@PathVariable Long id) {
        return producerConverter.entityToDto(producerService.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Producer with id:%s not found", id))));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProducer(@RequestBody ProducerDto producerDto) {
        producerService.addNewProducer(producerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducerById(@PathVariable Long id) {
        producerService.deleteById(id);
    }

}
