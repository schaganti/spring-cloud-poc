package chags.spring.cloud.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SpringcloudM4SecureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM4SecureServiceApplication.class, args);
	}
}
