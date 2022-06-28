package com.geekbang.supermarket.impl;

import com.geekbang.supermarket.interfaces.*;

import static com.geekbang.supermarket.util.ShoppingUtil.output;

public class SimpleShopman implements Shopman {
    private SuperMarket superMarket;

    public SimpleShopman(SuperMarket superMarket) {
        this.superMarket = superMarket;
    }

    private static final int MAX_BUY_DEFAULT = 9;

    @Override
    public void serveCustomer(Customer customer) {
        int maxTypeToBuy = MAX_BUY_DEFAULT;
        if (customer instanceof AbsCustomer) {
            maxTypeToBuy = ((AbsCustomer) customer).getGuangCount();
        }
        ShoppingCart shoppingCart = new ShoppingCart(maxTypeToBuy);
        customer.startShopping();

        while ((!customer.wantToCheckout()) && shoppingCart.canHold()) {
            Category category = customer.chooseCategory();
            // �򵥵ĵ���Ա���˿�˵����������ˣ������Ƽ�
            if (category == null) {
                continue;
            }
            Merchandise[] toChoose = superMarket.getRandomMerchandiseOfCategory(category);
            // �򵥵ĵ���Ա��һ�����Ƽ�����˵�Ӽ۸�ߵ����Ƽ�֮���С���ɡ�
            for (Merchandise m : toChoose) {
                if (m == null) {
                    continue;
                }
                int buyCount = customer.buyMerchandise(m);
                if (buyCount > 0) {
                    // һ�����ֻ��һ����Ʒ
                    shoppingCart.add(m, buyCount);
                    break;
                }
            }
        }

        double originCost = shoppingCart.calculateOriginCost();
        double finalCost = originCost;

        double savedMoney = 0;
        if (customer instanceof HasCard) {
            Card card = ((HasCard) customer).getCard();
            savedMoney = card.processCardDiscount(originCost, finalCost, customer, shoppingCart);
            finalCost -= savedMoney;
        }

        double moneyEarned = customer.payFor(shoppingCart, finalCost);

        superMarket.addEarnedMoney(moneyEarned);

        output("�˿�" + customer.getCustId() + "�����嵥���£�");
        output(shoppingCart.toString());
        output("�Żݽ��Ϊ��" + savedMoney);
        output("ʵ�����Ϊ��" + moneyEarned);


        // >> TODO ˼���⣺����Ĵ����Ƿ�̫�������ˣ�����б�����͵�shopmain���Ƿ��д���������ã��еĻ�Ӧ����ô�죿

    }
}
