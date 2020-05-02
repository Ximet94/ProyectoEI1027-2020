package es.uji.ei1027.clubesportiu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.uji.ei1027.clubesportiu.model.PersonaMayor;;

public class PersonaMayorValidator implements Validator {
  @Override
  public boolean supports(Class<?> cls) {
	  return PersonaMayor.class.equals(cls);
	 // o, si volguérem tractar també les subclasses: 
	 // return Nadador.class.isAssignableFrom(cls);
   }
 
  @Override
  public void validate(Object obj, Errors errors) {
	  PersonaMayor pm= (PersonaMayor)obj;
	  if (pm.getDni().trim().equals(""))
	       errors.rejectValue("dni", "obligatorio",
	                          "Hay que introducir un dni");
	 if(pm.getUserPwd().length()< 5)
		errors.rejectValue("userPwd", "insuficiente", "La contraseña introducida es demasiado corta");
	 if(pm.getTelefono().length()!= 9)
		 errors.rejectValue("telefono","incorrecto","El telefono introducido no es de 9 cifras");
   }
}
