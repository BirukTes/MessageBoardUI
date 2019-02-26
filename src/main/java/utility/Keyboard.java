package utility;

import java.util.Scanner;

public class Keyboard {
    private Scanner scanner;

    public Keyboard() {
        scanner = new Scanner(System.in);
    }

    public int nextInt() {
        String line = scanner.nextLine();
        int value = -1;
        try {
             value = Integer.parseInt(line.trim());
        }
        catch (NumberFormatException nbfe){
            System.out.println("Error, enter number(s) only.");
        }
        return value;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
