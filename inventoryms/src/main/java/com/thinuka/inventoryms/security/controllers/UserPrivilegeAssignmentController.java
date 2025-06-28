package com.thinuka.inventoryms.security.controllers;

import com.thinuka.inventoryms.models.Brand;
import com.thinuka.inventoryms.models.User;
import com.thinuka.inventoryms.security.models.Privilege;
import com.thinuka.inventoryms.security.models.Role;
import com.thinuka.inventoryms.security.models.UserPrivilegeAssignment;
import com.thinuka.inventoryms.security.services.PrivilegeService;
import com.thinuka.inventoryms.security.services.RoleService;
import com.thinuka.inventoryms.security.services.UserPrivilegeAssignmentService;
import com.thinuka.inventoryms.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
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

    @Transactional
    @PostMapping("/user/{userid}/privileges")
    public ResponseEntity<String> savePrivileges(@PathVariable("userid") Long userid, @RequestBody List<Privilege> privileges){

        try {
            List<Privilege> savePrivileges = userPrivilegeAssignmentService.savePrivilege(
                    privileges, userid
            );
            return ResponseEntity.status(HttpStatus.CREATED).body("Privileges were saved successfully");
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred:" + ex.getMessage());
        }
    }

    @GetMapping("/user/{id}/privileges")
    public List<Privilege> getUserPrivileges(@PathVariable("userid") Long userid){
        return userPrivilegeAssignmentService.getUserPrivileges(userid);

    }

    @GetMapping("/user/{id}/privileges")
    public List<User> getUserByPrivileges(@PathVariable("privilegeid") Long privilegeid){
        return userPrivilegeAssignmentService.getUserByPrivileges(privilegeid);

    }


    @DeleteMapping("/user/{userid}/privileges")
    public ResponseEntity<String> clearUserPrivileges(@PathVariable("userid") Long userid){

        try {
            userPrivilegeAssignmentService.deletePrivileges(userid);
            return ResponseEntity.status(HttpStatus.CREATED).body("Privileges were saved successfully");
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred:" + ex.getMessage());
        }
    }



}
