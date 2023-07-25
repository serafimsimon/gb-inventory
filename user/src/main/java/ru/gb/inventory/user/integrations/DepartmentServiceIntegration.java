package ru.gb.inventory.user.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.gb.inventory.user.api.DepartmentDto;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class DepartmentServiceIntegration {

    @Qualifier("departmentServiceWebClient")
    private final WebClient departmentServiceWebClient;

    public List<DepartmentDto> getDepartments() {
        Flux<DepartmentDto> departmentDtoFlux = departmentServiceWebClient.get()
                .uri("/api/v1/departments")
                .retrieve()
                .bodyToFlux(DepartmentDto.class);

        return departmentDtoFlux
                .collect(Collectors.toList())
                .share().block();
    }

    public DepartmentDto getDepartmentById(Long id) {
        return departmentServiceWebClient.get()
                .uri(String.format("/api/v1/departments/%s", id))
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
    }




}