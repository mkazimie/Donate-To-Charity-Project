package pl.coderslab.charity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @NotBlank
    @Column(name = "first_name")
    private String name;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Column(name = "password")
    @Length(min = 5, message = "To pole musi mieć co najmniej 5 znaków")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
