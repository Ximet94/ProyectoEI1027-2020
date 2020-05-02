package es.uji.ei1027.clubesportiu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.uji.ei1027.clubesportiu.model.Empresa;;

public class EmpresaValidator implements Validator {
  @Override
  public boolean supports(Class<?> cls) {
	  return Empresa.class.equals(cls);
	 // o, si volguérem tractar també les subclasses: 
	 // return Nadador.class.isAssignableFrom(cls);
   }
 
  @Override
  public void validate(Object obj, Errors errors) {
	  Empresa ts = (Empresa)obj;
	 if (ts.getCif().trim().equals(""))
	       errors.rejectValue("cif", "obligatorio",
	                          "Hay que introducir un valor");
   }
}
