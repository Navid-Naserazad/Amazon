import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Shop shop = new Shop("Amazon", "amazon.com", "+989371844989");
        Admin admin = new Admin("", "", "");
        Seller seller = new Seller("", "");
        User user = new User("", "", "", "", "");
        runMenu(shop, admin, seller, user);

    }

    public static void runMenu(Shop shop, Admin admin, Seller seller , User user)
    {
        shop.addingPredefinedAdmin();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to THE AMAZON");
        System.out.println("1. Admin");
        System.out.println("2. Seller");
        System.out.println("3. User");
        System.out.println("4. Exit");
        System.out.println("Enter your command");
        System.out.println("Command : ");
        int command = Integer.parseInt(input.nextLine());
        System.out.println("Command : ");
        switch (command)
        {
            case 1 :
                adminLogInMenu(shop, admin, seller, user);
                break;
            case 2 :
                sellerLogInMenu(shop, admin, seller, user);
                break;
            case 3 :
                userLogInMenu(shop, admin, seller, user);
                break;
            case 4 :
                System.exit(0);
                break;
            default :
                System.out.println("Wrong command!");
                runMenu(shop, admin, seller, user);
        }
    }
    public static void adminLogInMenu(Shop shop, Admin admin, Seller seller , User user)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Sign in");
        System.out.println("2. Back");
        System.out.println("Enter your command");
        System.out.println("Command : ");
        int  command = Integer.parseInt(input.nextLine());
        if (command == 1)
        {
            input = new Scanner(System.in);
            System.out.println("Enter your username");
            System.out.println("Username : ");
            String adminUsername = input.nextLine();
            System.out.println("Enter your password");
            System.out.println("Password : ");
            String password = input.nextLine();
            if (shop.logInAdmin(adminUsername, password))
            {
                Admin logIn = shop.searchAdmin(adminUsername);
                adminMenu(shop, logIn, seller, user);
            }
            else
            {
                System.out.println("1. Sign in");
                System.out.println("2. Go back to main menu");
                System.out.println("Enter your command");
                System.out.println("Command : ");
                command = Integer.parseInt(input.nextLine());
                if (command == 1)
                {
                    adminLogInMenu(shop, admin, seller, user);
                }
                else
                {
                    runMenu(shop, admin, seller, user);
                }
            }
        }
        else
        {
            runMenu(shop, admin, seller, user);
        }

    }
    public static void sellerLogInMenu(Shop shop, Admin admin, Seller seller , User user)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Sign up");
        System.out.println("2. Sign in");
        System.out.println("3. Back");
        System.out.println("Enter your command");
        System.out.println("Command : ");
        int command = Integer.parseInt(input.nextLine());
        if (command == 1)
        {
            if (shop.createAccountSeller())
            {
                sellerLogInMenu(shop, admin, seller, user);
            }
            else
            {
                System.out.println("You have to log in!");
                sellerLogInMenu(shop, admin, seller, user);
            }
        }

        else if (command == 2)
        {

            System.out.println("Enter your company's name");
            System.out.println("Company's name : ");
            String companyName = input.nextLine();
            System.out.println("Enter your password");
            System.out.println("Your password : ");
            String password = input.nextLine();
            if (shop.logInSeller(companyName, password))
            {
                Seller logIn = shop.searchSeller(companyName);
                sellerMenu(shop, admin, logIn, user);
            }
            else
            {
                System.out.println("1. Sign in");
                System.out.println("2. Go back to main menu");
                System.out.println("Enter your command");
                System.out.println("Command :  ");
                command = Integer.parseInt(input.nextLine());
                if (command == 1)
                {
                    sellerLogInMenu(shop, admin, seller, user);
                }
                else
                {
                    runMenu(shop, admin, seller, user);
                }
            }

        }
        else
        {
            runMenu(shop, admin, seller, user);
        }
    }
    public static void userLogInMenu(Shop shop, Admin admin, Seller seller , User user)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Sign up");
        System.out.println("2. Sign in");
        System.out.println("3. Back");
        System.out.println("Enter your command");
        System.out.println("Command : ");
        int command = Integer.parseInt(input.nextLine());
        if (command == 1)
        {
            if (shop.createAccountUser())
            {
                userLogInMenu(shop, admin, seller, user);
            }
            else
            {
                System.out.println("you have to log in!");
                userLogInMenu(shop, admin, seller, user);
            }

        }
        else if (command == 2)
        {
            System.out.println("Enter your username");
            System.out.println("Username : ");
            String username = input.nextLine();
            System.out.println("Enter your password");
            System.out.println("Your password : ");
            String password = input.nextLine();
            if (shop.logInUser(username, password))
            {
                User logIn = shop.searchUser(username);
                userMenu(shop, admin, seller, logIn);
            }
            else
            {
                System.out.println("1. Sign in");
                System.out.println("2. Go back to main menu");
                System.out.println("Enter your command");
                System.out.println("Command : ");
                command = Integer.parseInt(input.nextLine());
                if (command == 1)
                {
                    userLogInMenu(shop, admin, seller, user);
                }
                else
                {
                    runMenu(shop, admin, seller, user);
                }
            }
        }
        else
        {
            runMenu(shop, admin, seller, user);
        }
    }
    public static void adminMenu(Shop shop, Admin admin, Seller seller , User user)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Add admin");
        System.out.println("2. Remove admin");
        System.out.println("3. View user's profile");
        System.out.println("4. Remove user");
        System.out.println("5. View seller's profile");
        System.out.println("6. Remove seller");
        System.out.println("7. View requests");
        System.out.println("8. Add fund to user's wallet");
        System.out.println("9. View orders");
        System.out.println("10. Check orders");
        System.out.println("11. Edit profile");
        System.out.println("12. View profile");
        System.out.println("13. Log out");
        System.out.println("Enter your command");
        System.out.println("Command : ");
        int command = Integer.parseInt(input.nextLine());
        if (command == 1)
        {
            shop.createAccountAdmin();
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 2)
        {
            // just master admin can do this!
            if (admin.getIsMaster())
            {
                System.out.println("Enter user's username");
                System.out.println("Username : ");
                String username = input.nextLine();
                Admin removedAdmin = shop.searchAdmin(username);
                if (removedAdmin != null)
                {
                    if (removedAdmin.getIsMaster())
                    {
                        System.out.println("The master admin can not be removed!");
                    }
                    else
                    {
                        shop.removeAdmin(removedAdmin);
                        System.out.println("This admin \'" + username + "\' is removed now!");
                    }
                }
                else
                {
                    System.out.println("There is no admin with this username!");
                    System.out.println("Try again!");
                }
            }
            else
            {
                System.out.println("This feature is only available for the master admin!");
            }
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 3)
        {
            System.out.println("Enter user's username");
            System.out.println("Username : ");
            String username = input.nextLine();
            User viewUser = shop.searchUser(username);
            if (viewUser != null)
            {
                System.out.println(shop.searchUser(username).toString());
            }
            else
            {
                System.out.println("There is no user with this username!");
                System.out.println("Try again!");
            }
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 4)
        {
            System.out.println("Enter user's username");
            System.out.println("Username : ");
            String username = input.nextLine();
            User removedUser = shop.searchUser(username);
            if (removedUser != null)
            {
                shop.removeUser(removedUser);
                System.out.println("This user \'" + username + "\' is removed now!");
            }
            else
            {
                System.out.println("There is no user with this username!");
                System.out.println("Try again!");
            }
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 5)
        {
            System.out.println("Enter seller's company name");
            System.out.println("Company name : ");
            String companyName = input.nextLine();
            Seller viewSeller = shop.searchSeller(companyName);
            if (viewSeller != null)
            {
                System.out.println(shop.searchSeller(companyName));
            }
            else
            {
                System.out.println("There is no seller with this company name!");
                System.out.println("Try again!");
            }
            adminMenu(shop, admin, seller, user);
        }
        if (command == 6)
        {
            System.out.println("Enter seller's company name");
            System.out.println("Company name : ");
            String companyName = input.nextLine();
            Seller removedSeller = shop.searchSeller(companyName);
            if (removedSeller != null)
            {
                shop.removeSeller(removedSeller);
                System.out.println("This seller \' " + companyName + "\' is removed now!");
            }
            else
            {
                System.out.println("There is no seller with this company name!");
                System.out.println("Try again!");
            }
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 7)
        {
            System.out.println(admin.getRequestsForAddingFund());
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 8)
        {
            System.out.println("Enter user's username");
            System.out.println("Username : ");
            String username = input.nextLine();
            if (admin.doesRequestExist(username))
            {
                admin.addFundToUserWallet(shop, username);
                System.out.println("The fund has been added to " + username + "'s wallet!");
            }
            else
            {
                System.out.println("There is no request with this username!");
                System.out.println("Try again!");
            }
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 9)
        {
            System.out.println(shop.getOrders());
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 10)
        {
            System.out.println("Enter order ID");
            System.out.println("Order ID : ");
            String orderID = input.nextLine();
            System.out.println("Enter seller's company name");
            System.out.println("Company name : ");
            String companyName = input.nextLine();
            Seller confirmation = shop.searchSeller(companyName);
            if (shop.doesOrderExist(orderID))
            {
                if (confirmation != null)
                {
                    admin.orderConfirmation(shop, confirmation, orderID);
                }
                else
                {
                    System.out.println("There is no seller with this company name!");
                    System.out.println("Try again!");
                }
            }
            else
            {
                System.out.println("There is no order with this ID!");
                System.out.println("Try again!");
            }
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 11)
        {
            System.out.println("1. Change password");
            System.out.println("2. Change email address");
            System.out.println("Enter your command");
            System.out.println("Command : ");
            command = Integer.parseInt(input.nextLine());
            if (command == 1)
            {
                System.out.println("Enter your current password");
                System.out.println("Current password : ");
                String currentPassword = input.nextLine();
                if (admin.getPassword().equals(currentPassword))
                {
                    System.out.println("Enter your new password");
                    System.out.println("New password : ");
                    String newPassword = input.nextLine();
                    admin.setPassword(newPassword);
                    System.out.println("The password has been changed!");
                }
                else
                {
                    System.out.println("Wrong password!");
                    System.out.println("Try again!");
                }
            }
            else if (command == 2)
            {
                System.out.println("Enter your current email address");
                System.out.println("Current email address : ");
                String currentEmailAddress = input.nextLine();
                if (admin.getEmailAddress().equals(currentEmailAddress))
                {
                    System.out.println("Enter your new email address");
                    System.out.println("New email address : ");
                    String newEmailAddress = input.nextLine();
                    admin.setEmailAddress(newEmailAddress);
                    System.out.println("The email address has been changed!");
                }
                else
                {
                    System.out.println("Wrong email address!");
                    System.out.println("Try again!");
                }
            }
            else
            {
                System.out.println("Wrong command!");
            }
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 12)
        {
            System.out.println(admin.toString());
            adminMenu(shop, admin, seller, user);
        }
        else if (command == 13)
        {
            shop.logOutAdmin(admin);
            runMenu(shop, admin, seller, user);
        }
        else
        {
            System.out.println("Wrong command!");
            adminMenu(shop, admin, seller, user);
        }
    }

    public static void sellerMenu(Shop shop, Admin admin, Seller seller , User user)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Add product");
        System.out.println("2. Remove product");
        System.out.println("3. Edit profile");
        System.out.println("4. View profile");
        System.out.println("5. Log out");
        System.out.println("Enter your command");
        System.out.println("Command : ");
        int command = Integer.parseInt(input.nextLine());
        switch (command)
        {
            case 1 :
                System.out.println("Enter the name of product");
                System.out.println("Name : ");
                String productName = input.nextLine();
                System.out.println("Enter the price of product");
                System.out.println("Price : ");
                double price = Double.parseDouble(input.nextLine());
                System.out.println("Enter the quantity of product");
                System.out.println("Quantity : ");
                int quantity = Integer.parseInt(input.nextLine());
                System.out.println("Enter the category of product");
                System.out.println("Category : ");
                String category = input.nextLine();
                if (category.equals("cell phone"))
                {
                    System.out.println("Enter the brand");
                    System.out.println("Brand : ");
                    String brand = input.nextLine();
                    System.out.println("Enter the model");
                    System.out.println("Model : ");
                    String model = input.nextLine();
                    System.out.println("Enter the quality of camera");
                    System.out.println("Camera quality : ");
                    int cameraQuality = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the processor");
                    System.out.println("Processor : ");
                    String processor = input.nextLine();
                    System.out.println("Enter the RAM");
                    System.out.println("RAM : ");
                    int ram = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the storage");
                    System.out.println("Storage : ");
                    int storage = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the operating system");
                    System.out.println("OS :");
                    String os = input.nextLine();
                    System.out.println("Enter the size of screen");
                    System.out.println("Screen size : ");
                    double screenSize = Double.parseDouble(input.nextLine());
                    System.out.println("Enter the color of cell phone");
                    System.out.println("Color :");
                    String color = input.nextLine();
                    CellPhone newCellPhone = new CellPhone(productName, price, quantity, category, brand, model, processor, cameraQuality, ram, storage, os, screenSize, color);
                    System.out.println("The new product has been added to the store!");
                }
                else if (category.equals("laptop"))
                {
                    System.out.println("Enter the brand");
                    System.out.println("Brand : ");
                    String brand = input.nextLine();
                    System.out.println("Enter the model");
                    System.out.println("Model : ");
                    String model = input.nextLine();
                    System.out.println("Enter the processor");
                    System.out.println("Processor : ");
                    String processor = input.nextLine();
                    System.out.println("Enter the size of screen");
                    System.out.println("Screen size : ");
                    double screenSize = Double.parseDouble(input.nextLine());
                    System.out.println("Enter the RAM");
                    System.out.println("RAM : ");
                    int ram = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the CPU");
                    System.out.println("CPU :");
                    String cpu = input.nextLine();
                    System.out.println("Enter the storage");
                    System.out.println("Storage : ");
                    int storage = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the operating system");
                    System.out.println("OS :");
                    String os = input.nextLine();
                    Laptop newLapTop = new Laptop(productName, price, quantity, category, brand, model, processor, screenSize, ram, cpu, storage, os);
                    seller.addProduct(newLapTop);
                    System.out.println("The new product has been added to the store!");
                }
                else if (category.equals("watch"))
                {
                    System.out.println("Enter the brand");
                    System.out.println("Brand : ");
                    String brand = input.nextLine();
                    System.out.println("Enter the model");
                    System.out.println("Model : ");
                    String model = input.nextLine();
                    System.out.println("Is the watch smart?");
                    System.out.println("Enter true or false");
                    boolean isSmart = Boolean.parseBoolean(input.nextLine());
                    System.out.println("Enter the operating system");
                    System.out.println("OS : ");
                    String os = input.nextLine();
                    System.out.println("Enter the size of screen");
                    System.out.println("Screen size : ");
                    double screenSize = Double.parseDouble(input.nextLine());
                    System.out.println("Enter the processor");
                    System.out.println("Processor : ");
                    String processor = input.nextLine();
                    System.out.println("Enter the storage");
                    System.out.println("Storage : ");
                    int storage = Integer.parseInt(input.nextLine());
                    Watch newWatch = new Watch(productName, price, quantity, category, brand, model, isSmart, os, screenSize, processor, storage);
                    seller.addProduct(newWatch);
                    System.out.println("The new product has been added to the store!");
                }
                else if (category.equals("camera"))
                {
                    System.out.println("Enter the brand");
                    System.out.println("Brand : ");
                    String brand = input.nextLine();
                    System.out.println("Enter the model");
                    System.out.println("Model : ");
                    String model = input.nextLine();
                    System.out.println("Enter the quality of camera");
                    System.out.println("Camera quality : ");
                    int cameraQuality = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the amoumt of optical zoom");
                    System.out.println("Optical zoom : ");
                    int opticalZoom = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the color of camera");
                    System.out.println("Color :");
                    String color = input.nextLine();
                    System.out.println("Enter dimensions");
                    System.out.println("Dimensions : ");
                    String dimensions = input.nextLine();
                    System.out.println("Enter the weight");
                    System.out.println("Weight : ");
                    double weight = Double.parseDouble(input.nextLine());
                    System.out.println("Enter the video ccapture resolution");
                    System.out.println("Video capture resolution : ");
                    int videoCaptureResolution = Integer.parseInt(input.nextLine());
                    Camera newCamera = new Camera(productName, price, quantity, category, brand, model, cameraQuality, opticalZoom, color, dimensions, weight, videoCaptureResolution);
                    seller.addProduct(newCamera);
                    System.out.println("The new product has been added to the store!");
                }
                else if (category.equals("television"))
                {
                    System.out.println("Enter the brand");
                    System.out.println("Brand : ");
                    String brand = input.nextLine();
                    System.out.println("Enter the model");
                    System.out.println("Model : ");
                    String model = input.nextLine();
                    System.out.println("Enter the size of screen");
                    System.out.println("Screen size : ");
                    int screenSize = Integer.parseInt(input.nextLine());
                    System.out.println("Is the television smart?");
                    System.out.println("Enter true or false");
                    boolean isSmart = Boolean.parseBoolean(input.nextLine());
                    Television newTelevision = new Television(productName, price, quantity, category, brand, model, screenSize, isSmart);
                    seller.addProduct(newTelevision);
                    System.out.println("The new product has been added to the store!");
                }
                else if (category.equals("musical instrument"))
                {
                    System.out.println("Enter the name of musical instrument");
                    System.out.println("Name :");
                    String instrumentName = input.nextLine();
                    System.out.println("Enter the brand");
                    System.out.println("Brand : ");
                    String brand = input.nextLine();
                    System.out.println("Enter the model");
                    System.out.println("Model : ");
                    String model = input.nextLine();
                    System.out.println("Enter the color");
                    System.out.println("Color :");
                    String color = input.nextLine();
                    MusicalInstrument newMusicalInstrument = new MusicalInstrument(productName, price, quantity, category, instrumentName, brand, model, color);
                    seller.addProduct(newMusicalInstrument);
                    System.out.println("The new product has been added to the store!");
                }
                else if (category.equals("clothes"))
                {
                    System.out.println("Enter the brand");
                    System.out.println("Brand : ");
                    String brand = input.nextLine();
                    System.out.println("Enter the gender");
                    System.out.println("Gender : ");
                    String gender = input.nextLine();
                    System.out.println("Enter the range of age");
                    System.out.println("Age range : ");
                    String ageRange = input.nextLine();
                    System.out.println("Enter the type of clothes");
                    System.out.println("Type :");
                    String clothesType = input.nextLine();
                    System.out.println("Enter the size of clothes");
                    System.out.println("Size : ");
                    String size = input.nextLine();
                    System.out.println("Enter the color");
                    System.out.println("Color :");
                    String color = input.nextLine();
                    Clothes newClothes = new Clothes(productName, price, quantity, category, brand, gender, ageRange, clothesType, size, color);
                    seller.addProduct(newClothes);
                    System.out.println("The new product has been added to the store!");
                }
                else if (category.equals("shoes"))
                {
                    System.out.println("Enter the brand");
                    System.out.println("Brand : ");
                    String brand = input.nextLine();
                    System.out.println("Enter the model");
                    System.out.println("Model : ");
                    String model = input.nextLine();
                    System.out.println("Enter the size of shoes");
                    System.out.println("Size : ");
                    int size = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the color");
                    System.out.println("Color :");
                    String color = input.nextLine();
                    Shoe newShoes = new Shoe(productName, price, quantity, category, brand, model, size, color);
                    seller.addProduct(newShoes);
                    System.out.println("The new product has been added to the store!");
                }
                else if (category.equals("book"))
                {
                    System.out.println("Enter the name of book");
                    System.out.println("Name : ");
                    String bookName = input.nextLine();
                    System.out.println("Enter the name of author");
                    System.out.println("Name of author : ");
                    String author = input.nextLine();
                    System.out.println("Enter the year of publish");
                    System.out.println("Year of publish : ");
                    int yearOfPublish = Integer.parseInt(input.nextLine());
                    Book newBook = new Book(productName, price, quantity, category, bookName, author, yearOfPublish);
                    seller.addProduct(newBook);
                    System.out.println("The new product has been added to the store!");
                }
                else if (category.equals("car"))
                {
                    System.out.println("Enter the brand");
                    System.out.println("Brand : ");
                    String brand = input.nextLine();
                    System.out.println("Enter the model");
                    System.out.println("Model : ");
                    String model = input.nextLine();
                    System.out.println("Enter the horse power");
                    System.out.println("Horse power : ");
                    int horsePower = Integer.parseInt(input.nextLine());
                    System.out.println("Enter the color");
                    System.out.println("Color :");
                    String color = input.nextLine();
                    System.out.println("Enter the fuel type");
                    System.out.println("Fuel type : ");
                    String fuelType = input.nextLine();
                    System.out.println("Enter the tank volume");
                    System.out.println("Tank volume : ");
                    double tankVolume = Double.parseDouble(input.nextLine());
                    System.out.println("Enter the product date ");
                    System.out.println("Product date : ");
                    String prodDate = input.nextLine();
                    Car newCar = new Car(productName, price, quantity, category, brand, model, horsePower, color, fuelType, tankVolume, prodDate);
                    seller.addProduct(newCar);
                    System.out.println("The new product has been added to the store!");
                }
                else
                {
                    Product newProduct = new Product(productName, price, quantity, category);
                    seller.addProduct(newProduct);
                    System.out.println("The new product has been added to the store!");
                }
                sellerMenu(shop, admin, seller, user);
                break;
            case 2 :
                System.out.println("Enter the name of product");
                System.out.println("Name : ");
                productName = input.nextLine();
                Product removedProduct = seller.searchProduct(productName);
                if (removedProduct != null)
                {
                    seller.removeProduct(removedProduct);
                    System.out.println("The product has been removed from store!");
                }
                else
                {
                    System.out.println("This product does not exist!");
                }
                sellerMenu(shop, admin, seller, user);
                break;
            case 3 :
                //
                break;
            case 4 :
                System.out.println("Enter your current password");
                System.out.println("Current password : ");
                String currentPassword = input.nextLine();
                if (seller.getPassword().equals(currentPassword))
                {
                    System.out.println("Enter your new password");
                    System.out.println("New password : ");
                    String newPassword = input.nextLine();
                    seller.setPassword(newPassword);
                    System.out.println("The password has been changed!");
                }
                else
                {
                    System.out.println("Wrong password!");
                    System.out.println("Try again!");
                }
                sellerMenu(shop, admin, seller, user);
                break;
            case 5 :
                System.out.println(seller.toString());
                sellerMenu(shop, admin, seller, user);
                break;
            case 6 :
                shop.logOutSeller(seller);
                runMenu(shop, admin, seller, user);
                break;
            default :
                System.out.println("Wrong command!");
                sellerMenu(shop, admin, seller, user);
        }
    }
    public static void userMenu(Shop shop, Admin admin, Seller seller , User user)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Add a product to the shopping cart");
        System.out.println("2. Remove a product from the shopping cart");
        System.out.println("3. Update the shopping cart");
        System.out.println("4. View the shopping cart");
        System.out.println("5. End of shopping");
        System.out.println("6. View purchased items");
        System.out.println("7. Send a request to an admin for adding fund to wallet");
        System.out.println("8. View orders");
        System.out.println("9. Check order's status");
        System.out.println("10. Edit profile");
        System.out.println("11. View profile");
        System.out.println("12. Log out");
        System.out.println("Enter your command");
        System.out.println("Command : ");
        int command = Integer.parseInt(input.nextLine());
        switch (command)
        {
            case 1 :
                System.out.println("Enter the product's name");
                System.out.println("The product's name : ");
                String productName = input.nextLine();
                System.out.println("Enter the number of product");
                System.out.println("The number of product : ");
                int numberOfProduct = Integer.parseInt(input.nextLine());
                System.out.println("Enter the company name");
                System.out.println("Company name : ");
                String companyName = input.nextLine();
                Seller buy = shop.searchSeller(companyName);
                if (buy != null)
                {
                    if (buy.doesProductExist(productName))
                    {
                        user.addToShoppingCart(buy, productName, numberOfProduct);
                    }
                    else
                    {
                        System.out.println(companyName + " does not have this product!");
                    }
                }
                else
                {
                    System.out.println("There is no seller with this company name!");
                    System.out.println("Try again!");
                }
                userMenu(shop, admin, seller, user);
                break;
            case 2 :
                System.out.println("Enter the product's name");
                System.out.println("The product's name : ");
                productName = input.nextLine();
                if (user.doesProductExist(productName))
                {
                    user.removeFromShoppingCart(productName);
                }
                else
                {
                    System.out.println("There is no product with this name in your shopping cart!");
                }
                userMenu(shop, admin, seller, user);
                break;
            case 3 :
                System.out.println("Enter the product's name");
                System.out.println("The product's name : ");
                productName = input.nextLine();
                if (user.doesProductExist(productName))
                {
                    System.out.println("Enter the company name");
                    System.out.println("Company name : ");
                    companyName = input.nextLine();
                    System.out.println("Enter the new number of product");
                    System.out.println("The new number of product : ");
                    int newNumber = Integer.parseInt(input.nextLine());
                    Seller update = shop.searchSeller(companyName);
                    user.updateTheShoppingCart(update, productName, newNumber);
                }
                else
                {
                    System.out.println("There is no product with this name in your shopping cart!");
                }
                userMenu(shop, admin, seller, user);
                break;
            case 4 :
                System.out.println(user.getShoppingCart());
                userMenu(shop, admin, seller, user);
                break;
            case 5 :
                user.endOfShopping(shop);
                userMenu(shop, admin, seller, user);
                break;
            case 6 :
                System.out.println(user.getPurchasedItems());
                break;
            case 7 :
                System.out.println("Enter the amount of fund");
                System.out.println("Amount of fund : ");
                int fund = Integer.parseInt(input.nextLine());
                System.out.println("Enter the admin's username");
                System.out.println("Admin's username : ");
                String username = input.nextLine();
                Admin addingFund = shop.searchAdmin(username);
                if (addingFund != null)
                {
                    user.requestForAddingFundToWallet(addingFund, fund);
                    System.out.println("The request has been sent!");
                }
                else
                {
                    System.out.println("There is no admin with this username!");
                    System.out.println("Try again!");
                }
                userMenu(shop, admin, seller, user);
                break;
            case 8 :
                System.out.println(user.getOrders());
                userMenu(shop, admin, seller, user);
                break;
            case 9 :
                System.out.println("Enter the order ID");
                System.out.println("Order ID : ");
                String orderID = input.nextLine();
                if (user.doesOrderExist(orderID))
                {
                    user.checkOrderStatus(orderID);
                }
                else
                {
                    System.out.println("There is no order with this ID!");
                    System.out.println("Try again!");
                }
                userMenu(shop, admin, seller, user);
                break;
            case 10 :
                System.out.println("1. Change password");
                System.out.println("2. Change email address");
                System.out.println("3. Change phone number");
                System.out.println("4. Change address");
                System.out.println("Enter your command");
                System.out.println("Command : ");
                command = Integer.parseInt(input.nextLine());
                if (command == 1)
                {
                    System.out.println("Enter your current password");
                    System.out.println("Current password : ");
                    String currentPassword = input.nextLine();
                    if (user.getPassword().equals(currentPassword))
                    {
                        System.out.println("Enter your new password");
                        System.out.println("New password : ");
                        String newPassword = input.nextLine();
                        user.setPassword(newPassword);
                        System.out.println("The password has been changed!");
                    }
                    else
                    {
                        System.out.println("Wrong password!");
                        System.out.println("Try again!");
                    }
                }
                else if (command == 2)
                {
                    System.out.println("Enter your current email address");
                    System.out.println("Current email address : ");
                    String currentEmailAddress = input.nextLine();
                    if (user.getEmailAddress().equals(currentEmailAddress))
                    {
                        System.out.println("Enter your new email address");
                        System.out.println("New email address : ");
                        String newEmailAddress = input.nextLine();
                        user.setEmailAddress(newEmailAddress);
                        System.out.println("The email address has been changed!");
                    }
                    else
                    {
                        System.out.println("Wrong email address");
                        System.out.println("Try again!");
                    }
                }
                else if (command == 3)
                {
                    System.out.println("Enter your current phone number");
                    System.out.println("Current phone number : ");
                    String currentPhoneNumber = input.nextLine();
                    if (user.getPhoneNumber().equals(currentPhoneNumber))
                    {
                        System.out.println("Enter your new phone number");
                        System.out.println("New phone number : ");
                        String newPhoneNumber = input.nextLine();
                        user.setPhoneNumber(newPhoneNumber);
                        System.out.println("The phone number has been changed!");
                    }
                    else
                    {
                        System.out.println("Wrong phone number!");
                        System.out.println("Try again!");
                    }
                }
                else if (command == 4)
                {
                    System.out.println("Enter your current address");
                    System.out.println("Current address : ");
                    String currentAddress = input.nextLine();
                    if (user.getAddress().equals(currentAddress))
                    {
                        System.out.println("Enter your new address");
                        System.out.println("New address");
                        String newAddress = input.nextLine();
                        user.setAddress(newAddress);
                        System.out.println("The address has been changed!");
                    }
                    else
                    {
                        System.out.println("Wrong address!");
                        System.out.println("Try again!");
                    }
                }
                else
                {
                    System.out.println("Wrong command!");
                    System.out.println("Try again!");
                }
                userMenu(shop, admin, seller, user);
                break;
            case 11 :
                System.out.println(user.toString());
                userMenu(shop, admin, seller, user);
                break;
            case  12 :
                shop.logOutUser(user);
                runMenu(shop, admin, seller, user);
                break;
            default :
                System.out.println("Wrong command!");
                userMenu(shop, admin, seller, user);
        }
    }
}
