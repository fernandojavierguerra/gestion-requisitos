package com.durgam.guerra.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.durgam.guerra.servicio.ServicioRequisito;

@Controller
public class ControladorCambioEstados {
	@Autowired
	private ServicioRequisito servicioRequisito;
	
	@RequestMapping("cambioEstado/Resuelto/{id}")
    public String requisitoCambioResuelto(@PathVariable Long id, Model model){ 
       model.addAttribute("requisito", servicioRequisito.cambiarEstadoResuelto(id));
       model.addAttribute("estado", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito());
       model.addAttribute("siguientes", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito().siguiente());
       return "redirect:/requisitosCambioEstado/" + id;
	}
	@RequestMapping("cambioEstado/Cerrado/{id}")
    public String requisitoCambioCerrado(@PathVariable Long id, Model model){	
		model.addAttribute("requisito", servicioRequisito.cambiarEstadoCerrado(id));
        model.addAttribute("estado", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito());
        model.addAttribute("siguientes", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito().siguiente());
        return "redirect:/requisitosCambioEstado/" + id;	
	}
	
	@RequestMapping("cambioEstado/Reabierto/{id}")
    public String requisitoCambioReabierto(@PathVariable Long id, Model model){	
		model.addAttribute("requisito", servicioRequisito.cambiarEstadoReabierto(id));
		model.addAttribute("estado", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito());
        model.addAttribute("siguientes", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito().siguiente());
        return "redirect:/requisitosCambioEstado/" + id;
	}
	
	@RequestMapping("cambioEstado/EnProgreso/{id}")
    public String requisitoCambioEnProgreso(@PathVariable Long id, Model model){
		model.addAttribute("requisito", servicioRequisito.cambiarEstadoEnProgreso(id));
        model.addAttribute("estado", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito());
        model.addAttribute("siguientes", servicioRequisito.buscarRequisitoPorId(id).getEstadoRequisito().siguiente());
        return "redirect:/requisitosCambioEstado/" + id;
	}
}