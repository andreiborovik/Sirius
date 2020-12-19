package by.borovik.sirius.repos;

import by.borovik.sirius.entity.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepos extends CrudRepository<Song, Long> {
}
