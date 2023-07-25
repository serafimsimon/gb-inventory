package ru.gb.inventory.job.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.inventory.job.api.JobDto;
import ru.gb.inventory.job.converters.JobConverter;
import ru.gb.inventory.job.entities.Job;
import ru.gb.inventory.job.repositories.JobRepository;
import ru.gb.inventory.job.services.implementations.JobService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public List<JobDto> findAll() {
        return jobRepository.findAll()
                .stream()
                .map((Job job) -> JobConverter.jobToDto(Optional.ofNullable(job)))
                .collect(Collectors.toList());
    }

    //public List<JobDto> findAllByDepId(Long id) {
    //    return jobRepository.findAllByDepId()
    //            .stream()
    //            .map((Job job) -> JobConverter.jobToDto(Optional.ofNullable(job)))
    //            .collect(Collectors.toList());
    //}

    @Override
    public Optional<JobDto> findById(Long id) {
        return Optional.ofNullable(JobConverter.jobToDto(jobRepository.findById(id)));
    }

    @Override
    public void addNewJob(JobDto jobDto) {
        Job job = JobConverter.dtoToJob(jobDto);
        jobRepository.save(job);
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }
}
