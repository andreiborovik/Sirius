package by.borovik.sirius.repos;

import by.borovik.sirius.entity.Listener;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListenerRepos extends CrudRepository<Listener, Long> {
    Listener findListenerByUserId(Long id);
}
