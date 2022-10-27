package paneracheese;
import java.util.*;

public class PaneraCheese {

    public static void main(String[] args) {
        
        OrderList myList = new OrderList(); 
        int choice; 
                 
        while (true) {
        
            System.out.printf("==============================\n");
            System.out.printf("Select one the following:\n\t1 - Place an order\n\t2 - Serve next order\n\t3 - List all orders\n\t4 - Cancel an order\n");
        
            Scanner in = new Scanner(System.in);
            choice = in.nextInt(); 
        
            switch (choice)
            {
                case 1:  {myList.addOrder(); break;} 
                case 3:  {myList.listOrders(); break;} 
                case 2:  {myList.serveNextOrder(); break;} 
                case 4:  {myList.cancelOrder(); break;} 
                default: {System.out.println("Invalid choice."); break;} 
            }
        }
    }
}




