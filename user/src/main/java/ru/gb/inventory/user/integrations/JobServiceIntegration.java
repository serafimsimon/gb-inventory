package ru.gb.inventory.user.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.gb.inventory.user.api.JobDto;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class JobServiceIntegration {

    @Qualifier("jobServiceWebClient")
    private final WebClient jobServiceWebClient;

    public List<JobDto> getJobs() {
        Flux<JobDto> jobDtoFlux = jobServiceWebClient.get()
                .uri("/api/v1/job")
                .retrieve()
                .bodyToFlux(JobDto.class);

        return jobDtoFlux
                .collect(Collectors.toList())
                .share().block();
    }

    public JobDto getJobById(Long id) {
        return jobServiceWebClient.get()
                .uri(String.format("/api/v1/job/%s", id))
                .retrieve()
                .bodyToMono(JobDto.class)
                .block();
    }

}
