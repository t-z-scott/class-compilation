import java.util.Random;
import java.util.Scanner;

public class Algorithm()
{

    public static void main(String[] args) {
       System.out.println("Enter array size: ");
       Scanner in = new Scanner(System.in);
       int size = in.nextInt();
       in.close();
       int[] array = new int[size];
       populateArray(array);
       
       // start here
       printArray(array);
       SelectionSort(array);
       printArray(array);
    }

    public static void BubbleSort(int[] arr) {  // time complexity = O(n^2)
        for (int i = 0; i < arr.length-1; i++)  // (n-1)(n) / 2
	            for (int j = 0; j < arr.length-1; j++)
	                if (arr[j] > arr[j+1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
    }

    public static void BubbleSortShortCircuit(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
    }

    public static void InsertionSort(int[] arr) {
        int i, key, j;
        for (i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i-1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    private static void merge(int[] arr, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[i]) {
                arr[k] = l[i];
                i++;
            } else {
                arr[k] = r[i];
                j++;
            }
            k++;
        }

        while (i < left)
            arr[k++] = l[i++];

        while (i < right)
            arr[k++] = r[j++];
    }

    public static void MergeSort(int[] arr) { // time complex = n log(n)
        if (arr.length < 2)
            return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        for (int i = mid; i < arr.length; i++)
            right[i - mid] = arr[i];

        MergeSort(left);
        MergeSort(right);

        merge(arr, left, right, mid, arr.length - mid);
    }

    public static void populateArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(1001);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (i == arr.length-1) System.out.print(arr[i]);
            else System.out.print(arr[i] + ", ");
        System.out.println();
    }

    public static void SelectionSort(int[] arr) { // time complexity = O(n^2)
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = 1;
            for (int j = i+1; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}