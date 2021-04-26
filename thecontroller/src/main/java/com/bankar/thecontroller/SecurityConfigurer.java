package com.bankar.thecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bankar.thecontroller.filters.JwtRequestFilter;
import com.bankar.thecontroller.services.MyUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
		
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(myUserDetailsService);
//		auth.inMemoryAuthentication()
//			.withUser("blah")
//			.password("blah")
//			.roles("user");
	}
	
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	httpSecurity.csrf().disable()
	.authorizeRequests()
	.antMatchers("/authenticate").permitAll()
	.anyRequest().authenticated().and().sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	
}
