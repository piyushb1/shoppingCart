package com.bankar.profile.UserProfile.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.bankar.profile.UserProfile.pojo.UserProfile;
import com.bankar.profile.UserProfile.repository.ProfileRepository;
import com.bankar.profile.UserProfile.service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProfileResourceTest {
	

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProfileService service;	
	
	@MockBean
	private ProfileRepository profilerepository;	
		
	ObjectMapper om = new ObjectMapper();
	
	
	@Test
	void testGetUserProfileByProfileid() throws Exception {
		
		String profileid = "s5d8e5d6d4";
		
		UserProfile profile = new UserProfile(profileid,"Dudde@gmail.com", (long) 987654, "poerfect");
		Mockito.when(service.getByProfileid(profileid)).thenReturn(profile);
		
		MvcResult result = mockMvc.perform(get("/getById/"+profileid)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk()).andDo(print())
	                .andReturn();
	                
		String resultContent = result.getResponse().getContentAsString();
		UserProfile response = om.readValue(resultContent, UserProfile.class);
		
		assertEquals(profile.getMobilenumber(), response.getMobilenumber());
	}
	
	
	@Test
	void testUpdateUserProfileByProfileid() throws Exception {
		
		String profileid = "s5d8e5d6d4";
		
		UserProfile profile = new UserProfile(profileid,"Dudde@gmail.com", (long) 987654, "poerfect");
		Mockito.when(profilerepository.findByprofileid(profileid)).thenReturn(profile);
		
		UserProfile newProfile = new UserProfile(profileid,"Dudde@gmail.com", (long) 987654, "poerfect");
		
		mockMvc.perform(put("/update/"+profileid)
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(newProfile))
	            .accept(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk()).andDo(print())
	            .andReturn();	   
	}
	
	
	@Test
	void testDeleteOrderByid() throws Exception {		
		
		String profileid = "s5d8e5d6d4";
		
		UserProfile orders = new UserProfile("5d6s5d6","Dudde@gmail.com", (long) 987654, "poerfect");
		Mockito.when(service.getByProfileid(profileid)).thenReturn(orders);
		
		mockMvc.perform(delete("/delete/gg5gg")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andReturn();		
	}
	
	
	@Test
	void testNullProfileId() throws Exception {		
		
		mockMvc.perform(get("/getById/")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());		
	}
	
	
	@Test
	void testInvalidURL() throws Exception {		
		
		mockMvc.perform(get("/asdfghjk123456")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());		
	}
	
	
	@Test
	void testInvalidRequestMethod() throws Exception {		
		
		mockMvc.perform(post("/delete/5689")
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isNotFound());		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
