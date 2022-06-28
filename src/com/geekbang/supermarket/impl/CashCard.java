package com.geekbang.supermarket.impl;

import com.geekbang.supermarket.interfaces.Card;
import com.geekbang.supermarket.interfaces.Customer;
import com.geekbang.supermarket.interfaces.ShoppingCart;

public class CashCard implements Card {
    private double point;

    public CashCard(double point) {
        this.point = point;
    }

    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, ShoppingCart shoppingCart) {
        // ����ۿ�����ʣ�µ�Ǯ�ȵ����٣���ô�͵ֿ۵���Ҫ����ʣ�µ�Ǯ
        if (totalCostAfterDiscount < point) {
            point -= totalCostAfterDiscount;
            return totalCostAfterDiscount;
        } else {
            // ����͵ֿ۵����еĵ�
            point = 0;
            return point;
        }
    }
}
