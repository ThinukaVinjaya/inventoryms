package com.thinuka.inventoryms.repositories;


import com.thinuka.inventoryms.models.ProductMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMetaRepository extends JpaRepository<ProductMeta, Long> {
}
