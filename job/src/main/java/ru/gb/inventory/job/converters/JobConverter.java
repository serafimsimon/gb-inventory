package ru.gb.inventory.job.converters;

import org.springframework.stereotype.Component;
import ru.gb.inventory.job.api.JobDto;
import ru.gb.inventory.job.entities.Job;

import java.util.Optional;

@Component
public class JobConverter {

    public static Job dtoToJob(JobDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setDepId(jobDto.getDepId());
        job.setTitle(jobDto.getName());
        job.setDescription(job.getDescription());
        return job;
    }

    public static JobDto jobToDto(Optional<Job> job) {
        return new JobDto(job.get().getId(),
                job.get().getDepId(),
                job.get().getTitle(),
                job.get().getDescription());
    }
}
