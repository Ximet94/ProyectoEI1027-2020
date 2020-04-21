package dao;

import org.springframework.jdbc.core.RowMapper;

import model.Peticion;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class PeticionRowMapper implements RowMapper<Peticion> {
   public Peticion mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Peticion peticion = new Peticion();
       peticion.setNumero(rs.getInt("numero"));
       peticion.setTipo_servicio(rs.getString("tipo_servicio"));
       peticion.setFecha_creacion(rs.getDate("fecha_creacion"));
       peticion.setEstado(rs.getString("estado"));
       peticion.setFecha_aprobacion(rs.getDate("fecha_aprobacion"));
       peticion.setFecha_rechazado(rs.getDate("fecha_rechazado"));
       peticion.setComentarios(rs.getString("comentarios"));
       peticion.setFecha_finalizacion(rs.getDate("fecha_finalizacion"));
       peticion.setDni_personaMayor(rs.getString("dni_personaMayor"));
       peticion.setNumero_factura(rs.getInt("numero_factura"));
       peticion.setNumero_contrato(rs.getInt("numero_contrato"));
       return peticion;
   }
}
