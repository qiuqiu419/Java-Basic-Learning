package supermarket;

import java.util.Date;

public class Milk extends AbstractExpireDateMerchandise {

    private double milk_weight;//重量
    private boolean Is_defatted_Milk;//是否为脱脂牛奶
    private String place_of_Production;//产地
    private String brand;//品牌

    public Milk(
            String name, String id, int count, double soldPrice, double purchasePrice, Category category,
            Date produceDate, Date expirationDate, double milk_weight, boolean Is_defatted_Milk, String place_of_Production
            , String brand
    ) {
        super(name, id, count, soldPrice, purchasePrice, category, produceDate, expirationDate);
        this.milk_weight = milk_weight;
        this.Is_defatted_Milk = Is_defatted_Milk;
        this.place_of_Production = place_of_Production;
        this.brand = brand;
    }

    public double getMilk_weight() {
        return milk_weight;
    }

    public boolean isIs_defatted_Milk() {
        return Is_defatted_Milk;
    }

    public String getPlace_of_Production() {
        return place_of_Production;
    }

    public String getBrand() {
        return brand;
    }

    public void milkDescribe() {
        System.out.println("此牛奶商品属性如下");
        describe();
        System.out.println("牛奶厂商为" + brand + "；牛奶重量为" + milk_weight + "kg\n" +
                "牛奶产地为：" + place_of_Production + "\n" +
                "是否为脱脂牛奶" + Is_defatted_Milk);
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return soldPrice * (leftDatePercentage);
    }
}
