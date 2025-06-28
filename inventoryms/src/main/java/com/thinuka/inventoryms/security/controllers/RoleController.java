package com.thinuka.inventoryms.security.controllers;


import com.thinuka.inventoryms.security.models.Privilege;
import com.thinuka.inventoryms.security.repositories.PrivilegeRepository;
import com.thinuka.inventoryms.security.services.RoleService;
import com.thinuka.inventoryms.security.models.Role;
import com.thinuka.inventoryms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {


    private final PrivilegeRepository privilegeRepository;

    private final RoleService roleService;


    private final UserService userService;

    public RoleController(PrivilegeRepository privilegeRepository, RoleService roleService, UserService userService) {
        this.privilegeRepository = privilegeRepository;
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/roles")
    public List<Role> parameters(Model model) {
        return roleService.findAll();
    }

    @GetMapping("/role/{id}")
    @ResponseBody
    public Role getById(@PathVariable Integer id) {
        return roleService.findById(id);
    }

    @PostMapping("/roles")
    public Role save(Role role) {
        return roleService.save(role);
    }

    @RequestMapping(value = "/role/delete/{id}", method = {RequestMethod.DELETE, })
    public void delete(@PathVariable Integer id) {
        roleService.delete(id);
    }

    @PostMapping("/role/{roleid}/assign/user/{userid}")
    public void assignUserRole(@PathVariable("roleid") Long roleid, @PathVariable("userid") Long userid){
        roleService.assignUserRole(userid, roleid);
    }

    @DeleteMapping("/role/{roleid}/usAssign/user/{userid}")
    public void unAssignUserRole(@PathVariable("roleid") Long roleid, @PathVariable("userid") Long userid){
        roleService.unAssignUserRole(userid, roleid);
    }

    @GetMapping("/role/{roleid}/privileges")
    public List<Privilege> privilegesInRole(@PathVariable("roleid") Long roleid){
       return roleService.getPrivilegesInRole(roleid);
    }

}
