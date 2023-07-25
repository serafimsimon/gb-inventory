package ru.gb.inventory.user.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.inventory.user.api.UserDto;
import ru.gb.inventory.user.converters.UserConverter;
import ru.gb.inventory.user.entities.User;
import ru.gb.inventory.user.exceptions.ResourceNotFoundException;
import ru.gb.inventory.user.repositories.UserRepository;
import ru.gb.inventory.user.services.UserService;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserConverter userConverter;

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void save(UserDto userDto) {
        userRepository.save(userConverter.dtoToEntity(userDto));
    }

    @Override
    public void changeJob(Long id, Long jobId) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setJobId(jobId);
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public void changeDepartment(Long id, Long departmentId) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setDepartmentId(departmentId);
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public void changeFirstName(Long id, String firstName) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFirstname(firstName);
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public void changeLastName(Long id, String lastName) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLastname(lastName);
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public void changeMiddleName(Long id, String middleName) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setMiddlename(middleName);
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public void changeGrade(Long id, Long grade) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setGrade(grade);
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public List<User> findAllByGrade(Long grade) {
        Optional<List<User>> allByGrade = userRepository.findAllByGrade(grade);
        if (allByGrade.isPresent()) {
            return allByGrade.get();
        }
        throw new ResourceNotFoundException(String.format("С таким grade юзеров не найдено"));
    }

    @Override
    public List<User> findAllByDepartment(Long departmentId) {
        Optional<List<User>> allByDepartmentId = userRepository.findAllByDepartmentId(departmentId);
        if (allByDepartmentId.isPresent()) {
            return allByDepartmentId.get();
        }
        throw new ResourceNotFoundException(String.format("С таким departmentId юзеров не найдено"));
    }

    @Override
    public List<User> findAllByJob(Long jobId) {
        Optional<List<User>> allByJobId = userRepository.findAllByJobId(jobId);
        if (allByJobId.isPresent()) {
            return allByJobId.get();
        }
        throw new ResourceNotFoundException(String.format("С таким jobId юзеров не найдено"));
    }
}