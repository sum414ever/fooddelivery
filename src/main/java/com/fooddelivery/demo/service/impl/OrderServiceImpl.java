package com.fooddelivery.demo.service.impl;

import static com.fooddelivery.demo.utilit.OrderConverter.convertToDto;

import com.fooddelivery.demo.dto.OrderData;
import com.fooddelivery.demo.dto.OrderDto;
import com.fooddelivery.demo.entity.Order;
import com.fooddelivery.demo.entity.Product;
import com.fooddelivery.demo.entity.Restaurant;
import com.fooddelivery.demo.enums.DeliveryAvgTime;
import com.fooddelivery.demo.repository.OrderRepository;
import com.fooddelivery.demo.service.OrderService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  private final UserServiceImpl userServiceImpl;

  private final RestaurantServiceImpl restaurantServiceImpl;

  private final ProductServiceImpl productServiceImpl;

  @Override
  public OrderDto save(OrderData orderData) {

    Order order = new Order();
    List<Product> products = new ArrayList<>();

    for (String name : orderData.getProducts()) {
      products.add(productServiceImpl.findByName(name));
    }

    order.setProducts(products);
    order.setUserId(orderData.getUserId());

    LocalDateTime orderTime = LocalDateTime.now();
    order.setOrderTime(orderTime);

    Set<Restaurant> restaurants = new HashSet<>();
    Double totalCost = 0.0;
    LocalDateTime deliveryTime = LocalDateTime.now();

    for (Product product : products) {
      totalCost += product.getPrice();
      restaurants.add(restaurantServiceImpl.getRestaurantById(product.getRestaurantId()));
    }
    for (Restaurant restaurant : restaurants) {
      totalCost += restaurant.getDeliveryPrice();
      deliveryTime = restaurant.getDeliveryAvgTime().equals(DeliveryAvgTime.HALF_HOUR)
          ? orderTime.plusMinutes(30)
          : orderTime.plusMinutes(60);
    }
    order.setTotalCost(totalCost);
    order.setDeliveryTime(deliveryTime);
    order.setAddress(userServiceImpl.findById(orderData.getUserId()).getAddress());

    orderRepository.save(order);

    return convertToDto(order);
  }
}
