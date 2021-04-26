package com.bankar.thecontroller.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bankar.thecontroller.models.UserProfile;

public class MyUserDetails implements UserDetails{
	
	private String userName;
    private String password;
    private String userid;
    private boolean isActive;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(UserProfile user) {
        this.userName = user.getEmail();
        this.password = user.getPassword();
        this.userid = (user.getProfileid());
        this.isActive = user.isActive();
        this.authorities = Arrays.stream(user.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	public String getUserid() {
		return userid;
	}

}