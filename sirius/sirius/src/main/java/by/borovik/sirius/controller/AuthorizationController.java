package by.borovik.sirius.controller;

import by.borovik.sirius.entity.Role;
import by.borovik.sirius.entity.User;
import by.borovik.sirius.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @Autowired
    private UserRepos userRepos;

    @GetMapping("/homepage")
    public String homePage() {
        String request="";
        User currentUser = userRepos.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        Role userRole = currentUser.getRole();

        switch (userRole) {
            case SINGER:
                request = "redirect:/singer/home";
                break;
            case LISTENER:
                request="redirect:/listener/home";
                break;
        }

        return request;
    }
}
