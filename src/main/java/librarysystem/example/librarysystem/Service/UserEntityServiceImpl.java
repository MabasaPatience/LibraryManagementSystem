package librarysystem.example.librarysystem.Service;

import librarysystem.example.librarysystem.Entity.UserEntity;
import librarysystem.example.librarysystem.Repository.UserRepository;
import librarysystem.example.librarysystem.Service.ServiceInterface.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
   public PasswordEncoder passwordEncoder;
    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
