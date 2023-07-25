package ru.gb.inventory.user.services;

import ru.gb.inventory.user.api.UserDto;
import ru.gb.inventory.user.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Optional<User> findById(Long id);

    public List<User> findAll();

    public void deleteById(Long id);

    public void save(UserDto userDto);

    public void changeJob(Long id, Long jobId);

    public void changeDepartment(Long id, Long departmentId);

    public void changeFirstName(Long id, String firstName);

    public void changeLastName(Long id, String lastName);

    public void changeMiddleName(Long id, String middleName);

    public void changeGrade(Long id, Long grade);

    public List<User> findAllByGrade(Long grade);

    public List<User> findAllByDepartment(Long departmentId);

    public List<User> findAllByJob(Long JobId);
}
