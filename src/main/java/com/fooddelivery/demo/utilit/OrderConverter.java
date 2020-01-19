package com.fooddelivery.demo.utilit;

import com.fooddelivery.demo.dto.OrderDto;
import com.fooddelivery.demo.dto.ProductDto;
import com.fooddelivery.demo.entity.Order;
import com.fooddelivery.demo.entity.Product;
import com.fooddelivery.demo.service.impl.ProductServiceImpl;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderConverter {

  private static ProductServiceImpl productServiceImpl;

  public static OrderDto convertToDto(Order order) {

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
