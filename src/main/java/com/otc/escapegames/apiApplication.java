package com.otc.escapegames;

import org.skife.jdbi.v2.DBI;

import com.otc.escapegames.db.UserDAO;
import com.otc.escapegames.resources.UserResource;
import com.otc.escapegames.services.UserService;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class apiApplication extends Application<apiConfiguration> {

    public static void main(final String[] args) throws Exception {
    	
        new apiApplication().run(args);
        
    }

    @Override
    public String getName() {
        return "api";
    }

    @Override
    public void initialize(final Bootstrap<apiConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final apiConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application

    	final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, 
        		configuration.getDataSourceFactory(), "database");
       
        final UserDAO userDao = jdbi.onDemand(UserDAO.class);
        final UserService userService = new UserService(userDao);
        environment.jersey().register(new UserResource(userService));
        
        environment.getObjectMapper().configure(com.fasterxml.jackson.core.JsonGenerator
                .Feature.IGNORE_UNKNOWN, true);

    }
    
    

}
