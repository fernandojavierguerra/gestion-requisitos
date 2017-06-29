package com.durgam.guerra.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.durgam.guerra.dominio.RequisitoCompuesto;
import com.durgam.guerra.dominio.RequisitoSimple;
import com.durgam.guerra.servicio.ServicioProyecto;
import com.durgam.guerra.servicio.ServicioRequisito;

@Controller
public class ControladorRequisito {
	
	@Autowired
	private ServicioRequisito servicioRequisito;
	@Autowired
	private ServicioProyecto servicioProyecto;
	
	 @RequestMapping(value = "/requisitos", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("requisitos", servicioRequisito.obtenerTodosLosRequisitos());
	        return "requisitos";
	    }
 
		@RequestMapping("requisitos/newSimple")
	    public String newRequisitoSimple(Model model){
	        model.addAttribute("requisito", servicioRequisito.NuevoRequisitoSimple());
	        model.addAttribute("proyectos", servicioProyecto.obtenerTodosLosProyectos());
	       
	        return "requisitoformSimple";
	          }
		
		@RequestMapping("requisitos/newCompuesto")
	    public String newRequisitoCompuesto(Model model){
	        model.addAttribute("requisito", servicioRequisito.NuevoRequisitoCompuesto());
	        return "requisitoformCompuesto";
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
			 	if(servicioRequisito.buscarRequisitoPorId(id).compuesto()){
			 		return "requisitoformCompuesto";	
			 	}else
			 	{
			 		return "requisitoformSimple";
			 	}
			    
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
		 
		 @RequestMapping(value = "requisitoSimple", method = RequestMethod.POST)
		    public String saveRequisitoSimple(RequisitoSimple requisito){
			// servicioRequisito.NuevoRequisito(requisito);
		     servicioRequisito.grabarRequisito(requisito); 
			 return "redirect:/requisitos/" + requisito.getId();
		    }
		 @RequestMapping(value = "requisitoCompuesto", method = RequestMethod.POST)
		    public String saveRequisitoCompuesto(RequisitoCompuesto requisito){
			 servicioRequisito.NuevoRequisito(requisito);
		        return "redirect:/requisitos/" + requisito.getId();
		    }
}
