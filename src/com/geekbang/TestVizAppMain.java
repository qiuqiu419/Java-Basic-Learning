package com.geekbang;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Phone;
import com.geekbang.supermarket.ShellColorChangePhone;

public class TestVizAppMain {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, 100);

        // >> TODO 不同包里的代码，不可以访问缺省和protected
        Phone ph = (Phone) superMarket.getMerchandiseOf(10);
        System.out.println("手机屏幕尺寸："+ph.getScreenSize());
        System.out.println("手机内存大小："+ph.getMemoryG());
        //System.out.println(ph.screenSize);
        //System.out.println(ph.memoryG);

        ShellColorChangePhone scp = (ShellColorChangePhone) superMarket.getMerchandiseOf(100);
        System.out.println("可变颜色手机屏幕尺寸："+scp.getScreenSize());
        System.out.println("可变颜色手机内存大小："+scp.getMemoryG());
        //System.out.println(scp.screenSize);
        //System.out.println(scp.memoryG);

    }
}
