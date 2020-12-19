package by.borovik.sirius.repos;

import by.borovik.sirius.entity.Singer;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepos extends CrudRepository<Singer, Long> {
    Singer findSingerByUserId(Long id);
}
