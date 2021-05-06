package com.bankar.profile.UserProfile.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bankar.profile.UserProfile.pojo.UserProfile;
import com.bankar.profile.UserProfile.repository.ProfileRepository;
import com.bankar.profile.UserProfile.service.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProfileResourceTest {

	
	@Autowired
	private ProfileService profileServ;	

	
	@MockBean
	private ProfileRepository profilerepository;	
	
	@Autowired
	private ProfileResource profileResource;

	

	@Test
	void testGetAll() {

			when(profilerepository.findAll()).thenReturn(Stream.of(new UserProfile("d5s8d58f5d8s5d","Dude", (long) 59466, "perfect"),
					new UserProfile("d5s8d58f5d8s5d","Dudde", (long) 987654, "poerfect")).collect(Collectors.toList()));
			assertEquals(2, profileServ.getAll().size());
		
	}


	@Test
	void testGetuser() {
			String id = "d5s8d58f5d8s5d";
			UserProfile user = new UserProfile("d5s8d58f5d8s5d","Dude", (long) 59466, "perfect");

			when(profilerepository.findByprofileid(id)).thenReturn(user);
			assertEquals(user, profileResource.getById("d5s8d58f5d8s5d"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
