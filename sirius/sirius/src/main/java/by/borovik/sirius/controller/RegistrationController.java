package by.borovik.sirius.controller;


import by.borovik.sirius.entity.Role;
import by.borovik.sirius.entity.User;
import by.borovik.sirius.repos.UserRepos;
import by.borovik.sirius.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private UserService userService;

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("roles", Role.values());
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        User userFromDb = userRepos.findUserByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message_exists", "User exists!");
            return "registration";
        }

        userService.addUser(user);
        userService.addUserAsRole(user);
        return "redirect:/login";
    }

}
