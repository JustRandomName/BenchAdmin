package project;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author n.zhuchkevich
 * @since 09/22/2020
 * */
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = {"model.entity"})
public class AdminApplication {
	public static void main(final String[] args) {
		run(AdminApplication.class, args);
	}
}
