import java.util.Scanner;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private double wallet = 0.0;

    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Product> purchasedItems = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public User(String username, String password, String emailAddress, String phoneNumber, String address)
    {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void clearShoppingCart() {
        this.shoppingCart.clear();
    }

    public ArrayList<Product> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems() {
        this.purchasedItems.addAll(getShoppingCart());
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "User {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", wallet=" + wallet +
                " }";
    }

    public void addToShoppingCart(Seller seller, String productName, int numberOfProduct)
    {
        if (seller.doesProductExist(productName))
        {
            if (seller.quantityOfProduct(productName) >= numberOfProduct )
            {
                Product addingProduct = seller.searchProduct(productName);
                addingProduct.setQuantity(numberOfProduct);
                shoppingCart.add(addingProduct);
                System.out.println(productName + " added to the shopping cart!");
            }
            else
            {
                System.out.println("We do not have that number of product!");
            }
        }
        else
        {
            System.out.println("This product does not exist!");
        }
    }

    public void removeFromShoppingCart(String productName)
    {
        for (int i=0; i<shoppingCart.size(); i++)
        {
            if (productName.equals(shoppingCart.get(i).getName()))
            {
                shoppingCart.remove(i);
                return;
            }
        }
    }

    public void updateTheShoppingCart(Seller seller, String productName, int newNumber)
    {
        if (seller.quantityOfProduct(productName) >= newNumber)
        {
            for (int i=0; i<shoppingCart.size(); i++)
            {
                if (productName.equals(shoppingCart.get(i).getName()))
                {
                    shoppingCart.get(i).setQuantity(newNumber);
                    return;
                }
            }
        }
        else
        {
            System.out.println("We do not have that number of product!");
        }
    }

    public void endOfShopping(Shop shop)
    {
        User u = new User(getUsername(), getPassword(), getEmailAddress(), getPhoneNumber(), getAddress());
        Order newOrder = new Order(u);
        if (calculatingTheTotalPriceOfShoppingcart() != 0)
        {
            orders.add(newOrder);
            shop.addOrder(newOrder);
            System.out.println("This is your order ID : " + newOrder.getOrderID());
        }
        else
        {
            System.out.println("There is nothing in your shopping cart so you can not sumbit your order!");
        }
    }

    public double calculatingTheTotalPriceOfShoppingcart()
    {
        double totalPrice = 0.0;
        for (int i=0; i<shoppingCart.size(); i++)
        {
            totalPrice += shoppingCart.get(i).getPrice() * shoppingCart.get(i).getQuantity();
        }
        return totalPrice;
    }

    public void addOrder(Order order)
    {
        orders.add(order);
    }
    public void removeOrder(String orderID)
    {
        for (int i=0; i<orders.size(); i++)
        {
            if (orderID.equals(orders.get(i).getOrderID()))
            {
                orders.remove(i);
            }
        }
    }

    public void checkOrderStatus(String orderID)
    {
        for (int i=0; i<orders.size(); i++)
        {
            if (orderID.equals(orders.get(i).getOrderID()))
            {
                System.out.println(orders.get(i).getStatus());
            }
        }
    }

    public boolean doesOrderExist(String orderID)
    {
        boolean existance = false;
        for (int i=0; i<orders.size(); i++)
        {
            if (orderID.equals(orders.get(i).getOrderID()))
            {
                existance = true;
            }
        }
        return existance;
    }

    public void requestForAddingFundToWallet(Admin admin, double fund)
    {
        Request req = new Request(getUsername(), fund);
        admin.addRequest(req);
    }

    public boolean doesProductExist(String productName)
    {
        boolean existance = false;
        for (int i=0; i<shoppingCart.size(); i++)
        {
            if (productName.equals(shoppingCart.get(i).getName()))
            {
                existance = true;
            }
        }
        return existance;
    }
}
