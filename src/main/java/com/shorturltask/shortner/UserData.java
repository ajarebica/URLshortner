package com.shorturltask.shortner;

import java.util.HashMap;
import java.util.Map;

public class UserData {

	private static Map<Long, User> users = new HashMap<>();
	
	public static Map<Long, User> getUsers() {
		return users;
	}
}
