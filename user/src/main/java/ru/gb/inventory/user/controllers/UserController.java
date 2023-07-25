package ru.gb.inventory.user.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.inventory.user.api.UserDto;
import ru.gb.inventory.user.converters.UserConverter;
import ru.gb.inventory.user.exceptions.ResourceNotFoundException;
import ru.gb.inventory.user.services.implementations.UserServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final UserConverter userConverter;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll()
                .stream()
                .map(userConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto findByUserId(@PathVariable Long id) {
        return userConverter.entityToDto(userService.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Юзер с Id:%s - не найден", id))));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/{id}/job/change/{jobId}")
    public void changeJob(@PathVariable Long id, @PathVariable Long jobId) {
        userService.changeJob(id, jobId);
    }

    @GetMapping("/{id}/department/change/{departmentId}")
    public void changeDepartment(@PathVariable Long id, @PathVariable Long departmentId) {
        userService.changeDepartment(id, departmentId);
    }

    @GetMapping("/{id}/firstName/change/{firstName}")
    public void changeFirstName(@PathVariable Long id, @PathVariable String firstName) {
        userService.changeFirstName(id, firstName);
    }

    @GetMapping("/{id}/lastName/change/{lastName}")
    public void changeLastName(@PathVariable Long id, @PathVariable String lastName) {
        userService.changeLastName(id, lastName);
    }

    @GetMapping("/{id}/middleName/change/{middleName}")
    public void changeMiddleName(@PathVariable Long id, @PathVariable String middleName) {
        userService.changeMiddleName(id, middleName);
    }

    @GetMapping("/{id}/grade/change/{grade}")
    public void changeGrade(@PathVariable Long id, @PathVariable Long grade) {
        userService.changeGrade(id, grade);
    }

    @GetMapping("/findAllByGrade/{gradeId}")
    public List<UserDto> findAllByGrade(@PathVariable Long gradeId) {
        return userService.findAllByGrade(gradeId).stream()
                .map(userConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/findAllByDepartment/{departmentId}")
    public List<UserDto> findAllByDepartment(@PathVariable Long departmentId) {
        return userService.findAllByDepartment(departmentId).stream()
                .map(userConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/findAllByJob/{jobId}")
    public List<UserDto> findAllByJob(@PathVariable Long jobId) {
        return userService.findAllByJob(jobId).stream()
                .map(userConverter::entityToDto)
                .collect(Collectors.toList());
    }

    


}
