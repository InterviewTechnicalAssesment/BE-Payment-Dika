package com.project.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.payment.entity.PaymentType;
import com.project.payment.service.PaymentTypeService;
import com.project.payment.errorhandler.CommitFailedException;
import com.project.payment.errorhandler.DataNotFoundException;
import com.project.payment.errorhandler.UndefinedException;

@RestController
@RequestMapping("payment_type")
public class PaymentTypeController {
	@Autowired
    private PaymentTypeService paymentTypeService;

    @GetMapping
    public List<PaymentType> get() {

        return paymentTypeService.getAll();
    }
    
    @PostMapping("/create")
	public @ResponseBody PaymentType createNew(@RequestBody PaymentType paymentType) {
		try {
			return paymentTypeService.createNew(paymentType);
		} catch (CommitFailedException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		} catch (UndefinedException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}
	}
    
    @GetMapping("/{id}/detail")
	public @ResponseBody PaymentType findById(@PathVariable Long id) {
		try {
			return paymentTypeService.getById(id);
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}
	}

	@PutMapping("/{id}/update-data")
	public @ResponseBody PaymentType updateData(@RequestBody PaymentType paymentType, @PathVariable Long id) {
		return paymentTypeService.updateById(paymentType, id);
	}

	@DeleteMapping("/{id}/delete-data")
	public @ResponseBody ResponseEntity<Object> deleteById(@PathVariable Long id) {
		try {
			return paymentTypeService.deleteById(id);

		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}

	}
}
