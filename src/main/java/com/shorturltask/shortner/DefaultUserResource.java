package com.shorturltask.shortner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultUserResource implements UserResource {
	
	private Map<String, User> list = new HashMap<String, User>();
    private AtomicInteger idCounter = new AtomicInteger();
    
    User user1 = new User(Integer.toString(idCounter.getAndIncrement()),"pass1");
    User user2 = new User(Integer.toString(idCounter.getAndIncrement()), "pass2");
    
    public DefaultUserResource() {
    	this.addDefault();
    }
    
    public void addDefault() {
    	list.put(user1.getAccountID(),user1);
    	list.put(user2.getAccountID(),user2);
    }
    
    @Override
    public Map<String, User> getUserList() {
        return list;
    }

    @Override
    public User findUser(int id) {
        return list.get(id);
    }

    @Override
    public User createUser(User user) {
        user.setAccountID(Integer.toString(idCounter.getAndIncrement()));
        list.put(user.getAccountID(), user);

        return user;
    }
}
