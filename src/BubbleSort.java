import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {

        Scanner unSortString = new Scanner(System.in);

        System.out.println("ð�������������ַ���");
        String stringList = unSortString.next();//��ȡ�ַ���
        char[] bubbleSortChar = stringList.toCharArray();//���ַ���ת��������

        boolean changeFlag = false;//��������Ƿ����
        //ð������
        for (int i = 0; i < bubbleSortChar.length; i++) {
            for (int j = 0; j < bubbleSortChar.length - i - 1; j++) {
                if (bubbleSortChar[j] < bubbleSortChar[j + 1]) {
                    char exchange = bubbleSortChar[j];
                    bubbleSortChar[j] = bubbleSortChar[j + 1];
                    bubbleSortChar[j + 1] = exchange;
                    changeFlag = true;
                }
            }
            //��������Ƿ����������
            if (!changeFlag) {
                break;
            } else {
                changeFlag = false;
            }
        }//ð�ݽ���

        stringList = String.valueOf(bubbleSortChar);//����ת�����ַ���
        System.out.println("�����ַ�����" + stringList);//����ַ������

        //����ASCII������
        StringBuilder AscArray = new StringBuilder();
        for (int i = 0; i < bubbleSortChar.length; i++) {
            AscArray.append((int) bubbleSortChar[i]);
            if (i!=bubbleSortChar.length-1) AscArray.append(",");
        }
        System.out.println("ASCII��:["+AscArray+"]");//���ASCII���
    }
}
