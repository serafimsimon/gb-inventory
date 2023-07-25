package ru.gb.inventory.itactive.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.inventory.itactive.dto.KindDto;
import ru.gb.inventory.itactive.entities.Type;
import ru.gb.inventory.itactive.repositories.KindRepository;
import ru.gb.inventory.itactive.services.KindService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KindServiceImpl implements KindService {

    private final KindRepository kindRepository;

    @Override
    public List<Type> findAll() {
        return kindRepository.findAll();
    }

    @Override
    public void addNewKind(KindDto kindDto) {
        Type type = new Type();
        type.setTitle(kindDto.getTitle());
        kindRepository.save(type);
    }

    @Override
    public Optional<Type> findById(Long id) {
        return kindRepository.findById(id);
    }


    @Override
    public void deleteById(Long id) {
        kindRepository.deleteById(id);
    }

}
