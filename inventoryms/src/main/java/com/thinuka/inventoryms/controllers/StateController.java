package com.thinuka.inventoryms.controllers;


import com.thinuka.inventoryms.models.State;
import com.thinuka.inventoryms.services.CountryService;
import com.thinuka.inventoryms.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StateController {
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;

	@GetMapping("/states")
	public List<State> addModelAttribute(){
		return stateService.findAll();
	}

	@GetMapping("/state/{id}")
	public State findOne(@PathVariable("id") Integer id){
		return stateService.findById(id);
	}

	@PutMapping("/state/{id}")
	public State editState(@RequestBody State state){
		return stateService.save(state);
	}

	//Add State
	@PostMapping(value="/states")
	public State addNew(@RequestBody State state) {
		return stateService.save(state);
	}

	@RequestMapping(value="/parameters/states/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		stateService.delete(id);
		return "redirect:/parameters/states";
	}

}
