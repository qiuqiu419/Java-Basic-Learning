import java.util.Scanner;

public class ScoreMaster {
    public static void main(String[] args) {
        //�����ɼ�����
        int YuWenIndex = 0;
        int ShuXueIndex = 1;
        int WaiYuIndex = 2;
        int WuLiIndex = 3;
        int HuaXueIndex = 4;
        int ShengWuIndex = 5;
        int totalScoreCount = 6;
        //ÿ�ſ�Ŀ��ǩ
        String[] names = new String[totalScoreCount];
        names[YuWenIndex] = "����";
        names[ShuXueIndex] = "��ѧ";
        names[WaiYuIndex] = "����";
        names[WuLiIndex] = "����";
        names[HuaXueIndex] = "��ѧ";
        names[ShengWuIndex] = "����";

        Scanner scanner = new Scanner(System.in);

        System.out.println("�����빲�ж�����ĳɼ�:");

        int yearCount = scanner.nextInt();

        double[][] scores = new double[yearCount][totalScoreCount];
        //���ɳɼ�
        for (int i = 0; i < yearCount; i++) {
            for (int j = 0; j < totalScoreCount; j++) {
                scores[i][j] = 80 + Math.random() * 20;
                System.out.println("��" + (i + 1) + "��" + names[j] + "�ɼ�Ϊ" + scores[i][j]);
            }
        }

        boolean cont = true;
        while (cont) {
            System.out.println("������Ҫ���еĲ������");
            System.out.println("1.��ĳ�����óɼ�\n" +
                    "2.��ĳ���ƽ���ɼ�\n" +
                    "3.�����������óɼ�\n" +
                    "4.��ĳ�ſ�������óɼ�");

            int oprtId = scanner.nextInt();

            int year;
            switch (oprtId) {
                case 1:
                    System.out.println("������Ҫ����һ�����óɼ�");
                    year = scanner.nextInt() - 1;
                    if (year < 0 || year >= yearCount) {
                        System.out.println("�Ƿ����");
                        break;
                    }
                    int bestOfYearScoreId = 0;
                    for (int i = 1; i < totalScoreCount; i++) {
                        if (scores[year][bestOfYearScoreId] < scores[year][i]) bestOfYearScoreId = i;
                    }
                    System.out.println("��" + (year + 1) + "�����óɼ�Ϊ" + names[bestOfYearScoreId] + "��" + scores[year][bestOfYearScoreId]);
                    break;
                case 2:
                    System.out.println("������Ҫ����һ���ƽ���ɼ�");
                    year = scanner.nextInt() - 1;
                    if (year < 0 || year >= yearCount) {
                        System.out.println("�Ƿ����");
                        break;
                    }
                    double totalScore = 0;
                    for (int i = 0; i < totalScoreCount; i++) {
                        totalScore += scores[year][i];
                    }
                    System.out.println("��" + (year + 1) + "���ƽ���ɼ�Ϊ��" + (totalScore / totalScoreCount));
                    break;
                case 3:
                    int bestOfYearsScoreId = 0;
                    year = 0;
                    for (int i = 0; i < yearCount; i++) {
                        for (int j = 0; j < totalScoreCount; j++) {
                            if (scores[year][bestOfYearsScoreId] < scores[i][j]) {
                                year = i;
                                bestOfYearsScoreId = j;
                            }
                        }
                    }
                    System.out.println("������óɼ�Ϊ��" + (year + 1) + "��" + names[bestOfYearsScoreId] + ":" + scores[year][bestOfYearsScoreId]);
                    break;
                case 4:
                    System.out.println("����Ҫ��ѯ���ſε�������óɼ���1.���ġ�2.��ѧ��3.���4.����5.��ѧ��6.����");
                    int scoreId = scanner.nextInt()-1;
                    year = 0;
                    for (int i = 1; i < yearCount; i++) {
                        if (scores[year][scoreId] < scores[i][scoreId]) year = i;
                    }
                    System.out.println(names[scoreId] + "������óɼ�Ϊ��" + (year + 1) + "�꣬�ɼ�Ϊ��" + scores[year][scoreId]);
                    break;
                default:
                    System.out.println("���������");
                    cont = false;
            }
        }
    }
}
