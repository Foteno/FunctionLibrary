package lt.psp.validation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String phoneNr;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String password;

    public User(String name, String surname, String phoneNr, String email, String address, String password) {
        this.name = name;
        this.surname = surname;
        this.phoneNr = phoneNr;
        this.email = email;
        this.address = address;
        this.password = password;
    }
}
