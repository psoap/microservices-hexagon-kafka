package net.psoap.mshex.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MsHexUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsHexUserApplication.class, args);
	}

}
