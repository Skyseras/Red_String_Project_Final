package com.pro.WeBuy.controller;


import com.pro.WeBuy.model.Order;
import com.pro.WeBuy.model.OrderForm;
import com.pro.WeBuy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public Order saveOrder(@RequestBody OrderForm orderForm){
        return orderService.saveOrder(orderForm);
    }
}
