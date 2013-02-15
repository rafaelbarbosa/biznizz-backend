package com.biznizz.controller;

public class OrderAlreadyPaidException extends RuntimeException {
    public OrderAlreadyPaidException(Long orderId) {
        super("the order with id " + orderId + " has already been paid");
    }
}
