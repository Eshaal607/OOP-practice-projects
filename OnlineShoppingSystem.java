import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product{
    public String id;
    public String brand;
    public double price;

    public Product(String id, String brand,double price){
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public String toString(){
        return "ID: " + id + " BRAND: " + brand + " PRICE: " + price;
    }

}

class Shoes extends Product{
    public int size;

    public Shoes(String id,String brand,double price,int size){
        super(id,brand,price);
        this.size = size;
    }

    public String toString(){
        return super.toString() + "SIZE: " + size;
    }
}

class Clothes extends Product{
    public String material;

    public Clothes(String id,String brand,double price,String material){
        super(id,brand,price);
        this.material = material;
    }

    public String toString(){
        return super.toString() + "MATERIAL: " + material;
    }

}

public class CartItem {
    Product product;
    public int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

}


class Order{
    String orderId;
    String customerId;
    List<CartItem> items;
    double totalAmount;
    int count=1;

    public Order(String orderId,String customerId){
        this.orderId = orderId;
        this.customerId = customerId;
    }

    List<CartItem> items = new ArrayList<>();

    // Method to add items
    public void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        items.add(item);
    }

    // Optional: View all items
    public void displayCart() {
        for (CartItem item : items) {
            System.out.println(item.product.getName() + " - " + item.quantity);
        }
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
         total += item.product.getPrice() * item.quantity;
        }
        return total;
    } 
    
    public void run(){
         
        for(int i = 1 ; i <= quantity ; i++){
       try{
           Thread.sleep(100);
           System.out.println("Adding item......[items added: "+ count +"]");
           count++;
       }
       catch(InterruptedException e){
           System.out.println(e);
       }
        }
    }
}


public class OnlineShoppingSystem {
     public static void main(String[] args) {
        // Create products (Shoes and Clothes)
        Product shoe = new Shoes("S123", "Nike", 120.0, 42);
        Product shirt = new Clothes("C456", "Adidas", 45.0, 32);

        // Create an order
        Order order = new Order("O789", "Customer01");

        // Add items to the order
        order.addItem(shoe, 2);  // 2 shoes
        order.addItem(shirt, 3);

        Scanner src = new Scanner(System.in);
          
        while(true){
        System.out.println("\n=== Online Shopping System ===");
            System.out.println("1. Add item to cart");
            System.out.println("2. Display Cart");
            System.out.println("3. Total Bill");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = src.nextInt();

            switch(choice){
                case 1: 
                order.addItem(shirt, choice);
                order.start();
                break;

                case 2:
                order.displayCart();
                break;

                case 3:
                order.totalAmount();

                case 4:
                System.out.println("Exiting......");
                src.close();
                        return;
                        
                default:
                        System.out.println("Invalid option!");
            }
        }
     }            
}
