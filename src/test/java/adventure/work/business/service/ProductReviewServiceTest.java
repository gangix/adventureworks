package adventure.work.business.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import adventure.work.data.entity.ProductReview;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductReviewServiceTest {

	@Autowired
	private ProductReviewService productReviewService;

	
	@Test
	public void testIfUpdateSucceed() throws Exception {
		ProductReview productReview = new ProductReview();
		productReview.setId(4L);
		productReview.setInAppropriate(true);
		productReview.setRating(4);
		productReview.setEmail("olcay.bilir@gmail.com");
		productReview.setName("Olcay");
		productReview.setReview("Very Nice!");
		productReviewService.save(productReview);
		Optional<ProductReview> getOptReview = productReviewService.findReviewByID(4L);
		Assert.assertEquals(true,getOptReview.isPresent());
		Assert.assertEquals(productReview.getEmail(),getOptReview.get().getEmail());
		Assert.assertEquals(productReview.getName(),getOptReview.get().getName());
		Assert.assertEquals(productReview.getRating(),getOptReview.get().getRating());
		Assert.assertEquals(productReview.getReview(),getOptReview.get().getReview());
	}

}
