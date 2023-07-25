package ru.gb.inventory.itactive.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.inventory.itactive.converters.ConditionConverter;
import ru.gb.inventory.itactive.converters.KindConverter;
import ru.gb.inventory.itactive.converters.ProducerConverter;
import ru.gb.inventory.itactive.dto.ConditionDto;
import ru.gb.inventory.itactive.dto.ItActiveDto;
import ru.gb.inventory.itactive.dto.KindDto;
import ru.gb.inventory.itactive.dto.ProducerDto;
import ru.gb.inventory.itactive.entities.Device;
import ru.gb.inventory.itactive.exceptions.ResourceNotFoundException;
import ru.gb.inventory.itactive.repositories.ItActiveRepository;
import ru.gb.inventory.itactive.services.ItActiveService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItActiveServiceImpl implements ItActiveService {

    private final ItActiveRepository itActiveRepository;
    private final ConditionConverter conditionConverter;
    private final KindConverter kindConverter;
    private final ProducerConverter producerConverter;

    @Override
    public void deleteById(Long id) {
        itActiveRepository.deleteById(id);
    }

    @Override
    public void addNewItActive(ItActiveDto itActiveDto) {
        Device device = new Device();
        device.setOwnerId(itActiveDto.getOwner().getId());
        device.setType(itActiveDto.getType());
        device.setBrand(itActiveDto.getBrand());
        device.setModel(itActiveDto.getModel());
        device.setSerialNumber(itActiveDto.getSerialNumber());
        device.setCondition(itActiveDto.getCondition());
        device.setDescription(itActiveDto.getDescription());
    }

    @Override
    public void changeCondition(Long id, ConditionDto conditionDto) {
        Device device = itActiveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ItActive with Id " + id + " not found"));
        device.setCondition(conditionConverter.dtoToEntity(conditionDto));
    }

    @Override
    public void changeDescription(Long id, String description) {
        Device device = itActiveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ItActive with Id " + id + " not found"));
        device.setDescription(description);
    }

    @Override
    public void changeOwner(Long id, Long ownerId) {
        Device device = itActiveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ItActive with Id " + id + " not found"));
        device.setOwnerId(ownerId);

    }

    @Override
    public void changeKind(Long id, KindDto kindDto) {
        Device device = itActiveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ItActive with Id " + id + " not found"));
        device.setType(kindConverter.dtoToEntity(kindDto));
    }

    @Override
    public void changeProducer(Long id, ProducerDto producerDto) {
        Device device = itActiveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ItActive with Id " + id + " not found"));
        device.setBrand(producerConverter.dtoToEntity(producerDto));
    }

    @Override
    public void changeModel(Long id, String model) {
        Device device = itActiveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ItActive with Id " + id + " not found"));
        device.setModel(model);
    }

    @Override
    public void changeSerialNumber(Long id, String serialNumber) {
        Device device = itActiveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ItActive with Id " + id + " not found"));
        device.setSerialNumber(serialNumber);
    }

    @Override
    public void changeInventoryNumber(Long id, String inventoryNumber) {
        Device device = itActiveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ItActive with Id " + id + " not found"));
        device.setInventoryNumber(inventoryNumber);
    }

    @Override
    public List<Device> findAll() {
        return itActiveRepository.findAll();
    }

    @Override
    public Optional<Device> findById(Long id) {
        return itActiveRepository.findById(id);
    }

    @Override
    public Optional<Device> findBySerialNumber(String serialNumber) {
        return itActiveRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Optional<Device> findByInventoryNumber(String inventoryNumber) {
        return itActiveRepository.findByInventoryNumber(inventoryNumber);
    }

    @Override
    public List<Device> findAllByOwner(Long ownerId) {
        return itActiveRepository.findAllByOwnerId(ownerId);
    }
}
