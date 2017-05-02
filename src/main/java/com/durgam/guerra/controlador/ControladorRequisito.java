package com.durgam.guerra.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.durgam.guerra.dominio.Requisito;
import com.durgam.guerra.dominio.RequisitoCompuesto;
import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.repositorio.RepositorioRequisitoCompuesto;
import com.durgam.guerra.repositorio.RepositorioRequisitoSimple;
import com.durgam.guerra.servicio.ServicioRequisito;
import com.durgam.guerra.servicio.ServicioRequisitoCompuesto;
import com.durgam.guerra.servicio.ServicioRequisitoSimple;



@Controller
public class ControladorRequisito {
	
	@Autowired
	private ServicioRequisito servicioRequisito;
	

	 @RequestMapping(value = "/requisitos", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("requisitos", servicioRequisito.obtenerTodosLosRequisitos());
	        return "requisitos";
	    }
	 @RequestMapping(value = "requisito", method = RequestMethod.POST)
	    public String saveProduct(RequisitoSimple requisito){
		 servicioRequisito.NuevoRequisito(requisito);
	        return "redirect:/requisitos/" + requisito.getId();
	    }
		@RequestMapping("requisitos/newSimple")
	    public String newRequisitoSimple(Model model){
	        model.addAttribute("requisito", new RequisitoSimple());
	        return "requisitoform";
	          }
		
		@RequestMapping("requisitos/newCompuesto")
	    public String newRequisitoCompuesto(Model model){
	        model.addAttribute("requisito", new RequisitoCompuesto());
	        return "requisitoform";
	          }
		
		 @RequestMapping("requisitos/{id}")
		    public String requisitoShow(@PathVariable Long id, Model model){
		        model.addAttribute("requisito", servicioRequisito.buscarRequisitoPorId(id));
		        model.addAttribute("estado", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito());
		        model.addAttribute("compuesto", servicioRequisito.buscarComposicionPorId(id));
		        return "requisitoshow";
		 }
		 @RequestMapping("requisitos/edit/{id}")
		 public String edit(@PathVariable Long id, Model model){
			 model.addAttribute("requisito", servicioRequisito.buscarRequisitoPorId(id));
		        model.addAttribute("estado", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito());
		        model.addAttribute("compuesto", servicioRequisito.buscarComposicionPorId(id));
			 	
			    return "requisitoform";

		 }
		 @RequestMapping("requisitos/delete/{id}")
		 public String delete(@PathVariable Long id){
			 servicioRequisito.borrarRequisitoPorId(id);
		     return "redirect:/requisitos";
		 }
		 
		 @RequestMapping("requisitosCambioEstado/{id}")
		    public String requisitoCambioEstado(@PathVariable Long id, Model model){
		        model.addAttribute("requisito", servicioRequisito.buscarRequisitoPorId(id));
		        model.addAttribute("estado", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito());
		        model.addAttribute("siguientes", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito().siguiente());
		        return "requisitoCambioEstado";
		 }
		// @RequestMapping("cambioEstado/{id}")

/*		@RequestMapping(
				value = "/cambioEstado", 
				headers = { "key1=val1", "key2=val2" }, method = RequestMethod.GET)  
		 public String CambioEstado(@PathVariable Long id, Model model){
			 model.addAttribute("requisito", servicioRequisito.buscarRequisitoPorId(id));
		     model.addAttribute("estado", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito());
		     model.addAttribute("siguientes", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito().siguiente());
		       
		        return "requisitoCambioEstado";
		
		 }
*/
}
