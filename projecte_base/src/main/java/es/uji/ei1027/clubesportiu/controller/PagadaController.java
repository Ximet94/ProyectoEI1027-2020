package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.clubesportiu.dao.PagadaDao;

@Controller
@RequestMapping("/pagada")
public class PagadaController {

	@Autowired
	private PagadaDao pagadaDao;
	
	@Autowired
	public void setPagadaDao(PagadaDao pagadaDao) {
		this.pagadaDao = pagadaDao;
	}
	
	@RequestMapping("/list")
	public String listPagadas(Model model) {
		model.addAttribute("pagadas", pagadaDao.getPagadas());
		return "pagada/list";
	}
}
