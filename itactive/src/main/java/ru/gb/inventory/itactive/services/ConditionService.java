package ru.gb.inventory.itactive.services;

import ru.gb.inventory.itactive.dto.ConditionDto;
import ru.gb.inventory.itactive.entities.Condition;

import java.util.List;
import java.util.Optional;

public interface ConditionService {
    List<Condition> findAll();

    Optional<Condition> findById(Long id);


    void deleteById(Long id);


    void addNewCondition(ConditionDto conditionDto);
}
