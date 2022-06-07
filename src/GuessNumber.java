import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        //��������
        Scanner in = new Scanner(System.in);

        //��Ϸ��������
        int rangeStart = 20;
        int rangeEnd = 80;
        int guessTotal = 5;

        //��Ϸͳ��
        int totalGameCount = 0;
        int totalCorrectCount = 0;

        //�ж���Ϸ�Ƿ����
        boolean stopGame = false;

        while (!stopGame) {
            //��ʼ����Ϸ����
            int guessLeft = guessTotal;
            int mod = rangeEnd - rangeStart;
            double randNum = Math.random() * rangeEnd * 100;
            int num = (int) randNum % mod;
            num += rangeStart;

            System.out.println("=====================��������Ϸ========================");
            System.out.println("Ŀ�����Ѿ����ɣ�������" + rangeStart + "��" + rangeEnd + "֮�䣨������������" + guessTotal +
                    "�β²�Ļ��ᡣ����-1��ʱ������Ϸ");
            System.out.println("����Ϸ����" + totalGameCount + "\t�¶����ִ���" + totalCorrectCount);

            //�����Ƿ������Ϸ
            boolean guessNumCorrect = false;
            boolean currentGameCounted = false;
            while (guessLeft > 0) {
                System.out.println("����" + guessLeft + "�λ��ᣬ������²�����֣��س�ȷ��");
                int guessNum = in.nextInt();
                if (guessNum < 0) {
                    stopGame = true;
                    System.out.println("�û�ѡ�������Ϸ");
                    break;
                }//ֹͣ��Ϸ
                if (!currentGameCounted) {
                    totalGameCount++;
                    currentGameCounted = true;
                }//������Ϸ����
                guessLeft--;
                if (guessNum < num) {
                    System.out.println("�������ֱ�Ŀ������С");
                } else if (guessNum > num) {
                    System.out.println("�������ֱ�Ŀ�����ִ�");
                } else {
                    totalCorrectCount++;
                    guessNumCorrect = true;
                    System.out.println("����������ȷ");
                    break;
                }
            }
            if (!guessNumCorrect) System.out.println("����Ϸ���ǣ�" + num);
        }
    }
}
