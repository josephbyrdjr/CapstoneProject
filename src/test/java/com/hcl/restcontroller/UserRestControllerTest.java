package com.hcl.restcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controllers.rest.UserRestController;
import com.hcl.model.User;
import com.hcl.service.UserService;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {
	ObjectMapper mapper;

	@MockBean
	UserService userService;

	@InjectMocks
	UserRestController controllerUnderTest;

	private MockMvc mockMvc;

	@BeforeEach
	public void contextLoads() {
		mapper = new ObjectMapper();

		MockitoAnnotations.openMocks(this);

		this.mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();
	}

	@Test
	public void getAllUsersTest() throws Exception {
		ArrayList<User> arr = new ArrayList<>();
		arr.add(new User(1L, "UsernameTest", "FirstNameTest", "LastNameTest"));
		arr.add(new User(2L, "UsernameTest2", "FirstNameTest2", "LastNameTest2"));

		when(userService.getAllUsers()).thenReturn(arr);

		mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$[0].firstName").value("FirstNameTest"))
				.andExpect(jsonPath("$[1].firstName").value("FirstNameTest2"))
				.andExpect(jsonPath("$[0].lastName").value("LastNameTest"))
				.andExpect(jsonPath("$[1].lastName").value("LastNameTest2"));
	}

	@Test
	public void getUserTest() throws Exception {
		when(userService.getUserById(1L)).thenReturn(new User(1L, "UsernameTest", "FirstNameTest", "LastNameTest"));

		mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$.firstName").value("FirstNameTest"))
				.andExpect(jsonPath("$.lastName").value("LastNameTest"));
	}

//	@Test
//	public void createUserTest() throws Exception {
//		User user = new User("Test1","root", true, "FirstNameTest1", "LastNameTest1","EmailTest1",
//				"PhoneNumberTest1", "AddressTest1", "Apt#Test1", "CityTest1","StateTest1", "ZipcodeTest1");
//
//		mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON)).andDo(print())
//				.andExpect(status().isOk());
//	}

//	@Test
//	public void updateUserTest() throws Exception {
//		User user = new User("Test1","root", true, "FirstNameTest1", "LastNameTest1","EmailTest1",
//				"PhoneNumberTest1", "AddressTest1", "Apt#Test1", "CityTest1","StateTest1", "ZipcodeTest1");
//
//		mockMvc.perform(put("/user").contentType(MediaType.APPLICATION_JSON)).andDo(print())
//				.andExpect(status().isOk());
//	}
}
