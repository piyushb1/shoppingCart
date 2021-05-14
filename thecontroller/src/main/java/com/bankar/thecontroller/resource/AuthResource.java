package com.bankar.thecontroller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankar.thecontroller.models.AuthenticationRequest;
import com.bankar.thecontroller.models.AuthenticationResponse;
import com.bankar.thecontroller.models.UserProfile;
import com.bankar.thecontroller.services.MyUserDetails;
import com.bankar.thecontroller.services.MyUserDetailsService;
import com.bankar.thecontroller.services.UserService;
import com.bankar.thecontroller.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Api( tags = "Clients")
public class AuthResource {
	
	

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;

	@PreAuthorize("hasAuthority('admin')")
	@GetMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	
	@ApiOperation(value = "This method is used to get the clients.")
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final MyUserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		

		return ResponseEntity.ok(new AuthenticationResponse(jwt,userDetails.getAuthorities().toString(),userDetails.getUserid().toString()));
	}

	@PostMapping("/create")
	public ResponseEntity<?> createnewToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		UserProfile user = new UserProfile();
		user.setEmail(authenticationRequest.getUsername());
		user.setPassword(authenticationRequest.getPassword());

		userService.createuser(user);		
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final MyUserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		

		return ResponseEntity.ok(new AuthenticationResponse(jwt,userDetails.getAuthorities().toString(),userDetails.getUserid().toString()));
	}

	
	
	
	
	

}















