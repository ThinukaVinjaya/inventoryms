package com.thinuka.inventoryms.controllers;


import com.thinuka.inventoryms.models.Supplier;
import com.thinuka.inventoryms.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {
	private final SupplierService supplierService;

	@Autowired
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@GetMapping("/suppliers")
	public List<Supplier> getSuppliers(){
		return supplierService.findAll();
	}

	@GetMapping("/supplier/{id}")
	public Supplier getSupplier(@PathVariable("id") Long id){
		return supplierService.findById(id);
	}

	@PutMapping("/supplier/{id}")
	public Supplier updateSupplier(@RequestBody() Supplier supplier, @PathVariable("id") Long id){
		return supplierService.save(supplier);
	}

	@PostMapping("/suppliers")
	public Supplier addNew(@RequestBody() Supplier supplier){
		return supplierService.save(supplier);
	}

	@DeleteMapping("/supplier/{id}")
	public void deleteSupplier(@PathVariable("id") Long id){
		supplierService.deleteById(id);
	}
}
