package es.uji.ei1027.clubesportiu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.clubesportiu.model.UserDetails;


public class UserRowMapper implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetails user = new UserDetails();
		user.setUsername(rs.getString("username"));;
		user.setPassword(rs.getString("password"));;
		user.setRole(rs.getString("role"));
		
		return user;
	}

}
