package com.thinuka.inventoryms.security.services;

import com.thinuka.inventoryms.repositories.UserRepository;
import com.thinuka.inventoryms.security.models.Privilege;
import com.thinuka.inventoryms.security.models.Role;
import com.thinuka.inventoryms.security.repositories.PrivilegeRepository;
import com.thinuka.inventoryms.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private UserRepository userRepository;

    //Get All Privileges
    public List<Privilege> findAll() {
        return privilegeRepository.findAll();
    }

    //Get Privilege By Id
    public Privilege findById(Long id) {
        return privilegeRepository.findById(id).orElse(null);
    }

    //Delete Privilege
    public void delete(Long id) {
        privilegeRepository.deleteById(id);
    }

    //Update Privilege
    public Privilege save(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

}
