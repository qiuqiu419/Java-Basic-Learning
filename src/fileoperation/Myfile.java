package fileoperation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Myfile {
    private static final Scanner in = new Scanner(System.in);
    private static String SOURCE_FILE_NAME = null;
//    public static void main(String[] args) throws IOException {
//        File targetFile = createFile();
//        writeToFile(targetFile);
//        System.out.println("�������");
//
//        System.out.println("��������");
//        readFromFile(targetFile);
//
//
//    }
    /**
     * �����ļ�
     * @return
     * @throws IOException
     */
    public static File createFile() throws IOException {
        System.out.println("�������ļ�����");
        SOURCE_FILE_NAME = in.nextLine().trim();
        File f = new File("." + File.separator + SOURCE_FILE_NAME + ".txt");
        if (f.isFile()) {
            System.out.println("Ŀ���ļ����ڣ�ɾ����" + f.delete());
        }
        System.out.println(f.createNewFile());
        return f;
    }

    /**
     * д������
     * @param targetFile
     * @throws IOException
     */
    public static void writeToFile(File targetFile) throws IOException {
        // TODO try with resource�������Ǹ㶨close
        try (
                // TODO ����һ��outputstream��Ӧ����outputstream��лл@���� ׽סbugһ����������һ�����ļ��������byte���ݴ�����
                FileOutputStream fos = new FileOutputStream(targetFile);
                // TODO ����һ����������inputstream��Ӧ����outputstream��лл@���� ׽סbugһ������writer����ָ���ַ����������Ϳ���һ������д���ַ���
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                // TODO ʹ��PrintWriter�����Է����д��һ���ַ�
                PrintWriter pw = new PrintWriter(osw);
        ) {
            // TODO �²�System.out�Ǹ�ɶ��
            System.out.println("��������ݻ�ʵʱд���ļ������������������");
            while (true) {
                String lineToWrite = in.nextLine().trim();
                System.out.println("��������Ϊ" + lineToWrite);
                if (lineToWrite.trim().isBlank()) {
                    System.out.println("�������");
                    break;
                } else {
                    pw.println(lineToWrite);
                    pw.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ��������
     * @param sourceFile
     */
    public static void readFromFile(File sourceFile) {
        System.out.println("---------�����ı�-------------");

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr);
        ) {
            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
