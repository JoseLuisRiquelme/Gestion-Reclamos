package cl.praxis.GestionReclamos.Controller;

import cl.praxis.GestionReclamos.model.repositories.ComplainRepository;
import cl.praxis.GestionReclamos.model.service.ComplainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/complains")
public class ComplainController {

    ComplainService cService;

    public ComplainController(ComplainService cService) {
        this.cService = cService;
    }

    @GetMapping
    public String complains(Model model){
        model.addAttribute("complains",cService.findAll());
        return "complains";
    }
}
