import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        //创造输入
        Scanner in = new Scanner(System.in);

        //游戏参数设置
        int rangeStart = 20;
        int rangeEnd = 80;
        int guessTotal = 5;

        //游戏统计
        int totalGameCount = 0;
        int totalCorrectCount = 0;

        //判断游戏是否结束
        boolean stopGame = false;

        while (!stopGame) {
            //初始化游戏变量
            int guessLeft = guessTotal;
            int mod = rangeEnd - rangeStart;
            double randNum = Math.random() * rangeEnd * 100;
            int num = (int) randNum % mod;
            num += rangeStart;

            System.out.println("=====================猜数字游戏========================");
            System.out.println("目标数已经生成，数字在" + rangeStart + "到" + rangeEnd + "之间（开集），共有" + guessTotal +
                    "次猜测的机会。输入-1随时结束游戏");
            System.out.println("总游戏次数" + totalGameCount + "\t猜对数字次数" + totalCorrectCount);

            //本次是否猜中游戏
            boolean guessNumCorrect = false;
            boolean currentGameCounted = false;
            while (guessLeft > 0) {
                System.out.println("还有" + guessLeft + "次机会，请输入猜测的数字，回车确认");
                int guessNum = in.nextInt();
                if (guessNum < 0) {
                    stopGame = true;
                    System.out.println("用户选择结束游戏");
                    break;
                }//停止游戏
                if (!currentGameCounted) {
                    totalGameCount++;
                    currentGameCounted = true;
                }//计总游戏次数
                guessLeft--;
                if (guessNum < num) {
                    System.out.println("输入数字比目标数字小");
                } else if (guessNum > num) {
                    System.out.println("输入数字比目标数字大");
                } else {
                    totalCorrectCount++;
                    guessNumCorrect = true;
                    System.out.println("输入数字正确");
                    break;
                }
            }
            if (!guessNumCorrect) System.out.println("猜游戏答案是：" + num);
        }
    }
}
