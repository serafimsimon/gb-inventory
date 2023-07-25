package ru.gb.inventory.itactive.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.gb.inventory.itactive.dto.UserDto;

@Component
@RequiredArgsConstructor
public class UserServiceIntegration {

    private final WebClient userServiceWebClient;

    public UserDto findUserById(Long id) {
        return userServiceWebClient.get()
                .uri("api/v1/users/{id}")
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }

}
