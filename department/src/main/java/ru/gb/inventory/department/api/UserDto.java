package ru.gb.inventory.department.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String firstname;
    private String middlename;
    private int grade;
    private String email;
}

