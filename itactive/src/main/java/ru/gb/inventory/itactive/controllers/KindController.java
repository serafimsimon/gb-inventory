package ru.gb.inventory.itactive.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.inventory.itactive.converters.KindConverter;
import ru.gb.inventory.itactive.dto.KindDto;
import ru.gb.inventory.itactive.exceptions.ResourceNotFoundException;
import ru.gb.inventory.itactive.services.KindService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/kinds")
@RequiredArgsConstructor
public class KindController {

    private final KindConverter kindConverter;
    private final KindService kindService;

    @GetMapping()
    public List<KindDto> findAll() {
        return kindService.findAll().stream()
                .map(kindConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public KindDto findById(@PathVariable Long id) {
        return kindConverter.entityToDto(kindService.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Kind with id:%s not found", id))));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewKind(@RequestBody KindDto kindDto) {
        kindService.addNewKind(kindDto);
    }

    @DeleteMapping("/{id}")
    public void deleteKindById(@PathVariable Long id) {
        kindService.deleteById(id);
    }






}
