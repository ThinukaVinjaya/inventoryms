package com.thinuka.inventoryms.security.controllers;

import com.thinuka.inventoryms.repositories.UserRepository;
import com.thinuka.inventoryms.security.models.Privilege;
import com.thinuka.inventoryms.security.models.Role;
import com.thinuka.inventoryms.security.repositories.PrivilegeRepository;
import com.thinuka.inventoryms.security.repositories.RoleRepository;
import com.thinuka.inventoryms.security.services.PrivilegeService;
import com.thinuka.inventoryms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private UserService userService;

    @GetMapping("/privileges")
    public List<Privilege> parameters(Model model) {
        return privilegeService.findAll();
    }

    @GetMapping("/privileges/{id}")
    public Privilege getById(@PathVariable Long id){
        return privilegeService.findById(id);
    }

    @PutMapping("/privileges/{id}")
    public Privilege updatePrivilege(@RequestBody() Privilege privilege, @PathVariable("id") Long id){
        return privilegeService.save(privilege);
    }

    @PostMapping("/privileges")
    public Privilege save(Privilege privilege){
        return privilegeService.save(privilege);
    }

    @DeleteMapping("/privileges/delete/{id}")
    public void delete(@PathVariable Long id){
        privilegeService.delete(id);
    }
}
