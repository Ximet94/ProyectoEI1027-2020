package es.uji.ei1027.clubesportiu.controller;

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
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
   public String processAddSubmit(@ModelAttribute("peticion") Peticion peticion,
                                   BindingResult bindingResult) {
	   PeticionValidator validator = new PeticionValidator();
	   validator.validate(peticion, bindingResult);
   	 if (bindingResult.hasErrors())
   			return "peticion/add";
   	 try {   		 
   		 //trabajadorDao.addTrabajadorSocial(trabajador); 
   	 }
   	 catch(DuplicateKeyException e){
   		 //throw new ClubesportiuException("Ya existe una solicitud para este " + trabajador.getUsuarioCAS(), "CPduplicada");
   	 }
   	 return "redirect:list";
    }

}
