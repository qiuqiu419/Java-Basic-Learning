package com.geekbang.supermarket;

public class TestVizSamePkgAppMain {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, 100);

        // >> TODO 同一个包里的代码，可以访问缺省和protected
        Phone ph = (Phone) superMarket.getMerchandiseOf(10);
        ph.describe();
        System.out.println("手机屏幕尺寸："+ph.screenSize);
        System.out.println("手机内存大小："+ph.memoryG);

        // >> TODO 同一个包里的代码，可以访问缺省和protected，子类也没问题
        ShellColorChangePhone scp = (ShellColorChangePhone) superMarket.getMerchandiseOf(100);
        scp.describe();
        System.out.println("可变颜色手机屏幕尺寸："+scp.screenSize);
        System.out.println("可变颜色手机内存大小："+scp.memoryG);

    }
}
