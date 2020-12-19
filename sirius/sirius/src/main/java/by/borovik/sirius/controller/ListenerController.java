package by.borovik.sirius.controller;

import by.borovik.sirius.entity.Listener;
import by.borovik.sirius.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listener")
public class ListenerController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/home")
    public String home(Model model) {
        Listener listener = authenticationService.getAuthenticatedListener();
        model.addAttribute("songs", listener);
        return "listener-home";
    }
}
