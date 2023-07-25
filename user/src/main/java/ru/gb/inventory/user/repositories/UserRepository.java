package ru.gb.inventory.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.gb.inventory.user.entities.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findByFirstname(String userName);

    Optional<List<User>> findAllByDepartmentId(Long departmentId);

    Optional<List<User>> findAllByJobId(Long jobId);

    Optional<List<User>> findAllByGrade(Long grade);

}