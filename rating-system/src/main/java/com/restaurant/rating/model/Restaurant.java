package com.restaurant.rating.model;
import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private Long id;
    private String name;
    private String description; // Может быть null
    private CuisineType cuisineType;
    private BigDecimal averageBill;
    private BigDecimal rating;
}