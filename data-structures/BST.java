import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BST {

	class Node {
		int key, data, mindata;
		Node left, right, parent;
		
		public Node(int data) {
			key = data;
			left = right = null;
		}
	}
	
	// BST root node
	Node root;
	
	public BST() {
		root = null;
	}

	public static void main(String[] args) throws FileNotFoundException {
		/*String line = "";*/
		BST tree = new BST();
		Node n = null;
		File input = new File("inputFile2.txt");
		Scanner sc = new Scanner(input);
		int lines = sc.nextInt();
		for (int i = 0; i < lines - 1; i++) {
			n = tree.insert(tree.root, sc.nextInt());
			n.data = sc.nextInt();
		}
		//finish main
		sc.close();
	}

	public Node insert(Node root, int key) {
		if (root == null) {	// tree is empty
			root = new Node(key);
			root.mindata = root.data;
			return root;
		}
		// traverse the tree
		if (key < root.key) {
			if (root.left == null) {
				root.left = new Node(key);
				return root.left;
			}
			root.mindata = Math.min(root.mindata, key);
			root.left = insert(root.left, key);
		}
		else if (key > root.key) {
			if (root.right == null) {
				root.right = new Node(key);
				return root.right;
			}
			root.mindata = Math.min(root.mindata, key);
			root.right = insert(root.right, key);
		}
		return root;	//return pointer
	}
	
	public void RangeReport(Node x, int k1, int k2) {
		if (x == null) return;
		int min = 50;
		if (x.key < k1) {
			if (x.key < min) min = x.key;
			RangeReport(x.left, k1, k2);
		}
		if (x.key >= k1 && x.key <= k2) {
			min = x.key;
			System.out.println(x);
		}
		if (x.key > k2) {
			if (x.key < min) min = x.key;
			RangeReport(x.right, k1, k2);
		}
	}
	
	public int RangeMin(int k1, int k2, Node r) {
		int min = 0;
		root = r;
		while ( !((k1 <= root.key) && (root.key <= k2)) ) {
			if (k1 < root.key && k2 < root.key) root = root.left;
			else root = root.right;
		}
		// now we are at a node root from where k1 and k2 fall in different subtrees
		min = root.data;
		RangeMinRight(k1, root.left);
		RangeMinLeft(k2, root.right);
		return min;
	}
	
	public int RangeMinLeft(int k2, Node r) {
		int min = 0;
		if (k2 < r.key) {
			min = Math.min(r.data, r.left.mindata);
			RangeMinLeft(k2, r.right);
		}
		else if (k2 > r.key) RangeMinLeft(k2, r.left);
		else min = Math.min(r.data, r.left.mindata);
		return min;
	}
	
	public int RangeMinRight(int k1, Node r) {
		int min = 0;
		if (k1 < r.key) {
			min = Math.min(r.data, r.right.mindata);
			RangeMinRight(k1, r.left);
		}
		else if (k1 > r.key) RangeMinRight(k1, r.right);
		else min = Math.min(r.data, r.right.mindata);
		return min;
	}
	
	public void setMindata(Node r) {
		if (r != null) r.mindata = r.data;
		if (r.left != null) r.mindata = Math.min(r.mindata, r.left.mindata);
		if (r.right != null) r.mindata = Math.min(r.mindata, r.right.mindata);
	}
}
