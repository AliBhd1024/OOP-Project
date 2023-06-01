import java.util.ArrayList;
import java.util.HashMap;

public class Admin
{
    String username;
    String password;
    String confirmationPass;
    int ID;
    String phone;
    String gmail;
    int securityNo;
    String securityAns;
    private static ArrayList<Admin> admin=new ArrayList<Admin>();
    public static HashMap<String , Integer> adminState = new HashMap<>();

    Admin (String username,String password,int ID,String phone,String gmail,int securityNo,
           String securityAns)
    {
        this.username=username;
        this.password=password;
        this.ID=ID;
        this.phone=phone;
        this.gmail=gmail;
        this.securityNo=securityNo;
        this.securityAns=securityAns;
        admin.add(this);
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getConfirmationPass()
    {
        return confirmationPass;
    }
    public void setConfirmationPass(String confirmationPass)
    {
        this.confirmationPass=confirmationPass;
    }
    public static String pass(String username){
        int c=-1;
        for(int i=0;i<admin.size();i++){
            if(admin.get(i).getUsername().equals(username)){
                c=i;
            }
        }
        return admin.get(c).getPassword();
    }
    public static boolean Name(String username){
        for(int i=0;i<admin.size();i++){
            if(admin.get(i).username.equals(username)){
                return true;
            }
        }
        return false;
    }
    //password.length>=8
    //at least 1 dig in pass
    public static boolean Password(String password){
        int corr=0;
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)=='0'||password.charAt(i)=='1'||password.charAt(i)=='2'||password.charAt(i)=='3'||
                    password.charAt(i)=='4'||password.charAt(i)=='5'||password.charAt(i)=='6'||password.charAt(i)=='7'||password.charAt(i)=='8'||password.charAt(i)=='9'){
                corr++;
            }
        }
        if(corr==0||password.charAt(0)=='0'||password.charAt(0)=='1'||password.charAt(0)=='2'||password.charAt(0)=='3'||
                password.charAt(0)=='4'||password.charAt(0)=='5'||password.charAt(0)=='6'||password.charAt(0)=='7'||password.charAt(0)=='8'||password.charAt(0)=='9'||password.length()<8){
            return true;
        }
        return false;
    }
    public static void changePassword(int ID,String newPass){
        admin.get(ID-1).password=newPass;
    }
    public int getID()
    {
        return ID;
    }
    public void setID(int ID)
    {
        this.ID=ID;
    }
    public static int IDChecker(String ID){
        for(int i =0;i<admin.size();i++){
            if(admin.get(i).getUsername().equals(ID)){
                return admin.get(i).getID();
            }
        }
        return -1;
    }
    public static ArrayList<Admin> getAdmin() {
        return admin;
    }
    public static void setAdmin(ArrayList<Admin> admin) {
        Admin.admin = admin;
    }
    public static boolean checking(String username){
        for(int i=0;i<username.length();i++){
            if(username.charAt(i)==' '){
                return false;
            }
        }
        return true;
    }
    public static boolean checkName(String username){
        for(int i =0;i<username.length();i++){
            for (int j=0;j<10;j++)
            {
                if (username.charAt(i)==j)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public int AdminID() {
        return ID;
    }

    public void setAdminID(int ID) {
        this.ID = ID;
    }
}

