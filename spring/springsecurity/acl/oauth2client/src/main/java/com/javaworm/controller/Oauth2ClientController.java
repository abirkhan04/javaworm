package com.javaworm.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javaworm.constants.CommonConstants;
import org.apache.commons.codec.binary.Base64;

@RestController
@RequestMapping("/login")
public class Oauth2ClientController {

	@GetMapping(value = "/oauth2/code")
	public ResponseEntity<String> getOauthCode(@RequestParam("code") String code) {
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		String credentials = CommonConstants.CLIENT_CREDENTIALS;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add(CommonConstants.AUTHORIZATION, CommonConstants.BASIC + encodedCredentials);
		HttpEntity<String> request = new HttpEntity<String>(headers);
		String access_token_url = CommonConstants.ACCESS_TOKEN_URL;
		access_token_url += CommonConstants.ACCESS_TOKEN_URL_CODE + code;
		access_token_url += CommonConstants.GRANT_TYPE;
		access_token_url += CommonConstants.REDIRECT_URI;
		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
		// stringRedisTemplate.opsForValue().set(CommonConstants.ACCESS_TOKEN_KEY,
		// response.getBody());
		return response;
	}

}
