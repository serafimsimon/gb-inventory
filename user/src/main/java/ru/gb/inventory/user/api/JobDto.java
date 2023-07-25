package ru.gb.inventory.user.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {

    Long id;

    Long depId;

    String title;

    String description;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}
