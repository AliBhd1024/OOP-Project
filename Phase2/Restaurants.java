import java.util.*;

public class Restaurants {
    String ownerName = "";
    int ownerID;
    String restaurantName = "";
    String restaurantType = "";
    int restaurantID;
    double node1;
    double node2;
    double wEdge;
    String deliveryName;
    double deliveryPricePerKm;
    ArrayList<Food> foods = new ArrayList<>();
    
    // USER : FOOD (ALL ORDERS)
    HashMap<String , Food> order = new HashMap<>();

    // USER : FOOD NAME (SENT ORDERS)
    HashMap<String , String> orderSent = new HashMap<>();

    public Restaurants(String restaurantName,String restaurantType,int restaurantID,
                       String ownerName,int ownerID,double node1,double node2,double wEdge,
                       String deliveryName,double deliveryPricePerKm)
    {
        this.restaurantName=restaurantName;
        this.restaurantType=restaurantType;
        this.restaurantID=restaurantID;
        this.ownerName=ownerName;
        this.ownerID=ownerID;
        this.node1=node1;
        this.node2=node2;
        this.wEdge=wEdge;
        this.deliveryName=deliveryName;
        this.deliveryPricePerKm=deliveryPricePerKm;
    }

    public Restaurants(){
        
    }



    public double getNode1() {
        return node1;
    }

    public void setNode1(double node1) {
        this.node1 = node1;
    }

    public double getNode2() {
        return node2;
    }

    public void setNode2(double node2) {
        this.node2 = node2;
    }

    public double getwEdge() {
        return wEdge;
    }

    public void setwEdge(double wEdge) {
        this.wEdge = wEdge;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    public String getRestaurantType()
    {
        return restaurantType;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public double getDeliveryPricePerKm() {
        return deliveryPricePerKm;
    }

    public void setDeliveryPricePerKm(double deliveryPricePerKm) {
        this.deliveryPricePerKm = deliveryPricePerKm;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }
    public String getOwnerName()
    {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public static boolean checkRestaurantName(String restaurantName){
        for(int i =0;i<restaurantName.length();i++){
            for (int j=0;j<10;j++)
            {
                if (restaurantName.charAt(i)==j)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void editLocation(int restaurantID,double node1new,double node2new,double wEdgenew){
        this.node1=node1new;
        this.node2=node2new;
        this.wEdge=wEdgenew;
    }

    public void editFoodType(int restaurantID,String newFoodType)
    {
        this.restaurantType=newFoodType;
    }
}
