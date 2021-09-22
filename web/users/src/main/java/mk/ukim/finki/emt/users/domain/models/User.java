package mk.ukim.finki.emt.users.domain.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "bookstore_users", uniqueConstraints=@UniqueConstraint(columnNames="username"))
public class User implements UserDetails {

    private String name;
    private String surname;

    @Id
    private String username;
    private String password;
    private String phone;
    private String profession;

    public User(String name, String surname, String username, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;


    // koj so koj razmenil kniga
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> userCooperator;

    public User() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
