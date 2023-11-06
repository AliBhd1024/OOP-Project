import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Food {
    String foodName;
    String restaurantName;
    String restaurantOwner;
    int restaurantID;
    int restaurantOwnerID;
    int foodID;
    String foodType;
    double foodPrice;
    double foodDiscount;
    int foodTypeID;
    double timeDiscount;
    int numFoodAvailable;
    int numOrdered;

    private ArrayList<Food> food = new ArrayList<Food>();
    public HashMap<Integer , String> comments = new HashMap<>();
    public HashMap<Integer , String> response = new HashMap<>();
    public HashMap<String , Double> rating = new HashMap<>();

    // TODO : num ordered should be put in the main and class food

    // sea   id 1
    // fast  id 2

    public Food(String foodName,String foodType,int foodID,double foodPrice,double foodDiscount,
                String restaurantName,String restaurantOwner,int restaurantID,double timeDiscount,int numFoodAvailable)
    {
        this.foodName=foodName;
        this.foodID=foodID;
        this.foodPrice=foodPrice;
        this.foodType=foodType;
        this.foodDiscount=0;
        this.restaurantName=restaurantName;
        this.restaurantOwner=restaurantOwner;
        this.restaurantID=restaurantID;
        this.timeDiscount=timeDiscount;
        this.numFoodAvailable=numFoodAvailable;

    }
    public Food(String foodName,String foodType,int foodID,double foodPrice,
                String restaurantName,String restaurantOwner,int restaurantID,int numFoodAvailable)
    {
        this.foodName=foodName;
        this.foodID=foodID;
        this.foodPrice=foodPrice;
        this.foodType=foodType;
        this.restaurantName=restaurantName;
        this.restaurantOwner=restaurantOwner;
        this.restaurantID=restaurantID;
        this.numFoodAvailable=numFoodAvailable;

    }
    public Food(String foodName,String foodType,int foodID,double foodPrice,
                String restaurantName,String restaurantOwner,int restaurantID)
    {
        this.foodName=foodName;
        this.foodID=foodID;
        this.foodPrice=foodPrice;
        this.foodType=foodType;
        this.restaurantName=restaurantName;
        this.restaurantOwner=restaurantOwner;
        this.restaurantID=restaurantID;

    }

    public double getTimeDiscount() {
        return timeDiscount;
    }
    public void setTimeDiscount(double timeDiscount) {
        this.timeDiscount = timeDiscount;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getFoodDiscount() {
        return foodDiscount;
    }

    public void setFoodDiscount(double foodDiscount) {
        this.foodDiscount = foodDiscount;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodTypeID() {
        return foodTypeID;
    }

    public void setFoodTypeID(int foodTypeID) {
        this.foodTypeID = foodTypeID;
    }

    
    public ArrayList<Food> getFood() {
        return food;
    }
    
    public void setFood(ArrayList<Food> food) {
        this.food = food;
    }

    public int getRestaurantOwnerID() {
        return restaurantOwnerID;
    }

    public void editFoodName(int FoodID,String newName)
    {
        this.food.get(FoodID-1).foodName=newName;
    }

    public void editFoodPrice(int FoodID,double newFoodPrice)
    {
        this.food.get(FoodID-1).foodPrice=newFoodPrice;
    }

    public void deleteFood(int foodID) {
        for (int i=0;i<this.food.size();i++)
        {
            if (this.food.get(i).getFoodID()==foodID)
            {
                this.food.remove(i);
            }
        }
    }

    // DISCOUNT FOOD <FOOD ID> <DISCOUNT PERCENT> <TIMESTAMP>

    public void setRestaurantOwner(String restaurantOwner) {
        this.restaurantOwner = restaurantOwner;
    }

    public boolean responseChecker(int id) {
        for (Map.Entry<Integer , String> e : response.entrySet()) {
            if (e.getKey() == id) {
                return true;
            }
        }

        return false;
    }
}
