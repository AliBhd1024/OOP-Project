import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        int corrFood=1 ,corrRestaurant=1 , corrUser=1 , corrAdmin=1;
        Scanner myscanner = new Scanner(System.in);
        String inputs[] = {};
        String command="";
        String username = "" , password = "";
        int comdid = 0;
        Restaurants selRest = null;
        Food selFood = null;
        int comment_id = 0;
        int commID = 0;
        int order_id = 0;
        int cID = 0;

        DatabaseHandler handler = new DatabaseHandler();
        Connection connectDB = handler.getConnection();
        PreparedStatement init = connectDB.prepareStatement("USE snappfood_db_p1");
        init.execute();

        while (true) {
            if(command.equals("exit")) {
                break;
            }

            command = myscanner.nextLine();
            inputs = command.split(" ");

            if(inputs[0].equals("ADD")&&inputs[1].equals("USER"))
            {
                username=inputs[2];
                password=inputs[3];

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
                                System.out.println("Your email has been successfully registered\n" +
                                        "For the convenience of users and restaurant managers, if you forget your password,\n" +
                                        " you can log in by having a username and answering one of the following security questions.\n" +
                                        "In the lower part, there are a number of security questions for you,\n" +
                                        " which you have to choose one of and then answer.\n" +
                                        "1.What was your favorite school teacher’s name?\n" +
                                        "2.What’s your favorite movie?\n" +
                                        "3.What city were you born in?\n" +
                                        "4.What high school did you attend?\n" +
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
                                    
                                    String secQ = "";

                                    if (securityNo == 1) {
                                        secQ = "teacher’s name?";
                                    }
                                    else if(securityNo == 2) {
                                        secQ = "favorite movie?";
                                    }
                                    else if(securityNo == 3) {
                                        secQ = "city born in?";
                                    }
                                    else {
                                        secQ = "highschool attend?";
                                    }

                                    User usr = new User(username, confirmationPassword, corrUser, phone, gmail, securityNo, securityAns);
                                    User.user.add(usr);

                                    String query = "INSERT INTO user (name, password, ID, secQ, secA, phone, email, state) VALUES ('" + username + "', '" 
                                    + password + "', " + corrUser + ", '" + secQ + "', '" + securityAns + "', '" + phone + "', '" + gmail + "', " + 0 + ") ;";
                                    
                                    PreparedStatement addUser = connectDB.prepareStatement(query);
                                    addUser.execute();

                                    corrUser++;
                                    System.out.println("Dear " + username + ", You have been registered successfully!");
                                }
                            }
                        }
                    }
                }
            }

            else if(inputs[0].equals("ADD")&&inputs[1].equals("ADMIN"))
            {
                username=inputs[2];
                password=inputs[3];

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

                                    String secQ = "";

                                    if (securityNo == 1) {
                                        secQ = "teacher’s name?";
                                    }
                                    else if(securityNo == 2) {
                                        secQ = "favorite movie?";
                                    }
                                    else if(securityNo == 3) {
                                        secQ = "city born in?";
                                    }
                                    else {
                                        secQ = "highschool attend?";
                                    }

                                    Admin adm = new Admin(username, confirmationPassword, corrAdmin, phone, gmail, securityNo, securityAns);
                                    Admin.admin.add(adm);

                                    String query = "INSERT INTO admin (name, password, ID, secQ, secA, phone, email, state) VALUES ('" + username + "', '" 
                                    + password + "', " + corrUser + ", '" + secQ + "', '" + securityAns + "', '" + phone + "', '" + gmail + "', " + 0 + ") ;";
                                    
                                    PreparedStatement addAdmin = connectDB.prepareStatement(query);
                                    addAdmin.execute();

                                    corrAdmin++;
                                    System.out.println("Dear "+username+", You have been registered successfully!");
                                }
                            }
                        }
                    }
                }
            }

            else if(inputs[0].equals("LOGIN")&&inputs[1].equals("USER"))
            {
                int f = 0 , g = 0;
                username = inputs[2];
                password = inputs[3];

                if (User.checkName(username)) {
                    System.out.println("Username format invalid!");
                } else if (User.Password(password)) {
                    System.out.println("Password format invalid!");
                } else {
                    Statement checkLogged = connectDB.createStatement();
                    ResultSet rs = checkLogged.executeQuery("SELECT * FROM user");

                    while(rs.next()) {
                        if (rs.getString(8).equals("1")) {
                            g++;
                            break;
                        }
                    }

                    if (g == 1) {
                        System.out.println("Another user is logged in!");
                    }

                    else {
                        Statement checkUser = connectDB.createStatement();
                        ResultSet rs1 = checkUser.executeQuery("SELECT * FROM user WHERE password='" + password + "' ;");
    
                        while(rs1.next()) {
                            if (rs1.getString(1).equals(username)) {
                                f++;
                                break;
                            }
                        }
    
                        if (f == 1) {
                            PreparedStatement updateState = connectDB.prepareStatement("UPDATE user SET state=1 WHERE name='" + username + "' ;");
                            updateState.execute();
    
                            System.out.println("Dear "+ username+"! You have been logged in successfully!");
                        }
                        else {
                            System.out.println("No user found!");
                        }
                    }
                }
            }

            else if(inputs[0].equals("LOGIN")&&inputs[1].equals("ADMIN"))
            {
                int f = 0 , g = 0;
                username = inputs[2];
                password = inputs[3];

                if (Admin.checkName(username)) {
                    System.out.println("Username format invalid!");
                } else if (Admin.Password(password)) {
                    System.out.println("Password format invalid!");
                } else {
                    Statement checkLogged = connectDB.createStatement();
                    ResultSet rs = checkLogged.executeQuery("SELECT * FROM admin");

                    while(rs.next()) {
                        if (rs.getString(8).equals("1")) {
                            g++;
                            break;
                        }
                    }

                    if (g == 1) {
                        System.out.println("Another admin is logged in!");
                    }

                    else {
                        Statement checkUser = connectDB.createStatement();
                        ResultSet rs1 = checkUser.executeQuery("SELECT * FROM admin WHERE password='" + password + "' ;");
    
                        while(rs1.next()) {
                            if (rs1.getString(1).equals(username)) {
                                f++;
                                break;
                            }
                        }
    
                        if (f == 1) {
                            PreparedStatement updateState = connectDB.prepareStatement("UPDATE admin SET state=1 WHERE name='" + username + "' ;");
                            updateState.execute();
    
                            System.out.println("Dear "+ username+"! You have been logged in successfully!");
                        }
                        else {
                            System.out.println("No admin found!");
                        }
                    }
                }
            }
        
            else if(command.equals("LOGOUT USER")) {
                int f = 0;
                
                Statement checkLog = connectDB.createStatement();
                ResultSet rs = checkLog.executeQuery("SELECT * FROM user");

                while(rs.next()) {
                    if (rs.getString(8).equals("1")) {
                        f++;
                        break;
                    }
                }

                if (f == 1) {
                    PreparedStatement logoutUser = connectDB.prepareStatement("UPDATE user SET state=0;");
                    logoutUser.execute();

                    System.out.println("Logged out succesfully!");
                }
                else {
                    System.out.println("No user is logged in!");
                }
            }

            else if(command.equals("LOGOUT ADMIN")) {
                int f = 0;
                
                Statement checkLog = connectDB.createStatement();
                ResultSet rs = checkLog.executeQuery("SELECT * FROM admin");

                while(rs.next()) {
                    if (rs.getString(8).equals("1")) {
                        f++;
                        break;
                    }
                }

                if (f == 1) {
                    PreparedStatement logoutUser = connectDB.prepareStatement("UPDATE admin SET state=0;");
                    logoutUser.execute();

                    System.out.println("Logged out succesfully!");
                }
                else {
                    System.out.println("No admin is logged in!");
                }
            }
        
            if (checkLoggedInUser()) {
                // SEARCH RESTAURANT <REST NAME>
                if (command.contains("SEARCH RESTAURANT")) {
                    String name = inputs[2] , foodtype = "";
                    int f = 0;

                    Statement st = connectDB.createStatement();
                    ResultSet r = st.executeQuery("SELECT * FROM restaurants");

                    try {
                        while(r.next()) {
                            if (r.getString(1).equals(name)) {
                                f++;
                                foodtype = r.getString(6);
                                break;
                            }
                        }

                    } catch (Exception e) {
                        System.out.println("Restaurant list is empty");
                    }

                    if (f == 1) {
                        System.out.println("Restaurant " + name + " with food type of " + foodtype + " is found!");
                    }

                    else {
                        System.out.println("No Restaurant Found!");
                    }
                }

                // SEARCH FOOD <FOOD NAME>
                else if(command.contains("SEARCH FOOD")) {
                    String name = inputs[2];
                    int f = 0;

                    Statement s = connectDB.createStatement();
                    ResultSet r = s.executeQuery("SELECT * FROM restaurants;");

                    try {
                        while(r.next()) {
                            if (r.getString(2).equals(name)) {
                                f++;
                                System.out.println(r.getString(1) + " : " + r.getString(3));
                            }
                        }

                    } catch (Exception e) {
                        System.out.println("Restaurant list is empty");
                    }

                    if (f == 0) {
                        System.out.println("No such food exists!");
                    }
                }

                // SELECT FOOD <REST NAME> <FOOD NAME>
                else if(command.contains("SELECT FOOD")) {
                    int idx = select(User.restaurants , inputs[2]) , id = -1;

                    if (idx == -1) {
                        System.out.println("No restaurant found!");
                    }
                    else {
                        selRest = User.restaurants.get(idx);
                        for(int i = 0; i < selRest.foods.size() ; i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food avaliable!");
                        }

                        else {
                            selFood = selRest.foods.get(id);
                            System.out.println("Food selected succesfully!");
                        }
                    }
                }

                // ADD NEW COMMENT <COMMENT>
                else if(command.contains("ADD NEW COMMENT")) {
                    if (selFood == null) {
                        System.out.println("No food selected!");
                    }

                    else {
                        selFood.comments.put(cID, textModifier(command, 3));
                        cID++;
                        System.out.println("Comment added succesfully!");
                    }
                }

                // EDIT COMMENT <COMMENT ID> <COMMENT>
                else if(command.contains("EDIT COMMENT")) {
                    if (selFood == null) {
                        System.out.println("No food selected!");
                    }
                    else if (!selFood.comments.containsKey(Integer.parseInt(inputs[2]))) {
                        System.out.println("Invalid Comment ID!");
                    }

                    else {
                        selFood.comments.remove(Integer.parseInt(inputs[2]));
                        selFood.comments.put(Integer.parseInt(inputs[2]), textModifier(command , 3));
                        System.out.println("Comment edited successfully!");
                    }
                }

                // SUBMIT RATING <RATING>
                else if(command.contains("SUBMIT RATING")) {
                    if (selFood == null) {
                        System.out.println("No food selected!");
                    }
                    else {
                        if (selFood.rating.containsKey(username)) {
                            System.out.println("This user rated before!");
                        }
                        else {
                            selFood.rating.put(username, Double.parseDouble(inputs[2]));
                            System.out.println("Rating added succesfully!");
                        }
                    }
                }

                // EDIT RATING <RATING>
                else if(command.contains("EDIT RATING")) {
                    if (selFood == null) {
                        System.out.println("No food selected!");
                    }
                    else {
                        if (!selFood.rating.containsKey(username)) {
                            System.out.println("This user did not rate before!");
                        }
                        else {
                            selFood.rating.put(username, Double.parseDouble(inputs[2]));
                            System.out.println("Rating edited succesfully!");
                        }
                    }
                }

                else if(command.equals("DISPLAY RATING")) {
                    if (selFood == null) {
                        System.out.println("No food selected!");
                    }
                    else {
                        double rate = 0;
                        for(Map.Entry<String , Double> e : selFood.rating.entrySet()) {
                            rate += e.getValue();
                        }

                        System.out.println("Average Rating : " + (rate / (double) selFood.rating.size()) );
                    }
                }

                else if(command.equals("ADD THIS FOOD TO CART")) {
                    if (selFood == null) {
                        System.out.println("No food selected!");
                    }

                    else if(selFood.numFoodAvailable == 0) {
                        System.out.println("Selected food in currently unavailable");
                    }

                    else {
                        User.user.get(User.nameToIndex(username)).cart.add(selFood);
                        System.out.println("Selected food added to the cart!");                                
                    }
                }

                else if(command.equals("CONFIRM ORDER")) {
                    if (selFood == null) {
                        System.out.println("Selected food error!");
                    }

                    else if(User.user.get(User.nameToIndex(username)).cart.isEmpty()) {
                        System.out.println("Nothing in cart to be confirmed!");
                    }

                    else if (selFood.foodPrice > User.user.get(User.nameToIndex(username)).charge) {
                        System.out.println("Not enough charge to buy this product!");
                    }

                    else {
                        User.user.get(User.nameToIndex(username)).charge -=  selFood.foodPrice;
                        User.user.get(User.nameToIndex(username)).orders.add(selFood);
                        User.user.get(User.nameToIndex(username)).cart.remove(selFood);
                        selRest.order.put(username, selFood);
                        System.out.println(selRest.restaurantName);
                        System.out.println("Order confirmed and added the restaurant order list!");
                    }
                }

                else if(command.equals("ACCESS ORDER HISTORY")) {
                    System.out.println("Open Orders : ");
                    for (Map.Entry<String , Food> e : selRest.order.entrySet()) {
                        if (e.getKey().equals(username)) {
                            System.out.println("- " + e.getValue().foodName);
                        }
                    }

                    System.out.println("Delivered Orders : ");
                    for (Map.Entry<String , String> e : selRest.orderSent.entrySet()) {
                        if (e.getKey().equals(username)) {
                            System.out.println(e.getValue());
                        }
                    }
                }

                // SELECT ORDER <FOOD NAME>
                else if(command.contains("SELECT ORDER")) {
                    int fl = 0 , idx =  0;

                    for (int i = 0; i < User.user.get(User.nameToIndex(username)).orders.size(); i++) {
                        if (User.user.get(User.nameToIndex(username)).orders.get(i).foodName.equals(inputs[2])) {
                            fl++;
                            idx = i;
                            break;
                        }
                    }

                    if (fl == 0) {
                        System.out.println("No such order found!");
                    }

                    else {
                        Food currentFood = User.user.get(User.nameToIndex(username)).orders.get(idx);
                        order_id = idx;

                        System.out.println("Food Name : " + currentFood.foodName);
                        System.out.println("Food Price : " + currentFood.foodPrice );
                        System.out.println("Restaurant Name : " + currentFood.restaurantName);
                    }
                }

                // Sent or NotSent was not added!
                else if(command.equals("DISPLAY CART STATUS")) {
                    User currentUser = User.user.get(User.nameToIndex(username));

                    if (currentUser.cart.isEmpty()) {
                        System.out.println("No orders yet!");
                    }

                    else {
                        System.out.println("Not Confirmed Orders :");
                        
                        for (int i = 0; i < currentUser.cart.size(); i++) {
                            System.out.println(i + ". " + currentUser.cart.get(i).foodName);
                        }
                    }
                }

                else if(command.equals("SHOW ESTIMATED DELIVERY TIME")) {
                    System.out.println(User.user.get(User.nameToIndex(username)).cart.get(order_id));
                }

                // CHARGE ACCOUNT <AMOUNT $>
                else if(command.contains("CHARGE ACCOUNT")) {
                    String chr = "";

                    for (int i = 0; i < inputs[2].length(); i++) {
                        chr += inputs[2].charAt(i);
                    }

                    User.user.get(User.nameToIndex(username)).charge = Double.parseDouble(chr);
                    System.out.println("Account charged successfully!");
                }

                else if(command.equals("DISPLAY ACCOUNT CHARGE")) {
                    System.out.println("Account Credit : " +  User.user.get(User.nameToIndex(username)).charge + "$");
                } 
            }
        
            else if(checkLoggedInAdmin()) {
                Restaurants restaurant = null;
                String restaurantName = "" , restaurantType = "" ,  deliverName = "";;
                double node1 = 0 , node2 = 0 , wEdge = 0;

                if(command.contains("ADD RESTAURANT"))
                {
                    restaurantName = inputs[2];
                    restaurantType = inputs[3];

                    if(Restaurants.checkRestaurantName(restaurantName))
                    {
                        System.out.println("RestaurantName format invalid");
                    } else if (Admin.admin.get(Admin.nameToIndex(username)).restNameToIndex(username) != -1)
                    {
                        System.out.println("RestaurantName already taken!\nPlease try a new one!");
                    } else if(FoodType.foodType(restaurantType).equals("Null")) {
                        System.out.println("Invalid FoodType!");
                    }
                    else {
                        
                        System.out.println("Restaurant type has been successfully registered!");
                        System.out.println("Please enter the first node of the restaurant location!");
                        
                        node1=myscanner.nextDouble();
                        System.out.println("The first node of your restaurant has been registered successfully!\n" +
                                "Please enter the second node of the restaurant location!");
                        
                        node2= myscanner.nextDouble();
                        System.out.println("The second node of your restaurant has been registered successfully!\n" +
                                "Please enter the weight of the edge of the restaurant");
                        
                        wEdge=myscanner.nextDouble();
                        System.out.println("The weight of the edge of your restaurant has been registered successfully!");

                        System.out.println("Please enter the name of the delivery of your restaurant!");
                        
                        deliverName=myscanner.next();
                        System.out.println("The delivery of your restaurant has been registered successfully\n" +
                                "Please enter the price of your delivery per Km !");
                        double deliveryPerKm;
                        deliveryPerKm= myscanner.nextDouble();


                        String n1 = Double.toString(node1) , n2 = Double.toString(node2);

                        restaurant = new Restaurants(restaurantName, restaurantType, corrRestaurant, username, corrAdmin,
                         node1, node2, wEdge, deliverName, deliveryPerKm);

                        Admin.admin.get(Admin.nameToIndex(username)).restaurants.add(restaurant);
                        User.restaurants.add(restaurant);
                        
                        PreparedStatement pstm1 = connectDB.prepareStatement("UPDATE admin SET restaurant='" + restaurantName + "' WHERE name='" + username + "' ;");
                        PreparedStatement ptsm2 = connectDB.prepareStatement("INSERT INTO restaurants (name, food_name, food_price, ID , location, food_type, owner, numberAv) VALUES ('"
                        + restaurantName + "', '?' , '?', " + corrRestaurant + ", '" + n1 + ":" + n2 + "', '" + restaurantType + "', '" + username + "',  25);"); 
                        
                        pstm1.execute();
                        ptsm2.execute();
                        
                        
                        corrRestaurant++;
                        System.out.println("Dear "+username+" ,Your restaurant with the name "+restaurantName+" has been registered successfully!");
                    }
                }
                
                // EDIT LOCATION <NAME>
                else if(inputs[0].equals("EDIT")&&inputs[1].equals("LOCATION"))
                {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]);
                    if (idx == -1) {
                        System.out.println("Select a Restaurant first!");
                    }

                    else {
                        double newNode1;
                        double newNode2;
                        double newWEdge;
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        
                        System.out.println("Please enter the new first node!");
                        newNode1=myscanner.nextDouble();
                        System.out.println("Please enter the new second node!");
                        newNode2=myscanner.nextDouble();
                        System.out.println("Please enter the new weight of the node!");
                        newWEdge= myscanner.nextDouble();
                        
                        if (newNode1 == selRest.node1 && newNode2 == selRest.node2 && newWEdge == selRest.wEdge) {
                            System.out.println("Restaurant location did not change! ");
                        }
    
                        else {
                            PreparedStatement pts = connectDB.prepareStatement("UPDATE restaurants SET location='" + newNode1 + ":" + newNode2 + "' WHERE (owner='" 
                            + username + "' AND name='" + inputs[2] + "') ;");
                            pts.execute();

                            System.out.println("Your restaurant location has changed successfully.");
                            selRest.editLocation(corrRestaurant, newNode1, newNode2, newWEdge);
                        }
                    }
                }

                // SHOW LOCATION <NAME>
                else if (inputs[0].equals("SHOW")&&inputs[1].equals("LOCATION")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]);

                    if (idx == -1) {
                        System.out.println("Select a restaurant first!");
                    }

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);

                        if (selRest.restaurantName.equals("")) {
                            System.out.println("Select a Restaurant first!");
                        }
                        
                        else {
                                System.out.println("The location of the restaurant "+selRest.restaurantName+" ,\n" +
                                    "First node : "+selRest.node1+"\n" +
                                    "Second node : "+selRest.node2+"\n"+
                                    "Weight of the edge : "+selRest.wEdge+"\n");
                        }
                    }
                }
           
                // SHOW FOODTYPE <NAME>
                else if(inputs[0].equals("SHOW")&&inputs[1].equals("FOODTYPE"))
                {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]);
                    selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                    
                    System.out.println("The restaurant "+selRest.restaurantName+"'s food type is "+selRest.restaurantType);
                }

                // EDIT FOODTYPE <NAME> <FOODTYPE>
                else if(inputs[0].equals("EDIT")&&inputs[1].equals("FOODTYPE"))
                {
                    String newFoodType = inputs[3];
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]);

                    if (idx == -1) {
                        System.out.println("Restaurant Not Found!");
                    }
                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        
                        if (newFoodType.equals(selRest.getRestaurantType()))
                        {
                            System.out.println("Restaurant type is already "+newFoodType);
                        }
                        else {
                            System.out.print("ARE YOU SURE YOU WANT TO CHANGE YOUR RESTAURANT TYPE (Y/N): ");
                            String answer=myscanner.next();
                            if (answer.equals("N"))
                            {
                                System.out.println("Edition failed");
                            }
                            else if(answer.equals("Y"))
                            {
                                PreparedStatement pst = connectDB.prepareStatement("UPDATE restaurants SET food_type='" + newFoodType + 
                                "' WHERE (name='" + inputs[2] + "' AND owner='" + username + "') ;" );
                                pst.execute();

                                System.out.println("Your restaurant food type has been changed to "+newFoodType
                                        +" successfully!");
                                selRest.editFoodType(corrRestaurant,newFoodType);
                            }
                        }
                    }
                }

                else if(command.equals("SHOW RESTAURANTS")) {
                    int i = 1;
                    for (Restaurants rest : Admin.admin.get(Admin.nameToIndex(username)).restaurants) {
                        System.out.print(i + ". ");
                        System.out.println(rest.restaurantName + " " + rest.restaurantType);
                        i++;
                    }
                }

                // ADD FOOD <RES NAME> <FOOD NAME>
                else if(inputs[0].equals("ADD")&&inputs[1].equals("FOOD"))
                {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]);
                    if (idx == -1) {
                        System.out.println("No Restaurant Found!");
                    }
                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
    
                        if (selRest.restaurantName.equals("")) {
                            System.out.println("Select one of your restaurants please");
                        }
    
                        else {
                            String foodName;
                            double foodPrice;
                            double discount = 0.0;
                            foodName=inputs[3];
                            System.out.println("Enter Food Price: ");
                            foodPrice=myscanner.nextDouble();
    
                            System.out.println("Please enter thr number of discount for the food "+ foodName+"\n" +
                                    "If this food does not contain any discount , you can enter 0 instead!");
                            
                            discount = myscanner.nextDouble();
                            System.out.println("Please enter the number of food "+foodName+" available in your restaurant!");
                            int numAvailableFood;
                            numAvailableFood=myscanner.nextInt();
                            Food food=new Food(foodName,restaurantType,corrFood,foodPrice,discount, restaurantName,username,corrRestaurant,20 , numAvailableFood);
                            corrFood++;
                            selRest.foods.add(food);

                            PreparedStatement pts = connectDB.prepareStatement("UPDATE restaurants SET food_name='" + inputs[3] + 
                                "', food_price='" + foodPrice + "', ID=" + corrFood +" WHERE (name='" + inputs[2] + "' AND owner='" + username + "') ;");
                            pts.execute();

                            System.out.println("Food "+foodName+" added to restaurant successfully!");
                        }
                    }
                }

                // EDIT FOOD NAME <RES NAME> <FOOD NAME> <NEW FOOD NAME> 
                else if(command.contains("EDIT FOOD NAME"))
                {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[3]);
                    if (idx == -1) {
                        System.out.println("No Restaurant found!");
                    }

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        String foodname = inputs[4];
                        String newFoodName=inputs[5];
                        
                        if (foodname.equals(newFoodName)) {
                            System.out.println("Food name did not change!");
                        }
                        else {
                            for(int i = 0 ; i < selRest.foods.size() ; i++) {
                                if (selRest.foods.get(i).foodName.equals(foodname)) {
                                    selRest.foods.get(i).foodName = newFoodName;
                                    break;
                                }
                            }

                            PreparedStatement st = connectDB.prepareStatement("UPDATE restaurants SET food_name='" + newFoodName + "' WHERE (name='" + inputs[3] +
                            "' AND owner='" + username + "') ;");
                            st.execute();

                            System.out.println("Food name changed succesfully!");
                        }
                    }
                }

                // EDIT FOOD PRICE <RES NAME> <FOOD NAME> <NEW FOOD PRICE>
                else if(command.contains("EDIT FOOD PRICE"))
                {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[3]);
                    if (idx == -1) {
                        System.out.println("No Restaurant found!");
                    }
                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);

                        double newPrice = Double.parseDouble(inputs[5]);

                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[4])) {
                                if (selRest.foods.get(i).foodPrice == newPrice) {
                                    System.out.println("Price did not change!");
                                    break;
                                }

                                else {
                                    selRest.foods.get(i).foodPrice = newPrice;
                                    break;
                                }
                            }
                        }
                        PreparedStatement st = connectDB.prepareStatement("UPDATE restaurants SET food_price='" + inputs[5] + "' WHERE (name='" + inputs[3] +
                            "' AND owner='" + username + "' AND name='" + inputs[5] + "') ;");
                        st.execute();

                        System.out.println("Price Changed succesfully!");
                    }
                }

                // SHOW ORDER HISTORY <RES NAME>
                else if(command.contains("SHOW ORDER HISTORY")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[3]);
                    if (idx == -1) {
                        System.out.println("No Restaurant found!");
                    }
                    
                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);

                        if (selRest.order.isEmpty()) {
                            System.out.println("No orders to this restaurant yet!");
                        } 
    
                        else {
                            for(Map.Entry<String , Food> e : selRest.order.entrySet()) {
                                System.out.println(e.getKey() + " : " + e.getValue().foodName);
                            }
    
                            if (!selRest.orderSent.isEmpty()) {
                                System.out.println("Sent orders: ");

                                for(Map.Entry<String , String> e : selRest.orderSent.entrySet()) {
                                    System.out.println(e.getKey() + " : " + e.getValue());
                                }
                            }
                        }
                    }
                }

                // TODO : NOT TESTED FROM HERE!
                // EDIT ORDER <REST NAME> <USER> STATUS SENT
                else if(command.contains("EDIT ORDER")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]);
                    if (idx == -1) {
                        System.out.println("No Restaurant Found!");
                    }
                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);

                        if (selRest.order.isEmpty()) {
                            System.out.println("No orders to this restaurant yet!");
                        }
    
                        else if(!selRest.order.containsKey(inputs[3])) {
                            System.out.println("No order found!");
                        }
    
                        else {
                            selRest.orderSent.put(inputs[3], selRest.order.get(inputs[3]).foodName);
                            selRest.order.remove(inputs[3]);
                        }
                    }
                }

                // DISPLAY OPEN ORDERS <REST NAME>
                else if(command.equals("DISPLAY OPEN ORDERS")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[3]);
                    if (idx == -1) {
                        System.out.println("No Restaurant found!");
                    }

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        if (selRest.order.isEmpty()) {
                            System.out.println("No orders to this restaurant yet!");
                        }
    
                        else {
                            for(Map.Entry<String , Food> e : selRest.order.entrySet()) {
                                System.out.println(e.getKey() + " : " + e.getValue().foodName);
                            }
                        }
                    }
                }

                // All orders will be added to orders hashmap then if an order is sent , it will be added to orderSent hashmap
                // and be deleted from orders hashmap
                // EDIT RESPONSE <REST NAME> <FOOD NAME> <COMMENT ID> <COMMENT>
                else if(command.contains("EDIT RESPONSE")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]) , id = -1;
                    String cmd = textModifier(command , 5);

                    if (idx == -1) {
                        System.out.println("No Restaurant selected!");
                    }

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                                break;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food avaliable for this restaurant!");
                        }

                        else {
                            if (!selRest.foods.get(id).responseChecker(commID)) {
                                System.out.println("Invalid Comment ID!");
                            }

                            else {
                                selRest.foods.get(id).response.remove(comdid);
                                selRest.foods.get(id).response.put(comdid, cmd);

                                PreparedStatement st = connectDB.prepareStatement("UPDATE restaurants SET response='" + textModifier(command, 5) 
                                + "' WHERE (name='" + inputs[2] + "' AND food_name='" + inputs[3] + "') ;"); 
                                st.execute();

                                System.out.println("Response edited!");
                            }
                        }
                    }
                }

                // ADD NEW RESPONSE <REST NAME> <FOOD NAME> <COMMENT ID> <MESSAGE>
                else if(command.contains("ADD NEW RESPONSE")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[3]) , id = -1;
                    comdid = Integer.parseInt(inputs[5]); // id of the comment
                    
                    if (idx == -1) {
                        System.out.println("No such restaurant!");
                    }
                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[4])) {
                                id = i;
                                break;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food avaliable for this restaurant!");
                        }
                        else {
                            PreparedStatement st = connectDB.prepareStatement("UPDATE restaurants SET response='" + textModifier(command, 6) 
                            + "' WHERE (name='" + inputs[3] + "' AND food_name='" + inputs[4] + "') ;"); 
                            st.execute();

                            selRest.foods.get(id).response.put(comdid, textModifier(command, 6));
                            System.out.println("Response Added!");
                        }
                    }
                }

                // DISPLAY RESPONSES <REST NAME> <FOOD NAME>
                else if(command.contains("DISPLAY RESPONSES")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]) , id = -1;
                    if (idx == -1) {
                        System.out.println("No restaurant found!");
                    }

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                                break;
                            }
                        }

                        if(id == -1) {
                            System.out.println("No such food found!");
                        }
                        else {
                            if (selRest.foods.get(id).response.isEmpty()) {
                                System.out.println("No comment recorded for this food!");
                            }

                            else {
                                for (int i = 0; i < selRest.foods.get(id).response.size(); i++) {
                                    System.out.print(i + ".");
                                    System.out.println(selRest.foods.get(id).response.get(i));
                                }
                            }
                        }
                    }
                }

                // DISPLAY COMMENTS <REST NAME> <FOOD NAME>
                else if(command.contains("DISPLAY COMMENTS")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]) , id = -1;
                    if (idx == -1) {
                        System.out.println("No Such restaurant found!");    
                    } 
                    
                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                                break;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food avaliable!");
                        }
                        else {
                            if (selRest.foods.get(id).comments.isEmpty()) {
                                System.out.println("No comment recorded for this food!");
                            }

                            else {
                                for (int i = 0; i < selRest.foods.get(id).comments.size(); i++) {
                                    System.out.print(i + ".");
                                    System.out.println(selRest.foods.get(id).comments.get(i));
                                }
                            }
                        }
                    }
                }

                // ADD COMMENT <REST NANE> <FOOD NAME>  <COMMENT>
                else if(command.contains("ADD COMMENT")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]) , id = -1;
                    if (idx == -1) {
                        System.out.println("No Such restaurant found!");    
                    } 

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                                break;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food avaliable!");
                        }

                        else {
                            selRest.foods.get(id).comments.put(comment_id, textModifier(command, 4));
                            comment_id++;

                            PreparedStatement st = connectDB.prepareStatement("INSERT INTO restaurants (name, food_name, comments) VALUES ('" + inputs[2] + "', '" + 
                            inputs[3] + "', '" + textModifier(command , 4) + "') ;");
                            st.execute();

                            System.out.println("Comment added successfully!");
                        }
                    }
                }

                // DISLAY RATING <REST NAME> <FOOD NAME>
                else if (command.equals("DISPLAY RATINGS")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]) , id = -1;
                    if (idx == -1) {
                        System.out.println("No Such restaurant found!");    
                    } 

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                                break;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food avaliable!");
                        }

                        else {
                            for(Map.Entry<String , Double> e : selRest.foods.get(id).rating.entrySet()) {
                                System.out.println(e.getKey() + " : " + e.getValue());
                            }
                        }
                    }

                }
            
                // SHOW FOOD <REST NAME>
                else if(command.contains("SHOW FOOD")) {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]);
                    if (idx == -1) {
                        System.out.println("No Such restaurant found!");    
                    } 

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size() ; i++) {
                            System.out.println(i + ". " + selRest.foods.get(i).foodName + " : " + selRest.foods.get(i).foodPrice + " T");
                        }
                    }
                }

                // ACTIVATE FOOD <REST NAME> <FOOD NAME> 
                else if(inputs[0].equals("ACTIVATE")&&inputs[1].equals("FOOD"))
                {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]) , id = -1;
                    if (idx == -1) {
                        System.out.println("No Such restaurant found!");    
                    } 

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food!");
                        }

                        else {
                            if (selRest.foods.get(id).numFoodAvailable != 0) {
                                System.out.println("The food is already avaliable!");
                            }

                            else {

                                PreparedStatement st = connectDB.prepareStatement("UPDATE restaurants SET numberAv=" 
                                + 25 + " WHERE (name='" + inputs[2] + "' AND food_name='" + inputs[3] + "' ) ;");

                                st.execute();

                                selRest.foods.get(id).numFoodAvailable = 20; // initialy
                                System.out.println("food activated successfully!");
                            }
                        }
                    }   
                }

                // DEACTIVATE FOOD <REST NAME> <FOOD NAME>
                else if(inputs[0].equals("DEACTIVATE")&&inputs[1].equals("FOOD"))
                {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]) , id = -1;
                    if (idx == -1) {
                        System.out.println("No Such restaurant found!");    
                    } 

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food!");
                        }

                        else {
                            if (selRest.foods.get(id).numFoodAvailable == 0) {
                                System.out.println("The food is already unavaliable!");
                            }

                            else {

                                PreparedStatement st = connectDB.prepareStatement("UPDATE restaurants SET numberAv=" 
                                + 0 + " WHERE (name='" + inputs[2] + "' AND food_name='" + inputs[3] + "' ) ;");

                                st.execute();

                                selRest.foods.get(id).numFoodAvailable = 0;
                                System.out.println("food deactivated successfully!");
                            }
                        }
                    }   
                }

                // DISCOUNT FOOD <REST NAME> <FOOD NAME> 
                else if(inputs[0].equals("DISCOUNT")&&inputs[1].equals("FOOD"))
                {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]) , id = -1;
                    double dis , time;

                    if (idx == -1) {
                        System.out.println("No Such restaurant found!");    
                    } 

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food!");
                        }

                        else {
                            System.out.print("Enter discount amount (%): ");
                            dis = myscanner.nextDouble();
                            if (dis < 0 || dis > 50) {
                                System.out.println("discount amount invalid!");
                            }

                            else {
                                System.out.print("Enter discount time (min): ");
                                time = myscanner.nextDouble();

                                if (time < 0 || time > 60) {
                                    System.out.println("discount time invalid!");
                                }

                                else {

                                PreparedStatement st = connectDB.prepareStatement("UPDATE restaurants SET discount=" 
                                + dis + " WHERE (name='" + inputs[2] + "' AND food_name='" + inputs[3] + "' ) ;");

                                st.execute();

                                    selRest.foods.get(id).foodDiscount = dis;
                                    selRest.foods.get(id).timeDiscount = time;
                                    System.out.println("Discount amount and time successfuly set!");
                                }
                            }
                        }
                    }  
                }

                //  DELETE FOOD <REST NAME> <FOOD NAME>
                else if(inputs[0].equals("DELETE")&&inputs[1].equals("FOOD"))
                {
                    int idx = select(Admin.admin.get(Admin.nameToIndex(username)).restaurants , inputs[2]) , id = -1;

                    if (idx == -1) {
                        System.out.println("No Such restaurant found!");    
                    } 

                    else {
                        selRest = Admin.admin.get(Admin.nameToIndex(username)).restaurants.get(idx);
                        for (int i = 0; i < selRest.foods.size(); i++) {
                            if (selRest.foods.get(i).foodName.equals(inputs[3])) {
                                id = i;
                            }
                        }

                        if (id == -1) {
                            System.out.println("No such food!");
                        }

                        else {
                            System.out.println("Are you sure to delete this food? ");
                            String re = myscanner.nextLine();

                            if (re.equals("Y")) {
                                PreparedStatement st = connectDB.prepareStatement("DELETE FROM restaurants WHERE (food_name='" + inputs[3] + "' AND name='" + inputs[2] + "') ;");
                                st.execute();

                                selRest.foods.remove(id);
                                System.out.println("Food removed successfuly!");
                            }

                            else {
                                System.out.println("Deleting proccess failed!");
                            }
                        }
                    }
                }
            }

        }
        
        myscanner.close();
    }

    public static String textModifier(String text , int start) {
        String s = "";
        String[] parts = text.split(" ");

        for(int i = start; i < parts.length ; i++) {
            s += parts[i] + " ";
        }

        return s;
    }

    public static boolean checkLoggedInUser() throws Exception {
        int g = 0;
        
        DatabaseHandler handler = new DatabaseHandler();
        Connection connectDB = handler.getConnection();
        Statement checkLogged = connectDB.createStatement();
        ResultSet rs = checkLogged.executeQuery("SELECT * FROM user");

        while(rs.next()) {
            if (rs.getString(8).equals("1")) {
                g++;
                break;
            }
        }

        if (g == 1) {
            return true;
        }

        return false;
    }

    public static boolean checkLoggedInAdmin() throws Exception {
        int g = 0;
        
        DatabaseHandler handler = new DatabaseHandler();
        Connection connectDB = handler.getConnection();
        Statement checkLogged = connectDB.createStatement();
        ResultSet rs = checkLogged.executeQuery("SELECT * FROM admin");

        while(rs.next()) {
            if (rs.getString(8).equals("1")) {
                g++;
                break;
            }
        }

        if (g == 1) {
            return true;
        }

        return false;
    }

    public static int select(ArrayList <Restaurants> rest , String name) {
        int f = -1;
        for(int i = 0 ; i < rest.size() ; i++) {
            if(rest.get(i).restaurantName.equals(name)){
                f = i;
                break;
            }
        }

        return f;
    }
}