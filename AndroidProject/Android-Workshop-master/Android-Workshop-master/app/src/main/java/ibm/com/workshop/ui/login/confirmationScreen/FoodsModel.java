package ibm.com.workshop.ui.login.confirmationScreen;

public class FoodsModel {
    public int foodImage;
    public String foodName;

    public FoodsModel(int foodImage, String foodName) {
        this.foodImage = foodImage;
        this.foodName = foodName;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
