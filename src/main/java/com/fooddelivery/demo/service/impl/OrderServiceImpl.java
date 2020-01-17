package com.fooddelivery.demo.service.impl;

import com.fooddelivery.demo.dto.OrderDto;
import com.fooddelivery.demo.dto.ProductDto;
import com.fooddelivery.demo.dto.OrderMetaData;
import com.fooddelivery.demo.entity.Order;
import com.fooddelivery.demo.entity.Product;
import com.fooddelivery.demo.entity.Restaurant;
import com.fooddelivery.demo.enums.DeliveryAvgTime;
import com.fooddelivery.demo.repository.OrderRepository;
import com.fooddelivery.demo.service.OrderService;
import com.fooddelivery.demo.service.RestaurantService;
import com.fooddelivery.demo.service.UserService;
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

  private final UserService userService;

  private final RestaurantService restaurantService;

  private final ProductServiceImpl productServiceImpl;

  @Override
  public OrderDto save(OrderMetaData orderMetaData) {

    Order order = new Order();
    List<Product> products = new ArrayList<>();

    for (String name : orderMetaData.getProducts()) {
      products.add(productServiceImpl.findByName(name));
    }

    order.setProducts(products);
    order.setUserId(orderMetaData.getUserId());

    LocalDateTime orderTime = LocalDateTime.now();
    order.setOrderTime(orderTime);

    Set<Restaurant> restaurants = new HashSet<>();
    Double totalCost = 0.0;
    LocalDateTime deliveryTime = LocalDateTime.now();

    for (Product product : products) {
      totalCost += product.getPrice();
      restaurants.add(restaurantService.getRestaurantById(product.getRestaurantId()));
    }
    for (Restaurant restaurant : restaurants) {
      totalCost += restaurant.getDeliveryPrice();
      deliveryTime = restaurant.getDeliveryAvgTime().equals(DeliveryAvgTime.HALF_HOUR)
          ? orderTime.plusMinutes(30)
          : orderTime.plusMinutes(60);
    }
    order.setTotalCost(totalCost);
    order.setDeliveryTime(deliveryTime);
    order.setAddress(userService.findById(orderMetaData.getUserId()).getAddress());

    orderRepository.save(order);

    return convertToDto(order);
  }

  private OrderDto convertToDto(Order order) {

    OrderDto orderDto = new OrderDto();

    orderDto.setOrderTime(order.getOrderTime());
    orderDto.setTotalCost(order.getTotalCost());
    orderDto.setDeliveryTime(order.getDeliveryTime());
    orderDto.setAddress(order.getAddress());

    List<ProductDto> productDtos = new ArrayList<>();
    for (Product product : order.getProducts()) {
      productDtos.add(productServiceImpl.convertToDto(product));
    }

    orderDto.setProducts(productDtos);

    return orderDto;
  }
}
