package technicalTask;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String matrixString;
        while (true) {
            matrixString = scanner.nextLine();
            if (Math.sqrt(matrixString.length()) % 1 == 0) {
                break;
            }
            System.out.println("Invalid length of matrix");
        }
        String word = scanner.nextLine();

        System.out.println(new Solution().getResult(matrixString, word));
    }
}
