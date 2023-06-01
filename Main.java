import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int IDUser;
    static int IDAdmin;
    static int IDRestaurant;
    static int IDFood;
    static int corrFood=1;
    static int corrRestaurant=1;
    static int corrUser=1;
    static int corrAdmin=1;
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        String inputs[] = {};
        String command="";
        ArrayList<User> user = User.getUser();

        while (true) {
            if(command.equals("end")) {
                break;
            }

            command = myscanner.nextLine();
            inputs = command.split(" ");

            if(inputs[0].equals("ADD")&&inputs[1].equals("USER"))
            {
                String username=inputs[2];
                String password=inputs[3];

                if (User.checkName(username))
                {
                    System.out.println("Username format invalid!\nTry a new Username!");
                }
                else if(User.Password(password))
                {
                    System.out.println("Password format invalid!\nSelect a new Password!");
                }
                else if (User.Name(username)) {
                    System.out.println("Username already taken!\nPlease try a new Username!");
                }
                else {
                    System.out.println("Please enter your password again!");
                    String confirmationPassword ;
                    while (true)
                    {
                        confirmationPassword=myscanner.nextLine();
                        if (password.equals(confirmationPassword)) {
                            break;
                        }

                        System.out.println("Wrong confirmation!\n" +
                                "please enter your confirmation password again!");
                    }

                    if (confirmationPassword.equals(password)){
                        System.out.println("Account created successfully.");
                        System.out.println("Please enter your mobile phone number!");
                        String phone=myscanner.next();
                        while (phone.length()!=11)
                        {
                            System.out.println("Phone number invalid!\nPlease try again!");
                            phone=myscanner.next();

                        }
                        if (phone.length()==11)
                        {
                            System.out.println("Your phone number has been successfully registered\n" +
                                    "Please enter your email address!");
                            String gmail=myscanner.next();

                            while (gmail.length()<8 || !gmail.contains("@gmail.com"))
                            {
                                System.out.println("Your email is invalid!" +
                                        "\nPlease enter your email again");
                                gmail=myscanner.next();
                            }
                            if(gmail.length()>=8)
                            {
                                System.out.println("Your email has been successfully registered\n" +
                                        "For the convenience of users and restaurant managers, if you forget your password,\n" +
                                        " you can log in by having a username and answering one of the following security questions.\n" +
                                        "In the lower part, there are a number of security questions for you,\n" +
                                        " which you have to choose one of and then answer.\n" +
                                        "1.What was your favorite school teacher’s name?\n" +
                                        "2.What’s your favorite movie?\n" +
                                        "3.What city were you born in?\n" +
                                        "4.What high school did you attend?\n" +
                                        "5.What’s your favorite food?\n" +
                                        "Please choose a number of the security question you want to answer!");

                                int securityNo=myscanner.nextInt();
                                while (securityNo>5||securityNo<1)
                                {
                                    System.out.println("You should use a number of security question between 1-5");
                                    securityNo=myscanner.nextInt();
                                }
                                if(securityNo>=1&&securityNo<=5)
                                {
                                    System.out.println("Your security question number has been successfully registered!\n" +
                                            "Please answer your security question!");
                                    String securityAns=myscanner.next();
                                    System.out.println("Your answer has been registered successfully!");

                                    User users = new User(username, password,corrUser,phone,gmail,securityNo,securityAns);
                                    corrUser++;
                                    System.out.println("Dear " +username+", You have been registered successfully!");
                                }
                            }
                        }
                    }
                }
            }
            if(inputs[0].equals("ADD")&&inputs[1].equals("ADMIN"))
            {
                ArrayList<Admin> admin = Admin.getAdmin();
                String username=inputs[2];
                String password=inputs[3];

                if(User.checkName(username))
                {
                    System.out.println("Username format invalid!\nTry a new Username!");
                }
                else if(User.Password(password))
                {
                    System.out.println("Password format invalid!\nSelect a new Password!");
                }
                else if (User.Name(username)) {
                    System.out.println("Username already taken!\nPlease try a new Username!");
                }
                else {
                    System.out.println("Please enter your password again!");
                    String confirmationPassword;
                    while (true)
                    {
                        confirmationPassword=myscanner.nextLine();
                        if (password.equals(confirmationPassword)) {
                            break;
                        }

                        System.out.println("Wrong confirmation!\n" +
                                "please enter your confirmation password again!");
                    }

                    if (confirmationPassword.equals(password)){
                        System.out.println("Account created successfully.");
                        System.out.println("Please enter your mobile phone number!");
                        String phone=myscanner.next();
                        while (phone.length()!=11)
                        {
                            System.out.println("Phone number invalid!\nPlease try again!");
                            phone=myscanner.next();

                        }
                        if (phone.length()==11) {
                            System.out.println("Your phone number has been successfully registered\n" +
                                    "Please enter your email address!");
                            String gmail=myscanner.next();

                            while (gmail.length()<8 || !gmail.contains("@gmail.com"))
                            {
                                System.out.println("Your email is invalid!" +
                                        "\nPlease enter your email again");
                                gmail=myscanner.next();
                            }

                            if(gmail.length()>=8)
                            {
                                System.out.println("Your email has been successfully registered \n" +
                                        "For the convenience of users and restaurant managers, if you forget your password,\n" +
                                        " you can log in by having a username and answering one of the following security questions.\n" +
                                        "In the lower part, there are a number of security questions for you,\n" +
                                        " which you have to choose one of and then answer.\n" +
                                        "1.What was your favorite school teacher’s name?\n" +
                                        "2.What’s your favorite movie?\n" +
                                        "3.What city were you born in?\n" +
                                        "4.What high school did you attend?\n" +
                                        "5.What’s your favorite food?\n" +
                                        "Please choose a number of the security question you want to answer!");
                                int securityNo=myscanner.nextInt();
                                while (securityNo>5||securityNo<1)
                                {
                                    System.out.println("You should use a number of security question between 1-5");
                                    securityNo=myscanner.nextInt();
                                }
                                if(securityNo>=1&&securityNo<=5)
                                {
                                    System.out.println("Your security question number has been successfully registered!\n" +
                                            "Please answer your security question!");
                                    String securityAns=myscanner.next();
                                    System.out.println("Your answer has been registered successfully!");
                                    Admin admins = new Admin(username, password,corrAdmin,phone,gmail,securityNo,securityAns);
                                    System.out.println("Dear "+username+", You have been registered successfully!");
                                    corrAdmin++;
                                }
                            }
                        }
                    }
                }
            }

            else if(inputs[0].equals("LOGIN")&&inputs[1].equals("USER"))
            {

                String username = inputs[2];
                String password = inputs[3];

                if (!User.userState.isEmpty()) {
                    System.out.println("Another user is currently logged in!");
                }

                else if (User.checkName(username)) {
                    System.out.println("Username format invalid!");
                } else if (User.Password(password)) {
                    System.out.println("Password format invalid!");
                } else {
                    IDUser = User.IDChecker(username);
                    if (IDUser < 0) {
                        System.out.println("Username not found!");
                    } else {
                        if (!password.equals(User.pass(username))) {
                            System.out.println("Incorrect password!");
                            IDUser=0;
                        } else {
                            User.userState.put(username, 1);
                            System.out.println("Dear "+ username+"! You have been logged in successfully!");
                            if(inputs[0].equals("SEARCH")&&inputs[1].equals("RESTAURANT"))
                            {
                                //String foodName=Food.getFood().get(corrFood-1).getFoodName();
                                String restaurantName=inputs[2];
                                restaurantName=Restaurants.getRestaurant().get(corrRestaurant-1).getRestaurantName();
                                if(corrRestaurant<0)
                                {
                                    System.out.println("Restaurant with the name does not exist!");
                                }
                                else
                                {
                                    System.out.println("Restaurant has been selected successfully!");
                                    if (inputs[0].equals("SEARCH"))
                                    {
                                        String foodName=inputs[1];
                                        foodName=Food.getFood().get(corrFood-1).getRestaurantName();
                                        if (corrFood<0)
                                        {
                                            System.out.println("The food "+foodName+" does not exist in this restaurant!");
                                        }
                                        else {
                                            System.out.println("The food "+foodName+" is ready to be stored at the restaurant "+restaurantName+"\n" +
                                                    "with the ID "+corrFood);
                                            if (inputs[0].equals("SELECT"))
                                            {
                                                corrFood=Integer.parseInt(inputs[1]);
                                                if(IDFood<0)
                                                {
                                                    System.out.println("The ID does not exist");
                                                }
                                                else
                                                {
                                                    System.out.println("Logged in successfully!");
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }

            else if(inputs[0].equals("LOGIN")&&inputs[1].equals("ADMIN"))
            {
                String username = inputs[2];
                String password = inputs[3];

                if (!Admin.adminState.isEmpty()) {
                    System.out.println("Another admin is currently logged in!");
                }

                else if (Admin.checkName(username)) {
                    System.out.println("Username format invalid!");
                } else if (Admin.Password(password)) {
                    System.out.println("Password format invalid!");
                } else {
                    IDAdmin = Admin.IDChecker(username);
                    if (IDAdmin < 0) {
                        System.out.println("Username not found!");
                    } else {
                        if (!password.equals(Admin.pass(username))) {
                            System.out.println("Incorrect password!");
                            IDAdmin=0;
                        } else
                        {
                            Admin.adminState.put(username, 1);
                            System.out.println("Dear "+ username+"! You have been logged in successfully!");
                            if(inputs[0].equals("ADD")&&inputs[1].equals("RESTAURANT"))
                            {
                                String restaurantName=inputs[2];
                                if(Restaurants.checkRestaurantName(restaurantName))
                                {
                                    System.out.println("RestaurantName format invalid");
                                } else if (Restaurants.checkTakenRestaurant(restaurantName))
                                {
                                    System.out.println("RestaurantName already taken!\nPlease try a new one!");
                                }
                                else {
                                    System.out.println("Please enter your restaurant/shop type !\nYour restaurantType should be between following items!" +
                                            "\n1.Sea Food\n2.Fast Food\n3.Drinks\n4.Fruit and Vegetable\n5.Sweet and Candy" +
                                            "\n6.Dessert\n7.Coffee Shop\n8.Iranian Food\n9.Italian Food\n10.Chinese Food" +
                                            "\n11.Super Market\n12.Custom Food");
                                    String FoodType=myscanner.next();
                                    while (!FoodType.equals("Sea Food")||!FoodType.equals("Fast Food")||!FoodType.equals("Drinks")
                                            ||!FoodType.equals("Fruit and Vegetable")||!FoodType.equals("Sweet and Candy")||!FoodType.equals("Dessert")
                                            ||!FoodType.equals("Coffee shop")||!FoodType.equals("Iranian Food")||!FoodType.equals("Italian Food")
                                            ||!FoodType.equals("Chinese Food")||!FoodType.equals("Super Market")||
                                            !FoodType.equals("Custom Food"))
                                    {
                                        System.out.println("Restaurant FoodType Invalid!\nPlease Select a new type again!");
                                        FoodType=myscanner.next();
                                        if(FoodType.equals("Sea Food")||FoodType.equals("Fast Food")||FoodType.equals("Drinks")
                                                ||FoodType.equals("Fruit and Vegetable")||FoodType.equals("Sweet and Candy")||FoodType.equals("Dessert")
                                                ||FoodType.equals("Coffee shop")||FoodType.equals("Iranian Food")||FoodType.equals("Italian Food")
                                                ||FoodType.equals("Chinese Food")||FoodType.equals("Super Market")|| FoodType.equals("Custom Food"))
                                        {
                                            System.out.println("Restaurant type has been successfully registered!");
                                            System.out.println("Please enter the first node of the restaurant location!");
                                            double node1;
                                            node1=myscanner.nextDouble();
                                            System.out.println("The first node of your restaurant has been registered successfully!\n" +
                                                    "Please enter the second node of the restaurant location!");
                                            double node2;
                                            node2= myscanner.nextDouble();
                                            System.out.println("The second node of your restaurant has been registered successfully!\n" +
                                                    "Please enter the weight of the edge of the restaurant");
                                            double wEdge;
                                            wEdge=myscanner.nextDouble();
                                            System.out.println("The weight of the edge of your restaurant has been registered successfully!");
                                            System.out.println("Please enter the name of the delivery of your restaurant!");
                                            String deliverName;
                                            deliverName=myscanner.next();
                                            System.out.println("The delivery of your restaurant has been registered successfully\n" +
                                                    "Please enter the price of your delivery per Km !");
                                            double deliveryPerKm;
                                            deliveryPerKm= myscanner.nextDouble();
                                            Restaurants restaurants=new Restaurants(restaurantName,FoodType,corrRestaurant,username,corrAdmin,node1,node2,wEdge,deliverName,deliveryPerKm);
                                            corrRestaurant++;
                                            System.out.println("Dear "+username+" ,Your restaurant with the name "+restaurantName+" has been registered successfully!");
                                            if (inputs[0].equals("SHOW")&&inputs[1].equals("LOCATION")) {
                                                System.out.println("The location of the restaurant "+restaurantName+" ,\n" +
                                                        "First node : "+node1+"\n" +
                                                        "Second node : "+node2+"\n"+
                                                        "Weight of the edge : "+wEdge+"\n");
                                            }
                                            else if(inputs[0].equals("EDIT")&&inputs[1].equals("LOCATION"))
                                            {
                                                double newNode1;
                                                double newNode2;
                                                double newWEdge;
                                                System.out.println("Please enter the new first node!");
                                                newNode1=myscanner.nextDouble();
                                                System.out.println("Please enter the new second node!");
                                                newNode2=myscanner.nextDouble();
                                                System.out.println("Please enter the new weight of the node!");
                                                newWEdge= myscanner.nextDouble();
                                                if (newNode1==(Restaurants.getRestaurant().get(corrRestaurant - 1).getNode1())&&
                                                        newNode2==(Restaurants.getRestaurant().get(corrRestaurant - 1).getNode2())&&
                                                        newWEdge==(Restaurants.getRestaurant().get(corrRestaurant - 1).getwEdge())) {
                                                    System.out.println("Restaurant location does not change! ");
                                                }
                                                else {
                                                    System.out.println("Your restaurant location has changed successfully.");
                                                    Restaurants.editLocation(corrRestaurant,newNode1,newNode2,newWEdge);
                                                     }
                                            }
                                            else if(inputs[0].equals("SHOW")&&inputs[1].equals("FOODTYPE"))
                                            {
                                                System.out.println("The restaurant "+restaurantName+"'s food type is "+FoodType);
                                            }
                                            else if(inputs[0].equals("EDIT")&&inputs[1].equals("FOODTYPE"))
                                            {
                                                String newFoodType;
                                                newFoodType=inputs[3]+" "+inputs[4];
                                                if (newFoodType.equals(Restaurants.getRestaurant().get(corrRestaurant-1).getRestaurantType()))
                                                {
                                                    System.out.println("Restaurant type is already "+newFoodType);
                                                }
                                                else {
                                                    System.out.println("ARE YOU SURE YOU WANT TO CHANGE YOUR RESTAURANT TYPE?\n" +
                                                            "YES/NO");
                                                    String answer=myscanner.next();
                                                    if (answer.equals("No"))
                                                    {
                                                        System.out.println("Edition failed");
                                                    }
                                                    else if(answer.equals("YES"))
                                                    {
                                                        System.out.println("Your restaurant food type has been changed to "+newFoodType
                                                                +" successfully!");
                                                        Restaurants.editFoodType(corrRestaurant,newFoodType);
                                                    }
                                                }
                                            }
                                            else if(inputs[0].equals("ADD")&&inputs[1].equals("FOOD"))
                                            {
                                                String foodName;
                                                double foodPrice;
                                                foodName=inputs[2];
                                                foodPrice=Double.parseDouble(inputs[3]);
                                                System.out.println("Please enter thr number of discount for the food "+ foodName+"\n" +
                                                        "If this food does not contain any discount , you can enter 0 instead!");
                                                double foodDiscount;
                                                foodDiscount= myscanner.nextDouble();
                                                System.out.println("Please enter the number of food "+foodName+" available in your restaurant!");
                                                int numAvailableFood;
                                                numAvailableFood=myscanner.nextInt();
                                                Food food=new Food(foodName,FoodType,corrFood,foodPrice,restaurantName,username,corrRestaurant,numAvailableFood);
                                                corrFood++;
                                                System.out.println("Food "+foodName+"added to restaurant successfully!");
                                            }
                                            else if(inputs[0].equals("EDIT")&&inputs[1].equals("FOOD")&&inputs[3].equals("NAME"))
                                            {
                                                corrFood=Integer.parseInt(inputs[2]);
                                                String newFoodName=inputs[4];
                                                if(newFoodName.equals(Food.getFood().get(corrFood - 1).getFoodName()))
                                                {
                                                    System.out.println("Food Name is already "+newFoodName);
                                                }
                                                else
                                                {
                                                    Food.editFoodName(corrFood,newFoodName);
                                                    System.out.println("The name of the food was changed to "+newFoodName+" successfully!");
                                                }

                                            }
                                            else if(inputs[0].equals("EDIT")&&inputs[1].equals("FOOD")&&inputs[3].equals("PRICE"))
                                            {
                                                corrFood=Integer.parseInt(inputs[2]);
                                                double newFoodPrice=Double.parseDouble(inputs[4]);
                                                if(newFoodPrice==(Food.getFood().get(corrFood - 1).getFoodPrice()))
                                                {
                                                    System.out.println("Food price is already "+newFoodPrice);
                                                }
                                                else
                                                {
                                                    Food.editFoodPrice(corrFood,newFoodPrice);
                                                    System.out.println("The price of the food was changed to "+newFoodPrice+" successfully!");
                                                }
                                            }

                                            //  DELETE FOOD <FOOD ID>
                                            else if(inputs[0].equals("DELETE")&&inputs[1].equals("FOOD"))
                                            {
                                                System.out.println("Are you sure you want to delete the food with the ID "+corrFood+" ?\n" +
                                                        "Yes/No");
                                                String answer=myscanner.next();
                                                if (answer.equals("No"))
                                                {
                                                    System.out.println("Deletion failed successfully!");
                                                }
                                                else if(answer.equals("Yes"))
                                                {
                                                    Food.deleteFood(corrFood);
                                                    System.out.println("The selected food was deleted successfully!");
                                                }
                                                else {
                                                    System.out.println("Invalid command");
                                                }
                                            }
                                            else if(inputs[0].equals("DISCOUNT")&&inputs[1].equals("FOOD"))
                                            {
                                                corrFood=Integer.parseInt(inputs[2]);
                                                double foodDiscount=Double.parseDouble(inputs[3]);
                                                double timeDiscount=Double.parseDouble(inputs[4]);
                                                if(foodDiscount>50||foodDiscount<0)
                                                {
                                                    System.out.println("The percentage of the discount must be a number between 0-50!");
                                                }
                                                else if(timeDiscount<=0)
                                                {
                                                    System.out.println("Your time should be a positive value!");
                                                }
                                                else
                                                {
                                                    String foodName=Food.getFood().get(corrFood-1).getFoodName();
                                                    double foodPrice=Food.getFood().get(corrFood-1).getFoodPrice();
                                                    System.out.println("Please enter the number of food "+foodName+" available in your restaurant!");
                                                    int numAvailableFood;
                                                    numAvailableFood=myscanner.nextInt();
                                                    Food food=new Food(foodName,FoodType,corrFood,foodPrice,foodDiscount,restaurantName,username
                                                    ,corrRestaurant,timeDiscount,numAvailableFood);
                                                    System.out.println("The "+foodDiscount+"% discount was set to food "+foodName+" with the " +
                                                            "foodID "+corrFood+" successfully!");
                                                }
                                            }
                                            else if(inputs[0].equals("DEACTIVE")&&inputs[1].equals("FOOD"))
                                            {
                                                corrFood=Integer.parseInt(inputs[2]);
                                                System.out.println("Are you sure you want to deactivate the food with the ID "+corrFood+" ?\n" +
                                                        "Yes/No");
                                                String answer=myscanner.next();
                                                if (answer.equals("No"))
                                                {
                                                    System.out.println("Deactivation failed successfully!");
                                                }

                                        else if(answer.equals("Yes"))
                                            {
                                            String foodName = Food.getFood().get(corrFood-1).getFoodName();
                                            double foodPrice=Food.getFood().get(corrFood-1).getFoodPrice();
                                            Food food=new Food(foodName,FoodType,corrFood,foodPrice,0,restaurantName,username
                                            ,corrRestaurant,0,0);
                                            System.out.println("The selected food was deactivated successfully!");
                                             }
                                           }
                                            else if(inputs[0].equals("Active")&&inputs[1].equals("FOOD"))
                                            {
                                                corrFood=Integer.parseInt(inputs[2]);
                                                String foodName=Food.getFood().get(corrFood-1).getFoodName();
                                                double foodPrice=Food.getFood().get(corrFood-1).getFoodPrice();
                                                System.out.println("Please enter the number of food "+foodName +" available in your restaurant!");
                                                int numAvailableFood;
                                                numAvailableFood=myscanner.nextInt();
                                                if(numAvailableFood==0)
                                                {
                                                    System.out.println("The food wasn't already available");
                                                }
                                                else
                                                {
                                                    Food food=new Food(foodName,FoodType,corrFood,foodPrice,0,restaurantName,username
                                                            ,corrRestaurant,0,numAvailableFood);
                                                }

                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            else if(command.equals("LOGOUT USER")) {
                User.userState.clear();
                System.out.println("Logged out successfully");
            }

            else if(command.equals("LOGOUT ADMIN")) {
                Admin.adminState.clear();
                System.out.println("Logged out successfully");
            }
        }
    }
}