import java.util.ArrayList;
public class Admin {
    private String username;
    private String password;
    private String emailAddress;
    private boolean isMaster = false;

    // Requsets
    ArrayList<Request> requestsForAddingFund = new ArrayList<>();

    public Admin(String username, String password, String emailAddress)
    {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
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

    public boolean getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(boolean isMaster) {
        this.isMaster = isMaster;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<Request> getRequestsForAddingFund() {
        return requestsForAddingFund;
    }

    public void setRequestsForAddingFund(ArrayList<Request> requestsForAddingFund) {
        this.requestsForAddingFund = requestsForAddingFund;
    }

    @Override
    public String toString() {
        return "Admin {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                " }";
    }

    public boolean doesRequestExist(String username)
    {
        boolean existance = false;
        for (int i=0; i<requestsForAddingFund.size(); i++)
        {
            if (username.equals(requestsForAddingFund.get(i).getUsername()))
            {
                existance = true;
                break;
            }
        }
        return existance;
    }

    public void addRequest(Request request)
    {
        requestsForAddingFund.add(request);
    }

    public void addFundToUserWallet(Shop shop, String username)
    {
        for (int i=0; i<requestsForAddingFund.size(); i++)
        {
            if (username.equals(requestsForAddingFund.get(i).getUsername()))
            {
                User updatedUser = shop.searchUser(username);
                shop.removeUser(updatedUser);
                updatedUser.setWallet(requestsForAddingFund.get(i).getFund() + updatedUser.getWallet());
                shop.addUser(updatedUser);
                requestsForAddingFund.remove(i);
            }
        }
    }

    public void orderConfirmation(Shop shop,Seller seller, String orderID)
    {
        Order updatedOrder = shop.searchOrder(orderID);

        if (updatedOrder.getTotalPrice() <= updatedOrder.getUser().getWallet())
        {
            // SHOP
            shop.removeOrder(updatedOrder.getOrderID());
            updatedOrder.confirmedStatus();
            shop.addOrder(updatedOrder);
            shop.setProfit(updatedOrder.getTotalPrice() * 0.1 + shop.getProfit());
            // USER
            User updatedUser = updatedOrder.getUser();
            updatedUser.setWallet(updatedUser.getWallet() - updatedOrder.getTotalPrice());
            updatedUser.setPurchasedItems();
            updatedUser.clearShoppingCart();
            updatedUser.removeOrder(updatedOrder.getOrderID());
            updatedUser.addOrder(updatedOrder);
            shop.removeUser(updatedUser);
            shop.addUser(updatedUser);
            // SELLER
            Seller updatedSeller = seller;
            updatedSeller.setWallet(updatedOrder.getTotalPrice() * 0.9 + seller.getWallet());
            for (int i=0; i<updatedOrder.getUserShoppingCart().size(); i++)
            {
                for (int j=0; j<updatedSeller.availableProducts.size(); j++)
                {
                    if (updatedOrder.getUserShoppingCart().get(i).getName().equals(updatedSeller.availableProducts.get(j).getName()))
                    {
                        updatedSeller.availableProducts.get(j).setQuantity(updatedSeller.availableProducts.get(j).getQuantity() - updatedOrder.getUserShoppingCart().get(i).getQuantity());
                        if (updatedSeller.availableProducts.get(j).getQuantity() == 0)
                        {
                            updatedSeller.availableProducts.remove(j);
                        }
                        break;
                    }
                }
            }
            shop.removeSeller(seller);
            shop.addSeller(updatedSeller);

        }
        else
        {
            // SHOP
            shop.removeOrder(updatedOrder.getOrderID());
            updatedOrder.canceledStatus();
            shop.addOrder(updatedOrder);
            // USER
            User updatedUser = updatedOrder.getUser();
            updatedUser.clearShoppingCart();


        }
    }
}