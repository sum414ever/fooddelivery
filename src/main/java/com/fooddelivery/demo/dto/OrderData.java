package com.fooddelivery.demo.dto;

import java.util.List;
import lombok.Data;

@Data
public class OrderData {

  private String userId;

  private List<String> products;
}
