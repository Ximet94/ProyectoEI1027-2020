package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.clubesportiu.dao.FacturaDao;

@Controller
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	private FacturaDao facturaDao;
	
	@Autowired
	public void setFacturaDao(FacturaDao facturaDao) {
		this.facturaDao = facturaDao;
	}
	
	@RequestMapping("/list")
	public String listFacturas(Model model) {
		model.addAttribute("facturas", facturaDao.getFacturas());
		return "factura/list";
	}
}
