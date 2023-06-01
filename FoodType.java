public enum FoodType {
    SeaFood,FastFood,Drinks,FruitVegetable,SweetCandy, Dessert,CoffeeShop,IranianFood,ItalianFood,ChineseFood,
    SuperMarket,CustomFood,PetShop;
    FoodType() {
    }
    static FoodType foodType(String FoodType) {
        if(FoodType.equals("SeaFood"))
            return SeaFood;
        if(FoodType.equals("FastFood"))
            return FastFood;
        if(FoodType.equals("Drinks"))
            return Drinks;
        if(FastFood.equals("FruitVegetable"))
            return FruitVegetable;
        if(FoodType.equals("SweetCandy"))
            return SweetCandy;
        if(FoodType.equals("Dessert"))
            return Dessert;
        if(FoodType.equals("CoffeeShop"))
            return CoffeeShop;
        if(FoodType.equals("IranianFood"))
            return IranianFood;
        if(FoodType.equals("ItalianFood"))
            return ItalianFood;
        if(FoodType.equals("ChineseFood"))
            return ChineseFood;
        if(FoodType.equals("SuperMarket"))
            return SuperMarket;
        if(FoodType.equals("CustomFood"))
            return CustomFood;
        return PetShop;
    }
}