package com.thinuka.inventoryms.security.repositories;

import com.thinuka.inventoryms.security.models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

}
