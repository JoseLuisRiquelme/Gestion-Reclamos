package cl.praxis.GestionReclamos.controller;

import cl.praxis.GestionReclamos.model.entities.Complain;
import cl.praxis.GestionReclamos.model.entities.User;
import cl.praxis.GestionReclamos.model.repositories.UserRepository;
import cl.praxis.GestionReclamos.model.service.ComplainService;
import cl.praxis.GestionReclamos.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/complains")
public class ComplainController {

    private final ComplainService cService;
private final UserService uService;
private final UserRepository uRepo;
    public ComplainController(ComplainService cService, UserService uService, UserRepository uRepo) {
        this.cService = cService;
        this.uService = uService;
        this.uRepo = uRepo;
    }

    @GetMapping
    public String complains(Model model){
        model.addAttribute("complains",cService.findAll());
        return "complains";
    }
    //new report form
    @GetMapping("/new")
    public String getCreate(Principal principal, Model model) {
        String currentUsername=principal.getName();
        User user= uRepo.findOneByEmail(currentUsername).orElse(null);
        model.addAttribute("authenticatedUserId",user.getId());
        return "newComplain";
    }
    //new report creation
    @PostMapping("/new")
    public String postCreate(@ModelAttribute Complain report) {
        boolean result = cService.create(report);
        return "redirect:/complains";
    }
    //delete report
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean result = cService.delete(id);
        return "redirect:/complains";
    }
    //read report
    @GetMapping("/{id}")
    public String getUpdate(@PathVariable("id") int id, Model model,Principal principal) {
        Complain complainToUpdate = cService.findOne(id);
        model.addAttribute("complain", complainToUpdate);
        String currentUsername=principal.getName();
        User user= uRepo.findOneByEmail(currentUsername).orElse(null);
        model.addAttribute("authenticatedUserId",user.getId());
        return "complainEdit";
    }
    //update report
    @PostMapping
    public  String postUpdate(@ModelAttribute Complain report){
        boolean result  = cService.update(report);
        return "redirect:/complains";
    }
}
