package supermarket;

import java.util.Date;

public class Dress extends AbstractExpireDateMerchandise{

    private Size size;//尺寸
    private String material;//面料
    private String color;//颜色
    private String brand;//品牌

    public Dress(String name, String id, int count, double soldPrice, double purchasePrice, Category category,
                 Date produceDate, Date expirationDate, Size size, String material, String color, String brand) {
        super(name, id, count, soldPrice, purchasePrice, category, produceDate, expirationDate);
        this.size = size;
        this.material = material;
        this.color = color;
        this.brand = brand;
    }

    public Size getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public void dressDescribe(){
        System.out.println("此裙子商品属性如下");
        describe();
        System.out.println("裙子品牌为" + brand + "；尺寸为" + size + "\n" +
                "裙子面料为：" + material + "\n" +
                "裙子颜色为：" + color);
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return super.getSoldPrice();
    }
}
