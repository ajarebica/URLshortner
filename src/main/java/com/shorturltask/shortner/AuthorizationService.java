package com.shorturltask.shortner;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class AuthorizationService {
	
	private UserService userService = new UserService();
	private List<User> users = this.userService.getAllUsers();
	boolean isUserAuthenticated(String authString) throws IOException{
	        
	        String decodedAuth = "";
	
	        String[] authParts = authString.split("\\s+");
	        String authInfo = authParts[1];
	        Base64.Decoder mimeDecoder = java.util.Base64.getMimeDecoder();
	        byte[] bytes = null;
	        bytes =  mimeDecoder.decode(authInfo);
	        decodedAuth = new String(bytes);
	        System.out.println(decodedAuth);
	        String id = decodedAuth.substring(0, decodedAuth.length() - 1);
	        System.out.println(users);
	        
	        for (int x = 0; x < users.size(); x++) 
			 {
				 if(users.get(x).getAccountID().equals(decodedAuth.substring(0, decodedAuth.length() - 1))) {
					 return true;
				 }
			 }
	        return false;	         
	    }
}
