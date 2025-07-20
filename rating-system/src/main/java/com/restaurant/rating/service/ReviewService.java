public ReviewDTO.Response addReview(ReviewDTO.Request request) {
    Review review = convertToEntity(request);
    Review savedReview = reviewRepository.save(review);

    updateRestaurantRating(savedReview.getRestaurantId());

    return convertToDTO(savedReview);
}

private void updateRestaurantRating(Long restaurantId) {
    List<Review> reviews = reviewRepository.findByRestaurantId(restaurantId);

    BigDecimal averageRating = reviews.stream()
            .map(review -> BigDecimal.valueOf(review.getRating()))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(reviews.size()), 2, RoundingMode.HALF_UP);

    restaurantRepository.updateRating(restaurantId, averageRating);
}