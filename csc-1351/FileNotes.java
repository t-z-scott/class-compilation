import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileNotes {
    private ArrayList<Book> books = new ArrayList<>();
    private String name;

    public static void main(String[] args) throws FileNotFoundException {
        FileNotes libraries = new FileNotes("LSU Library");
        libraries.loadBooks();
    }

    public FileNotes(String library_Name) {
        name = library_Name;
    }

    public void loadBooks() throws FileNotFoundException {
        File inFile = new File("books.txt");
        Scanner in = new Scanner(inFile);

        String line;
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] fields = line.split(";");

            books.add(new Book(fields[0], fields[1], Integer.parseInt(fields[2].trim()),
                    Integer.parseInt(fields[3].trim())));
        }

        in.close();
    }

    // encapulation - grouping things that i need
}
