package com.biznizz.view;

import com.biznizz.domains.Order;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

@XmlRootElement
public class OrderView implements Serializable {

    private Long id;
    private String state;

    private Set<ProductView> products;
    private Long customerId;

    public static OrderView from(Order order) {
        OrderView view = new OrderView();
        view.setId(order.getId());
        view.setState(String.valueOf(order.getState()));
        view.setProducts(ProductView.from(order.getProducts()));
        return view;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setProducts(Set<ProductView> products) {
        this.products = products;
    }

    public Set<ProductView> getProducts() {
        return products;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
