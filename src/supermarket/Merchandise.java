package supermarket;


import com.geekbang.supermarket.MerchandiseV2;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public void describe() {
        System.out.println("��Ʒ���ֽ���" + name + "��id��" + id + "�� ��Ʒ�ۼ���" + soldPrice
                + "����Ʒ������" + purchasePrice + "����Ʒ�������" + count +
                "������һ����ë������" + (soldPrice - purchasePrice));
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        if(profit <= 0){
            return 0;
        }
        return profit;
    }

    // >> TODO �����Ƕ����ڷ������ֺ�����������
    // >> TODO ��������Ĺ淶�ͱ���һ���������������ּӱ�ʶ��������ı�ʶ�����ǽ�����������
    // >> TODO �������еĴ������ʹ�ò���
    // >> TODO ������ֵ�ڵ��÷�����ʱ����Ҫ�������е����Ͻ���ʵ�Σ�ʵ�ʲ�����
    //    TODO ��Ӧ�ģ�������������Ĳ����������βΣ���ʽ������
    // �������ֵ�Ǹ������ʹ�����ʧ�ܣ������治��
    public double buy(int countToBuy) {
        if (count < countToBuy) {
            System.out.println("��Ʒ��治��");
            return -1;
        }

        // FIXME: ����Ӧ����soldPrice������purchasePrice��лл @Novichok ָ���������
        System.out.println("��Ʒ����Ϊ" + soldPrice);

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        count -= countToBuy;

        return totalCost;
    }

    // >> TODO һ�����������ж���������������֮���ö��Ÿ���
    public double buyAndPrintLeft(int countToBuy, boolean printLeft) {
        if (count < countToBuy) {
            System.out.println("��Ʒ��治��");
            if (printLeft) {
                System.out.println("��Ʒʣ����Ϊ" + count);
            }
            return -1;
        }

        // FIXME: ����Ӧ����soldPrice������purchasePrice��лл @Novichok ָ���������
        System.out.println("��Ʒ����Ϊ" + soldPrice);

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        count -= countToBuy;

        if (printLeft) {
            System.out.println("��Ʒʣ����Ϊ��" + count);
        }

        return totalCost;
    }

    // >> TODO �����������κ����ͣ������Զ������ͣ��������Լ������Ͷ�û����
    public boolean totalValueBiggerThan(Merchandise merchandise) {
        return count * purchasePrice > merchandise.purchasePrice * merchandise.count;
    }

    // >> TODO �����������κ����ͣ������Զ�������
    public boolean isTheBiggestTotalValueOne(LittleSuperMarket littleSuperMarket) {
        double totalValue = count * purchasePrice;
        for (int i = 0; i < littleSuperMarket.merchandises.length; i++) {
            Merchandise m = littleSuperMarket.merchandises[i];
            double newTotalValue = m.count * m.purchasePrice;
            if (totalValue < newTotalValue) {
                // ִ�е�return��ʱ�򣬷���ֱ�ӽ����������ǲ�����ѭ���У����ڵڼ���ѭ���С�
                return false;
            }
        }
        return true;
    }
}
