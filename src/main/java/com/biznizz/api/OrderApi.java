package com.biznizz.api;

import com.biznizz.controller.OrderController;
import com.biznizz.domains.Customer;
import com.biznizz.domains.Order;
import com.biznizz.domains.OrderState;
import com.biznizz.domains.Product;
import com.biznizz.view.OrderView;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Path(value = "order")
public class OrderApi {

    @Inject
    OrderController orderController;

    @GET
    @Produces(value = "application/json")
    public Set<OrderView> get(){

        Customer customer = new Customer();

        customer.setId(1L);

        Order  order = new Order(customer,
                new Timestamp(Calendar.getInstance().getTimeInMillis()),
                new Timestamp(Calendar.getInstance().getTimeInMillis()),
                "lalala",
                "lala",
                OrderState.OPEN,
                new HashSet<Product>()
        );
        //List<Order> orders = orderController.getAllOrders();
        Set<OrderView> orderViews = new HashSet<OrderView>();

        orderViews.add(OrderView.from(order));

        return orderViews;
    }

    @POST
    @Consumes(value={"application/json", "application/xml"})
    @Produces(value={"application/json", "application/xml"})
    public OrderView create(OrderView request){

        Customer customer = new Customer();

        customer.setId(request.getCustomerId());

       Order  order = new Order(customer,
                new Timestamp(Calendar.getInstance().getTimeInMillis()),
                new Timestamp(Calendar.getInstance().getTimeInMillis()),
                "lalala",
                "lala",
                OrderState.OPEN,
                new HashSet<Product>()
        );



        return OrderView.from(order);
    }





}