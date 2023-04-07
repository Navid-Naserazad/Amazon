import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;

public class Order {
    private User user;
    private String orderID;
    private String date;
    private String status = "Pending";
    private double totalPrice;
    private ArrayList<Product> userShoppingCart;

    public Order(User user)
    {
        this.user = user;
        this.orderID = UUID.randomUUID().toString();
        this.date = java.time.LocalDate.now().toString();
        this.totalPrice = user.calculatingTheTotalPriceOfShoppingcart();
        this.userShoppingCart = user.getShoppingCart();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getStatus() {
        return status;
    }

    public void confirmedStatus() {
        this.status = "Confirmd";
    }

    public void canceledStatus() { this.status = "Canceled";}

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(User user) {
        this.totalPrice = user.calculatingTheTotalPriceOfShoppingcart();
    }

    public ArrayList<Product> getUserShoppingCart() {
        return userShoppingCart;
    }

    public void setUserShoppingCart(User user) {
        this.userShoppingCart = user.getShoppingCart();
    }
}