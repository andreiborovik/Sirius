package by.borovik.sirius.controller;

import by.borovik.sirius.entity.Singer;
import by.borovik.sirius.repos.SingerRepos;
import by.borovik.sirius.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private SingerRepos singerRepos;

    @GetMapping("/home")
    public String home(Model model) {
        Singer singer = authenticationService.getAuthenticatedSinger();
        model.addAttribute("singer", singer);
        return "singer-home";
    }

    @GetMapping("/editInfo")
    public String editInfo(Model model) {
        Singer singer = authenticationService.getAuthenticatedSinger();
        model.addAttribute("singer", singer);
        return "singer-info";
    }

    @PostMapping("/editInfo")
    public String saveInfo(@ModelAttribute Singer singer) {
        Singer s = authenticationService.getAuthenticatedSinger();
        s.setName(singer.getName());
        s.setGenre(singer.getGenre());
        singerRepos.save(s);
        return "redirect:/singer/home";
    }
}
