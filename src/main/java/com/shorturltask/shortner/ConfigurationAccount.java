package com.shorturltask.shortner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.ClientResponse.Status;

@Path("account")
public class ConfigurationAccount {
	
	UserService userService = new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getMessages() {
		return userService.getAllUsers();
	}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object registerAccount(User user) {
    	String password = user.getPassword();
    	if(userService.addUser(user)!= null) {
    		List<User> users = userService.getAllUsers();
    		JSONObject object = new JSONObject();
    		 try {
				object.put("success:", "true");
	    		object.put("description:", "Your account is opened");
	    		object.put("password:", users.get(users.size()-1).getPassword());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    		 Object response = Response.status(Status.OK).entity(object.toString()).build();
    		 return response;
    	}
    	
    	else {
    		JSONObject object = new JSONObject();
			try {
				object.put("success:", "false");
	    		object.put("description:", "Account already exists");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object response = Response.status(Status.OK).entity(object.toString()).build();
			return response;
    	} 
    	
    
    }
    
    @ApplicationPath("webapi")
    public class JAXRSConfigurationOne extends Application {
        @Override
        public Set<Class<?>> getClasses() {
            Set<Class<?>> resources = new HashSet<>();
            resources.add(User.class);
            return resources;
        }
    }
}
