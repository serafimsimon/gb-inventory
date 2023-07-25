package ru.gb.inventory.order.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class UserServiceIntegration {

    private final WebClient userServiceWebClient;


//    public UserDto getUserById(Long id) {
//        return userServiceWebClient.get()
//                .uri("api/v1/userService/0")
//                .header("username", username)
//                .retrieve()
//                .bodyToMono(UserDto.class)
//                .block();
//    }
//
//    public void clearCart(String username) {
//        userServiceWebClient.delete()
//                .uri("api/v1/cart/0/clear")
//                .header("username", username)
//                .retrieve()
//                .bodyToMono(Void.class)
//                .block();
//    }

}
