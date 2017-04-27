package com.durgam.guerra.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.durgam.guerra.dominio.Proyecto;
import com.durgam.guerra.servicio.ServicioProyecto;


@Controller
public class ControladorProyecto {
	
	@Autowired
	private ServicioProyecto servicioProyecto;
	
	@RequestMapping("proyecto/new")
    public String newProduct(Model model){
        model.addAttribute("proyecto", new Proyecto());
        return "proyectoform";
    }
	@RequestMapping(value = "proyecto", method = RequestMethod.POST)
    public String saveProduct(Proyecto proyecto){
        servicioProyecto.NuevoProyecto(proyecto);
        return "redirect:/proyecto/" + proyecto.getId();
    }
	 @RequestMapping("proyecto/{id}")
	    public String showProduct(@PathVariable Long id, Model model){
	        model.addAttribute("proyecto", servicioProyecto.buscarProyectoPorId(id));
	        return "proyectoshow";
	    }
	 @RequestMapping(value = "/proyectos", method = RequestMethod.GET)
	    public String list(Model model){
	        model.addAttribute("proyectos", servicioProyecto.obtenerTodosLosProyectos());
	        return "proyectos";
	    }
	 @RequestMapping("proyecto/edit/{id}")
	 public String edit(@PathVariable Long id, Model model){
		    model.addAttribute("proyecto", servicioProyecto.buscarProyectoPorId(id));
		    return "proyectoform";
	 }
	 @RequestMapping("proyecto/delete/{id}")
	 public String delete(@PathVariable Long id){
		 servicioProyecto.borrarProyectoId(id);
	     return "redirect:/proyectos";
	 }
}
