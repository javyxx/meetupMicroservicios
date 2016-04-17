package es.paradigma.service.agregation.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
@RefreshScope
@Service
public class AgregationService {
	
    @Value("${sendProducts}")
    private boolean sendProducts;
	

	@Autowired
	@LoadBalanced
	private RestTemplate loadBalanced;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LinkedHashMap findUserById(String id, MultiValueMap<String,String> headers) {
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<LinkedHashMap> result = loadBalanced.exchange("http://userService/api/v1/user/" + id,
				HttpMethod.GET, request, LinkedHashMap.class);
		LinkedHashMap user = result.getBody();
		if(sendProducts){
			ResponseEntity<List> projects = loadBalanced.exchange(
					"http://productService/api/v1/product/search?filter=userId:" + id, HttpMethod.GET, request,
					List.class);
			user.put("products", projects.getBody());
		}

		return user;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public List findProductByParameters(Map<String,Object> params, MultiValueMap<String,String> headers) {
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<List> products = loadBalanced.exchange(
				"http://productService/api/v1/product", HttpMethod.GET, request,
				List.class, params);
		return products.getBody();
	}
	
	public void deleteUser(String id, MultiValueMap<String,String> headers) {  
		HttpEntity<String> request = new HttpEntity<>(headers);
		loadBalanced.exchange("http://userService/api/v1/user/" + id,
				HttpMethod.DELETE, request, String.class);
	}
}