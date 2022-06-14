package com.geekbang;

import com.geekbang.supermarket.MerchandiseV2;
import static com.geekbang.supermarket.MerchandiseV2.getVIPDiscount;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        MerchandiseV2 merchandise = new MerchandiseV2
                ("书桌", "DESK9527", 40, 999.9, 500);
        //todo 展示超市数据
        merchandise.describe();
        //todo 展示超市折扣价
        System.out.println(getVIPDiscount());

    }
}
