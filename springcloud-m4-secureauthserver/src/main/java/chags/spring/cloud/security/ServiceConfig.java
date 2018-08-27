package chags.spring.cloud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
public class ServiceConfig extends GlobalAuthenticationConfigurerAdapter {

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("{noop}pass1").roles("USER").and().withUser("user2")
				.password("{noop}pass2").roles("USER", "OPERATOR");
	}

	@Bean
	public TokenStore tokenStore(RedisConnectionFactory redisConnectionFactory) {
		return new RedisTokenStore(redisConnectionFactory);
	}
}
