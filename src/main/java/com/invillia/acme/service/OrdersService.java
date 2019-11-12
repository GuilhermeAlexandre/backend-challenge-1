package com.invillia.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.exception.SavingOrderException;
import com.invillia.acme.exception.SupplyValidationException;
import com.invillia.acme.model.Item;
import com.invillia.acme.model.Orders;
import com.invillia.acme.model.OrdersItem;
import com.invillia.acme.repository.OrdersItemRepository;
import com.invillia.acme.repository.OrdersRepository;


@Service
public class OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private OrdersItemRepository ordersItemRepository;
	@Autowired
	private ItemService itemService;

	public List<Orders> get() {
		return ordersRepository.findAll();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Orders save(Orders order) throws Exception {

		try {
			order = ordersRepository.save(order);
			
			List<OrdersItem> items = order.getItems();
			for (OrdersItem orderItem : items) {
				orderItem.setOrder(order);
				Item item = itemService.getById(orderItem.getItem().getId());
				orderItem.setItem(item);
				if (this.amountValidation(orderItem)) {
					
					ordersItemRepository.save(orderItem);
					item.updateAmount(orderItem);
					itemService.update(item);
				}
				else {
					throw new SupplyValidationException("Product is not avaliable"); 
				}
			}
			return order;
		} catch (Exception e) {
			 throw e;
		}
	}

	public Orders getById(Long orderId) {
		return ordersRepository.findOne(orderId);
	}

	public void delete(Long orderId) {
		ordersRepository.delete(orderId);
	}

	public void update(Orders order) {
		ordersRepository.save(order);
	}

	public boolean amountValidation(OrdersItem orderItem) {
		return orderItem.getItem().getAmount() > 0 
				&& orderItem.getItem().getAmount() >= orderItem.getQuantity();
	}
}
