package fileoperation;

import java.io.File;
import java.io.IOException;


public class fileMain {
    public static void main(String[] args) throws IOException {
        File targetFile= Myfile.createFile();
        Myfile.writeToFile(targetFile);
        System.out.println("输入完成");

        System.out.println("读出数据");
        Myfile.readFromFile(targetFile);
    }
}
