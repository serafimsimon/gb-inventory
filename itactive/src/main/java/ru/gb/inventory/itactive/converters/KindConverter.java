package ru.gb.inventory.itactive.converters;

import org.springframework.stereotype.Component;
import ru.gb.inventory.itactive.dto.KindDto;
import ru.gb.inventory.itactive.entities.Type;

@Component
public class KindConverter {

    public KindDto entityToDto(Type type) {
        return new KindDto(type.getId(), type.getTitle());
    }

    public Type dtoToEntity(KindDto kindDto) {
        Type type = new Type();
        type.setTitle(kindDto.getTitle());
        type.setId(kindDto.getId());
        return type;
    }

}
