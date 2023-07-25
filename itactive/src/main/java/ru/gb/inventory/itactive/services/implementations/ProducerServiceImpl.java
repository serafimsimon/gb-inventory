package ru.gb.inventory.itactive.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.inventory.itactive.dto.ProducerDto;
import ru.gb.inventory.itactive.entities.Brand;
import ru.gb.inventory.itactive.repositories.ProducerRepository;
import ru.gb.inventory.itactive.services.ProducerService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository producerRepository;

    @Override
    public Optional<Brand> findById(Long id) {
        return producerRepository.findById(id);
    }

    @Override
    public List<Brand> findAll() {
        return producerRepository.findAll();
    }

    public void addNewProducer(ProducerDto producerDto) {
        Brand brand = new Brand();
        brand.setTitle(producerDto.getTitle());
        producerRepository.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        producerRepository.deleteById(id);
    }
}
