import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int IDUser;
    static int IDAdmin;
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
                        } else {
                            Admin.adminState.put(username, 1);
                            System.out.println("Dear "+ username+"! You have been logged in successfully!");
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