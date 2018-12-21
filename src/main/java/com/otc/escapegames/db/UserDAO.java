package com.otc.escapegames.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.otc.escapegames.core.User;
import com.otc.escapegames.db.mappers.UserMapper;

public interface UserDAO {
	
	
	@SqlQuery("select first_name from users where id = :id")
	@RegisterMapper(UserMapper.class)
	User findName(@Bind("id") int id);

}
