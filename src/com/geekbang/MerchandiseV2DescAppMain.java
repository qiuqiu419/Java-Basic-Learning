package com.geekbang;

import com.geekbang.supermarket.MerchandiseV2;
import static com.geekbang.supermarket.MerchandiseV2.getVIPDiscount;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        MerchandiseV2 merchandise = new MerchandiseV2
                ("����", "DESK9527", 40, 999.9, 500);
        //todo չʾ��������
        merchandise.describe();
        //todo չʾ�����ۿۼ�
        System.out.println(getVIPDiscount());

    }
}
