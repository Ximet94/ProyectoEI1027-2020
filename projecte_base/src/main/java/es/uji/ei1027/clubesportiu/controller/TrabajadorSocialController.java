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

import es.uji.ei1027.clubesportiu.dao.TrabajadorSocialDao;
import es.uji.ei1027.clubesportiu.model.TrabajadorSocial;

@Controller
@RequestMapping("/trabajadorSocial")
public class TrabajadorSocialController {

	@Autowired
   private TrabajadorSocialDao trabajadorDao;

   @Autowired
   public void setTrabajadorSocialDao(TrabajadorSocialDao trabajadorDao) {
       this.trabajadorDao=trabajadorDao;
   }
   
   @RequestMapping("/indexTrabajadorSocial")
   public String gestionTrabajador(Model model) {
      return "trabajadorSocial/indexTrabajadorSocial";
   }
   
   @RequestMapping("/provaTrabajador")
   public String provaUnTrabajador(Model model) {
	  TrabajadorSocial ts = TrabajadorSocialDao.getTrabajadorSocial("PepeLu");
      model.addAttribute("message", ts.toString());
      return "trabajadorSocial/prova";
   }


   // Operacions: Crear, llistar, actualitzar, esborrar
   // ...
   
   @RequestMapping("/list")
   public String listTrabajadores(Model model) {
	   List<TrabajadorSocial> trabajadores = TrabajadorSocialDao.getTrabajadoresSociales();
	   model.addAttribute("trabajadores", trabajadores);
      return "trabajadorSocial/list";
   }

   @RequestMapping("/add")
   public String addTrabajadorSocial(Model model) {
	   model.addAttribute("trabajador", new TrabajadorSocial());
      return "trabajadorSocial/add";
   }
   
   @RequestMapping(value="/update/{usuarioCAS}", method = RequestMethod.GET)
	public String editTrabajadorSocial(Model model, @PathVariable String usuarioCAS) {
		model.addAttribute("trabajador", TrabajadorSocialDao.getTrabajadorSocial(usuarioCAS));
		return "trabajadorSocial/update"; 
	}
   
   @RequestMapping(value="/update", method = RequestMethod.POST) 
	public String processUpdateSubmit(@ModelAttribute("trabajador") TrabajadorSocial trabajador, 
                           BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "trabajadorSocial/update";
		 trabajadorDao.updateTrabajadorSocial(trabajador);
		 return "redirect:list"; 
	}

   @RequestMapping(value="/delete/{usuarioCAS}")
	public String processDelete(@PathVariable String usuarioCAS) {
	   trabajadorDao.deleteTrabajadorSocial(usuarioCAS);
          return "redirect:../list"; 
	}

   //Añadido codigo de validacion de trabajador Social
   @RequestMapping(value="/add", method=RequestMethod.POST)
   public String processAddSubmit(@ModelAttribute("trabajador") TrabajadorSocial trabajador,
                                   BindingResult bindingResult) {
	   TrabajadorSocialValidator tsValidator = new TrabajadorSocialValidator();
	   tsValidator.validate(trabajador, bindingResult);
   	 if (bindingResult.hasErrors())
   			return "trabajadorSocial/add";
   	 try {   		 
   		 trabajadorDao.addTrabajadorSocial(trabajador); 
   	 }
   	 catch(DuplicateKeyException e){
   		 throw new ClubesportiuException("Ya existe un trabajador Social con ese usuarioCAS " + trabajador.getUsuarioCAS(), "CPduplicada");
   	 }
   	 return "redirect:list";
    }
   
   
}
