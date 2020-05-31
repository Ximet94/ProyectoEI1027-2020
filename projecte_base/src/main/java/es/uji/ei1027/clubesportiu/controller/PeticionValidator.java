package es.uji.ei1027.clubesportiu.controller;

import java.util.ArrayList;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.clubesportiu.dao.PeticionDao;
import es.uji.ei1027.clubesportiu.model.Peticion;
import es.uji.ei1027.clubesportiu.model.TrabajadorSocial;
import es.uji.ei1027.clubesportiu.model.UserDetails;
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
	  //UserDetails ts = (UserDetails)obj;
	  Peticion ts = (Peticion)obj;
	  System.out.println(ts.getDni_personaMayor());
	 //hay que comprobar que la persona solicitante no tiene ninguna peticion pendiente
	  PeticionDao peticionDao = new PeticionDao();
	  ArrayList<Peticion> peticiones = (ArrayList<Peticion>) peticionDao.getPeticionesFromUser(ts.getDni_personaMayor());
	  System.out.println("Peticion del usuario " + peticiones.toString());
	  for(int i=0;i<peticiones.size();i++) {
		  System.out.println(peticiones.get(i).getNumero() + " - " + peticiones.get(i).getEstado());
		  if(peticiones.get(i).getEstado().equals("pendiente")) {
			  System.out.println("Tienes solicitud pendiente");
			  errors.rejectValue("tipo_servicio", "obligatorio",
                      "Tienes una solicitud pendiente ya!");
		  }
	  }
   }

}
