package es.uji.ei1027.clubesportiu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.clubesportiu.dao.PeticionDao;
import es.uji.ei1027.clubesportiu.model.Peticion;
import es.uji.ei1027.clubesportiu.model.UserDetails;

@Controller
@RequestMapping("/peticion")
public class PeticionController {

	@Autowired
	private PeticionDao peticionDao;
	
	@Autowired
	public void setPeticionDao(PeticionDao peticionDao) {
		this.peticionDao = peticionDao;
	}
	
	@RequestMapping("/list")
	public String listPeticiones(Model model) {
		model.addAttribute("peticiones", peticionDao.getPeticiones());
		return "peticion/list";
	}
	
	@RequestMapping(value="/add")
	public String nuevaPeticion(Model model) {
		System.out.println("nueva peticion");
		model.addAttribute("peticion", new Peticion());
		return "peticion/add";
	}
	
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
   public String processAddSubmit(@ModelAttribute("peticion") Peticion peticion,
                                   BindingResult bindingResult, HttpSession session) {
		System.out.println("2");
	   PeticionValidator validator = new PeticionValidator();
	   validator.validate(peticion, bindingResult);
	   UserDetails user = (UserDetails) session.getAttribute("user");
	   peticion.setDni_personaMayor(user.getUsername());
   	 if (bindingResult.hasErrors())
   			return "peticion/add";
   	 try {   		 
   		 //Añadir la peticion a BBDD
   		 //System.out.println("Añadiendo a base de datos " + peticion.toString());
   		 PeticionDao peticionDao = new PeticionDao();
   		 peticionDao.anadirPeticion(peticion);
   	 }
   	 catch(DuplicateKeyException e){
   		 throw new ClubesportiuException("Ya existe una solicitud para este " + peticion.getDni_personaMayor(), "CPduplicada");
   	 }
   	 return "personaMayor/portada";
    }

}
