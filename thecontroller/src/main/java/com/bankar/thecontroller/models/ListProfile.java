package com.bankar.thecontroller.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ListProfile {
	
	private List<UserProfile> listprofile;

	public List<UserProfile> getListproduct() {
		return listprofile;
	}

	public void setListproduct(List<UserProfile> listprofile) {
		this.listprofile = listprofile;
	}

}
