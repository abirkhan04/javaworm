package com.javaworm.methodsecurity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.javaworm.service.UserRoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class MethodSecurityApplicationTests {

	@Autowired
	private UserRoleService userRoleService;

	@Configuration
	@ComponentScan("com.javaworm.*")
	public static class SpringConfig {

	}

	@Test
	public void contextLoads() {
	}

	@Test
	@WithMockUser(username = "Khan", roles = { "VIEWER" })
	public void givenRoleViewer_whenCallGetUsername_thenReturnUsername() {
		String userName = userRoleService.getUserName();
		assertEquals("Khan", userName);
	}


    @Test
    @WithMockUser(roles = { "USER" })
    public void givenUsernameJohn_whenCallIsValidUsername_thenReturnTrue() {
        boolean isValid = userRoleService.isValidUserName("Nazrul Islam");
        assertEquals(true, isValid);
   }

}