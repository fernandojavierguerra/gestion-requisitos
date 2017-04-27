package com.durgam.guerra.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.servicio.ServicioRequisitoCompuesto;
import com.durgam.guerra.servicio.ServicioRequisitoSimple;



@Controller
public class ControladorRequisito {
	
	@Autowired
	private ServicioRequisitoSimple servicioRequisitoSimple;
	private ServicioRequisitoCompuesto servicioRequisitocompuesto;


	@RequestMapping("requisitosSimple/new")
    public String newProduct(Model model){
        model.addAttribute("requisito", new RequisitoSimple());
        return "requisitoSimpleform";
        
    }
	 @RequestMapping(value = "/requisitosSimples", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("requisitos", servicioRequisitoSimple.obtenerTodosLosRequisitosSimples());
	        return "requisitosSimples";
	    }
	 @RequestMapping(value = "requisitoSimple", method = RequestMethod.POST)
	    public String saveProduct(RequisitoSimple requisito){
		 servicioRequisitoSimple.NuevoRequisitoSimple(requisito);
	        return "redirect:/requisitosSimple/" + requisito.getId();
	    }
		 @RequestMapping("requisitosSimple/{id}")
		    public String showProduct(@PathVariable Long id, Model model){
		        model.addAttribute("requisito", servicioRequisitoSimple.buscarRequisitoSimplePorId(id));
		        return "requisitoSimpleshow";
		 }
		 @RequestMapping("requisitosSimple/edit/{id}")
		 public String edit(@PathVariable Long id, Model model){
			    model.addAttribute("requisito", servicioRequisitoSimple.buscarRequisitoSimplePorId(id));
			    return "requisitoSimpleform";

		 }
		 @RequestMapping("requisitosSimple/delete/{id}")
		 public String delete(@PathVariable Long id){
			 servicioRequisitoSimple.borrarRequisitoSimplePorId(id);
		     return "redirect:/requisitosSimples";
		 }
}
