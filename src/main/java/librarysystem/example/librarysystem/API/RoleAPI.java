package librarysystem.example.librarysystem.API;

import librarysystem.example.librarysystem.Entity.Role;
import librarysystem.example.librarysystem.Service.ServiceInterface.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/role")
public class RoleAPI {

    @Autowired
    RoleService roleService;


    @GetMapping("/get")
    public ResponseEntity<List<Role>> getAllRole(){
        List<Role> getAllRole= roleService.getAllRoles();
        return new ResponseEntity<>(getAllRole, HttpStatus.OK);
    }

    @GetMapping("/get/{role}")
    public ResponseEntity<Role> getRoleByEmail(@PathVariable("role") String role){
        Role getAllRole= roleService.getRoleByName(role);

        return new ResponseEntity<>(getAllRole, HttpStatus.OK);
    }

    @PostMapping("/saveRole")
    public ResponseEntity<Role> addProduct(@RequestBody Map<String,String> request){
        Role role=new Role();
        role.setName(request.get("role"));
        Role getAllRole= roleService.saveRole(role);

        return new ResponseEntity<>(getAllRole, HttpStatus.OK);
    }

}
