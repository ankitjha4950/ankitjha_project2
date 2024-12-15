public class OrderManager Class {
    
}
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();
    private Inventory inventory;

    public OrderManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public void createOrder(Customer customer, List<Integer> productIds) {
        List<Product> products = new ArrayList<>();
        for (int productId : productIds) {
            Product product = inventory.getProduct(productId);
            if (product != null && product.getQuantity() > 0) {
                products.add(product);
                inventory.updateStock(productId, product.getQuantity() - 1); // Reduce stock
            } else {
                System.out.println("Product ID: " + productId + " is out of stock.");
            }
        }
        if (!products.isEmpty()) {
            Order order = new Order(orders.size() + 1, customer, products);
            orders.add(order);
            System.out.println("Order created successfully! Order ID: " + order.getOrderId());
        } else {
            System.out.println("Order creation failed. No products added.");
        }
    }

    public void viewOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void updateOrderStatus(int orderId, String status) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.setOrderStatus(status);
                System.out.println("Order ID: " + orderId + " status updated to: " + status);
                return;
            }
        }
        System.out.println("Order ID: " + orderId + " not found.");
    }
}
