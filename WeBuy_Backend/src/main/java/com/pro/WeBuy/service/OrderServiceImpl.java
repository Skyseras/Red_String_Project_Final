package com.pro.WeBuy.service;

import com.pro.WeBuy.model.*;
import com.pro.WeBuy.repository.ClientRepository;
import com.pro.WeBuy.repository.OrderItemRepository;
import com.pro.WeBuy.repository.OrderRepository;
import com.pro.WeBuy.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class OrderServiceImpl implements OrderService {
    private ProductRepository productRepository;
    private ClientRepository clientRepository;
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(ProductRepository productRepository, ClientRepository clientRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Order saveOrder(OrderForm orderForm){
        Client client=new Client();
        client.setName(orderForm.getClient().getName());
        client.setEmail(orderForm.getClient().getEmail());
        client.setAddress(orderForm.getClient().getAddress());
        client.setPhoneNumber(orderForm.getClient().getPhoneNumber());
        client.setUsername(orderForm.getClient().getUsername());
        client=clientRepository.save(client);
        System.out.println(client.getId());

        Order order=new Order();
        order.setClient(client);
        order.setDate(new Date());
        order=orderRepository.save(order);
        double total=0;
        for(OrderProduct p:orderForm.getProducts()){
            OrderItem orderItem=new OrderItem();
            orderItem.setOrder(order);
            Product product=productRepository.findById(p.getId()).get();
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(p.getQuantity());
            orderItemRepository.save(orderItem);
            total+=p.getQuantity()*product.getPrice();
        }
        order.setTotalAmount(total);
        return orderRepository.save(order);
    }
}
