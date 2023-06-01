import java.util.ArrayList;

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
    private boolean available;
    private DiscountPro discount;
    private ArrayList<GetStar> star;
    private ArrayList<Comment> comment;





    // TODO num ordered should be put in the main and class food

    int numOrdered;


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

    public int getNumFoodAvailable() {
        return numFoodAvailable;
    }

    public void setNumFoodAvailable(int numFoodAvailable) {
        this.numFoodAvailable = numFoodAvailable;
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
    private static ArrayList<Food> food=new ArrayList<Food>();
    public static ArrayList<Food> getFood() {
        return food;
    }
    public static void setFood(ArrayList<Food>food)
    {
        Food.food = food;
    }
    public int getRestaurantOwnerID() {
        return restaurantOwnerID;
    }
    public static void editFoodName(int FoodID,String newName)
    {
        food.get(FoodID-1).foodName=newName;
    }
    public static void editFoodPrice(int FoodID,double newFoodPrice)
    {
        food.get(FoodID-1).foodPrice=newFoodPrice;
    }
//    public static void editComment(int commentID,int foodID,int restaurantID,String newComment)
//    {
//        food.get(foodID-1).comments=newComment;
//    }

    public static void deleteFood(int foodID) {
        for (int i=0;i<food.size();i++)
        {if (food.get(i).getFoodID()==foodID)
        {
            food.remove(i);
        }
        }
    }
    // DISCOUNT FOOD <FOOD ID> <DISCOUNT PERCENT> <TIMESTAMP>
    public void setRestaurantOwner(String restaurantOwner) {
        this.restaurantOwner = restaurantOwner;
    }
}
