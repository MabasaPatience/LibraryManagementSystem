package librarysystem.example.librarysystem.Service.ServiceInterface;

import librarysystem.example.librarysystem.Entity.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);

    public Role saveRole(Role role);
    List<Role> getAllRoles();

}
