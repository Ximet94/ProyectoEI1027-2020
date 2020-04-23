package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.clubesportiu.dao.DisponibilidadDao;

@Controller
@RequestMapping("/disponibilidad")
public class DisponibilidadController {

	@Autowired
	private DisponibilidadDao disponibilidadDao;
	
	@Autowired
	public void setDisponibilidadDao(DisponibilidadDao disponibilidadDao) {
		this.disponibilidadDao = disponibilidadDao;
	}
	
	@RequestMapping("/list")
	public String listDisponibilidades(Model model) {
		model.addAttribute("disponibilidades", disponibilidadDao.getDisponibilidades());
		return "disponibilidad/list";
	}
}
