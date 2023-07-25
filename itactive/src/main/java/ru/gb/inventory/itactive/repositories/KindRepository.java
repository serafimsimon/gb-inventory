package ru.gb.inventory.itactive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.gb.inventory.itactive.entities.Type;

import java.util.Optional;

public interface KindRepository extends JpaRepository<Type, Long>, JpaSpecificationExecutor<Type> {

    Optional<Type> findByTitle(String title);

    void deleteByTitle(String title);
}
