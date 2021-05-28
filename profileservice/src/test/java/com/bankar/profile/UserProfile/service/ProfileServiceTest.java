package com.bankar.profile.UserProfile.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bankar.profile.UserProfile.exception.NotFoundException;
import com.bankar.profile.UserProfile.pojo.UserProfile;
import com.bankar.profile.UserProfile.repository.ProfileRepository;
import com.bankar.profile.UserProfile.resource.ProfileResource;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProfileServiceTest {
	
	
	@Autowired
	private ProfileService profileServ;	
	
	@MockBean
	private ProfileRepository profilerepository;	
	
	@MockBean
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
		assertEquals(user, profileServ.getByProfileid(id));
		
	}
	
	
	@Test
	void testFindByMobileNo() {

		String profileid = "d5s8d58f5d8s5d";
		when(profilerepository.findAllBymobilenumber(59466)).thenReturn(new UserProfile(profileid,"Dude", (long) 59466, "perfect"));
		UserProfile user = new UserProfile("d5s8d58f5d8s5d","Dude", (long) 594669, "perfect");
			
		UserProfile response = profileServ.findByMobileNo(59466);
			
		assertEquals(user.getProfileid(), response.getProfileid());
	}

	
	@Test
	void testFindByEmail() {
		
		String email = "Dude@gmail.com";
		UserProfile user = new UserProfile("d5s8d58f5d8s5d",email, (long) 59466, "perfect");
		when(profilerepository.findByemail(email)).thenReturn(user);
		
		assertEquals(user, profileServ.findByEmail(email));		
	}
	
	
	@Test
	void testUpdateUser() {
		
		String profileid = "s6d5w68e9e";
		UserProfile user = new UserProfile(profileid,"Dudde@gmail.com", (long) 59466, "perfect");
		UserProfile updatedUser = new UserProfile(profileid,"Dude@gmail.com", (long) 59466, "perfect");
		when(profilerepository.findByprofileid(profileid)).thenReturn(user);
		
		UserProfile result = profileServ.updateProfile(updatedUser);
		assertEquals(updatedUser.getProfileid(), result.getProfileid());		
	}
	
	
	@Test
	void testDeleteProfileById() {
		
		String id = "d5s8d58f5d8s5d";
		UserProfile user = new UserProfile("d5s8d58f5d8s5d","Dude", (long) 59466, "perfect");
		when(profilerepository.findByprofileid(id)).thenReturn(user);
		
		assertThrows(NotFoundException.class,()->{ profileServ.deleteProfile(id); });
	}
	
	
	
	
	
}
