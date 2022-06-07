public class MultiTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; ++i) {
            StringBuffer line = new StringBuffer(" ");
            for (int j = 1; j <= 9; ++j) {
                if (i >= j) {
                    line.append(i).append("*").append(j).append("=").append(i * j).append("\t");
                }
            }
            System.out.println(line);
        }
    }
}
