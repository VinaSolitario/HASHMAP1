import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BookReport {
    public static void main(String[] args) {
        // Create a HashMap to store author's name and bio
        HashMap<String, String> authorMap = new HashMap<>();

        // Read Author.csv and populate the authorMap
        try (BufferedReader authorReader = new BufferedReader(new FileReader("/workspaces/HASHMAP1/Author.csv"))) {
            String line;
            while ((line = authorReader.readLine()) != null) {
                String[] parts = line.split(",");
                authorMap.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read Book.csv and display the report
        try (BufferedReader bookReader = new BufferedReader(new FileReader("/workspaces/HASHMAP1/Book.csv"))) {
            String line;
            while ((line = bookReader.readLine()) != null) {
                String[] parts = line.split(",");
                String isbn = parts[0];
                String title = parts[1];
                String authorName = parts[2];

                // Retrieve author's bio from authorMap
                String authorBio = authorMap.get(authorName);

                // Display the report
                System.out.println(isbn + " " + title);
                System.out.println("\t" + authorName + " - " + authorBio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
