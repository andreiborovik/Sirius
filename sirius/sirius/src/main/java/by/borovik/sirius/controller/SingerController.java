package by.borovik.sirius.controller;

import by.borovik.sirius.entity.Singer;
import by.borovik.sirius.entity.Song;
import by.borovik.sirius.repos.SingerRepos;
import by.borovik.sirius.repos.SongRepos;
import by.borovik.sirius.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private SingerRepos singerRepos;

    @Autowired
    private SongRepos songRepos;

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

    @GetMapping("/addSong")
    public String addSong(Model model) {
        model.addAttribute("song", new Song());
        return "song";
    }

    @PostMapping("/addSong")
    public String saveSong(@ModelAttribute Song song) {
        Singer singer=authenticationService.getAuthenticatedSinger();
        song.setSinger(singer);
        song.setReleaseDate(LocalDate.now());
        songRepos.save(song);
        return "redirect:/singer/home";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        Singer singer=authenticationService.getAuthenticatedSinger();
        model.addAttribute("songs", singer.getSongs());
        return "list-song";
    }


}
