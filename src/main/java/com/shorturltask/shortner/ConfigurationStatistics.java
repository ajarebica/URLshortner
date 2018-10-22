package com.shorturltask.shortner;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.ClientResponse.Status;

@Path("statistic")
public class ConfigurationStatistics {

	private UrlService urlService = new UrlService();
	private AuthorizationService authService = new AuthorizationService();
	
	@GET
	@Path("/{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStatistics(@PathParam("accountId") long id, @HeaderParam("authorization") String authString) throws IOException {
		if(!authService.isUserAuthenticated(authString)){
			System.out.println("User not authorized!");
            return null;
		}
		JSONObject object = new JSONObject();
		List<Url> urls = urlService.getAllUrls();
		for (int x = 0; x < urls.size(); x++) {
			int count = this.findCounts(urls, urls.get(x));
			try {
				object.put(urls.get(x).toString(), Integer.toString(count));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Response response = Response.status(Status.OK).entity(object.toString()).build();
		return response;
		
	}
	
	private int findCounts(List<Url> urls, Url url)  
    { 
		int count = 0;
		int i = 0;
		while( i < urls.size()) {
			if(urls.get(i).equals(url)) {
				count++;
			};
			
		}
		return count;
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
