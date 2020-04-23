package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.clubesportiu.dao.ContratoDao;

@Controller
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	private ContratoDao contratoDao;
	
	@Autowired
	public void setContratoDao(ContratoDao contratoDao) {
		this.contratoDao = contratoDao;
	}
	
	@RequestMapping("/list")
	public String listContratos(Model model) {
		model.addAttribute("contratos", contratoDao.getContratos());
		return "contrato/list";
	}
}