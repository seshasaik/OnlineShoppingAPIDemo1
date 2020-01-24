package com.onlineShoping.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.Supplier;
import com.onlineShoping.demo.exceptions.SupplierAlreadyExistedException;
import com.onlineShoping.demo.exceptions.SupplierNotFoundException;
import com.onlineShoping.demo.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	private final String SUPPLIER_NOT_FOUND = "Supplier not found for given id : %1$s";

	@Autowired
	SupplierRepository supplierRepository;

	public SupplierServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}
	@Override
	public List<Supplier> getAllSuppliers(String[] supplierIds) {
		// TODO Auto-generated method stub
		return supplierRepository.findByIdNotIn(supplierIds);
	}
	@Override
	public Supplier getSupplierById(String id)
			throws SupplierNotFoundException {
		// TODO Auto-generated method stub
		return supplierRepository.findById(id).orElseThrow(() -> {
			throw new SupplierNotFoundException(
					String.format(SUPPLIER_NOT_FOUND, id));
		});
	}

	@Override
	public void saveSupplier(Supplier supplier)
			throws SupplierAlreadyExistedException {
		// TODO Auto-generated method stub
		Supplier existedSupplier = supplierRepository.findByRegNumberOrMobile(
				supplier.getRegNumber(), supplier.getMobile()).orElse(null);

		if (Objects.isNull(existedSupplier)) {
			supplierRepository.save(supplier);
		} else {
			String message = "Supplier with %1$s : %2$s is already existed";
			if (existedSupplier.getRegNumber()
					.equals(supplier.getRegNumber())) {
				message = String.format(message, "Regno",
						supplier.getRegNumber());
			} else {
				message = String.format(message, "Mobile no",
						supplier.getMobile());
			}
			throw new SupplierAlreadyExistedException(message);
		}
	}

	@Override
	public void updateSupplier(Supplier supplier)
			throws SupplierNotFoundException {
		// TODO Auto-generated method stub

		Supplier existedSuppiler = supplierRepository
				.findByMobileNumberOrRegNumberAndIdNot(supplier.getMobile(),
						supplier.getRegNumber(), supplier.getId())
				.orElse(null);
		if (Objects.isNull(existedSuppiler)) {
			supplierRepository.save(supplier);
		}
		String message = "Supplier with %1$s : %2$s is already existed";
		if (existedSuppiler.getRegNumber().equals(supplier.getRegNumber())) {
			message = String.format(message, "Registration number",
					supplier.getRegNumber());
		} else {
			message = String.format(message, "Mobile number",
					supplier.getRegNumber());
		}
		throw new SupplierAlreadyExistedException(message);
	}

}
