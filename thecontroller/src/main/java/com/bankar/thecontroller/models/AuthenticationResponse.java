package com.bankar.thecontroller.models;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String jwt;
    private String role;
    private String userid;
    
    public AuthenticationResponse(String jwt,String role,String userid) {
        this.jwt = jwt;
        this.role = role;
        this.userid = userid;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
    
    public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	
    public String getJwt() {
        return jwt;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
