package com.durgam.guerra.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.durgam.guerra.dominio.Stakeholder;
import com.durgam.guerra.servicio.ServicioRequisito;
import com.durgam.guerra.servicio.ServicioStakeholder;

@Controller
public class ControladorStakeholder {
	@Autowired
	private ServicioStakeholder servicioStakeholder;
	
	@Autowired
	private ServicioRequisito servicioRequisito;
	 
	@RequestMapping(value = "/stakeholders", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("stakeholders",servicioStakeholder.obtenerTodosLosStakeholder());
	        return "stakeholders";
	    }
	 @RequestMapping(value = "stakeholder", method = RequestMethod.POST)
	    public String saveStakeholder(Stakeholder stakeholder){
		 servicioStakeholder.NuevoStakeholder(stakeholder);
	     return "redirect:/stakeholder/" + stakeholder.getId();
	    }
	 
	@RequestMapping("stakeholder/new")
	   public String newStakeholder(Model model){
	       model.addAttribute("stakeholder", servicioStakeholder.NuevoStakeholder());
	       return "stakeholderform";
	   }
		
		@RequestMapping("stakeholder/{id}")
	    public String showStakeholder(@PathVariable Long id, Model model){
	        model.addAttribute("stakeholder",servicioStakeholder.buscarStakeholderPorId(id));
	        return "stakeholdershow";
	 }
	 @RequestMapping("stakeholder/edit/{id}")
	 public String edit(@PathVariable Long id, Model model){
		    model.addAttribute("stakeholder", servicioStakeholder.buscarStakeholderPorId(id));
		    return "stakeholderform";
	 }
	 
	 @RequestMapping("stakeholder/delete/{id}")
	 public String delete(@PathVariable Long id){
		 servicioStakeholder.borrarStakeholderId(id);
	     return "redirect:/stakeholders";
	 }	
	 
	 @RequestMapping("/stakeholder/quitar/{id}/{id_requisito}")
	 public String quitarRequisito(@PathVariable Long id, Long id_requisito){
		 servicioStakeholder.quitarRequisitoStakeholder(servicioStakeholder.buscarStakeholderPorId(id), servicioRequisito.buscarRequisitoPorId(id_requisito));
	     return "redirect:/stakeholders";
	 }	
}
