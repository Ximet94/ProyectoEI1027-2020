package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
   
   @RequestMapping("/provaTrabajador")
   public String provaUnTrabajador(Model model) {
	  TrabajadorSocial ts = TrabajadorSocialDao.getTrabajadorSocial("PepeLu");
      model.addAttribute("message", ts.toString());
      System.out.println(ts.toString());
      return "trabajadorSocial/prova";
   }


   // Operacions: Crear, llistar, actualitzar, esborrar
   // ...
   
   @RequestMapping("/list")
   public String listTrabajadores(Model model) {
      model.addAttribute("trabajadores", trabajadorDao.getTrabajadoresSociales());
      return "trabajadorSocial/list";
   }


}
