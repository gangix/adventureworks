package adventure.work.common.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import adventure.work.business.service.ProductReviewServiceImpl;
import adventure.work.data.entity.ProductReview;

public class ProductReviewNotification implements INotifierEmail<ProductReview> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductReviewServiceImpl.class);

	@Override
	public void notifyByEmail(ProductReview productReview) {
		LOGGER.info("the reviewer is notified via email. " + productReview.getEmail());
	}

}
