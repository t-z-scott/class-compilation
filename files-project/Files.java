package nash.programs;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Files {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("output.txt");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i <= 5; i++) {
            System.out.print("Please enter a name: ");
            String name = in.nextLine();
            out.println(name);
        }
        out.close();
        
        File input = new File("output2.txt");
        Scanner scan = new Scanner(input);
        while (scan.hasNextLine()) {
            String name = scan.nextLine();
            System.out.println(name);
        }
        scan.close();
    }
    
}



