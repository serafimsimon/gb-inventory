package ru.gb.inventory.itactive.converters;

import org.springframework.stereotype.Component;
import ru.gb.inventory.itactive.dto.ProducerDto;
import ru.gb.inventory.itactive.entities.Brand;

@Component
public class ProducerConverter {

    public ProducerDto entityToDto(Brand brand) {
        return new ProducerDto(brand.getId(), brand.getTitle());
    }
    public Brand dtoToEntity(ProducerDto producerDto) {
        Brand brand = new Brand();
        brand.setId(producerDto.getId());
        brand.setTitle(producerDto.getTitle());
        return brand;
    }
}
