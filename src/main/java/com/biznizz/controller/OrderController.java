package com.biznizz.controller;

import com.biznizz.domains.Customer;
import com.biznizz.domains.Order;
import com.biznizz.domains.OrderState;
import com.biznizz.domains.Product;
import com.biznizz.repository.CustomerRepository;
import com.biznizz.repository.OrderRepository;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class OrderController {

    @Inject
    protected OrderRepository orderRepository;


    @Inject
    protected CustomerRepository customerRepository;


    public List<Order> getAllOrders(){
        return orderRepository.getAll();
    }

    public BigDecimal receivePayment(Long orderId, BigDecimal ammount){

        Order order =  orderRepository.getById(orderId);

        if(order == null){
            throw new OrderNotFoundException(orderId);
        }


        if(order.getState().equals(OrderState.PAID)){
            throw new OrderAlreadyPaidException(orderId);
        }

        BigDecimal total = BigDecimal.ZERO;
        for(Product  product :order.getProducts()){
            total = total.add(product.getUnitPrice());
        }
        if(ammount.compareTo(total) >= 0){
            order.setState(OrderState.PAID);
        }

        return ammount.subtract(total);
    }


    public Order create(Long customerId) {

        Customer customer = customerRepository.getById(customerId);

        Order order = new Order();

        order.setCustomer(customer);
        customer.getOrders().add(order);

        order.setState(OrderState.OPEN);

        order.setCreatedOn(new Timestamp(Calendar.getInstance().getTimeInMillis()));

        orderRepository.save(order);
        customerRepository.save(customer);

        return order;

    }
}
