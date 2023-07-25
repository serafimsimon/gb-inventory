package ru.gb.inventory.itactive.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.inventory.itactive.converters.ConditionConverter;
import ru.gb.inventory.itactive.dto.ConditionDto;
import ru.gb.inventory.itactive.exceptions.ResourceNotFoundException;
import ru.gb.inventory.itactive.services.implementations.ConditionServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/conditions")
@RequiredArgsConstructor
public class ConditionController {

    private final ConditionConverter conditionConverter;
    private final ConditionServiceImpl conditionService;

    @GetMapping
    public List<ConditionDto> findAll() {
        return conditionService.findAll().stream()
                .map(conditionConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ConditionDto findById(@PathVariable Long id) {
        return conditionConverter.entityToDto(conditionService.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Kind with id:%s not found", id))));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewCondition(@RequestBody ConditionDto conditionDto) {
        conditionService.addNewCondition(conditionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteConditionById(@PathVariable Long id) {
        conditionService.deleteById(id);
    }
}
