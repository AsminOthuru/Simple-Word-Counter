package AsminDsaProject; // Package declaration

import java.io.FileNotFoundException; // Importing necessary packages
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleWordCounterApplication implements SimpleWordCounter { // Class declaration implementing an interface

    Map<String, Integer> wordFrequency = new HashMap<>(); // Initialization of a map to store word frequencies
    Map<Character, Integer> characterFrequency = new HashMap<>(); // Initialization of a map to store character frequencies

    // Method to check if the file is readable at the given path
    private boolean IsFileReadable(String path) {
        File file = new File(path); // Creating a File object based on the path provided
        if (file.canRead()) { // Checking if the file is readable
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void countCharacters(String path) { // Method to count characters in a file
        File inputFile = new File(path); // Creating a File object based on the path provided
        if (!inputFile.exists() && IsFileReadable(path)) { // Checking if the file exists and is readable
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile); // Creating a Scanner object to read from the file
                int characterCount = 0; // Initializing a counter for characters
                while (scan.hasNextLine()) { // Looping through each line in the file
                    String line = scan.nextLine(); // Reading the next line
                    characterCount += line.length(); // Adding the length of the line to the character count
                }
                System.out.println("Total Number of characters in the file: " + characterCount); // Printing the total number of characters
                scan.close(); // Closing the scanner
            } catch (FileNotFoundException e) { // Handling file not found exception
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace(); // Printing the stack trace for the exception
            }
        }
    }

    @Override
    public void characterFrequency(String path) { // Method to calculate character frequencies
        File inputFile = new File(path); // Creating a File object based on the path provided
        if (!inputFile.exists()) { // Checking if the file exists
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile); // Creating a Scanner object to read from the file
                while (scan.hasNext()) { // Looping through the file
                    String line = scan.nextLine(); // Reading the next line
                    for (char character : line.toCharArray()) { // Looping through each character in the line
                        if (Character.isLetter(character)) { // Checking if the character is a letter
                            if (characterFrequency.containsKey(character)) { // Checking if the character already exists in the map
                                int count = characterFrequency.get(character); // Getting the count of the character
                                characterFrequency.put(character, count + 1); // Incrementing the count
                            } else {
                                characterFrequency.put(character, 1); // Adding the character to the map with count 1
                            }
                        }
                    }
                }
                scan.close(); // Closing the scanner
                System.out.println("--------------------------------------------------------");
                System.out.println("              Character Frequencies");
                System.out.println("--------------------------------------------------------");
                for (Map.Entry<Character, Integer> entry : characterFrequency.entrySet()) { // Looping through the character frequencies map
                    System.out.println("'" + entry.getKey() + "': " + entry.getValue() + " times"); // Printing character frequency
                }
            } catch (FileNotFoundException e) { // Handling file not found exception
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace(); // Printing the stack trace for the exception
            }
        }
    }

    @Override
    public void countWords(String path) { // Method to count words in a file
        File inputFile = new File(path); // Creating a File object based on the path provided
        if (!inputFile.exists()) { // Checking if the file exists
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile); // Creating a Scanner object to read from the file
                int totalWords = 0; // Initializing a counter for words
                while (scan.hasNext()) { // Looping through each word in the file
                    scan.next(); // Reading the next word
                    totalWords++; // Incrementing the word count
                }
                System.out.println("Total Number of words in the file: " + totalWords); // Printing the total number of words
                scan.close(); // Closing the scanner
            } catch (FileNotFoundException e) { // Handling file not found exception
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace(); // Printing the stack trace for the exception
            }
        }
    }

    public void wordFrequency(String path) { // Method to calculate word frequencies
        File inputFile = new File(path); // Creating a File object based on the path provided
        if (!inputFile.exists()) { // Checking if the file exists
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile); // Creating a Scanner object to read from the file
                while (scan.hasNext()) { // Looping through the file
                    String word = scan.next(); // Reading the next word
                    if (wordFrequency.containsKey(word)) { // Checking if the word already exists in the map
                        int count = wordFrequency.get(word); // Getting the count of the word
                        wordFrequency.put(word, count + 1); // Incrementing the count
                    } else {
                        wordFrequency.put(word, 1); // Adding the word to the map with count 1
                    }
                }
                scan.close(); // Closing the scanner
                System.out.println("--------------------------------------------------------");
                System.out.println("           Word Frequencies in the File ");
                System.out.println("--------------------------------------------------------");

                for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) { // Looping through the word frequencies map
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " times"); // Printing word frequency
                }
                String mostFrequentWord = null;
                int highestFrequency = 0;
                for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) { // Looping through word frequencies to find the most frequent word
                    int frequency = entry.getValue(); // Getting the frequency of the word
                    if (frequency > highestFrequency) { // Checking if frequency is higher
                        highestFrequency = frequency; // Updating highest frequency
                        mostFrequentWord = entry.getKey(); // Updating most frequent word
                    }
                }
                if (mostFrequentWord != null) { // Checking if most frequent word exists
                    System.out.println("The word with the highest frequency is " + "'" + mostFrequentWord + "'" + " (Frequency: " + highestFrequency + " times)");
                }
            } catch (FileNotFoundException e) { // Handling file not found exception
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace(); // Printing the stack trace for the exception
            }
        }
    }

    @Override
    public void countLines(String path) { // Method to count lines in a file
        File inputFile = new File(path); // Creating a File object based on the path provided
        if (!inputFile.exists()) { // Checking if the file exists
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile); // Creating a Scanner object to read from the file
                int totalLines = 0; // Initializing a counter for lines
                while (scan.hasNext()) { // Looping through each line in the file
                    totalLines++; // Incrementing the line count
                    scan.nextLine(); // Moving to the next line
                }
                System.out.println("Total Number of Lines in the file: " + totalLines); // Printing the total number of lines
                scan.close(); // Closing the scanner
            } catch (FileNotFoundException e) { // Handling file not found exception
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace(); // Printing the stack trace for the exception
            }
        }
    }

    @Override
    public void printContent(String path) { // Method to print the content of the file
        File inputFile = new File(path); // Creating a File object based on the path provided
        if (!inputFile.exists()) { // Checking if the file exists
            System.out.println("File not found at the specified path.");
        } else {
            try {
                Scanner scan = new Scanner(inputFile); // Creating a Scanner object to read from the file
                System.out.println("The Content in the File is : ");
                while (scan.hasNextLine()) { // Looping through each line in the file
                    String line = scan.nextLine(); // Reading the next line
                    System.out.println(line); // Printing the line
                }
                scan.close(); // Closing the scanner
            } catch (FileNotFoundException e) { // Handling file not found exception
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace(); // Printing the stack trace for the exception
            }
        }

    }
}
