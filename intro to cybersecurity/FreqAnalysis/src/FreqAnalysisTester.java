import java.io.FileNotFoundException;

public class FreqAnalysisTester {

	public static void main(String[] args) throws FileNotFoundException {
        String plainTextFile = "src/plaintext.txt";
		FreqAnalysis plainText = new FreqAnalysis(plainTextFile);
		plainText.readFile(plainTextFile);
		plainText.findFrequency();
		plainText.writeToFile("src/plaintextfreq.txt");
		
		System.out.println("==================================");
		
		String cipherTextFile = "src/cipherText.txt";
		FreqAnalysis cipherText = new FreqAnalysis(cipherTextFile);
		cipherText.readFile(cipherTextFile);
		cipherText.findFrequency();
		cipherText.writeToFile("src/ciphertextfreq.txt");
    }
}
