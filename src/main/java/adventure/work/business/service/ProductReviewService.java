package adventure.work.business.service;

import java.util.List;
import java.util.Optional;

import adventure.work.business.productreview.model.ProductReviewResponse;
import adventure.work.data.entity.ProductReview;

public interface ProductReviewService {

	ProductReviewResponse saveAndProduceMessage(ProductReview productReview);

	ProductReview save(ProductReview productReview);

	Optional<ProductReview> findReviewByID(Long id);

	List<ProductReview> getAllReviews();

}
