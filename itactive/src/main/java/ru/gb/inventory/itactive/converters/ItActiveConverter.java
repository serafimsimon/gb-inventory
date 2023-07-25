package ru.gb.inventory.itactive.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.inventory.itactive.dto.ItActiveDto;
import ru.gb.inventory.itactive.entities.Device;
import ru.gb.inventory.itactive.integrations.UserServiceIntegration;

@Component
@RequiredArgsConstructor
public class ItActiveConverter {

    private final UserServiceIntegration userServiceIntegration;

    public ItActiveDto entityToDto(Device device) {
       return new ItActiveDto(
               device.getId(),
               userServiceIntegration.findUserById(device.getOwnerId()),
               device.getType(),
               device.getBrand(),
               device.getModel(),
               device.getSerialNumber(),
               device.getInventoryNumber(),
               device.getCondition(),
               device.getDescription()
       );

    }

    public Device dtoToEntity(ItActiveDto itActiveDto) {
        Device device = new Device();
        device.setId(itActiveDto.getId());
        device.setOwnerId(itActiveDto.getOwner().getId());
        device.setType(itActiveDto.getType());
        device.setBrand(itActiveDto.getBrand());
        device.setModel(itActiveDto.getModel());
        device.setSerialNumber(itActiveDto.getSerialNumber());
        device.setInventoryNumber(itActiveDto.getInventoryNumber());
        device.setCondition(itActiveDto.getCondition());
        device.setDescription(itActiveDto.getDescription());
        return device;
    }

}
