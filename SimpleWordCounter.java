package AsminDsaProject; // Package declaration

public interface SimpleWordCounter { // Declaring an interface for simple word counting functionalities

    // Method declarations for counting characters, word frequencies, and other operations in a file

    void countCharacters(String path); // Method to count characters in a file
    void characterFrequency(String path); // Method to determine character frequency in a file
    void countWords(String path); // Method to count the total number of words in a file
    void wordFrequency(String path); // Method to determine word frequency in a file
    void countLines(String path); // Method to count the total number of lines in a file
    void printContent(String path); // Method to print the content of a file
}
