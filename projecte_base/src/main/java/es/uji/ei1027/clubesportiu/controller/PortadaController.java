package es.uji.ei1027.clubesportiu.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortadaController {
	@RequestMapping("/entrada")
	public String provaWeb(Model model) {
		return "/index3";
	}
}