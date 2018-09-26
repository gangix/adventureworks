package adventure.work.business.processer.productreview;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import adventure.work.business.service.ProductReviewService;
import adventure.work.common.notification.INotifierEmail;
import adventure.work.common.notification.ProductReviewNotification;
import adventure.work.data.entity.ProductReview;

@Service
public class ProductReviewProcesser {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductReviewProcesser.class);
	private final ObjectMapper objectMapper;
	private final ProductReviewService productReviewService;
	private static final String[] BAD_WORDS = { "fee", "nee", "cruul", "leent" };

	@Autowired
	public ProductReviewProcesser(ObjectMapper objectMapper, ProductReviewService productReviewService) {
		this.objectMapper = objectMapper;
		this.productReviewService = productReviewService;
	}

	public void receiveMessage(String roomJson) {
		try {
			LOGGER.info("Message Recieved");
			ProductReview productReview = this.objectMapper.readValue(roomJson, ProductReview.class);
			String comment = productReview.getReview();
			if (existsBadWord(comment)) {
				saveAsInApropriate(productReview);
				return;
			}
			notifyReviewer(productReview);
		} catch (Throwable e) {
			LOGGER.info("Exception on parsing or I/O" + e.getMessage());
		}

	}

	private void saveAsInApropriate(ProductReview productReview) {
		productReview.setInAppropriate(true);
		productReviewService.save(productReview);
	}

	private void notifyReviewer(ProductReview productReview) {
		INotifierEmail<ProductReview> notifier = new ProductReviewNotification();
		notifier.notifyByEmail(productReview);
	}

	private boolean existsBadWord(String comment) {
		return Arrays.stream(BAD_WORDS).parallel().anyMatch(comment::contains);
	}

}
