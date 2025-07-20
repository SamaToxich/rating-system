package com.restaurant.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatingSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RatingSystemApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private ReviewService reviewService;

	@Override
	public void run(String... args) {
		// Создание тестовых данных
		User user1 = userService.save(new User(null, "Alice", 28, "Female"));
		Restaurant rest1 = restaurantService.save(
				new Restaurant(null, "La Piazza", "Italian cuisine",
						CuisineType.ITALIAN, new BigDecimal("1500"), null));

		reviewService.addReview(new Review(null, user1.getId(), rest1.getId(), 5, "Excellent!"));
	}
}