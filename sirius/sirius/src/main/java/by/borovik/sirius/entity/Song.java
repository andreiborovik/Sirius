package by.borovik.sirius.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;
}
