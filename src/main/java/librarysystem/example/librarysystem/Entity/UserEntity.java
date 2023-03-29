package librarysystem.example.librarysystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @NaturalId()
    private String email;

    private  String name;
    private  String password;
    @JoinTable(name="user_roles" ,
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    @ManyToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Role> role;

}
