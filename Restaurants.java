import java.util.*;
public class Restaurants {
    private static ArrayList<Restaurants> restaurant=new ArrayList<Restaurants>();


    String ownerName;
    int ownerID;
    String restaurantName;
    String restaurantType;
    int restaurantID;
    double node1;
    double node2;
    double wEdge;
    String deliveryName;
    double deliveryPricePerKm;
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
    public static ArrayList<Restaurants> getRestaurant() {
        return restaurant;
    }
    public static void setUser(ArrayList<Restaurants> restaurant) {
        Restaurants.restaurant = restaurant;
    }
    public  static boolean checkTakenRestaurant(String restaurantName){
        for(int i=0;i<restaurant.size();i++){
            if(restaurant.get(i).restaurantName.equals(restaurantName)){
                return true;
            }
        }
        return false;
    }
    public static void editLocation(int restaurantID,double node1new,double node2new,double wEdgenew){
        restaurant.get(restaurantID-1).node1=node1new;
        restaurant.get(restaurantID-1).node2=node2new;
        restaurant.get(restaurantID-1).wEdge=wEdgenew;
    }
    public static void editFoodType(int restaurantID,String newFoodType)
    {
        restaurant.get(restaurantID-1).restaurantType=newFoodType;
    }
    private ArrayList<Food> Menu;
    private ArrayList<Order> Order;



}
