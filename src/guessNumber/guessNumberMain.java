package guessNumber;

import java.util.Scanner;

public class guessNumberMain {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        guessNumber guess=new guessNumber();//����guessNumber��

        boolean stopGameFlag = false;//�ж�����Ƿ��˳���Ϸ

        while (!stopGameFlag) {

            guess.describe();//��Ϸ��������
            guess.buildNum();//��ʼ�������������

            while(guess.NotGameOver()){
                int num=input.nextInt();
                if(num<0){
                    //todo ����˳���Ϸ
                    stopGameFlag=true;
                    break;
                }else{
                guess.judgeNum(num);//�ж��������ִ�С
                }
            }
        }// todo �����ֽ���
        System.out.println("��������Ϸ����");
    }
}
