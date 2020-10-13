package com.project.payment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.payment.entity.Payment;
import com.project.payment.repository.PaymentRepository;
import com.project.payment.errorhandler.CommitFailedException;
import com.project.payment.errorhandler.DataNotFoundException;
import com.project.payment.errorhandler.UndefinedException;
import com.project.payment.util.SuccessTemplateMessage;

@Service
public class PaymentService{

	
	@Autowired
    private PaymentRepository paymentRepository;
	
	public List<Payment> getAll() {
		return paymentRepository.findAll();
	}
	
	public Payment createNew(Payment newData) throws CommitFailedException, UndefinedException {
		try {
			return paymentRepository.save(newData);
		} catch (Exception e) {
			if (e.getMessage().contains("Error while committing")) {
				throw new CommitFailedException();
			} else {
				throw new UndefinedException(e.toString());
			}
		}
	}

	public Payment getById(Long id) throws DataNotFoundException {
		return paymentRepository.findById(id).orElseThrow(() -> new DataNotFoundException());
	}

	public Payment updateById(Payment updatedData, Long id) {

		return paymentRepository.findById(id).map(data -> {
			updatedData.setId(id);
			data = updatedData;

			return paymentRepository.save(data);
		}).orElseGet(() -> {
			return paymentRepository.save(updatedData);
		});
	}

	public ResponseEntity<Object> deleteById(long id) throws DataNotFoundException {

		try {
			if (paymentRepository.findById(id) != null) {
				paymentRepository.deleteById(id);
			}
		} catch (Exception e) {
			throw new DataNotFoundException();
		}
		return new ResponseEntity<Object>(new SuccessTemplateMessage(), HttpStatus.OK);
	}

}
