package com.geekbang.supermarket;

public class MerchandiseV2 {

    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;


    public static double DISCOUNT_FOR_VIP = 0.95;

    //����VIP�ۿ�
    public static double getVIPDiscount() {
        return DISCOUNT_FOR_VIP;
    }

    //���г����Żݻ������
    public static double getDiscountOnDiscount(LittleSuperMarket littleSuperMarket) {
        double activityDiscount = littleSuperMarket.activityDiscount;
        return DISCOUNT_FOR_VIP * activityDiscount;
    }

    public MerchandiseV2(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
        // soldPrice = 9/0;
    }

    public String getName() {
        return name;
    }

    public MerchandiseV2(String name, String id, int count, double soldPrice) {
        // double purPrice = soldPrice * 0.8;
        // this(name, id, count, soldPrice, purchasePrice);
        this(name, id, count, soldPrice, soldPrice * 0.8);
        // double purPrice = soldPrice * 0.8;
    }

    public MerchandiseV2() {
        this("����", "000", 0, 1, 1.1);

    }

    public void describe() {
        System.out.println("��Ʒ���ֽ���" + name + "��id��" + id + "�� ��Ʒ�ۼ���" + soldPrice
                + "����Ʒ������" + purchasePrice + "����Ʒ�������" + count +
                "������һ����ë������" + (soldPrice - purchasePrice) + "���ۿ�Ϊ" + DISCOUNT_FOR_VIP);
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
//        if(profit <= 0){
//            return 0;
//        }
        return profit;
    }


    public double buy() {
        return buy(1);
    }

    public double buy(int count) {
        return buy(count, false);
    }

    public double buy(int count, boolean isVIP) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        if (isVIP) {
            return totalCost * getVIPDiscount();
        } else {
            return totalCost;
        }
    }
}
