package com.project.payment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.payment.entity.PaymentType;
import com.project.payment.repository.PaymentTypeRepository;
import com.project.payment.errorhandler.CommitFailedException;
import com.project.payment.errorhandler.DataNotFoundException;
import com.project.payment.errorhandler.UndefinedException;
import com.project.payment.util.SuccessTemplateMessage;

@Service
public class PaymentTypeService{

	
	@Autowired
    private PaymentTypeRepository paymentTypeRepository;
	
	public List<PaymentType> getAll() {
		// TODO Auto-generated method stub
		return paymentTypeRepository.findAll();
	}
	
	public PaymentType createNew(PaymentType newData) throws CommitFailedException, UndefinedException {
		try {
			return paymentTypeRepository.save(newData);
		} catch (Exception e) {
			if (e.getMessage().contains("Error while committing")) {
				throw new CommitFailedException();
			} else {
				throw new UndefinedException(e.toString());
			}
		}
	}

	public PaymentType getById(Long id) throws DataNotFoundException {
		return paymentTypeRepository.findById(id).orElseThrow(() -> new DataNotFoundException());
	}

	public PaymentType updateById(PaymentType updatedData, Long id) {

		return paymentTypeRepository.findById(id).map(data -> {
			updatedData.setId(id);
			data = updatedData;

			return paymentTypeRepository.save(data);
		}).orElseGet(() -> {
			return paymentTypeRepository.save(updatedData);
		});
	}

	public ResponseEntity<Object> deleteById(long id) throws DataNotFoundException {

		try {
			if (paymentTypeRepository.findById(id) != null) {
				paymentTypeRepository.deleteById(id);
			}
		} catch (Exception e) {
			throw new DataNotFoundException();
		}
		return new ResponseEntity<Object>(new SuccessTemplateMessage(), HttpStatus.OK);
	}

}

