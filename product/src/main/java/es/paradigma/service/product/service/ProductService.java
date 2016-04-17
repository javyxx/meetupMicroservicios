package es.paradigma.service.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.paradigma.arquitecture.repository.AdvancedSearchRepositoryHelper;

import es.paradigma.service.product.domain.Product;
import es.paradigma.service.product.domain.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private AdvancedSearchRepositoryHelper advancedSearchRepositoryHelper;
		
	public List<Product> findProducts(){
		List<Product> resultado =  this.repository.findAll();
		return resultado;
	}
	
	public List<Product> findByParameters(Map<String,Object> parameters){
		Page<Product> products = advancedSearchRepositoryHelper.findAllByParams(parameters, Product.class);
		List<Product> result = new ArrayList<>(products.getContent());
		return result;
	}
	

	public Product findById(String id) {
		return this.repository.findOne(id);
	}
}
