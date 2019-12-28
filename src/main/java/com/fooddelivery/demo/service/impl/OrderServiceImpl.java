package com.fooddelivery.demo.service.impl;

import com.fooddelivery.demo.dto.OrderDto;
import com.fooddelivery.demo.entity.Customer;
import com.fooddelivery.demo.entity.Order;
import com.fooddelivery.demo.entity.Restaurant;
import com.fooddelivery.demo.enums.DeliveryAvgTime;
import com.fooddelivery.demo.repository.OrderRepository;
import com.fooddelivery.demo.service.OrderService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  private final CustomerServiceImpl customerService;

  private final RestaurantServiceImpl restaurantService;

  @Override
  public OrderDto save(String restaurantName, String phoneNumber) {

    Customer customer = customerService.getByPhoneNumber(phoneNumber);

    Restaurant restaurant = restaurantService.getRestaurantByName(restaurantName);

    DeliveryAvgTime deliveryAvgTime = restaurant.getDeliveryAvgTime();

    LocalDateTime orderTime = LocalDateTime.now();

    Order order = new Order();

    LocalDateTime deliveryTime = deliveryAvgTime.equals(DeliveryAvgTime.HALF_HOUR)
        ? orderTime.plusMinutes(30)
        : orderTime.plusMinutes(60);

    order.setOrderTime(orderTime);
    order.setAddress(customer.getAddress());
    order.setPhoneNumber(customer.getPhoneNumber());
    order.setDeliveryTime(deliveryTime);
    order.setProcess(true);
    order.setTotalCost(restaurant.getRestaurantType().getPrice() + restaurant.getDeliveryPrice());

    orderRepository.save(order);

    return convertToDto(order);
  }

  private OrderDto convertToDto(Order order) {

    OrderDto orderDto = new OrderDto();
    orderDto.setPhoneNumber(order.getPhoneNumber());
    orderDto.setOrderTime(order.getOrderTime());
    orderDto.setTotalCost(order.getTotalCost());
    orderDto.setDeliveryTime(order.getDeliveryTime());
    orderDto.setCompleted(order.isCompleted());
    orderDto.setProcess(order.isProcess());
    orderDto.setAddress(order.getAddress());

    return orderDto;
  }
}
