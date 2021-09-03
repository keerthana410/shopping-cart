package com.shopping.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entities.Address;
import com.shopping.exception.RecordNotFoundException;
import com.shopping.repository.AddressRepository;
import com.shopping.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address addAddress(Address add) {
		return addressRepository.save(add);
	}

	@Override
	public Address updateAddress(int addressId, Address add) {
		Optional<Address> existingAddress = addressRepository.findById(addressId);
		if (!existingAddress.isPresent()) {
			throw new RecordNotFoundException("Address with Id: " + addressId + " not found. Try saving a new product");
		}
		add.setAddressId(addressId);
		return addressRepository.save(add);
	}

	@Override
	public Address removeAddress(int addressId) {
		Optional<Address> existingAddress = addressRepository.findById(addressId);
		if (!existingAddress.isPresent()) {
			throw new RecordNotFoundException("Address with Id: " + addressId + " not found. Try saving a new product");
		}
		addressRepository.deleteById(addressId);
		return existingAddress.get();
	}

	@Override
	public List<Address> viewAllAddress() {
		
		return addressRepository.findAll();
	}

	@Override
	public Address viewAddress(int addressId) throws RecordNotFoundException {
		Optional<Address> address = addressRepository.findById(addressId);
		if (!address.isPresent()) {
			throw new RecordNotFoundException("Address with Id: " + addressId + " not found");
		}
		return address.get();
	}
}
