package cl.praxis.GestionReclamos.controller;

import cl.praxis.GestionReclamos.model.entities.Role;
import cl.praxis.GestionReclamos.model.entities.User;
//import cl.praxis.GestionReclamos.model.service.FileStorageService;
import cl.praxis.GestionReclamos.model.repositories.RoleRepository;
import cl.praxis.GestionReclamos.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService uService;
    private final RoleRepository rRepo;
    //private final FileStorageService fileStorageService;
    public RegisterController(UserService uService,/*, FileStorageService fileStorageService*/RoleRepository rRepo) {
        this.uService = uService;
        //this.fileStorageService = fileStorageService;
        this.rRepo = rRepo;
    }

    @GetMapping
    public String getCreateUser(Model model){
        model.addAttribute("roles",rRepo.findAll());
        return "register";
    }

    @PostMapping
    public String postCreateUser(@ModelAttribute User user, @RequestParam("role") String roleName/*,
                                 @RequestParam("image")MultipartFile imageFile*/){
       /* if(!imageFile.isEmpty()) {
            String image = fileStorageService.storeFile(imageFile);
            user.setImage(image);
        }*/
        Role role=rRepo.findByName(roleName);
        user.setRoles(Collections.singletonList(role));
        boolean result = uService.create(user);
        return "redirect:/login";
    }
}
