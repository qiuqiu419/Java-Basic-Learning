import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {

        Scanner unSortString = new Scanner(System.in);

        System.out.println("冒泡排序，请输入字符串");
        String stringList = unSortString.next();//读取字符串
        char[] bubbleSortChar = stringList.toCharArray();//将字符串转化成数组

        boolean changeFlag = false;//检测排序是否结束
        //冒泡排序
        for (int i = 0; i < bubbleSortChar.length; i++) {
            for (int j = 0; j < bubbleSortChar.length - i - 1; j++) {
                if (bubbleSortChar[j] < bubbleSortChar[j + 1]) {
                    char exchange = bubbleSortChar[j];
                    bubbleSortChar[j] = bubbleSortChar[j + 1];
                    bubbleSortChar[j + 1] = exchange;
                    changeFlag = true;
                }
            }
            //检测序列是否已完成排序
            if (!changeFlag) {
                break;
            } else {
                changeFlag = false;
            }
        }//冒泡结束

        stringList = String.valueOf(bubbleSortChar);//数组转换成字符串
        System.out.println("有序字符串：" + stringList);//输出字符串结果

        //生成ASCII码数组
        StringBuilder AscArray = new StringBuilder();
        for (int i = 0; i < bubbleSortChar.length; i++) {
            AscArray.append((int) bubbleSortChar[i]);
            if (i!=bubbleSortChar.length-1) AscArray.append(",");
        }
        System.out.println("ASCII码:["+AscArray+"]");//输出ASCII结果
    }
}
