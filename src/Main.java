import java.util.Calendar;
import java.util.Date;


public class Main {

    public static void main(String[] args) {

        Calendar ed = Calendar.getInstance();
        ed.set(2021,5,14);
        Date expirationDate = ed.getTime();

        FoodBeverage apple = new FoodBeverage("Apple", "BrandA", 1.50,expirationDate);

        ed.set(2022, 1,2);
        expirationDate = ed.getTime();

        FoodBeverage milk = new FoodBeverage("Milk", "BrandM", 0.99,expirationDate);

        Clothes tshirt = new Clothes("T-shirt", "BrandT", 15.99, "M", "violet");

        Calendar pd = Calendar.getInstance();
        pd.set(2021,2,3);
        Date productionDate = pd.getTime();

        Appliance laptop = new Appliance("laptop", "BrandL", 2345, "ModelL", productionDate, 1.125);

        Calendar pdt = Calendar.getInstance();
        pdt.set(2021,5,14);
        Date purchaseDate = pdt.getTime();

        Cashier cart = new Cashier(purchaseDate, apple, laptop,apple,milk,tshirt,milk,milk,tshirt);

        cart.print();
    }
}
