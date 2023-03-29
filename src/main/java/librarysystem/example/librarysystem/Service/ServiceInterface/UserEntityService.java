package librarysystem.example.librarysystem.Service.ServiceInterface;

import librarysystem.example.librarysystem.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserEntityService {

    List<UserEntity> getAllUser();

    UserEntity saveUser(UserEntity userEntity);

    UserEntity getUserByEmail(String email);
}
