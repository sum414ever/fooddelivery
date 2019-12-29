package com.fooddelivery.demo.service;

import com.fooddelivery.demo.dto.ProductDto;
import com.fooddelivery.demo.entity.Product;
import java.util.List;

public interface ProductService {

  ProductDto save(Product product);

  List<ProductDto> findAll();

  Product findByName(String name);
}
