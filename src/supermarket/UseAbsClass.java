package supermarket;

import java.util.Date;

public class UseAbsClass {
    public static void main(String[] args) {

        Date produceDate = new Date();
        Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);
        GamePointCard gamePointCard = new GamePointCard(
                "点卡001", "点卡001", 100, 1999, 999,Category.ELECTRIC,
                produceDate, expireDate
        );

        // >> TODO 父类的引用可以用子类的引用赋值，抽象类也一样
        AbstractExpireDateMerchandise am = gamePointCard;

        am.describe();
        System.out.println("商品生产日期："+am.getProducedDate());
        System.out.println("商品保质期："+am.getExpireDate());
        System.out.println(am.notExpireInDays(30));

    }
}
