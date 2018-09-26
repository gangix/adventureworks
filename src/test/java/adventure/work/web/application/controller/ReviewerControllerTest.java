package adventure.work.web.application.controller;

import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.ResourceAccessException;

import com.fasterxml.jackson.databind.ObjectMapper;

import adventure.work.business.productreview.model.ProductReviewResponse;
import adventure.work.business.service.ProductReviewService;
import adventure.work.data.entity.ProductReview;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReviewerControllerTest {

	MockMvc mockMvc;

	@Mock
	private ReviewerController reviewerController;

	@Autowired
	private TestRestTemplate template;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ProductReviewService productReviewService;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(reviewerController).build();
	}

	@Test
	public void testProductReviewCreateSucceed() throws Exception {
		HttpEntity<Object> productReviewReq = getHttpEntityAuthHeaders(
				"{\"name\": \"Olcay Bilir\"," + "\"email\": \"olcay.bilir@elvismansion.com\"," + "\"productid\": \"3\","
						+ "\"rating\": \"5\"," + "\"review\": \"Very nice!\"}");

		ResponseEntity<ProductReviewResponse> response = template.postForEntity("/api/reviews", productReviewReq,
				ProductReviewResponse.class);
		Assert.assertEquals(true, response.getBody().isSuccess());
		Optional<ProductReview> productReviewList = productReviewService
				.findReviewByID(response.getBody().getReviewId());
		Assert.assertEquals(true, productReviewList.isPresent());
	}

	@Test
	public void testProductReviewCreateFailed() throws Exception {
		HttpEntity<Object> productReview = getHttpEntityAuthHeaders(
				"{\"name\": \"Olcay Bilir\"," + "\"email\": \"theking@elvismansion.com\"," + "\"productid\": \"8\","
						+ "\"rating\": \"4\"," + "\"review\": \"Very nice!}");

		ResponseEntity<ProductReviewResponse> response = template.postForEntity("/api/reviews", productReview,
				ProductReviewResponse.class);
		Assert.assertEquals(false, response.getBody().isSuccess());
	}

	@Test
	public void testProductReviewCreateAuthError() throws Exception {
		HttpEntity<Object> productReview = getHttpEntityWrongAuth(
				"{\"name\": \"Olcay Bilir\"," + "\"email\": \"theking@elvismansion.com\"," + "\"productid\": \"8\","
						+ "\"rating\": \"4\"," + "\"review\": \"Very nice!}");
		ResponseEntity<ProductReviewResponse> response = null;
		try {
			response = template.postForEntity("/api/reviews", productReview, ProductReviewResponse.class);
		} catch (ResourceAccessException rEx) {
			Assert.assertEquals(true, true);
			return;
		}
		Assert.assertEquals(401, response.getStatusCode());
	}

	@Test
	public void testProductReviewGetById() throws Exception {
		Long reviewId = 3L;
		HttpHeaders headers = getHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<ProductReview> response = template.exchange("/api/reviews/{reviewId}", HttpMethod.GET,
				requestEntity, ProductReview.class, reviewId);
		Assert.assertEquals(200, response.getStatusCode().value());
	}

	@Test
	public void testProductReviewGetByIdAuthError() throws Exception {
		Long reviewId = 3L;
		ResponseEntity<ProductReview> response = template.getForEntity("/api/reviews/{reviewId}", ProductReview.class,
				reviewId);
		Assert.assertEquals(401, response.getStatusCode().value());
	}

	@Test
	public void testProductReviewGetByIdNotFound() throws Exception {
		Long reviewId = 33L;
		HttpHeaders headers = getHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<ProductReview> response = template.exchange("/api/reviews/{reviewId}", HttpMethod.GET,
				requestEntity, ProductReview.class, reviewId);
		Assert.assertEquals(404, response.getStatusCode().value());
	}

	@Test
	public void testProductReviewsSucceed() throws Exception {
		HttpHeaders headers = getHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<ProductReview[]> response = template.exchange("/api/allreviews", HttpMethod.GET, requestEntity,
				ProductReview[].class);
		Assert.assertEquals(200, response.getStatusCode().value());
	}

	@Test
	public void testMockProductReviewUpdateSucceed() throws Exception {
		ProductReview productReview = new ProductReview();
		productReview.setInAppropriate(true);
		productReview.setRating(4);
		productReview.setName("Olcay");
		productReview.setReview("Very Nice!");
		String jSon = objectMapper.writeValueAsString(productReview);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/reviews").content(jSon).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(200));
	}

	private HttpEntity<Object> getHttpEntityAuthHeaders(Object body) {
		HttpHeaders headers = getHeaders();
		return new HttpEntity<Object>(body, headers);
	}

	private HttpEntity<Object> getHttpEntityWrongAuth(Object body) {
		HttpHeaders headers = getWrongHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<Object>(body, headers);
	}

	private HttpHeaders getHeaders() {
		String credential = "adventure:adventure";
		String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + encodedCredential);
		return headers;
	}

	private HttpHeaders getWrongHeaders() {
		String credential = "admin:admin";
		String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + encodedCredential);
		return headers;
	}
}
