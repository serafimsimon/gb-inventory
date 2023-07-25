package ru.gb.inventory.user.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto{

    @Schema(description = "ID пользователя", required = true, example = "1")
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private Long grade;

    @Schema(description = "e-mail", required = true, example = "IvanovII@gmail.com")
    private String email;

    private DepartmentDto department;

    private JobDto job;


}
