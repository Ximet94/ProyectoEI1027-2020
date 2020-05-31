package es.uji.ei1027.clubesportiu.controller;

import java.util.ArrayList;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.clubesportiu.dao.PeticionDao;
import es.uji.ei1027.clubesportiu.model.Peticion;
import es.uji.ei1027.clubesportiu.model.TrabajadorSocial;
import groovyjarjarantlr.collections.List;;

public class PeticionValidator implements Validator {
  @Override
  public boolean supports(Class<?> cls) {
	  return PeticionValidator.class.equals(cls);
	 // o, si volguérem tractar també les subclasses: 
	 // return Nadador.class.isAssignableFrom(cls);
   }
  @Override
  public void validate(Object obj, Errors errors) {
	  System.out.println("daofjaso");
	  Peticion ts = (Peticion)obj;
	 //hay que comprobar que la persona solicitante no tiene ninguna peticion pendiente
	  PeticionDao peticionDao = new PeticionDao();
	  ArrayList<Peticion> peticiones = (ArrayList<Peticion>) peticionDao.getPeticionesFromUser(ts.getDni_personaMayor());
	  for(int i=0;i<peticiones.size();i++) {
		  if(peticiones.get(i).getEstado()=="pendiente") {
			  errors.rejectValue("tipo_servicio", "obligatorio",
                      "Tienes una solicitud pendiente ya!");
		  }
	  }
   }

}
