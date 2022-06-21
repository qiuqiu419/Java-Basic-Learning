package supermarket;

import java.util.Date;

public abstract class AbstractExpireDateMerchandise extends MerchandiseV2 implements ExpireDateMerchandise {
    private Date produceDate;
    private Date expirationDate;

    // >> TODO 抽象类里构造方法的语法和类一样。
    public AbstractExpireDateMerchandise(String name, String id, int count, double soldPrice, double purchasePrice, Category category, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice, category);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    public AbstractExpireDateMerchandise(String name, String id, int count, double soldPrice, Category category,Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, category);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    public AbstractExpireDateMerchandise(Date produceDate, Date expirationDate) {
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    // >> TODO @ 是Java中的注解（annotation），后面我们会详细讲述
    // >> TODO @Override代表此方法覆盖了父类的方法/实现了继承的接口的方法，否则会报错
    public boolean notExpireInDays(int days) {
        return daysBeforeExpire() > 0;
    }

    public Date getProducedDate() {
        return produceDate;
    }

    public Date getExpireDate() {
        return expirationDate;
    }

    public double leftDatePercentage() {
        return 1.0 * daysBeforeExpire() / (daysBeforeExpire() + daysAfterProduce());
    }

//    @Override
//    public double actualValueNow(double leftDatePercentage) {
//        return 0;
//    }

    // >> TODO 抽象类里自己定义的抽象方法，可以是protected，也可以是缺省的，这点和接口不一样
//    protected abstract void test();


    // TODO 这俩方法是私有的，返回值以后即使改成int，也没有顾忌
    private long daysBeforeExpire() {
        long expireMS = expirationDate.getTime();
        long left = expireMS - System.currentTimeMillis();
        if (left < 0) {
            return -1;
        }
        // 返回值是long，是根据left的类型决定的
        return left / (24 * 3600 * 1000);
    }

    private long daysAfterProduce() {
        long produceMS = produceDate.getTime();
        long past = System.currentTimeMillis() - produceMS;
        if (past < 0) {
            // 生产日期是未来的一个时间？315电话赶紧打起来。
            return -1;
        }
        // 返回值是long，是根据left的类型决定的
        return past / (24 * 3600 * 1000);
    }
}
