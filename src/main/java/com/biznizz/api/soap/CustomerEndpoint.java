package com.biznizz.api.soap;

import com.biznizz.domains.Customer;
import com.biznizz.domains.Order;
import com.biznizz.domains.OrderState;
import com.biznizz.domains.Product;
import com.biznizz.view.OrderView;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by NB18058 on 28-01-2015.
 */
@WebService(serviceName = "CustomerService")
public class CustomerEndpoint {

    @WebMethod(operationName = "GetOrder")
    public Set<OrderView> getOrder(){
        Customer customer = new Customer();

        customer.setId(1L);

        Order order = new Order(customer,
                new Timestamp(Calendar.getInstance().getTimeInMillis()),
                new Timestamp(Calendar.getInstance().getTimeInMillis()),
                "lalala",
                "lala",
                OrderState.OPEN,
                new HashSet<Product>()
        );
        Order order2 = new Order(customer,
                new Timestamp(Calendar.getInstance().getTimeInMillis()),
                new Timestamp(Calendar.getInstance().getTimeInMillis()),
                "lalala2",
                "lala2",
                OrderState.CANCELED,
                new HashSet<Product>()
        );
        //List<Order> orders = orderController.getAllOrders();
        Set<OrderView> orderViews = new HashSet<OrderView>();

        orderViews.add(OrderView.from(order));
        orderViews.add(OrderView.from(order2));

        return orderViews;
    }

}
