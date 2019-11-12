package com.invillia.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.exception.OrderDoneException;
import com.invillia.acme.model.Orders;
import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrdersService orderService;
	
	public List<Payment> get() {
		return paymentRepository.findAll();
	}
	@Transactional(rollbackFor = Exception.class)
	public Payment save(Payment payment) {
		Orders order = orderService.getById(payment.getOrder().getId());
		if(order.getStatus().equals("Pending")) {
			paymentRepository.save(payment);
			order.setStatus("done");
			orderService.update(order);
			return payment;
		}
		else
			throw new OrderDoneException("The Order already was paid");
		
	}
	
	public Payment getById(Long paymentId) {
		return paymentRepository.findOne(paymentId);
    }
		
	public void delete(Long paymentId) {	
		paymentRepository.delete(paymentId);
	}
	
	public void update(Payment payment) {
		paymentRepository.save(payment);
		
	}

}
