package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.clubesportiu.dao.VoluntarioDao;
import es.uji.ei1027.clubesportiu.model.Voluntario;

@Controller
@RequestMapping("/voluntario")
public class VoluntarioController {

	@Autowired
	private VoluntarioDao voluntarioDao;
	
	@Autowired
	public void setVoluntarioDao(VoluntarioDao voluntarioDao) {
		this.voluntarioDao = voluntarioDao;
	}
	
	@RequestMapping("/list")
	public String listVoluntarios(Model model) {
		model.addAttribute("voluntarios", voluntarioDao.getVoluntarios());
		return "voluntario/list";
	}
	
	@RequestMapping("/portada")
	public String portada(Model model) {
		System.out.println("encontrado template");
		//model.addAttribute("voluntarios", voluntarioDao.getVoluntarios());
		return "voluntario/list";
	}
	
	@RequestMapping("/indexVoluntario")
	   public String gestionTrabajador(Model model) {
	      return "voluntario/indexVoluntario";
	   }
	
	@RequestMapping("/add")
	   public String addTrabajadorSocial(Model model) {
		   model.addAttribute("voluntario", new Voluntario());
	      return "voluntario/add";
	   }
	
	//Añadido codigo de validacion de trabajador Social
   @RequestMapping(value="/add", method=RequestMethod.POST)
   public String processAddSubmit(@ModelAttribute("voluntario") Voluntario voluntario,
                                   BindingResult bindingResult) {
	   VoluntarioValidator tsValidator = new VoluntarioValidator();
	   tsValidator.validate(voluntario, bindingResult);
   	 if (bindingResult.hasErrors())
   			return "voluntario/add";
   	 try {
   		voluntarioDao.addVoluntario(voluntario); 
   	 }
   	 catch(DuplicateKeyException e){
   		 throw new ClubesportiuException("Ya existe un voluntario con ese nombre de usuario " + voluntario.getUsuario(), "CPduplicada");
   	 }
   	 return "redirect:list";
    }
   
   @RequestMapping(value="/update/{usuario}", method = RequestMethod.GET)
	public String editVoluntario(Model model, @PathVariable String usuario) {
		model.addAttribute("voluntario", VoluntarioDao.getVoluntario(usuario));
		return "voluntario/update"; 
	}
  
  @RequestMapping(value="/update", method = RequestMethod.POST) 
	public String processUpdateSubmit(@ModelAttribute("voluntario") Voluntario voluntario, 
                          BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "voluntario/update";
		 voluntarioDao.updateVoluntario(voluntario);
		 return "redirect:list"; 
	}

  @RequestMapping(value="/delete/{usuario}")
	public String processDelete(@PathVariable String usuario) {
	  voluntarioDao.deleteVoluntario(usuario);
         return "redirect:../list"; 
	}
}
