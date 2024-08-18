package cl.praxis.GestionReclamos.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView home() {
        // Obtiene la autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verifica si el usuario está autenticado
        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            // Si el usuario está autenticado, redirige a la página protegida
            return new ModelAndView("index");
        }

        // Si el usuario no está autenticado, redirige a la página de registro
        return new ModelAndView("redirect:/register");
    }
}
