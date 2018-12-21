package com.otc.escapegames.services;

import com.otc.escapegames.core.User;
import com.otc.escapegames.db.UserDAO;

public class UserService {
	
    private final UserDAO dao;
    
    public UserService(final UserDAO dao) {
        this.dao = dao;
    }
    
    public User findName(int id) {
    	System.out.println("==================================");
    	System.out.println(dao.findName(id).getFirstName());
        return dao.findName(id);
    }


}
