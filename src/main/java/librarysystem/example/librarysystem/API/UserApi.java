package librarysystem.example.librarysystem.API;

import librarysystem.example.librarysystem.Entity.Role;
import librarysystem.example.librarysystem.Entity.UserEntity;
import librarysystem.example.librarysystem.Service.ServiceInterface.RoleService;
import librarysystem.example.librarysystem.Service.ServiceInterface.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/user")
public class UserApi {

    @Autowired
    public UserEntityService userService;

    @Autowired
    public RoleService IroleService;

    @GetMapping("/get")
    public ResponseEntity<List<UserEntity>> getAllUser(){
        List<UserEntity> getAllUser= userService.getAllUser();
        return new ResponseEntity<>(getAllUser, HttpStatus.OK);
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable("email") String email){


        UserEntity getAllUser= userService.getUserByEmail(email);

        return new ResponseEntity<>(getAllUser, HttpStatus.OK);
    }



    @PostMapping(path="/save")
    public ResponseEntity<UserEntity> addUser(@RequestBody Map<String,String> request){
        UserEntity user= userService.getUserByEmail(request.get("email"));
        Role role = IroleService.getRoleByName(request.get("role"));
        List<Role> r= new ArrayList<>();
        r.add(role);

        if(!Objects.isNull(user)){
            user.setRole(r);
        }
        else {
            user =new UserEntity();
            user.setPassword(request.get("password"));
            user.setEmail(request.get("email"));
            user.setName(request.get("name"));
            user.setRole(r);
            //user.addRole(role);
        }
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
    }


}
