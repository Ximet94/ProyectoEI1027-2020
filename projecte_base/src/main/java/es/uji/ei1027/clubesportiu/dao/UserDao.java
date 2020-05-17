package es.uji.ei1027.clubesportiu.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import es.uji.ei1027.clubesportiu.model.UserDetails;

public interface UserDao {
	UserDetails loadUserByUsername(String username, String password);
 	Collection<UserDetails> listAllUsers();
}