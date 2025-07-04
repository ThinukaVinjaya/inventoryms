package com.thinuka.inventoryms.security.services;


import com.thinuka.inventoryms.models.User;
import com.thinuka.inventoryms.repositories.UserRepository;
import com.thinuka.inventoryms.security.models.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserPrivilegeAssignmentService assignmentService;
    private UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserPrivilegeAssignmentService assignmentService, UserRepository userRepository) {
        this.assignmentService = assignmentService;

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            throw  new UsernameNotFoundException("User not found in the database");
        }
        return new UserPrincipal(assignmentService, user);
    }
}
