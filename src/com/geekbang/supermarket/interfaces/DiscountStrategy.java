package com.geekbang.supermarket.interfaces;

public interface DiscountStrategy {
    /**
     * @param shoppingCart
     * @return ��Ϊ���ۿ۲������ۿ۵���Ǯ��ע�Ⲣ���ۿ۵��ܼۡ�
     */
    double discount(ShoppingCart shoppingCart);
}
