package com.thinuka.inventoryms.repositories;


import com.thinuka.inventoryms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,  Long> {
    User findByUsername(String username);
}
