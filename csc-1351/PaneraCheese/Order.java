package paneracheese;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Order {

    private String name;
    private String food;
    private LocalDateTime time;

    public Order (String name, String food) {
        this.name = name;
        this.food = food;
        this.time = java.time.LocalDateTime.now();
    }
    
    public String getName() { return name; }
    
    public String getOrder() { return food; }
    
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("%-10s%-10s%-10s", name, food, time.format(dtf));
    }
}
