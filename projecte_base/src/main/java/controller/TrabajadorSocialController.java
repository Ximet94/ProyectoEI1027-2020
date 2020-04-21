package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.TrabajadorSocialDao;
import model.TrabajadorSocial;

/*@Controller
@RequestMapping("/nadador")
public class ProvaController {
	@RequestMapping("/prova")
	public String provaWeb(Model model) {
		String message = "Provant la Web 'Majors a casa'";
		model.addAttribute("message", message);
		return "prova";
	}
	
	@Autowired
	TrabajadorSocialDao trabajadorDao;
	
	@RequestMapping("/provaTrabajadorSocial")
	public String provaPersonaMayor(Model model) {
		TrabajadorSocial ts = trabajadorDao.getTrabajadorSocial("MartaCast");
		model.addAttribute("ts",ts);
		return "prova_trabjadorsocial";
	}
	
	
}*/

@Controller
/*@RequestMapping("/trabajadorSocial")*/
public class TrabajadorSocialController {

   private TrabajadorSocialDao trabajadorDao;

   @Autowired
   public void setTrabajadorSocialDao(TrabajadorSocialDao trabajadorDao) {
       this.trabajadorDao=trabajadorDao;
   }
   
   @RequestMapping("/provaTrabajador")
   public String provaUnTrabajadorSocial(Model model) {
      TrabajadorSocial ts = TrabajadorSocialDao.getTrabajadorSocial("PepeLu");
      model.addAttribute("message", ts.toString());
      return "prova_trabajadorsocial";
   }

   // Operacions: Crear, llistar, actualitzar, esborrar
   // ...
   
   @RequestMapping("/list")
   public String listTrabajadores(Model model) {
      model.addAttribute("trabajadores", trabajadorDao.getTrabajadoresSociales());
      return "trabajadorSocial/list";
   }


}
