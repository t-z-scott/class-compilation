import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Heap {
    private int heap[];
    private int heapSize; // current heap size

    public Heap(int arraySize) {
        heap = new int[arraySize];
        heapSize = 0;
    }

    public static void main(String args[]) throws FileNotFoundException {

        int instr = 0, i = 0; // num of instructions
        String line; // current line read in file

        File inputFile = new File("inputFile3.txt");
        Scanner scan = new Scanner(inputFile);
        instr = Integer.parseInt(scan.nextLine());
        Heap h = new Heap(100);
        
        while (scan.hasNextLine() && i < instr) {
            line = scan.nextLine();
            if ('I' == line.charAt(0))
            	h.insert(Integer.parseInt(line.substring(3)));
            if ('D' == line.charAt(0))
            	h.decreaseKey(line.charAt(3), line.charAt(5));
            if ('E' == line.charAt(0)) {
            	if (i == instr - 1) {
            		System.out.print(h.extractMin() + "\n");
            	}
            	else h.extractMin();
            }
            i++;
        }
        scan.close();        
    }

    public void decreaseKey(int index, int newElement) {
    	int[] newHeap = new int[heapSize];
    	for (int i = 0; i < heapSize - 1; i++) {
    		if (i == index) newHeap[i] = newElement;
    		else newHeap[i] = heap[i];
    	}
    	floatUp(newHeap, index, heapSize - 1);
    	heap = newHeap;
    }

    public int extractMin() {
        int minChild = 0, root = 0, bottom = heapSize - 1, j = 0;
        minChild = findMin(heap, root, bottom);
        
        heapSize--;
        int[] newHeap = new int[heapSize];
        for (int i = 0; i < heapSize + 1; i++) {
        	if (i != minChild) newHeap[j++] = heap[i];
        }
        
        sinkDown(newHeap, minChild, heapSize - 1);
        heap = Arrays.copyOf(newHeap, newHeap.length);
        return minChild;
    }
    
    public int findMin(int[] arr, int root, int bottom) {
    	int minChild = root;
    	for (int i = root; i < bottom; i++) {
    		if (arr[i] < arr[minChild])
    			minChild = i;
    	}
        return minChild;
    }
    
    public void floatUp(int[] arr, int root, int bottom) {
    	//opposite of sinkDown
    	int maxChild, otherChild;
        //the block below finds the maximum child
      maxChild = root * 2 + 3;
      if (maxChild > bottom) return;
      if (maxChild < bottom) {
        otherChild = maxChild - 1;
        maxChild = (arr[otherChild] > arr[maxChild]) ? otherChild:maxChild;
      }
      if(arr[root] <= arr[maxChild]) return; /*done - go no further*/
      swap(arr[root], arr[maxChild]);
      floatUp(arr, maxChild, bottom);
    }

    public void insert(int element) {
    	heapSize++;
        int[] newHeap = Arrays.copyOf(heap, heapSize);
        newHeap[heapSize - 1] = element;
        floatUp(newHeap, 0, heapSize - 1);
        heap = newHeap;
    }

    // heapify(u) in lectures
    public void sinkDown(int[] arr, int root, int bottom) {
        int minChild = findMin(arr, root, bottom);
        
        if (arr[root] <= arr[minChild])
            return;
        swap(arr[root], arr[minChild]);
        sinkDown(arr, minChild, bottom);
    }

    public void swap(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
    
    public String toString(int[] a) {
    	String arr = "[";
    	for (int i = 0; i < a.length; i++)
    		arr += a[i] + " ";
    	return arr.trim() + "]";
    }
}
