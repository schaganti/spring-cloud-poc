package chags.spring.cloud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@Configuration
public class ServiceConfig {

	@Bean
	public OAuth2RestTemplate restTemplate(OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails,
			OAuth2ClientContext oAuth2ClientContext) {
		return new OAuth2RestTemplate(oAuth2ProtectedResourceDetails, oAuth2ClientContext);
	}
}
