package ru.gb.inventory.user.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.inventory.user.entities.User;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private Long id;

    private String title;

    private List<User> users;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}
