package ru.gb.inventory.itactive.services;

import ru.gb.inventory.itactive.dto.KindDto;
import ru.gb.inventory.itactive.entities.Type;

import java.util.List;
import java.util.Optional;

public interface KindService {

    List<Type> findAll();

    void addNewKind(KindDto kindDto);

    Optional<Type> findById(Long id);

    void deleteById(Long id);

}
