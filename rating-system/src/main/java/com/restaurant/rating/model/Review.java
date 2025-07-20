package com.restaurant.rating.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private Integer rating;
    private String comment; // Может быть null
}