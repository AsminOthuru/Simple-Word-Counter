package AsminDsaProject;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SimpleWordCounterApplication implements SimpleWordCounter {
    Map<String, Integer> wordFrequency = new HashMap<>();
    Map<Character, Integer> characterFrequency = new HashMap<>();
    private boolean IsFileReadable(String path) {
        File file = new File(path);
        if (file.canRead()) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void countCharacters(String path){
        File inputFile = new File(path);
        if (!inputFile.exists() && IsFileReadable(path)) {
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile);
                int characterCount = 0;
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    characterCount += line.length();
                }
                System.out.println("Total Number of characters in the file: " + characterCount);
                scan.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        }
    }
    @Override
    public void characterFrequency(String path){
        File inputFile = new File(path);
        if (!inputFile.exists()) {
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile);
                while (scan.hasNext()) {
                    String line = scan.nextLine();
                    for (char character : line.toCharArray()) {
                        if (Character.isLetter(character)) {
                            if (characterFrequency.containsKey(character)) {
                                int count = characterFrequency.get(character);
                                characterFrequency.put(character, count + 1);
                            } else {
                                characterFrequency.put(character, 1);
                            }
                        }
                    }
                }
                scan.close();
                System.out.println("--------------------------------------------------------");
                System.out.println("              Character Frequencies");
                System.out.println("--------------------------------------------------------");
                for (Map.Entry<Character, Integer> entry : characterFrequency.entrySet()) {
                    System.out.println("'" + entry.getKey() + "': " + entry.getValue() + " times");
                }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        }
    }
    @Override
    public void countWords(String path) {
        File inputFile = new File(path);
        if (!inputFile.exists()) {
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile);
                int totalWords = 0;
                while (scan.hasNext()) {
                    scan.next();
                    totalWords++;
                }
                System.out.println("Total Number of words in the file: " + totalWords);
                scan.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        }
    }
    public void wordFrequency(String path){
        File inputFile = new File(path);
        if (!inputFile.exists()) {
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile);
                while (scan.hasNext()) {
                    String word = scan.next();
                    if (wordFrequency.containsKey(word)) {
                        int count = wordFrequency.get(word);
                        wordFrequency.put(word, count + 1);
                    } else {
                        wordFrequency.put(word, 1);
                    }
                }
                scan.close();
                System.out.println("--------------------------------------------------------");
                System.out.println("           Word Frequencies in the File ");
                System.out.println("--------------------------------------------------------");

                for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
                }
                String mostFrequentWord = null;
                int highestFrequency = 0;
                for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                    int frequency = entry.getValue();
                    if (frequency > highestFrequency) {
                        highestFrequency = frequency;
                        mostFrequentWord = entry.getKey();
                    }
                }
                if (mostFrequentWord != null) {
                    System.out.println("The word with the highest frequency is: " + mostFrequentWord + " (Frequency: " + highestFrequency + " times)");
                }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        }
    }
    @Override
    public void countLines(String path) {
        File inputFile = new File(path);
        if (!inputFile.exists()) {
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile);
                int totalLines = 0;
                while (scan.hasNext()) {
                    totalLines++;
                    scan.nextLine();
                }
                System.out.println("Total Number of Lines in the file: " + totalLines);
                scan.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void printContent(String path) {
        File inputFile = new File(path);
        if (!inputFile.exists()) {
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile);
                System.out.println("The Content in the File is : ");
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    System.out.println(line);
                }
                scan.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        }

    }
}