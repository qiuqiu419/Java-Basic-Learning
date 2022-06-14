package supermarket;



import com.geekbang.supermarket.MerchandiseV2;

import java.util.Scanner;

public class RunLittleSupperMarketAppMain {
    public static void main(String[] args) {
        // ����һ��С������
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        // ���θ����е����֣���ַ��ͣ��λ��ֵ
        littleSuperMarket.superMarketName = "�м�С����";
        littleSuperMarket.address = "�ֶ��������ʹ��666��";
        littleSuperMarket.parkingCount = 100;
        // ������200����Ʒ
        littleSuperMarket.merchandises = new Merchandise[200];
        // ͳ���õ�����
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        // Ϊ��ʹ�÷��㣬����һ����Ʒ�������ã���littleSuperMarket.merchandisesָ��ͬһ���������
        Merchandise[] all = littleSuperMarket.merchandises;

        // ��������200����Ʒ��ֵ
        for (int i = 0; i < all.length; i++) {
            // ����������Ʒ�����Ը�ֵ
            Merchandise m = new Merchandise();
            m.name = "��Ʒ" + i;
            m.count = 200;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            // �ô�������Ʒ������Ʒ����ĵ�i�����ø�ֵ��all��С���е���Ʒ��������ָ�����ͬһ���������
            all[i] = m;
        }

        // ����һ��Scanner��ȡ����
        Scanner scanner = new Scanner(System.in);
        Merchandise m0 = all[0];
        while (true) {
            System.out.println("���ճ��д��ػݣ�������Ʒ�ڶ�����ۣ�ѡ��Ҫ�������Ʒ������");
            int index = scanner.nextInt();
            if (index < 0) {
                System.out.println("��ӭ�ٴι��٣�");
                break;
            }

            System.out.println("������Ҫ�����������");
            int count = scanner.nextInt();

            Merchandise m = littleSuperMarket.merchandises[index];
            System.out.println("�û�ѡ�����Ʒ�ǳ������ֵ��ߵģ�" +
                    m.isTheBiggestTotalValueOne(littleSuperMarket));
            double totalCost = m.buyAndPrintLeft(count, true);

            boolean m0BiggerThan = m0.totalValueBiggerThan(m);
            System.out.println("m0���ܼ�ֵ���û�ѡ���Ҫ��" + m0BiggerThan);

            System.out.println("��Ʒ�ܼ�Ϊ��" + totalCost);
        }

    }
}
