package ru.gb.inventory.department.converters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.inventory.department.api.DepartmentDto;
import ru.gb.inventory.department.entyties.Department;

@Component
@AllArgsConstructor
public class DepartmentConverter {

    public DepartmentDto entityToDto(Department department){
        return new DepartmentDto(department.getId(), department.getName());
    }

    public Department dtoToEntity(DepartmentDto departmentDto){
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        return department;
    }
}
