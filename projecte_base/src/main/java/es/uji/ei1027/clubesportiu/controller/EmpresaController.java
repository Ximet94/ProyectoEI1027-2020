package es.uji.ei1027.clubesportiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.clubesportiu.dao.EmpresaDao;
import es.uji.ei1027.clubesportiu.model.Empresa;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaDao empresaDao;
	
	@Autowired
	public void setEmpresaDao(EmpresaDao empresaDao) {
		this.empresaDao = empresaDao;
	}
	
	@RequestMapping("/list")
	public String listEmpresas(Model model) {
		model.addAttribute("empresas", empresaDao.getEmpresas());
		return "empresa/list";
	}
	
	@RequestMapping("/indexEmpresas")
	public String gestionEmpresa(Model model) {
      return "empresa/indexEmpresas";
	}
	
	@RequestMapping("/add")
   public String addEmpresa(Model model) {
	   model.addAttribute("empresa", new Empresa());
      return "empresa/add";
   }
	
  @RequestMapping(value="/delete/{cif}")
	public String processDelete(@PathVariable String cif) {
	   empresaDao.deleteEmpresa(cif);
          return "redirect:../list"; 
	}
	
	//Añadido codigo de validacion de trabajador Social
   @RequestMapping(value="/add", method=RequestMethod.POST)
   public String processAddSubmit(@ModelAttribute("empresa") Empresa empresa,
                                   BindingResult bindingResult) {
	   EmpresaValidator tsValidator = new EmpresaValidator();
	   tsValidator.validate(empresa, bindingResult);
   	 if (bindingResult.hasErrors())
   			return "empresa/add";
   	 try {   		 
   		 empresaDao.addEmpresa(empresa); 
   	 }
   	 catch(DuplicateKeyException e){
   		 throw new ClubesportiuException("Ya existe una empresa con ese cif " + empresa.getCif(), "CPduplicada");
   	 }
   	 return "redirect:list";
    }
   
   @RequestMapping(value="/update/{cif}", method = RequestMethod.GET)
	public String editEmpresa(Model model, @PathVariable String cif) {
		model.addAttribute("empresa", empresaDao.getEmpresa(cif));
		return "empresa/update"; 
	}
  
  @RequestMapping(value="/update", method = RequestMethod.POST) 
	public String processUpdateSubmit(@ModelAttribute("empresa") Empresa empresa, 
                          BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "empresa/update";
		 empresaDao.updateEmpresa(empresa);
		 return "redirect:list"; 
	}
}
