package com.thinuka.inventoryms.security.controllers;

import com.thinuka.inventoryms.models.Brand;
import com.thinuka.inventoryms.security.models.Role;
import com.thinuka.inventoryms.security.models.UserPrivilegeAssignment;
import com.thinuka.inventoryms.security.services.RoleService;
import com.thinuka.inventoryms.security.services.UserPrivilegeAssignmentService;
import com.thinuka.inventoryms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserPrivilegeAssignmentController {

    @Autowired
    private UserPrivilegeAssignmentService userPrivilegeAssignmentService;

    @Autowired
    private UserService userService;

    @GetMapping("/userPrivilegeAssignment")
    public List<UserPrivilegeAssignment> parameters(Model model) {
        return userPrivilegeAssignmentService.findAll();
    }

    @GetMapping("/userPrivilegeAssignment/{id}")
    @ResponseBody
    public UserPrivilegeAssignment getById(@PathVariable Long id) {
        return userPrivilegeAssignmentService.findById(id);
    }

    @PostMapping("/userPrivilegeAssignment")
    public UserPrivilegeAssignment save(UserPrivilegeAssignment userPrivilegeAssignment) {
        return userPrivilegeAssignmentService.save(userPrivilegeAssignment);
    }

    @RequestMapping(value = "/userPrivilegeAssignment/delete/{id}", method = {RequestMethod.DELETE,})
    public void delete(@PathVariable Long id) {
        userPrivilegeAssignmentService.delete(id);
    }

}
