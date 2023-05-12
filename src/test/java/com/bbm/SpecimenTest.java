package com.bbm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.server.authentication.HttpBasicServerAuthenticationEntryPoint;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import lombok.Value;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

@SpringBootTest
@AutoConfigureMockMvc
public class SpecimenTest {

	@Autowired
	private MockMvc mockMvc;

	private String ValidUserName = "abc";
	private String ValidPassword = "abc";

	public SpecimenTest() {
	}

	@Test
	public void simpleSpecimenListPositiveTest() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/specimen")
				.contentType(MediaType.APPLICATION_JSON).with(httpBasic(ValidUserName, ValidPassword))

		).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
	}

	@Test
	public void invalidCredentialsSpecimenListTest() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/specimen")
				.contentType(MediaType.APPLICATION_JSON).with(httpBasic(ValidUserName + "1", ValidPassword))

		).andExpect(MockMvcResultMatchers.status().isUnauthorized()).andReturn();
	}

	private Object HttpBasicAuthentication(String string, String string2) {
		return null;
	}

}
