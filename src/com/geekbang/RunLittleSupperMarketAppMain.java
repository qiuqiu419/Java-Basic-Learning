package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.MerchandiseV2;

public class RunLittleSupperMarketAppMain {
    public static void main(String[] args) {
        // ����һ��С������
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket(
                "��������", "�ֶ��Ž���٢·168��",
                100, 200, 200);

        System.out.println("VIP���������ۿ�����Ϊ��" + MerchandiseV2.getDiscountOnDiscount(littleSuperMarket));

    }
}