package adventure.work.business.productreview.model;

public class ProductReviewResponse {
	private long reviewId;
	private boolean success;

	public ProductReviewResponse() {
	}

	public ProductReviewResponse(long reviewId, boolean success) {
		this.reviewId = reviewId;
		this.success = success;
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
