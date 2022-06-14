package guessNumber;

/**
 * guessNumber类申明
 * guessNumber()            初始化
 * guessNumber(int,int,int) 重载初始化
 * guess.describe()         游戏描述
 * guess.buildNum()         生成猜数字游戏的随机数
 * guess.NotGameOver()      判断本轮游戏是否结束
 * guess.judgeNum(int)      判断输入数字与结果是否相同
 */
public class guessNumber {

    private int rangeStart;//起始数字
    private int rangeEnd;//终止数字
    private int totalGuessNum;//一轮游戏次数
    private int totalGameGuess;//总游戏次数
    private int totalCorrectNum;//总游戏胜利次数
    private int randomNum;//随机数
    private int guessLeft;//剩余猜数字次数
    private boolean guessNumCorrect;//是否猜对数字标签

    /**
     * 初始化猜数字程序
     */
    public guessNumber() {
        rangeStart = 20;
        rangeEnd = 60;
        totalGuessNum = 5;
        totalGameGuess = 0;
        totalCorrectNum = 0;
        guessNumCorrect = false;
    }

    /**
     * 初始化猜数字程序
     *
     * @param startNum 起始位置
     * @param endNum   终止位置
     * @param guessNum 猜数字次数
     */
    public guessNumber(int startNum, int endNum, int guessNum) {
        rangeStart = startNum;
        rangeEnd = endNum;
        totalGuessNum = guessNum;
        totalGameGuess = 0;
        totalCorrectNum = 0;
        guessNumCorrect = false;
    }

    /**
     * 游戏介绍
     */
    public void describe() {
        System.out.println("=====================猜数字游戏========================");
        System.out.println("目标数已经生成，数字在" + rangeStart + "到" + rangeEnd + "之间（开集），共有" + totalGuessNum +
                "次猜测的机会。输入-1随时结束游戏");
        System.out.println("总游戏次数" + totalGameGuess + "\t猜对数字次数" + totalCorrectNum);
    }

    /**
     * 生成猜数字的随机数
     */
    public void buildNum() {
        guessLeft = totalGuessNum;
        guessNumCorrect = false;
        int mod = rangeEnd - rangeStart;
        double midNum = Math.random() * rangeEnd * 100;
        randomNum = (int) midNum % mod;
        randomNum += rangeStart;
        totalGameGuess++;
    }

    /**
     * 判断游戏是否结束
     *
     * @return 结束为false；继续为true
     */
    public boolean NotGameOver() {
        if (guessLeft > 0 && !guessNumCorrect) {
            System.out.println("还有" + guessLeft + "次机会，请输入猜测的数字，回车确认");
            return true;
        } else if (guessLeft > 0 && guessNumCorrect) {
            System.out.println("恭喜完成本轮数字游戏");
            return false;
        } else {
            System.out.println("猜游戏答案是："+randomNum);
            return false;
        }
    }

    /**
     * 判断输入数字正确与否
     *
     * @param input 输入数字
     * @return input与randomNum相同为true；否之为false；
     */
    public boolean judgeNum(int input) {
        guessLeft--;
        if (input < randomNum) {
            System.out.println("输入数字比目标数字小");
            return false;
        } else if (input > randomNum) {
            System.out.println("输入数字比目标数字大");
            return false;
        } else {
            totalCorrectNum++;
            System.out.println("输入数字正确");
            guessNumCorrect = true;
            return true;
        }
    }
}
