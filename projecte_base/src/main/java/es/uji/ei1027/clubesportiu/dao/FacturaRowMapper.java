package es.uji.ei1027.clubesportiu.dao;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.clubesportiu.model.Factura;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class FacturaRowMapper implements RowMapper<Factura> {
   public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Factura factura= new Factura();
	   factura.setNumero(rs.getInt("numero"));
	   factura.setFecha(rs.getDate("fecha"));
	   factura.setCantidad(rs.getInt("cantidad"));
	   factura.setConcepto(rs.getString("concepto"));
	   factura.setDni_personaMayor(rs.getString("dni_personaMayor"));

       return factura;
   }
}
