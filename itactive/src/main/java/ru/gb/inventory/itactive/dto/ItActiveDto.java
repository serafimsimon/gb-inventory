package ru.gb.inventory.itactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.inventory.itactive.entities.Condition;
import ru.gb.inventory.itactive.entities.Type;
import ru.gb.inventory.itactive.entities.Brand;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItActiveDto {

    private Long id;

    private UserDto owner;

    private Type type;

    private Brand brand;

    private String model;

    private String serialNumber;

    private String inventoryNumber;

    private Condition condition;

    private String description;
}