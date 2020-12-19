package by.borovik.sirius.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="usr")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Enumerated(EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private boolean isActive;

    @ElementCollection(targetClass = SecurityRole.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id_role"))
    @Enumerated(EnumType.STRING)
    private Set<SecurityRole> roles;
}
