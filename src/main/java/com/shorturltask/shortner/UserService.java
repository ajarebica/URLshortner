package com.shorturltask.shortner;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {
	
	private Map<Long, User> users = UserData.getUsers();
	private AtomicInteger idCounter = new AtomicInteger();
	User user1 = new User(Integer.toString(idCounter.getAndIncrement()),"pass1");
    User user2 = new User(Integer.toString(idCounter.getAndIncrement()), "pass2"); 
    
	public UserService() {
	    	//this.addDefault();
	    }
	    
    public void addDefault() {
    	users.put((long) 1,user1);
    	users.put((long) 2,user2);
    }
	public List<User> getAllUsers() {
		return new ArrayList<User>(users.values()); 
	}
	
	public User addUser(User user) {
		List<User> usersList = this.getAllUsers();
		if(usersList.size() != 0) {
			 for (int x = 0; x < usersList.size(); x++) 
			 {
				 if(usersList.get(x).getAccountID().equals(user.getAccountID())) {
					 return null;
				 }
			 }
			 user.setAccountID(user.getAccountID());
			 String password = randomAlphaNumeric(8);
			 users.put((long) Integer.parseInt(user.getAccountID()), new User(user.getAccountID(),password));
			 return user;
		}
		else {
		user.setAccountID(user.getAccountID());
		String password = randomAlphaNumeric(8);
		users.put((long) Integer.parseInt(user.getAccountID()), new User(user.getAccountID(),password));
		return user;
		}
		
	}
	

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
