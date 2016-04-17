package es.paradigma.service.product.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{

	void deleteByUserId(String userId);

}
