package cl.praxis.GestionReclamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewComplainController {
    @GetMapping("/newComplain")
    public String newComplain(){
        return "newComplain";
    }
}
