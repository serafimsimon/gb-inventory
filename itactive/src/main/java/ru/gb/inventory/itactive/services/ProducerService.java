package ru.gb.inventory.itactive.services;

import ru.gb.inventory.itactive.dto.ProducerDto;
import ru.gb.inventory.itactive.entities.Brand;

import java.util.List;
import java.util.Optional;


public interface ProducerService {

    Optional<Brand> findById(Long id);

    List<Brand> findAll();

    void addNewProducer(ProducerDto producerDto);

    void deleteById(Long id);

}
