package es.uji.ei1027.clubesportiu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.uji.ei1027.clubesportiu.model.TrabajadorSocial;;

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
	  PeticionValidator ts = (PeticionValidator)obj;
	 //hay que comprobar que la persona solicitante no tiene ninguna peticion pendiente
   }
}
