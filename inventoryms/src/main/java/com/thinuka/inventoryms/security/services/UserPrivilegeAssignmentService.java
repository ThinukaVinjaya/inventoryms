package com.thinuka.inventoryms.security.services;

import com.thinuka.inventoryms.models.User;
import com.thinuka.inventoryms.repositories.UserRepository;
import com.thinuka.inventoryms.security.models.Privilege;
import com.thinuka.inventoryms.security.models.Role;
import com.thinuka.inventoryms.security.models.UserPrivilegeAssignment;
import com.thinuka.inventoryms.security.repositories.RoleRepository;
import com.thinuka.inventoryms.security.repositories.UserPrivilegeAssignmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
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

    @Transactional
    public List<Privilege> savePrivilege(List<Privilege> privileges, Long userid){
        userPrivilegeAssignmentRepository.deleteByUserid(userid);

        List<UserPrivilegeAssignment> assignments = privileges.stream()
                .map(privilege -> new UserPrivilegeAssignment(userid, privilege.getId()))
                .toList();

        return userPrivilegeAssignmentRepository.saveAll(assignments).stream()
                .map(UserPrivilegeAssignment::getPrivilege)
                .toList();
    }

    public void deletePrivileges(Long userid){
        userPrivilegeAssignmentRepository.deleteByUserid(userid);
    }

    public List<Privilege> getUserPrivileges(Long userid) {
        List<UserPrivilegeAssignment> assignments = userPrivilegeAssignmentRepository.findByUserid(userid);
        return assignments.stream()
                .map(UserPrivilegeAssignment::getPrivilege)
                .toList();
    }


    public List<User> getUserByPrivileges(Long privilegeid) {
        List<UserPrivilegeAssignment> assignments = userPrivilegeAssignmentRepository.findByUserid(privilegeid);
        return assignments.stream()
                .map(UserPrivilegeAssignment::getUser)
                .toList();
    }
}
