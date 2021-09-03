package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entities.Address;
import com.shopping.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/addresses")
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.addAddress(address));
	}

	@GetMapping("/addresses")
	public ResponseEntity<List<Address>> viewAllAddress() {
		return ResponseEntity.ok(addressService.viewAllAddress());
	}

	@GetMapping("/addresses/{addressId}")
	public ResponseEntity<Address> viewAddress(@PathVariable("addressId") int addressId) {
		return ResponseEntity.ok(addressService.viewAddress(addressId));
	}

	@PutMapping("/addresses/{addressId}")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address,
			@PathVariable("addressId") int addressId) {
		return ResponseEntity.ok(addressService.updateAddress(addressId, address));
	}

	@DeleteMapping("/addresses/{addressId}")
	public ResponseEntity<Address> removeAddress(@PathVariable("addressId") int addressId) {
		return ResponseEntity.ok(addressService.removeAddress(addressId));
	}
}
