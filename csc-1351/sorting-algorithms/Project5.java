package project5;

public class Project5 {

    public static void main(String[] args) {
        System.out.println("x\tfib(x)\tRecursive(ns)\tIterative(ns) ");
        System.out.println("===============================================");
        int num = 10;
        long fib = Utilities.iterativeFib(num);
        for (int i = 0; i < 5; i++) {
            System.out.printf("%d\t%d\t\t%d\t\t%d\n", num, fib, measureRecTime(num), measureItTime(num));
            num += 10;
            fib = Utilities.iterativeFib(num);
        }
        System.out.println("===============================================");
    }
    
    private static long measureRecTime(int x) {
        long start = System.nanoTime();
        Utilities.recursiveFib(x);
        return (System.nanoTime() - start);
    }
    
    private static long measureItTime(int x) {
        long start = System.nanoTime();
        Utilities.iterativeFib(x);
        return (System.nanoTime() - start);
    }
}
