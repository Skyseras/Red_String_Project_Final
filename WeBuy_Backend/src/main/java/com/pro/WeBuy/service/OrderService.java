package com.pro.WeBuy.service;

import com.pro.WeBuy.model.Order;
import com.pro.WeBuy.model.OrderForm;

public interface OrderService {
	Order saveOrder(OrderForm orderForm);
}
