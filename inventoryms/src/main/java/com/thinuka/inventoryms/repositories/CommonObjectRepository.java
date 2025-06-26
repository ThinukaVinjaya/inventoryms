package com.thinuka.inventoryms.repositories;


import com.thinuka.inventoryms.models.CommonObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonObjectRepository extends JpaRepository<CommonObject, Long> {
    List<CommonObject> findByObjectType(String objectName);
}
