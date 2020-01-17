package com.fooddelivery.demo.controller;

import com.fooddelivery.demo.dto.ProductDto;
import com.fooddelivery.demo.entity.Product;
import com.fooddelivery.demo.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping("/product")
  public ProductDto addProduct(@RequestBody Product product) {
    return productService.save(product);
  }

  @GetMapping("/product/{id}")
  public List<ProductDto> showMenu(@PathVariable String id) {
    return productService.findAllById(id);
  }
}
