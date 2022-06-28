package com.geekbang.supermarket.impl;

import com.geekbang.supermarket.interfaces.Category;
import com.geekbang.supermarket.interfaces.Customer;
import com.geekbang.supermarket.interfaces.ShoppingCart;
import static com.geekbang.supermarket.util.ShoppingUtil.getRandomCategory;

public abstract class AbsCustomer implements Customer {
    private Category shouldBuy;
    private String custId;
    private double moneySpent;
    private int guangLeft = 0;
    private int guangCount = 0;

    public static final int DEFAULT_GUANG_COUNT = 5;

    public AbsCustomer(String custId, Category shouldBuy, int guangCount) {
        this.shouldBuy = shouldBuy;
        this.guangCount = guangCount;
        this.custId = custId;
    }

    public int getGuangCount() {
        return guangCount;
    }

    public void setGuangCount(int guangCount) {
        this.guangCount = guangCount;
    }

    public AbsCustomer(String custId, Category shouldBuy) {
        this(custId, shouldBuy, DEFAULT_GUANG_COUNT);
    }

    @Override
    public String getCustId() {
        return custId;
    }

    @Override
    public void startShopping() {
        guangLeft = guangCount;
    }

    @Override
    public boolean wantToCheckout() {
        guangLeft--;
        return guangLeft <= 0;
    }

    @Override
    public double payFor(ShoppingCart shoppingCart, double totalCost) {
        // TODO ������ҵ�˼���⣬������ô�죿
        moneySpent += totalCost;
        return totalCost;
    }

    public Category getShouldBuy() {
        return shouldBuy;
    }

    /**
     * �ȿ�������ģ�û�б�����ľ���㿴��
     *
     * @return ��Ҫ�������Ʒ����
     */
    @Override
    public Category chooseCategory() {
        // ��һ�λ��ῴ��Ҫ��Ķ���
        if (guangLeft + 1 >= guangCount) {
            return shouldBuy;
        } else {
            return getRandomCategory();
        }
    }

    @Override
    public double getMoneySpent() {
        return moneySpent;
    }
}
