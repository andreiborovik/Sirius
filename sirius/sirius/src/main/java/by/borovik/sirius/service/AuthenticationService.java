package by.borovik.sirius.service;

import by.borovik.sirius.entity.Listener;
import by.borovik.sirius.entity.Singer;
import by.borovik.sirius.repos.ListenerRepos;
import by.borovik.sirius.repos.SingerRepos;
import by.borovik.sirius.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private ListenerRepos listenerRepos;

    @Autowired
    private SingerRepos singerRepos;

    @Autowired
    private UserRepos userRepos;

    public Singer getAuthenticatedSinger() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long id=userRepos.findUserByUsername(username).getId();
        return singerRepos.findSingerByUserId(id);
    }

    public Listener getAuthenticatedListener() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        long id=userRepos.findUserByUsername(username).getId();
        return listenerRepos.findListenerByUserId(id);
    }
}
