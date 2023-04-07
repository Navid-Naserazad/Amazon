import javax.swing.*;
import java.util.ArrayList;

public class Seller {
    private String companyName;
    private String password;
    private double wallet = 0.0;

    ArrayList<Product> availableProducts = new ArrayList<>();

    public Seller(String companyName, String password)
    {
        this.companyName = companyName;
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "companyName='" + companyName + '\'' +
                ", password='" + password + '\'' +
                ", wallet=" + wallet +
                ", availableProducts=" + availableProducts +
                '}';
    }

    public boolean doesProductExist(String productName)
    {
        boolean existance = false;
        for (int i=0; i<availableProducts.size(); i++)
        {
            if (productName.equals(availableProducts.get(i).getName()))
            {
                existance = true;
                break;
            }
        }
        return existance;
    }
    public void addProduct(Product product)
    {
        if (doesProductExist(product.getName()))
        {
            for (int i=0; i<availableProducts.size(); i++)
            {
                if (product.getName().equals(availableProducts.get(i).getName()))
                {
                    availableProducts.get(i).setQuantity(availableProducts.get(i).getQuantity() + product.getQuantity());
                    break;
                }
            }
        }
        else
        {
            availableProducts.add(product);
        }
    }
    public void removeProduct(Product product)
    {
        if (doesProductExist(product.getName()))
        {
            availableProducts.remove(product);
        }
        else
        {
            System.out.println("This product does not exist");
        }
    }

    public int quantityOfProduct(String productName)
    {
        int quantity = 0;
        for (int i=0; i<availableProducts.size(); i++)
        {
            if (productName.equals(availableProducts.get(i).getName()))
            {
                quantity = availableProducts.get(i).getQuantity();
                break;
            }
        }
        return quantity;
    }

    public Product searchProduct(String productName)
    {
        Product resultOfSearch = null;
        for (int i=0; i<availableProducts.size(); i++)
        {
            if (productName.equals(availableProducts.get(i).getName()))
            {
                resultOfSearch = availableProducts.get(i);
                break;
            }
        }
        return resultOfSearch;
    }

}