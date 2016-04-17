package es.paradigma.service.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.paradigma.arquitecture.ParadigmaApplication;
import com.paradigma.arquitecture.model.DataAccessMode;

@ParadigmaApplication(dataAccessMode=DataAccessMode.MONGO)
@EnableDiscoveryClient
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
