package com.biznizz.controller;

import com.biznizz.domains.Order;
import com.biznizz.domains.OrderState;
import com.biznizz.domains.Product;
import com.biznizz.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderControllerTest {


    OrderController orderController;

    @Before
    public void setUp() throws Exception {

        orderController = new OrderController();

        orderController.orderRepository = mock(OrderRepository.class);


        Order order = new Order();

        order.setId(1L);

        order.setState(OrderState.OPEN);


        Product product1 = new Product();
        Product product2 = new Product();


        product1.setId(1L);
        product1.setUnitPrice(new BigDecimal("10.22"));

        product2.setId(2L);
        product2.setUnitPrice(new BigDecimal("5.14"));


        order.getProducts().add(product1);
        order.getProducts().add(product2);




        when(orderController.orderRepository.getById(1L)).thenReturn(order);


        Order order3 = new Order();

        order3.setState(OrderState.PAID);

        when(orderController.orderRepository.getById(3L)).thenReturn(order3);


    }

    @Test
    public void testReceivePayment() throws Exception {


        BigDecimal change = orderController.receivePayment(1L, new BigDecimal("20"));

        assert change.equals(new BigDecimal("4.64"));
        assert orderController.orderRepository.getById(1L).getState().equals(OrderState.PAID);

    }

    @Test(expected = OrderNotFoundException.class)
    public void testOrderNotFound() throws Exception{
        orderController.receivePayment(2L, new BigDecimal("20"));
    }

    @Test(expected = OrderAlreadyPaidException.class)
    public void testOrderAlreadyPaid() throws  Exception{
        orderController.receivePayment(3L, new BigDecimal("20"));
    }


    @Test()
    public void testPersonPaidLessThanTotal() throws Exception{
        BigDecimal change = orderController.receivePayment(1L,new BigDecimal("10"));

        assert change.compareTo(new BigDecimal("0")) == -1;
    }

}
