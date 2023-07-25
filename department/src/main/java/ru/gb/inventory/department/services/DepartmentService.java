package ru.gb.inventory.department.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.inventory.department.api.DepartmentDto;
import ru.gb.inventory.department.api.ResourceNotFoundException;
import ru.gb.inventory.department.converters.DepartmentConverter;
import ru.gb.inventory.department.entyties.Department;
import ru.gb.inventory.department.repositories.DepartmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentConverter departmentConverter;

    public List<DepartmentDto> findAll(){
        return departmentRepository.findAll()
                .stream()
                .map(departmentConverter::entityToDto)
                .collect(Collectors.toList());
    }

//    public Specification<Department> createSpecByFilter(String titlePart){
//        Specification<Department> specification = Specification.where(null);
//
//        // select d from Department d where true and like &titlePart&
//        if(titlePart != null){
//            specification = specification.and(DepartmentSpecifications.titleLike(titlePart));
//        }
//        return specification;
//    }

    public Optional<Department> findById(Long id){
        return departmentRepository.findById(id);
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public Department createNewDepartment(DepartmentDto departmentDto){
        Department department = new Department();
        department.setName(departmentDto.getName());
        departmentRepository.save(department);
        return department;
    }

    public void deleteById(Long id){
        departmentRepository.deleteById(id);
    }

    @Transactional
    public void updateDepartmentFromDto(DepartmentDto departmentDto){
        Department department = findById(departmentDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Department id: " + departmentDto.getId() + " not found"));
        department.setName(departmentDto.getName());
    }
}
