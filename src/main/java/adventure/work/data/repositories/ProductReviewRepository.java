package adventure.work.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import adventure.work.data.entity.ProductReview;

@RestResource(exported = false)
public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {

}
