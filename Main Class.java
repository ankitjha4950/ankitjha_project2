package MySecondProject;

public class Main Class {
    
}
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        OrderManager orderManager = new OrderManager(inventory);

        // Add some sample products to inventory
        inventory.addProduct(new Product(1, "Laptop", 1200.99, 5));
        inventory.addProduct(new Product(2, "Smartphone", 799.49, 10));
        inventory.addProduct(new Product(3, "Headphones", 199.99, 15));

        Scanner scanner = new Scanner(System.in);

        // Add a sample customer
        Customer customer = new Customer(1, "John Doe", "john.doe@example.com", "123 Main St");

        while (true) {
            System.out.println("\n--- E-Commerce Order Management ---");
            System.out.println("1. View Products");
            System.out.println("2. Place an Order");
            System.out.println("3. View Orders");
            System.out.println("4. Update Order Status");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inventory.displayProducts();
                    break;
                case 2:
                    System.out.println("Enter Product IDs to order (comma separated): ");
                    scanner.nextLine();
                    String[] productIdsStr = scanner.nextLine().split(",");
                    ArrayList<Integer> productIds = new ArrayList<>();
                    for (String productId : productIdsStr) {
                        productIds.add(Integer.parseInt(productId.trim()));
                    }
                    orderManager.createOrder(customer, productIds);
                    break;
                case 3:
                    orderManager.viewOrders();
                    break;
                case 4:
                    System.out.println("Enter Order ID to update: ");
                    int orderId = scanner.nextInt();
                    System.out.println("Enter new status (Pending, Shipped, Delivered, Cancelled): ");
                    scanner.nextLine();
                    String status = scanner.nextLine();
                    orderManager.updateOrderStatus(orderId, status);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
