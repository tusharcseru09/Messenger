package org.koushik.javabrains.messenger.restClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class RestApiClient {
	
	public static void main(String[] args) throws Exception {
		
		
		Client client = ClientBuilder.newClient();
		
/*		
// Step 01
		  Response response = client.target("http://localhost:8989/Messenger/webapi/messages/1").request().get();
		  Message msg = response.readEntity(Message.class);
		  System.out.println(msg.getMessage());
		
*/


/*	
// Step 02
		  WebTarget target = client.target("http://localhost:8989/Messenger/webapi/messages/1");
		  Builder builder = target.request();
		  Response response = builder.get();
		  Message msg = response.readEntity(Message.class);
		  System.out.println(msg.getMessage());
		
*/	


/*		
// Step 03
		  Message msg = client.target("http://localhost:8989/Messenger/webapi/messages/2")
		  .request(MediaType.APPLICATION_JSON)
		  .get(Message.class);
		  System.out.println(msg.getMessage());
		  
*/		 
	

/*
// Step 04
		 	String msg = client.target("http://localhost:8989/Messenger/webapi/messages/2")
		  	.request(MediaType.APPLICATION_JSON)
		  	.get(String.class);
		  	System.out.println(msg);
		  
*/		 
		
		
	
		WebTarget baseTarget = client.target("http://localhost:8989/Messenger/webapi/");
		WebTarget messageTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");
		
		Message message1 = singleMessageTarget
				.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		
		System.out.println(message1.getMessage());
		System.out.println(message2.getMessage());
		
	
		
	}
}
