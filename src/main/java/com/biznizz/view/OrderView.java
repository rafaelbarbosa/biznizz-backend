package com.biznizz.view;

import com.biznizz.domains.Order;

import javax.xml.bind.annotation.XmlElement;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderView orderView = (OrderView) o;

        if (customerId != null ? !customerId.equals(orderView.customerId) : orderView.customerId != null) return false;
        if (id != null ? !id.equals(orderView.id) : orderView.id != null) return false;
        if (products != null ? !products.equals(orderView.products) : orderView.products != null) return false;
        if (state != null ? !state.equals(orderView.state) : orderView.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderView{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", products=" + products +
                ", customerId=" + customerId +
                '}';
    }
}
