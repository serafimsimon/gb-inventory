package ru.gb.inventory.job.services.implementations;

/*import ru.gb.inventory.job.api.JobDto;*/
import ru.gb.inventory.job.api.JobDto;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<JobDto> findAll();

    Optional<JobDto> findById(Long id);

    void addNewJob(JobDto jobDto);

    void deleteById(Long id);

//    List<JobDto> findAllByDepId(Long id);
}
