package com.shorturltask.shortner;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

public interface UserResource {

	  	@GET
	    @Path("/list")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public Map<String, User> getUserList();
	  
	    @GET
	    @Path("/find")
	    @Produces({ MediaType.APPLICATION_JSON })
	    public User findUser(@QueryParam("id") int id);
	    
	    @POST
	    @Path("/account")
	    @Consumes("application/json")
	    @Produces("application/json")
	    public User createUser(User user);
}
