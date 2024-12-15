public class OrderClass {
    
}
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> productList;
    private String orderStatus;

    public Order(int orderId, Customer customer, List<Product> productList) {
        this.orderId = orderId;
        this.customer = customer;
        this.productList = productList;
        this.orderStatus = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customer.getName() + ", Total: $" + calculateTotal() + ", Status: " + orderStatus;
    }
}
