package adventure.work.business.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import adventure.work.business.productreview.model.ProductReviewResponse;
import adventure.work.data.entity.ProductReview;
import adventure.work.data.repositories.ProductReviewRepository;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

	@Value("${amqp.queue.name}")
	private String queueName;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductReviewServiceImpl.class);

	private final RabbitTemplate rabbitTemplate;
	private final ObjectMapper objectMapper;
	private final ProductReviewRepository productReviewRepository;

	@Autowired
	public ProductReviewServiceImpl(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper,
			ProductReviewRepository productReviewRepository) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.objectMapper = objectMapper;
		this.productReviewRepository = productReviewRepository;
	}

	@Override
	public ProductReviewResponse saveAndProduceMessage(ProductReview productReview) {
		try {
			ProductReview savedProductReview = save(productReview);
			String jsonString = objectMapper.writeValueAsString(savedProductReview);
			rabbitTemplate.convertAndSend(queueName, jsonString);

			return new ProductReviewResponse(productReview.getId(), true);
		} catch (JsonProcessingException e) {
			LOGGER.error("Parsing Exception", e);
			return new ProductReviewResponse(productReview.getId(), false);
		}
	}

	@Override
	public ProductReview save(ProductReview productReview) {
		if (productReview.getReviewDate() == null) {
			productReview.setReviewDate(LocalDateTime.now());
		}
		productReview.setModifiedDate(LocalDateTime.now());
		return productReviewRepository.save(productReview);
	}

	@Override
	public Optional<ProductReview> findReviewByID(Long id) {
		return productReviewRepository.findById(id);
	}

	@Override
	public List<ProductReview> getAllReviews() {
		Iterable<ProductReview> reviews = productReviewRepository.findAll();
		List<ProductReview> list = new ArrayList<>();
		reviews.forEach(review -> list.add(review));
		return list;
	}

}
