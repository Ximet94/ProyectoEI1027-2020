package es.uji.ei1027.clubesportiu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.Errors; 
import org.springframework.validation.Validator;

import es.uji.ei1027.clubesportiu.dao.UserDao; 
import es.uji.ei1027.clubesportiu.model.UserDetails;

class UserValidator implements Validator { 
	@Override
	public boolean supports(Class<?> cls) { 
		return UserDetails.class.isAssignableFrom(cls);
	}
	@Override 
	public void validate(Object obj, Errors errors) {
		UserDetails user= (UserDetails)obj;
		 if (user.getUsername().trim().equals(""))
		       errors.rejectValue("username", "obligatorio",
		                          "Hay que introducir un valor");
		 if(user.getPassword().trim().equals(""))
			errors.rejectValue("password", "insuficiente", "La contraseña introducida es demasiado corta");
	}
}

@Controller
public class LoginController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("user", new UserDetails());
		return "index3";
	}
	
	@RequestMapping(value = "/entrada", method = RequestMethod.GET)
	public String displayLogin2(Model model) {
		model.addAttribute("user", new UserDetails());
		return "login";
	}
	
	@RequestMapping("/registrarse")
	public String auxiliar(Model model) {
		return "register/index";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String checkLogin(@ModelAttribute("user") UserDetails user,
				BindingResult bindingResult, HttpSession session) {
		UserValidator userValidator = new UserValidator(); 
		userValidator.validate(user, bindingResult); 
		if (bindingResult.hasErrors()) {
			return "login";
		}
		try {
			String nextUrl = session.getAttribute("nextUrl").toString();
			if(! nextUrl.equals("")) {
				session.setAttribute("nextUrl", "");
				return "redirect:" + nextUrl;
			}
		}
		catch(Exception ex) {
			
		}
		// Comprova que el login siga correcte 
		// intentant carregar les dades de l'usuari 
		user = userDao.loadUserByUsername(user.getUsername(), user.getPassword()); 
		System.out.println(user.toString());
		if (user == null) {
			bindingResult.rejectValue("password", "badpw", "Contraseña incorrecta"); 
			return "entrada";
		}
		// Autenticats correctament. 
		// Guardem les dades de l'usuari autenticat a la sessió
		session.setAttribute("user", user); 
		
		// Torna a la pàgina principal
		return "redirect:/";
	}

	@RequestMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/";
	}
}
