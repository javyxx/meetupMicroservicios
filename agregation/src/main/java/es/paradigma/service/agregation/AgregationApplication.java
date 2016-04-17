package es.paradigma.service.agregation;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.paradigma.arquitecture.ParadigmaApplication;
import com.paradigma.arquitecture.model.DataAccessMode;

@ParadigmaApplication(dataAccessMode=DataAccessMode.MONGO)
@EnableDiscoveryClient
public class AgregationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgregationApplication.class, args);
	}
}
