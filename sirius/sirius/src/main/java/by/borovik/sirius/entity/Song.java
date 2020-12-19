package by.borovik.sirius.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private LocalDate releaseDate;
    private String album;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    @ManyToMany
    @JoinTable(name="listener_song",
            joinColumns = @JoinColumn(name = "listener_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Listener> songLibrary;
}
