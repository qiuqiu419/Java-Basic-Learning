package supermarket;

import java.util.Date;

public class GamePointCard extends AbstractExpireDateMerchandise {
    public GamePointCard(String name, String id, int count, double soldPrice, double purchasePrice, Category category, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice, category, produceDate, expirationDate);
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return super.getSoldPrice();
    }
}
