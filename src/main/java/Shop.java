import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private String name;
    private String webAddress;
    private String phoneNumber;
    private double profit = 0.0;

    // ArrayLists
    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Seller> sellers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public Shop(String name, String webAddress, String phoneNumber)
    {
        this.name = name;
        this.webAddress = webAddress;
        this.phoneNumber = phoneNumber;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    // Predefinded Admin
    Admin predefinedAdmin = new Admin("master", "1111", "");
    public void addingPredefinedAdmin()
    {
        predefinedAdmin.setIsMaster(true);
        admins.add(predefinedAdmin);
    }

    public boolean doesAdminExist(Admin admin)
    {
        boolean existance = false;
        for (int i=0; i<admins.size(); i++)
        {
            if (admin.getUsername().equals(admins.get(i).getUsername()))
            {
                existance = true;
                break;
            }
        }
        return existance;
    }
    public void addAdmin(Admin admin)
    {
        if (doesAdminExist(admin))
        {
            System.out.println("This admin has already existed");
        }
        else
        {
            admins.add(admin);
        }
    }
    public void removeAdmin(Admin admin)
    {
        if (doesAdminExist(admin))
        {
            for (int i=0; i<admins.size(); i++)
            {
                if (admin.getUsername().equals(admins.get(i).getUsername()))
                {
                    admins.remove(i);
                }
            }
        }
        else
        {
            System.out.println("This admin does not exist");
        }
    }

    public Admin searchAdmin (String username)
    {
        for (int i=0; i<admins.size(); i++)
        {
            if (username.equals(admins.get(i).getUsername()))
            {
                return admins.get(i);
            }
        }
        return null;
    }

    public boolean doesUserExist(User user)
    {
        boolean existance = false;
        for (int i=0; i<users.size(); i++)
        {
            if (user.getUsername().equals(users.get(i).getUsername()))
            {
                existance = true;
                break;
            }
        }
        return existance;
    }
    public void addUser(User user)
    {
        if (doesUserExist(user))
        {
            System.out.println("This user has already existed");
        }
        else
        {
            users.add(user);
        }
    }
    public void removeUser(User user)
    {
        if (doesUserExist(user))
        {
            for (int i=0; i< users.size(); i++)
            {
                if (user.getUsername().equals(users.get(i).getUsername()))
                {
                    users.remove(i);
                }
            }
        }
        else
        {
            System.out.println("This user does not exist");
        }
    }

    public User searchUser(String username)
    {
        for (int i=0; i<users.size(); i++)
        {
            if (username.equals(users.get(i).getUsername()))
            {
                return users.get(i);
            }
        }
        return null;
    }

    public boolean doesSellerExist(Seller seller)
    {
        boolean existance = false;
        for (int i=0; i<sellers.size(); i++)
        {
            if (seller.getCompanyName().equals(sellers.get(i).getCompanyName()))
            {
                existance = true;
                break;
            }
        }
        return existance;
    }
    public void addSeller(Seller seller)
    {
        if (doesSellerExist(seller))
        {
            System.out.println("This seller has already existed");
        }
        else
        {
            sellers.add(seller);
        }
    }
    public void removeSeller(Seller seller)
    {
        if (doesSellerExist(seller))
        {
            for (int i=0; i<sellers.size(); i++)
            {
                if (seller.getCompanyName().equals(sellers.get(i).getCompanyName()))
                {
                    sellers.remove(i);
                }
            }
        }
        else
        {
            System.out.println("This seller does not exist");
        }
    }

    public Seller searchSeller(String companyName)
    {
        for (int i=0; i<sellers.size(); i++)
        {
            if (companyName.equals(sellers.get(i).getCompanyName()))
            {
                return sellers.get(i);
            }
        }
        return null;
    }

    public boolean doesOrderExist(String orderID)
    {
        boolean existance = false;
        for (int i=0; i< orders.size(); i++)
        {
            if (orderID.equals(orders.get(i).getOrderID()))
            {
                existance = true;
            }
        }
        return existance;
    }
    public void addOrder(Order order)
    {
        orders.add(order);
    }

    public Order searchOrder(String orderID)
    {
        for (int i=0; i<orders.size(); i++)
        {
            if (orderID.equals(orders.get(i).getOrderID()))
            {
                return orders.get(i);
            }
        }
        return null;
    }
    public void removeOrder(String orderID)
    {
        for (int i=0; i< orders.size(); i++)
        {
            if (orderID.equals(orders.get(i).getOrderID()))
            {
                orders.remove(i);
            }
        }
    }

    public void createAccountAdmin()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your username");
        System.out.println("Username : ");
        String username = in.nextLine();
        System.out.println("Enter your password");
        System.out.println("Password : ");
        String password = in.nextLine();
        System.out.println("Enter your email address");
        System.out.println("Email Address : ");
        String emailAddress = in.nextLine();
        Admin createAccount = new Admin(username, password, emailAddress);
        if (doesAdminExist(createAccount))
        {
            System.out.println("This username has been taken!");
        }
        else
        {
            addAdmin(createAccount);
            System.out.println("Account created");
        }
    }
    public boolean logInAdmin(String username, String password)
    {
        boolean check = false;
        Admin logIn = new Admin(username, password, "");
        if (doesAdminExist(logIn))
        {
            for (int i=0; i<admins.size(); i++)
            {
                if (username.equals(admins.get(i).getUsername()))
                {
                    if (password.equals(admins.get(i).getPassword()))
                    {
                        System.out.println("Welcome");
                        check = true;
                        break;
                    }
                    else
                    {
                        System.out.println("Wrong password");
                        check =  false;
                        break;
                    }
                }
            }
        }
        else
        {
            System.out.println("This admin does not exist!");
            check =  false;
        }
        return check;
    }

    public boolean createAccountUser()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your username");
        System.out.println("Username : ");
        String username = in.nextLine();
        System.out.println("Enter your password");
        System.out.println("Password : ");
        String password = in.nextLine();
        System.out.println("Enter your email address");
        System.out.println("Email Address : ");
        String emailAddress = in.nextLine();
        System.out.println("Enter your phone number");
        System.out.println("Phone Number : ");
        String phoneNumber = in.nextLine();
        System.out.println("Enter your address");
        System.out.println("Address : ");
        String address = in.nextLine();
        User createAccount = new User(username, password, emailAddress, phoneNumber, address);
        if (doesUserExist(createAccount))
        {
            System.out.println("This username has been taken!");
            return false;
        }
        else
        {
            addUser(createAccount);
            System.out.println("Account created");
            return true;
        }
    }
    public boolean logInUser(String username, String password)
    {
        boolean check = false;
        User logIn = new User(username, password, "", "", "");
        if (doesUserExist(logIn))
        {
            for (int i=0; i<users.size(); i++)
            {
                if (username.equals(users.get(i).getUsername()))
                {
                    if (password.equals(users.get(i).getPassword()))
                    {
                        System.out.println("Welcome");
                        check = true;
                        break;
                    }
                    else
                    {
                        System.out.println("Wrong password");
                        check =  false;
                        break;
                    }
                }
            }
        }
        else
        {
            System.out.println("This user does not exist!");
            check =  false;
        }
        return check;
    }

    public boolean createAccountSeller()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your company's name");
        System.out.println("Company's Name : ");
        String companyName = in.nextLine();
        System.out.println("Enter your password");
        System.out.println("Password : ");
        String password = in.nextLine();
        Seller createAccount = new Seller(companyName, password);
        if (doesSellerExist(createAccount))
        {
            System.out.println("You have already created an account!");
            return false;
        }
        else
        {
            addSeller(createAccount);
            System.out.println("Account created");
            return true;
        }
    }
    public boolean logInSeller(String companyName, String password)
    {
        boolean check = false;
        Seller logIn = new Seller(companyName, password);
        if (doesSellerExist(logIn))
        {
            for (int i=0; i<sellers.size(); i++)
            {
                if (companyName.equals(sellers.get(i).getCompanyName()))
                {
                    if (password.equals(sellers.get(i).getPassword()))
                    {
                        System.out.println("Welcome");
                        check = true;
                        break;
                    }
                    else
                    {
                        System.out.println("Wrong password");
                        check =  false;
                        break;
                    }
                }
            }
        }
        else
        {
            System.out.println("This seller does not exist!");
            check =  false;
        }
        return check;
    }

    public void logOutAdmin(Admin admin)
    {
        removeAdmin(admin);
        addAdmin(admin);
    }

    public void logOutUser(User user)
    {
        removeUser(user);
        addUser(user);
    }

    public void logOutSeller(Seller seller)
    {
        removeSeller(seller);
        addSeller(seller);
    }

}
