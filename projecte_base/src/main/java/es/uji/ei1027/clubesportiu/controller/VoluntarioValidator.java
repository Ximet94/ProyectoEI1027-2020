package es.uji.ei1027.clubesportiu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.uji.ei1027.clubesportiu.model.TrabajadorSocial;
import es.uji.ei1027.clubesportiu.model.Voluntario;;

public class VoluntarioValidator implements Validator {
  @Override
  public boolean supports(Class<?> cls) {
	  return Voluntario.class.equals(cls);
	 // o, si volguérem tractar també les subclasses: 
	 // return Nadador.class.isAssignableFrom(cls);
   }
 
  @Override
  public void validate(Object obj, Errors errors) {
	  Voluntario voluntario= (Voluntario)obj;
	 if (voluntario.getUsuario().trim().equals(""))
	       errors.rejectValue("usuario", "obligatorio",
	                          "Hay que introducir un valor");
	 if(voluntario.getPwd().length()< 5)
		errors.rejectValue("pwd", "insuficiente", "La contraseña introducida es demasiado corta");
	 
   }
}
