package adventure.work.web.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import adventure.work.business.productreview.model.ProductReviewResponse;
import adventure.work.business.service.ProductReviewService;
import adventure.work.data.entity.ProductReview;

@RestController
public class ReviewerController {
	@Autowired
	ProductReviewService productReviewService;

	@RequestMapping(path = "/api/reviews", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<ProductReviewResponse> createNewProductReview(@RequestBody ProductReview productReview) {
		return ResponseEntity.ok(productReviewService.saveAndProduceMessage(productReview));
	}

	@RequestMapping(path = "/api/reviews/{reviewId}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<ProductReview> getReviewByID(@PathVariable(value = "reviewId", required=true) Long reviewId) {
		Optional<ProductReview> productReviewOpt = productReviewService.findReviewByID(reviewId);
		if (!productReviewOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productReviewOpt.get());
	}
	
	@RequestMapping(path = "/api/allreviews", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<ProductReview>> getReviews() {
		List<ProductReview> productReviewList = productReviewService.getAllReviews();
		if (productReviewList.size()==0) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(productReviewList);
	}
	
	

}
