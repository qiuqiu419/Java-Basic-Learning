package supermarket;

import java.util.Date;

public class ShowGoods {
    public static void main(String[] args) {
        Date produceDate = new Date();

        Date expireDate_dress = new Date(produceDate.getTime() + 3 * 365L * 24 * 3600 * 1000);
        Dress dress = new Dress("百褶裙", "裙子001", 100, 199, 99,
                Category.CLOTHES, produceDate, expireDate_dress, Size.MEDIUM, "全棉", "淡蓝", "古驰");


        Date expireDate_milk = new Date(produceDate.getTime() + 7L * 24 * 3600 * 1000);
        Milk milk = new Milk("光明优倍", "鲜奶001", 100, 12, 5,
                Category.FOOD, produceDate, expireDate_milk, 5, true, "上海",
                "光明");

        dress.dressDescribe();
        System.out.println("商品生产日期：" + dress.getProducedDate());
        System.out.println("商品保质期：" + dress.getExpireDate()+"\n");

        milk.milkDescribe();
        System.out.println("商品生产日期：" + milk.getProducedDate());
        System.out.println("商品保质期：" + milk.getExpireDate());
    }
}
