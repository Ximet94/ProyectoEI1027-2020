
package es.uji.ei1027.clubesportiu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.clubesportiu.dao.PersonaMayorDao;
import es.uji.ei1027.clubesportiu.dao.TrabajadorSocialDao;
import es.uji.ei1027.clubesportiu.model.PersonaMayor;
import es.uji.ei1027.clubesportiu.model.TrabajadorSocial;

@Controller
@RequestMapping("/personaMayor")
public class PersonaMayorController {

	@Autowired
   PersonaMayorDao personaMayorDao;

   @Autowired
   public void setPersonaMayorDao(PersonaMayorDao personaMayorDao) {
       this.personaMayorDao = personaMayorDao;
   }
   
   @RequestMapping("/indexPersonaMayor")
   public String gestionPersonaMayor(Model model) {
      return "personaMayor/indexPersonaMayor";
   }
   
   // Operacions: Crear, llistar, actualitzar, esborrar
   // ..
   
	@RequestMapping("/list")
	public String listPersonasMayores(Model model) {
		List<PersonaMayor> personas = PersonaMayorDao.getPersonasMayores();
		model.addAttribute("personas", personas);
		return "personaMayor/list";
	}
	
	@RequestMapping("/add")
	public String addPersonaMayor(Model model) {
		model.addAttribute("persona", new PersonaMayor());
		return "personaMayor/add";
	}
	
	//Añadido codigo de validacion de trabajador Social
   @RequestMapping(value="/add", method=RequestMethod.POST)
   public String processAddSubmit(@ModelAttribute("persona") PersonaMayor persona,
                                   BindingResult bindingResult) {
	   PersonaMayorValidator pmValidator = new PersonaMayorValidator();
	   pmValidator.validate(persona, bindingResult);
   	 if (bindingResult.hasErrors())
   			return "personaMayor/add";
   	 try {   		 
   		 personaMayorDao.addPersonaMayor(persona); 
   	 }
   	 catch(DuplicateKeyException e){
   		 throw new ClubesportiuException("Ya existe una persona mayor con este dni " + persona.getDni(), "CPduplicada");
   	 }
   	 return "redirect:list";
    }
   @RequestMapping(value="/update/{dni}", method = RequestMethod.GET)
	public String editPersonaMayor(Model model, @PathVariable String dni) {
		model.addAttribute("persona", PersonaMayorDao.getPersonaMayor(dni));
		return "personaMayor/update"; 
	}
  
  @RequestMapping(value="/update", method = RequestMethod.POST) 
	public String processUpdateSubmit(@ModelAttribute("persona") PersonaMayor persona, 
                          BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "personaMayor/update";
		 PersonaMayorDao.updatePersonaMayor(persona);
		 return "redirect:list"; 
	}

  @RequestMapping(value="/delete/{dni}")
	public String processDelete(@PathVariable String dni) {
	  PersonaMayorDao.deletePersonaMayor(dni);
         return "redirect:../list"; 
	}
}
