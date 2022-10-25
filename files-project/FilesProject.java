package nash.programs;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class FilesProject {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
    	System.out.print("Enter your file name: ");
        String fileName = scan.nextLine();
        System.out.print("Enter your file size: ");
        int size = scan.nextInt();
        scan.close();
        populateFile(fileName, size);
        System.out.printf("\nFile: %s \t Mean: %.2f \tMax: %d\n", fileName, getMean(fileName), getMax(fileName));
    }
    
    public static int getMax(String fileName) throws FileNotFoundException {
    	int max = 0, next;
    	Scanner in = new Scanner(new File(fileName));
    	
    	while (in.hasNextInt()) {
    		next = in.nextInt();
    		if (next > max) max = next;
    	}
    	
    	in.close();
    	return (max);
    }
    
    public static double getMean(String fileName) throws FileNotFoundException {
    	double sum = 0, count = 0;
    	Scanner in = new Scanner(new File(fileName));
    	
    	while (in.hasNextInt()) {
    		sum += in.nextInt();
    		count++;
    	}
    	
    	in.close();
    	if (0 == count) return (sum);
        else return (sum / count);
    }
    
    public static void populateFile(String fileName, int size) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        Random rand = new Random();
        
        for (int i = 0; i < size; i++)
            out.printf("%d\n", rand.nextInt(1001)+1000);
      
        out.close();
    }
}
