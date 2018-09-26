package adventure.work.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productreview")
public class ProductReview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProductReviewId")
	private Long id;
	@Column(name = "ProductId", nullable = false)
	private int productid;
	@Column(name = "ReviewerName", length = 50)
	private String name;
	@Column(name = "ReviewDate", nullable = false)
	private LocalDateTime reviewDate;
	@Column(name = "EmailAddress", length = 50)
	private String email;
	@Column(name = "Rating", nullable = true)
	private int rating;
	@Column(name = "Comments", length = 50)
	private String review;
	@Column(name = "ModifiedDate", nullable = false)
	private LocalDateTime modifiedDate;
	@Column(name = "InAppropriate")
	private boolean inAppropriate;

	public ProductReview(int productid, String name, LocalDateTime reviewDate, String email, int rating, String review,
			LocalDateTime modifiedDate, boolean inAppropriate) {
		super();
		this.productid = productid;
		this.name = name;
		this.reviewDate = reviewDate;
		this.email = email;
		this.rating = rating;
		this.review = review;
		this.modifiedDate = modifiedDate;
		this.inAppropriate = inAppropriate;
	}

	public ProductReview() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean isInAppropriate() {
		return inAppropriate;
	}

	public void setInAppropriate(boolean inAppropriate) {
		this.inAppropriate = inAppropriate;
	}

	@Override
	public String toString() {
		return "ProductReview [productid=" + productid + ", name=" + name + ", reviewDate=" + reviewDate + ", email="
				+ email + ", rating=" + rating + ", review=" + review + ", modifiedDate=" + modifiedDate
				+ ", inAppropriate=" + inAppropriate + "]";
	}

}