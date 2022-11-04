import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trie {

	class Node {
		char leadChar;		// empty for root
		boolean isWord;		// does current node represent a whole word or not?
		Node rightSibling, firstChild;
		
		public Node(char c) {
			leadChar = c;
			isWord = false;
			rightSibling = firstChild = null;
		}
	}
	static Node root;
	static int count;
	
	public static void main(String[] args) throws FileNotFoundException {
		Trie t = new Trie();
		root = t.new Node('\0');
		File word = new File("WORD.LST");
		Scanner sc = new Scanner(word);
		while (sc.hasNext()) {
			String line = sc.next();
			if (line.length() == 5) {
				t.insert(root, line);
			}
		}
		sc.close();
		
		File in = new File("inputFile.txt");
		sc = new Scanner(in);
		String str = sc.nextLine();
		sc.close();
		String strs[] = str.split(" ");
		t.query(root, strs[0], strs[1]);
		System.out.println(count);
	}

	public Node findChild (Node p, char c) {
		if (p == null) {
			return null;
		}
		Node q = p.firstChild;
		while (q != null && q.leadChar != c) {
			q = q.rightSibling;
		}
		return q;
	}
	
	public void insert (Node p, String s) {
		if (root.isWord == true) return;
		if (s.length() == 0) {
			p.isWord = true;
			return;
		}
		char c = s.charAt(0);
		String ss = s.substring(1, s.length());
		Node q = findChild(p, c);
		if (q == null) {
			Node r = new Node(c);
			r.rightSibling = p.firstChild;		// insert as leftmost child
			p.firstChild = r;
			insert(r, ss);
		}
		else {
			insert(q, ss);
		}
	}
	
	public void preorderMatch (Node p, String prefix, String forbidden) {
		if (p == null) {
			return;
		}
		if (p.isWord) {
			count++;
		}
		prefix += p.leadChar;
		Node q = p.firstChild;
		while (q != null) {
			if (forbidden.indexOf(q.leadChar) == -1) {
				preorderMatch(q, prefix + q.leadChar, forbidden);
			}
			q = q.rightSibling;
		}
	}
	
	public void query (Node p, String qprefix, String forbidden) {
		Node q = search(p, qprefix);
		preorderMatch(q, qprefix, forbidden);
	}
	
	public Node search (Node p, String qprefix) {
		if (qprefix.length() == 0) {
			return p;
		}
		Node q = findChild(p, qprefix.charAt(0));
		if (q == null) {
			return null;
		}
		return search(q, qprefix.substring(1, qprefix.length()));
	}
}
