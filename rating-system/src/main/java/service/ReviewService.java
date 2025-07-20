@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public Review addReview(Review review) {
        Review savedReview = reviewRepository.save(review);
        updateRestaurantRating(savedReview.getRestaurantId());
        return savedReview;
    }

    private void updateRestaurantRating(Long restaurantId) {
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurantId);
        BigDecimal average = reviews.stream()
                .map(r -> BigDecimal.valueOf(r.getRating()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(reviews.size()), 2, RoundingMode.HALF_UP);

        restaurantRepository.findById(restaurantId)
                .ifPresent(r -> r.setRating(average));
    }
}