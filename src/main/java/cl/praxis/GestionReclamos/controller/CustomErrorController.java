package cl.praxis.GestionReclamos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CustomErrorController {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {
        ModelAndView mav = new ModelAndView();
        if (e instanceof org.springframework.security.access.AccessDeniedException) {
            mav.setViewName("403"); // Redirige a la página 403.html
            mav.setStatus(HttpStatus.FORBIDDEN);
        } else {
            mav.setViewName("error"); // Página genérica de error
            mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        mav.addObject("message", e.getMessage());
        return mav;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNotFoundError(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("404"); // Redirige a la página 404.html
        mav.setStatus(HttpStatus.NOT_FOUND);
        mav.addObject("message", e.getMessage());
        return mav;
    }
}
