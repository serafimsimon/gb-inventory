package ru.gb.inventory.user.converters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.inventory.user.api.UserDto;
import ru.gb.inventory.user.entities.User;
import ru.gb.inventory.user.integrations.DepartmentServiceIntegration;
import ru.gb.inventory.user.integrations.JobServiceIntegration;

@Component
@AllArgsConstructor

public class UserConverter {

    private final JobServiceIntegration jobServiceIntegration;
    private final DepartmentServiceIntegration departmentServiceIntegration;


    public UserDto entityToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getMiddlename(),
                user.getGrade(),
                user.getEmail(),
                departmentServiceIntegration.getDepartmentById(user.getDepartmentId()),
                jobServiceIntegration.getJobById(user.getJobId())
        );
    }

    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setFirstname(userDto.getFirstName());
        user.setLastname(userDto.getLastName());
        user.setMiddlename(userDto.getMiddleName());
        user.setGrade(userDto.getGrade());
        user.setEmail(userDto.getEmail());
        user.setDepartmentId(userDto.getDepartment().getId());
        user.setJobId(userDto.getJob().getId());
        return user;
    }


}
