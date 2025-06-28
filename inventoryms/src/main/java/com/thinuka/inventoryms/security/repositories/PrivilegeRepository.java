package com.thinuka.inventoryms.security.repositories;

import com.thinuka.inventoryms.security.models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

   public List<Privilege> findByRoleid(Long roleid);
}
