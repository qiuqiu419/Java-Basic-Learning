package guessNumber;

/**
 * guessNumber������
 * guessNumber()            ��ʼ��
 * guessNumber(int,int,int) ���س�ʼ��
 * guess.describe()         ��Ϸ����
 * guess.buildNum()         ���ɲ�������Ϸ�������
 * guess.NotGameOver()      �жϱ�����Ϸ�Ƿ����
 * guess.judgeNum(int)      �ж��������������Ƿ���ͬ
 */
public class guessNumber {

    private int rangeStart;//��ʼ����
    private int rangeEnd;//��ֹ����
    private int totalGuessNum;//һ����Ϸ����
    private int totalGameGuess;//����Ϸ����
    private int totalCorrectNum;//����Ϸʤ������
    private int randomNum;//�����
    private int guessLeft;//ʣ������ִ���
    private boolean guessNumCorrect;//�Ƿ�¶����ֱ�ǩ

    /**
     * ��ʼ�������ֳ���
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
     * ��ʼ�������ֳ���
     *
     * @param startNum ��ʼλ��
     * @param endNum   ��ֹλ��
     * @param guessNum �����ִ���
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
     * ��Ϸ����
     */
    public void describe() {
        System.out.println("=====================��������Ϸ========================");
        System.out.println("Ŀ�����Ѿ����ɣ�������" + rangeStart + "��" + rangeEnd + "֮�䣨������������" + totalGuessNum +
                "�β²�Ļ��ᡣ����-1��ʱ������Ϸ");
        System.out.println("����Ϸ����" + totalGameGuess + "\t�¶����ִ���" + totalCorrectNum);
    }

    /**
     * ���ɲ����ֵ������
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
     * �ж���Ϸ�Ƿ����
     *
     * @return ����Ϊfalse������Ϊtrue
     */
    public boolean NotGameOver() {
        if (guessLeft > 0 && !guessNumCorrect) {
            System.out.println("����" + guessLeft + "�λ��ᣬ������²�����֣��س�ȷ��");
            return true;
        } else if (guessLeft > 0 && guessNumCorrect) {
            System.out.println("��ϲ��ɱ���������Ϸ");
            return false;
        } else {
            System.out.println("����Ϸ���ǣ�"+randomNum);
            return false;
        }
    }

    /**
     * �ж�����������ȷ���
     *
     * @param input ��������
     * @return input��randomNum��ͬΪtrue����֮Ϊfalse��
     */
    public boolean judgeNum(int input) {
        guessLeft--;
        if (input < randomNum) {
            System.out.println("�������ֱ�Ŀ������С");
            return false;
        } else if (input > randomNum) {
            System.out.println("�������ֱ�Ŀ�����ִ�");
            return false;
        } else {
            totalCorrectNum++;
            System.out.println("����������ȷ");
            guessNumCorrect = true;
            return true;
        }
    }
}
