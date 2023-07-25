package ru.gb.inventory.job.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.inventory.job.api.JobDto;
import ru.gb.inventory.job.services.JobServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/job")
@RequiredArgsConstructor
public class JobController {

    private final JobServiceImpl jobService;

    @GetMapping
    public List<JobDto> findAll() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<JobDto> findById(@PathVariable Long id){
        return jobService.findById(id);
    }

//    @GetMapping("/dep/{id}")
//    public List<JobDto> findByDepId(@PathVariable Long id){
//        return jobService.findAllByDepId(id);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewJob(@RequestBody JobDto jobDto) {
        jobService.addNewJob(jobDto);
    }

    @DeleteMapping("/{id}")
    public void deleteJobById(@PathVariable Long id) {
        jobService.deleteById(id);
    }

//    @GetMapping("/dep/{id}")
//    public List<JobDto> findOnDepId(@PathVariable Long id) {
//        return jobService.findAllByDepId(id);
//    }
}
