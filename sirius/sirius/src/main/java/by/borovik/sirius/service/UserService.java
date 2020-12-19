package by.borovik.sirius.service;

import by.borovik.sirius.entity.*;
import by.borovik.sirius.repos.ListenerRepos;
import by.borovik.sirius.repos.SingerRepos;
import by.borovik.sirius.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SingerRepos singerRepos;

    @Autowired
    private ListenerRepos listenerRepos;

    public void addUser(User user) {
        user.setActive(true);
        user.setRoles(Set.of(SecurityRole.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepos.save(user);
    }

    public void addUserAsRole(User user) {
        Role userRole=user.getRole();
        switch (userRole) {
            case SINGER:
                singerRepos.save(new Singer(user));
                break;
            case LISTENER:
                listenerRepos.save(new Listener(user));
                break;
        }

    }
}
