package com.thinuka.inventoryms.security.services;

import com.thinuka.inventoryms.repositories.UserRepository;
import com.thinuka.inventoryms.security.models.Role;
import com.thinuka.inventoryms.security.models.UserPrivilegeAssignment;
import com.thinuka.inventoryms.security.repositories.RoleRepository;
import com.thinuka.inventoryms.security.repositories.UserPrivilegeAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPrivilegeAssignmentService {
    @Autowired
    private UserPrivilegeAssignmentRepository userPrivilegeAssignmentRepository;

    @Autowired
    private UserRepository userRepository;

    //Get All userPrivilegeAssignment
    public List<UserPrivilegeAssignment> findAll() {
        return userPrivilegeAssignmentRepository.findAll();
    }

    //Get userPrivilegeAssignment By Id
    public UserPrivilegeAssignment findById(Long id) {
        return userPrivilegeAssignmentRepository.findById(id).orElse(null);
    }

    //Delete userPrivilegeAssignment
    public void delete(Long id) {
        userPrivilegeAssignmentRepository.deleteById(id);
    }

    //Update userPrivilegeAssignment
    public UserPrivilegeAssignment save(UserPrivilegeAssignment userPrivilegeAssignment) {
        return userPrivilegeAssignmentRepository.save(userPrivilegeAssignment);
    }
}
