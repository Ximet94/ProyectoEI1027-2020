package es.uji.ei1027.clubesportiu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.uji.ei1027.clubesportiu.model.TrabajadorSocial;;

public class TrabajadorSocialValidator implements Validator {
  @Override
  public boolean supports(Class<?> cls) {
	  return TrabajadorSocial.class.equals(cls);
	 // o, si volguérem tractar també les subclasses: 
	 // return Nadador.class.isAssignableFrom(cls);
   }
 
  @Override
  public void validate(Object obj, Errors errors) {
	  TrabajadorSocial ts = (TrabajadorSocial)obj;
	 if (ts.getUsuarioCAS().trim().equals(""))
	       errors.rejectValue("usuarioCAS", "obligatorio",
	                          "Hay que introducir un valor");
	 if(ts.getPwd().length()< 5)
		errors.rejectValue("pwd", "insuficiente", "La contraseña introducida es demasiado corta");
	 if(ts.getTelefono().length()!= 9)
		 errors.rejectValue("telefono","incorrecto","El telefono introducido no es de 9 cifras");
   }
}
