package paneracheese;
import java.util.*;

class OrderList {
    Queue<Order> ord = new LinkedList<>();

    public void addOrder() {
        System.out.println("Enter order description:");
        Scanner in = new Scanner(System.in);
        String or = in.nextLine();
        System.out.println("Enter customer name:");
        String name = in.nextLine();
        
        ord.add(new Order(name, or));
    }
    
    public void cancelOrder() {
	Scanner in = new Scanner(System.in).useDelimiter("\\n");
	System.out.println("Enter customer name:");
	String name = in.next();
	if (ord.removeIf((Order r) -> r.getName().equalsIgnoreCase(name)))
            System.out.println(name + "'s order has been removed");
	else
            System.out.println("No " + name + " in our system");
}

    public void listOrders() {
        if (ord.isEmpty()) {
            System.out.println("No pending orders");
            
        }
        else {
            System.out.printf("Name\tOrder\tTime\n");
            System.out.printf("--------------------------------\n");
            for (Order o : ord) {
                System.out.println(o.toString());
            }
        }
    }
    
    public void serveNextOrder() {
        System.out.print("Now serving ... ");
        System.out.println(ord.poll().toString());
    }
}
