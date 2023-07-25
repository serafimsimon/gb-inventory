package ru.gb.inventory.itactive.converters;

import org.springframework.stereotype.Component;
import ru.gb.inventory.itactive.dto.ConditionDto;
import ru.gb.inventory.itactive.entities.Condition;

@Component
public class ConditionConverter {

    public ConditionDto entityToDto(Condition condition) {
        return new ConditionDto(condition.getId(), condition.getTitle());
    }

    public Condition dtoToEntity(ConditionDto conditionDto) {
        Condition condition = new Condition();
        condition.setTitle(conditionDto.getTitle());
        condition.setId(condition.getId());
        return condition;

    }
}
