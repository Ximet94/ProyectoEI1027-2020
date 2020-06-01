package es.uji.ei1027.clubesportiu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="aceptar/{numero}", method=RequestMethod.GET)
	public String aceptarPeticion(Model model, @PathVariable String numero) {
		Peticion pet = peticionDao.getPeticion(Integer.parseInt(numero));
		peticionDao.changeEstado(pet, "aceptada");
		model.addAttribute("peticiones", peticionDao.getPeticiones());
		return "trabajadorSocial/gestionPmPeticiones"; 
	}
	
	@RequestMapping(value="rechazar/{numero}", method=RequestMethod.GET)
	public String rechazarPeticion(Model model, @PathVariable String numero) {
		Peticion pet = peticionDao.getPeticion(Integer.parseInt(numero));
		peticionDao.changeEstado(pet, "rechazada");
		model.addAttribute("peticiones", peticionDao.getPeticiones());
		return "trabajadorSocial/gestionPmPeticiones"; 
	}
	
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
   public String processAddSubmit(@ModelAttribute("peticion") Peticion peticion,
                                   BindingResult bindingResult, HttpSession session, Model model) {
	   PeticionValidator validator = new PeticionValidator();
	   UserDetails user = (UserDetails) session.getAttribute("user");
	   peticion.setDni_personaMayor(user.getUsername());
	   validator.validate(peticion, bindingResult);
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
   	List<Peticion> peticiones = new ArrayList<Peticion>(); 
	peticiones = peticionDao.getPeticionesFromUser(user.getUsername());
	//System.out.println("peticiones " + peticiones);
	model.addAttribute("peticiones", peticiones);
   	 return "personaMayor/portada";
    }

}
