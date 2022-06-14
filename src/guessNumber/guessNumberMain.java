package guessNumber;

import java.util.Scanner;

public class guessNumberMain {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        guessNumber guess=new guessNumber();//生成guessNumber类

        boolean stopGameFlag = false;//判断玩家是否退出游戏

        while (!stopGameFlag) {

            guess.describe();//游戏互动界面
            guess.buildNum();//初始化猜数字随机数

            while(guess.NotGameOver()){
                int num=input.nextInt();
                if(num<0){
                    //todo 玩家退出游戏
                    stopGameFlag=true;
                    break;
                }else{
                guess.judgeNum(num);//判断输入数字大小
                }
            }
        }// todo 猜数字结束
        System.out.println("猜数字游戏结束");
    }
}
