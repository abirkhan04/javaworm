package com.javaworm.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceLoaderFactory.class)
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Value("${user.oauth.clientId}")
	private String ClientID;
	@Value("${user.oauth.clientSecret}")
	private String ClientSecret;
	@Value("${user.oauth.redirectUris}")
	private String RedirectURLs;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
				.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		System.out.println("client id here -->" + ClientID);
		clients.inMemory().withClient(ClientID).secret(passwordEncoder.encode(ClientSecret))
				.authorizedGrantTypes("client_credentials", "authorization_code", "refresh_token")
				.resourceIds("oauth2-resource")
				.scopes("user_info")
				.redirectUris(RedirectURLs);
	}

}
