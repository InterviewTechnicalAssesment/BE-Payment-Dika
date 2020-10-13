package com.project.payment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.payment.entity.PaymentMenu;
import com.project.payment.repository.PaymentMenuRepository;
import com.project.payment.errorhandler.CommitFailedException;
import com.project.payment.errorhandler.DataNotFoundException;
import com.project.payment.errorhandler.UndefinedException;
import com.project.payment.util.SuccessTemplateMessage;

@Service
public class PaymentMenuService{

	
	@Autowired
    private PaymentMenuRepository paymentMenuRepository;
	
	public List<PaymentMenu> getAll() {
		// TODO Auto-generated method stub
		return paymentMenuRepository.findAll();
	}
	
	public PaymentMenu createNew(PaymentMenu newData) throws CommitFailedException, UndefinedException {
		try {
			return paymentMenuRepository.save(newData);
		} catch (Exception e) {
			if (e.getMessage().contains("Error while committing")) {
				throw new CommitFailedException();
			} else {
				throw new UndefinedException(e.toString());
			}
		}
	}

	public PaymentMenu getById(Long id) throws DataNotFoundException {
		return paymentMenuRepository.findById(id).orElseThrow(() -> new DataNotFoundException());
	}

	public PaymentMenu updateById(PaymentMenu updatedData, Long id) {

		return paymentMenuRepository.findById(id).map(data -> {
			updatedData.setId(id);
			data = updatedData;

			return paymentMenuRepository.save(data);
		}).orElseGet(() -> {
			return paymentMenuRepository.save(updatedData);
		});
	}

	public ResponseEntity<Object> deleteById(long id) throws DataNotFoundException {

		try {
			if (paymentMenuRepository.findById(id) != null) {
				paymentMenuRepository.deleteById(id);
			}
		} catch (Exception e) {
			throw new DataNotFoundException();
		}
		return new ResponseEntity<Object>(new SuccessTemplateMessage(), HttpStatus.OK);
	}

}
