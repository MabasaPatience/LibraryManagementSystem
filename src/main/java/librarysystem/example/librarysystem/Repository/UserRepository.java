package librarysystem.example.librarysystem.Repository;

import librarysystem.example.librarysystem.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findUserByEmail(String email);

    @Query("SELECT u FROM UserEntity u where u.email= :email")
    UserEntity findByEmail(String email);

}
