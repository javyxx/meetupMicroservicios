package es.paradigma.service.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.paradigma.service.product.domain.Product;
import es.paradigma.service.product.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product",method = RequestMethod.GET)
	@PreAuthorize("@permissions.allowAny('product', 'read')")
	@PostFilter("@permissions.allow(filterObject.id, 'product', 'read')")
	public List<Product> findAll() {
		return productService.findProducts();
	}
	
	@RequestMapping(value = "/product/search",method = RequestMethod.GET)
	@PreAuthorize("@permissions.allowAny('product', 'read')")
	@PostFilter("@permissions.allow(filterObject.id, 'product', 'read')")
	public List<Product> findByParameters(@RequestParam Map<String,Object> parameters) {
		return productService.findByParameters(parameters);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	@PreAuthorize("@permissions.allow(#id, 'product', 'read')")
	public Product findById(@PathVariable("id") String id) {
		return this.productService.findById(id);
	}
}
