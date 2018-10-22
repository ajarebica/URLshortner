package com.shorturltask.shortner;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.ClientResponse.Status;


@Path("register")
public class ConfigurationRegister {
	private UrlService urlService = new UrlService();
	private UserService userService = new UserService();
	private AuthorizationService authService = new AuthorizationService();
	private List<User> users = this.userService.getAllUsers();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Url> getUrls() {
		return urlService.getAllUrls();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUrl(Url url, @HeaderParam("authorization") String authString) throws IOException {
		if(!authService.isUserAuthenticated(authString)){
			System.out.println("User not authorized!");
            return null;
		}
		urlService.addUrl(url);
		

		URI uri;
		try {
			uri = new URI("http://short.com/" + UserService.randomAlphaNumeric(4));
			return Response.status(Status.MOVED_PERMANENTLY).location(uri).build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}
	
	
    @ApplicationPath("webapi")
    public class JAXRSConfigurationOne extends Application {
        @Override
        public Set<Class<?>> getClasses() {
            Set<Class<?>> resources = new HashSet<>();
            resources.add(Url.class);
            return resources;
        }
    }
	
}
