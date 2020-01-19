package com.fooddelivery.demo.service.impl;

import com.fooddelivery.demo.dto.ProductDto;
import com.fooddelivery.demo.entity.Product;
import com.fooddelivery.demo.entity.Restaurant;
import com.fooddelivery.demo.exception.ThereIsNoSuchElementException;
import com.fooddelivery.demo.repository.ProductRepository;
import com.fooddelivery.demo.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  private final RestaurantServiceImpl restaurantServiceImpl;

  @Override
  public ProductDto save(Product product) {

    List<Product> menu =
        restaurantServiceImpl.getRestaurantById(product.getRestaurantId()).getMenu() == null
            ? new ArrayList<>()
            : restaurantServiceImpl.getRestaurantById(product.getRestaurantId()).getMenu();
    menu.add(product);
    restaurantServiceImpl.getRestaurantById(product.getRestaurantId()).setMenu(menu);

    productRepository.save(product);

    return convertToDto(product);
  }

  @Override
  public List<ProductDto> findAllById(String id) {

    List<Product> products = productRepository.findAllByRestaurantId(id);
    List<ProductDto> productDtos = new ArrayList<>();

    for (Product product : products) {
      productDtos.add(convertToDto(product));
    }

    return productDtos;
  }

  @Override
  public Product findByName(String name) {
    return productRepository.findByName(name).orElseThrow(ThereIsNoSuchElementException::new);
  }

  public ProductDto convertToDto(Product product) {

    ProductDto productDto = new ProductDto();
    Restaurant restaurant = restaurantServiceImpl.getRestaurantById(product.getRestaurantId());

    productDto.setName(product.getName());
    productDto.setPrice(product.getPrice());
    productDto.setRestaurantName(restaurant.getName());

    return productDto;
  }
}
