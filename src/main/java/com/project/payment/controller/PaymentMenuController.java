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
import com.project.payment.entity.PaymentMenu;
import com.project.payment.errorhandler.CommitFailedException;
import com.project.payment.errorhandler.DataNotFoundException;
import com.project.payment.errorhandler.UndefinedException;
import com.project.payment.service.PaymentMenuService;
@RestController
@RequestMapping("payment_menu")
public class PaymentMenuController {
	@Autowired
    private PaymentMenuService paymentMenuService;

    @GetMapping
    public List<PaymentMenu> get() {

        return paymentMenuService.getAll();
    }
    
    @PostMapping("/create")
	public @ResponseBody PaymentMenu createNew(@RequestBody PaymentMenu paymentMenu) {
		try {
			return paymentMenuService.createNew(paymentMenu);
		} catch (CommitFailedException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		} catch (UndefinedException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}
	}
    
    @GetMapping("/{id}/detail")
	public @ResponseBody PaymentMenu findById(@PathVariable Long id) {
		try {
			return paymentMenuService.getById(id);
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}
	}

	@PutMapping("/{id}/update-data")
	public @ResponseBody PaymentMenu updateData(@RequestBody PaymentMenu paymentMenu, @PathVariable Long id) {
		return paymentMenuService.updateById(paymentMenu, id);
	}

	@DeleteMapping("/{id}/delete-data")
	public @ResponseBody ResponseEntity<Object> deleteById(@PathVariable Long id) {
		try {
			return paymentMenuService.deleteById(id);

		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}

	}
}
