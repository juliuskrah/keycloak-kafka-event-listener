package com.juliuskrah.keycloak.provider;

import org.keycloak.models.UserModel;

import lombok.Data;

@Data
public class User {
	private String id;
	private String username;
	private String email;

	public static User toUser(UserModel model) {
		User user = new User();
		user.id = model.getId();
		user.username = model.getUsername();
		user.email = model.getEmail();
		return user;
	}
}
