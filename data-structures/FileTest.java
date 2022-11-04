import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTest {

	public static void main(String[] args) throws FileNotFoundException {
		File in = new File("inputFile.txt");
		Scanner sc = new Scanner(in);
		String str = sc.nextLine();
		sc.close();
		String strs[] = str.split(" ");
		System.out.printf("prefix: %s\nforbidden: %s", strs[0], strs[1]);
	}

}
