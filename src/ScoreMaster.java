import java.util.Scanner;

public class ScoreMaster {
    public static void main(String[] args) {
        //声明成绩索引
        int YuWenIndex = 0;
        int ShuXueIndex = 1;
        int WaiYuIndex = 2;
        int WuLiIndex = 3;
        int HuaXueIndex = 4;
        int ShengWuIndex = 5;
        int totalScoreCount = 6;
        //每门科目标签
        String[] names = new String[totalScoreCount];
        names[YuWenIndex] = "语文";
        names[ShuXueIndex] = "数学";
        names[WaiYuIndex] = "外语";
        names[WuLiIndex] = "物理";
        names[HuaXueIndex] = "化学";
        names[ShengWuIndex] = "生物";

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入共有多少年的成绩:");

        int yearCount = scanner.nextInt();

        double[][] scores = new double[yearCount][totalScoreCount];
        //生成成绩
        for (int i = 0; i < yearCount; i++) {
            for (int j = 0; j < totalScoreCount; j++) {
                scores[i][j] = 80 + Math.random() * 20;
                System.out.println("第" + (i + 1) + "年" + names[j] + "成绩为" + scores[i][j]);
            }
        }

        boolean cont = true;
        while (cont) {
            System.out.println("请输入要进行的操作编号");
            System.out.println("1.求某年的最好成绩\n" +
                    "2.求某年的平均成绩\n" +
                    "3.求所有年份最好成绩\n" +
                    "4.求某门课理念最好成绩");

            int oprtId = scanner.nextInt();

            int year;
            switch (oprtId) {
                case 1:
                    System.out.println("请输入要求哪一年的最好成绩");
                    year = scanner.nextInt() - 1;
                    if (year < 0 || year >= yearCount) {
                        System.out.println("非法年份");
                        break;
                    }
                    int bestOfYearScoreId = 0;
                    for (int i = 1; i < totalScoreCount; i++) {
                        if (scores[year][bestOfYearScoreId] < scores[year][i]) bestOfYearScoreId = i;
                    }
                    System.out.println("第" + (year + 1) + "年的最好成绩为" + names[bestOfYearScoreId] + "：" + scores[year][bestOfYearScoreId]);
                    break;
                case 2:
                    System.out.println("请输入要求哪一年的平均成绩");
                    year = scanner.nextInt() - 1;
                    if (year < 0 || year >= yearCount) {
                        System.out.println("非法年份");
                        break;
                    }
                    double totalScore = 0;
                    for (int i = 0; i < totalScoreCount; i++) {
                        totalScore += scores[year][i];
                    }
                    System.out.println("第" + (year + 1) + "年的平均成绩为：" + (totalScore / totalScoreCount));
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
                    System.out.println("历年最好成绩为第" + (year + 1) + "年" + names[bestOfYearsScoreId] + ":" + scores[year][bestOfYearsScoreId]);
                    break;
                case 4:
                    System.out.println("请问要查询哪门课的历年最好成绩：1.语文、2.数学、3.外语、4.物理、5.化学、6.生物");
                    int scoreId = scanner.nextInt()-1;
                    year = 0;
                    for (int i = 1; i < yearCount; i++) {
                        if (scores[year][scoreId] < scores[i][scoreId]) year = i;
                    }
                    System.out.println(names[scoreId] + "历年最好成绩为第" + (year + 1) + "年，成绩为：" + scores[year][scoreId]);
                    break;
                default:
                    System.out.println("程序结束。");
                    cont = false;
            }
        }
    }
}
