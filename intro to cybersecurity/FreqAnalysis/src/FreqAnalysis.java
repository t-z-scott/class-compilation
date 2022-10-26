import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class FreqAnalysis {
    private final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z'};
    private HashMap<Character, Integer> frequency = new HashMap<>();
    private int[] freqs = new int[alphabet.length];
    private String text;
    private String inputFile;
    private boolean foundFreq = false;
    
    public static void main(String[] args) throws FileNotFoundException {
    	String plainTextFile = "src/plaintext1.txt";
		FreqAnalysis plainText = new FreqAnalysis(plainTextFile);
		String readFile = "";
		readFile = plainText.readFile(plainTextFile);
		plainText.decrypt(readFile, findKey(readFile));
		plainText.writeToFile("src/plaintext1.txt");
    }

    FreqAnalysis(String inputFileName) {
        this.inputFile = inputFileName;
    }
    
    // convert ciphertext to plaintext by finding the shift
    public String decrypt(String cipher, int key) {
    	cipher = cipher.toLowerCase();
    	FreqAnalysis fq = new FreqAnalysis(cipher);
    	String plain = "";
    	for (int i = 0; i < cipher.length(); i++) {
    		if (cipher.charAt(i) == ' ') {
    			plain += ' ';
    			break;
    		}
    		int charPos = fq.alphabet[i];
    		int keyVal = (charPos - (key-2)) % 26;
    		if (keyVal < 0) {
    			keyVal += 26;
    		}
    		char replaceVal = fq.alphabet[keyVal];
    		plain += replaceVal;
    	}
    	return plain;
    }

    public void findFrequency() {
        if (this.inputFile != null) {
            for (int i = 0; i < text.length(); i++) {
                char character = text.charAt(i);

                // if the character is in the alphabet
                if ((int) character >= 97 && (int) character <= 122) {
                    if (frequency.containsKey(character)) {
                        // add one to the current key
                        frequency.put(character, frequency.get(character) + 1);
                    }
                    else {
                        frequency.put(character, 1);
                    }
                }
            }
            foundFreq = true;
        }
    }

    public static int findKey(String txt) {
        int key = 0;
        int highestFreq = 0;
        int highestFreqIndex = -1;
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) >= 'a' && txt.charAt(i) <= 'z') {
                int count = (new FreqAnalysis(txt)).freqs[txt.charAt(i) - 'a']++;

                if (count > highestFreq) {
                    highestFreq = count;
                    highestFreqIndex = i;
                }
            }
        }
        key = highestFreqIndex - ('e' - 'a');
        return key;
    }
    
    public void printFindFrequency(PrintWriter write) {
    	// for each letter in the alphabet, print its occurrence and freq.
        for (int i = 0; i < alphabet.length; i++) {
            char letter = alphabet[i];
            int occurrences = 0;
            if (frequency.containsKey(letter)) {
                occurrences = frequency.get(letter);
            }
            write.printf("%c: %-6d %n", letter, occurrences);
            System.out.printf("%c: %-6d %n", letter, occurrences);
        }
    }
    
    public String readFile(String filename) throws FileNotFoundException {
        String returnString = "";
        File in = new File(filename);
        Scanner scanFile = new Scanner(in);
        while (scanFile.hasNext()) {
            returnString += scanFile.nextLine();
        }
        this.text = returnString;
        scanFile.close();
        return returnString;
    }
    

    public void writeToFile(String filename) throws FileNotFoundException {
        PrintWriter write = new PrintWriter(filename);
        write.println(inputFile);
        System.out.println(inputFile);

        if (foundFreq) {
        	printFindFrequency(write);
        }
        write.close();
    }
}
