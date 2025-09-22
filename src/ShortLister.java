import javax.swing.*;
import java.io.*;
import java.util.*;

public class ShortLister {
    public static void main(String[] args) {
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a text file");
        
        // Show the file chooser dialog
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            // Create the filter
            ShortWordFilter filter = new ShortWordFilter();
            
            try {
                // Read the file and filter short words
                Scanner scanner = new Scanner(selectedFile);
                List<String> shortWords = new ArrayList<>();
                
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    // Remove punctuation for cleaner word checking
                    word = word.replaceAll("[^a-zA-Z]", "");
                    
                    if (!word.isEmpty() && filter.accept(word)) {
                        shortWords.add(word);
                    }
                }
                scanner.close();
                
                // Display the results
                System.out.println("Short words (length < 5) found in " + selectedFile.getName() + ":");
                System.out.println("=".repeat(50));
                
                if (shortWords.isEmpty()) {
                    System.out.println("No short words found.");
                } else {
                    for (String word : shortWords) {
                        System.out.println(word + " (length: " + word.length() + ")");
                    }
                    System.out.println("\nTotal short words found: " + shortWords.size());
                }
                
            } catch (FileNotFoundException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected. Exiting.");
        }
    }
}
