package com.durgam.guerra.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorApp {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
