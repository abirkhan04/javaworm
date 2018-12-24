package com.javaworm.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PassEncoder implements PasswordEncoder {

	@Value("${jwt.password.encoder.secret}")
	private String secret;

	@Value("${jwt.password.encoder.iteration}")
	private Integer iteration;

	@Value("${jwt.password.encoder.keylength}")
	private Integer keylength;

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		try {
			byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512").generateSecret(
					new PBEKeySpec(rawPassword.toString().toCharArray(), secret.getBytes(), iteration, keylength))
					.getEncoded();
			return Base64.getEncoder().encodeToString(result);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
