package chags.spring.cloud.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SpringcloudM4SecurecliApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudM4SecurecliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Starting the job");

		ResourceOwnerPasswordResourceDetails resourceOwnerDetails = new ResourceOwnerPasswordResourceDetails();
		resourceOwnerDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");
		resourceOwnerDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
		resourceOwnerDetails.setClientId("pluralsight");
		resourceOwnerDetails.setClientSecret("pluralsightsecret");
		resourceOwnerDetails.setUsername("user1");
		resourceOwnerDetails.setPassword("pass1");

		OAuth2RestTemplate oaAuth2RestTemplate = new OAuth2RestTemplate(resourceOwnerDetails);

		System.out.println("ACCESS Token " + oaAuth2RestTemplate.getAccessToken().getValue());

		ResponseEntity<String> response = oaAuth2RestTemplate.getForEntity("http://localhost:9001/services/tolldata",
				String.class);

		System.out.println(response.getBody());

	}
}
