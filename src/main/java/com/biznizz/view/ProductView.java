package com.biznizz.view;

import com.biznizz.domains.Product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductView implements Serializable {

    private Long id;
    private String ean;
    private Long quantity;
    private String unitPrice;

    public static Set<ProductView> from(Set<Product> products) {

        Set<ProductView> views = new HashSet<ProductView>();

        for (Product product : products) {
            ProductView view = new ProductView();

            view.setId(product.getId());
            view.setEan(product.getEan());
            view.setQuantity(product.getQuantity());
            view.setUnitPrice(String.valueOf(product.getUnitPrice()));

            views.add(view);
        }

        return views;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getEan() {
        return ean;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitPrice() {
        return unitPrice;
    }
}
