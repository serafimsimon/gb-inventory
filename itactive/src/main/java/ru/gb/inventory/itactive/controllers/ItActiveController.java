package ru.gb.inventory.itactive.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.inventory.itactive.ItActiveApplication;
import ru.gb.inventory.itactive.converters.ItActiveConverter;
import ru.gb.inventory.itactive.dto.ItActiveDto;
import ru.gb.inventory.itactive.integrations.UserServiceIntegration;
import ru.gb.inventory.itactive.services.implementations.ItActiveServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ItActivities")
@RequiredArgsConstructor
public class ItActiveController {

    private final ItActiveServiceImpl itActiveService;
    private final ItActiveConverter itActiveConverter;

    private final UserServiceIntegration userServiceIntegration;

    @GetMapping
    public List<ItActiveDto> findAll() {
        return itActiveService.findAll()
                .stream()
                .map(itActiveConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ItActiveDto findById(@PathVariable Long id) {
        return itActiveConverter.entityToDto(itActiveService.findById(id).get());
    }



    @PostMapping("/{activeId}/owner/change/{ownerId}")
    public void changeOwner(@PathVariable Long activeId, @PathVariable Long ownerId) {
        itActiveService.changeOwner(activeId, ownerId);
    }

    @GetMapping("/{ownerId}/findAll")
    public List<ItActiveDto> findAllByOwner(@PathVariable Long ownerId) {
        return itActiveService.findAllByOwner(ownerId)
                .stream()
                .map(itActiveConverter::entityToDto)
                .collect(Collectors.toList());
    }



}
