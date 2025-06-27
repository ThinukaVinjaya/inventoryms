package com.thinuka.inventoryms.security.repositories;

import com.thinuka.inventoryms.security.models.UserPrivilegeAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrivilegeAssignmentRepository extends JpaRepository<UserPrivilegeAssignment, Long> {
}
