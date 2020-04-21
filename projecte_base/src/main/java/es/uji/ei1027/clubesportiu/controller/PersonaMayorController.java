
package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.clubesportiu.dao.PersonaMayorDao;
import es.uji.ei1027.clubesportiu.model.PersonaMayor;

@Controller
@RequestMapping("/personamayor")
public class PersonaMayorController {

	@Autowired
   PersonaMayorDao personaMayorDao;

   @Autowired
   public void setPersonaMayorDao(PersonaMayorDao personaMayorDao) {
       this.personaMayorDao=personaMayorDao;
   }
   
   @RequestMapping("/prova")
   public String provaUnPersonaMayor(Model model) {
	   System.out.println("probandooooooooo");
	  PersonaMayor ps = PersonaMayorDao.getPersonaMayor("14578945B");
      model.addAttribute("message", ps.toString());
      //System.out.println(ts.toString());
      return "personamayor/prova";
   }


   // Operacions: Crear, llistar, actualitzar, esborrar
   // ...
   
   
}
