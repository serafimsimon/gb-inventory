package ru.gb.inventory.department.integrations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@AllArgsConstructor
public class UserServiceIntegrations {
    private final WebClient userServiceWebClient;

//    public UserDto getCurrentUser(String username){
//        return userServiceWebClient.get()
//                .uri("api/V1/user/0")
//                .header("username", username)
//                .retrieve()
//                .bodyToMono(UserDto.class)
//                .block();
//    }

    public void clear(String username) {
        userServiceWebClient.get()
                .uri("api/V1/user/0/clear")
                .header("username", username)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
