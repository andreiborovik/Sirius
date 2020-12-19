package by.borovik.sirius.controller;

import by.borovik.sirius.entity.Singer;
import by.borovik.sirius.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/home")
    public String home(Model model) {
        Singer singer=authenticationService.getAuthenticatedSinger();
       // model.addAttribute("songs", )
        return "singer-home";
    }
}
