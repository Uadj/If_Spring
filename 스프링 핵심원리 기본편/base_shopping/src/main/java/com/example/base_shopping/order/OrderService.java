package com.example.base_shopping.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
