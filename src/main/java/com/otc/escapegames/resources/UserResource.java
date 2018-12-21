package com.otc.escapegames.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.skife.jdbi.v2.DBI;

import com.otc.escapegames.core.User;
import com.otc.escapegames.services.UserService;

@Path("/users/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource{

    private final UserService service;

    public UserResource(final UserService service) {
    	this.service = service;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User get() {
    	//System.out.println("==================================");
    	//System.out.println(service.findName(1).getFirstName());
        return service.findName(1);
    	//return "hihihihihih";
    }

}
