package com.restaurant.rating.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    @NonNull private Integer age;
    @NonNull private String gender;
}