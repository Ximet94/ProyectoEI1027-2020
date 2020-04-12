package dao;

import org.springframework.jdbc.core.RowMapper;

import model.TrabajadorSocial;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class TrabajadorSocialRowMapper implements RowMapper<TrabajadorSocial> {
   public TrabajadorSocial mapRow(ResultSet rs, int rowNum) throws SQLException {
       TrabajadorSocial trabajador= new TrabajadorSocial();
       trabajador.setUsuarioCAS(rs.getString("usuarioCAS"));
       trabajador.setNombre(rs.getString("nombre"));
       trabajador.setPwd(rs.getString("pwd"));
       trabajador.setTelefono(rs.getString("telefono"));
       trabajador.setEmail(rs.getString("email"));
       return trabajador;
   }
}
