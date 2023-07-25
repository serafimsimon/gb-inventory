package ru.gb.inventory.order.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.inventory.order.dto.OrderDetailsDto;
import ru.gb.inventory.order.entities.Order;
import ru.gb.inventory.order.integrations.UserServiceIntegration;
import ru.gb.inventory.order.repositories.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserServiceIntegration userServiceIntegration;

    private final OrderRepository orderRepository;


    @Transactional
    public void createNewOrder(Long userId, OrderDetailsDto orderDetailsDto) {
        //
    }

    public List<Order> findUserOrders(Long userId) {
        return orderRepository.findAllByUserID(userId);
    }
}
