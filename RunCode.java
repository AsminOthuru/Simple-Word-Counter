package AsminDsaProject;
import java.util.Scanner;


public class RunCode {
    public static void main(String[] args) {
        SimpleWordCounterApplication analyzer = new SimpleWordCounterApplication();
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("                  Simple Word Counter                   ");
            System.out.println("--------------------------------------------------------");
            System.out.println("1. Count Characters");
            System.out.println("2. Character Frequency");
            System.out.println("3. Count Words");
            System.out.println("4. Word Frequency");
            System.out.println("5. Count Lines");
            System.out.println("6. Print Content");
            System.out.println("7. Exit");
            System.out.println("--------------------------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the file path: ");
                    String filePath = inputScanner.nextLine();
                    analyzer.countCharacters(filePath);
                    break;
                case 2:
                    System.out.print("Enter the file path: ");
                    filePath = inputScanner.nextLine();
                    analyzer.characterFrequency(filePath);
                    break;
                case 3:
                    System.out.print("Enter the file path: ");
                    filePath = inputScanner.nextLine();
                    analyzer.countWords(filePath);
                    break;
                case 4:
                    System.out.print("Enter the file path: ");
                    filePath = inputScanner.nextLine();
                    analyzer.wordFrequency(filePath);
                    break;
                case 5:
                    System.out.print("Enter the file path: ");
                    filePath = inputScanner.nextLine();
                    analyzer.countLines(filePath);
                    break;
                case 6:
                    System.out.print("Enter the file path: ");
                    filePath = inputScanner.nextLine();
                    analyzer.printContent(filePath);
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    inputScanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}