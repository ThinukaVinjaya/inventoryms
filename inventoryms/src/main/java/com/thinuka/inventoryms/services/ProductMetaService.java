package com.thinuka.inventoryms.services;


import com.thinuka.inventoryms.models.ProductMeta;
import com.thinuka.inventoryms.repositories.ProductMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMetaService {
    private ProductMetaRepository productMetaRepository;

    @Autowired
    public ProductMetaService(ProductMetaRepository productMetaRepository) {
        this.productMetaRepository = productMetaRepository;
    }

    public List<ProductMeta> getAllProductMetas(){
        return productMetaRepository.findAll();
    }

    public ProductMeta getProductMetaById(Long id) {
        return productMetaRepository.findById(id).orElse(null);
    }

    public ProductMeta save(ProductMeta productMeta) {
        return productMetaRepository.save(productMeta);
    }

    public void deleteProductMeta(Long id){
        productMetaRepository.deleteById(id);
    }
}
