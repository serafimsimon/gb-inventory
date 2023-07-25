package ru.gb.inventory.itactive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.gb.inventory.itactive.entities.Device;

import java.util.List;
import java.util.Optional;

public interface ItActiveRepository extends JpaRepository<Device, Long>, JpaSpecificationExecutor<Device> {

    Optional<Device> findBySerialNumber(String serialNumber);

    Optional<Device> findByInventoryNumber(String inventoryNumber);

    List<Device> findAllByOwnerId(Long ownerId);
}
