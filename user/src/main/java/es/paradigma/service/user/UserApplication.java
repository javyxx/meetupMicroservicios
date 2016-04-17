package es.paradigma.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.paradigma.arquitecture.ParadigmaApplication;
import com.paradigma.arquitecture.model.DataAccessMode;

@ParadigmaApplication(dataAccessMode=DataAccessMode.MONGO)
@EnableDiscoveryClient
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
