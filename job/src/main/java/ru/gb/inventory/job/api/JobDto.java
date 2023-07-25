package ru.gb.inventory.job.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobDto {

    Long id;
    Long depId;
    String name;
    String description;

}
