package com.otc.escapegames.db.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.otc.escapegames.core.User;

public class UserMapper implements ResultSetMapper<User> {

    @Override
    public User map(int i, ResultSet rs, StatementContext cxt)
        throws SQLException {

        User user = new User();
        
        //System.out.println("++++++++++++++++++++++++++");
        //System.out.println(rs.getString("first_name"));

        user.setFirstName(rs.getString("first_name"));

        return user;
    }
}
