import java.util.Date;

public class FoodBeverage extends Product{

    private Date expirationDate;
    private Date purchaseDate;

    public FoodBeverage(String name, String brand, double price, Date expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public void setPurchaseDate(Date purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }


    @Override
    public void countDiscount() {
        long difference = Math.abs((expirationDate.getTime()-purchaseDate.getTime())/86400000);

        if (difference > 0 && difference <= 5)
            super.discount = 10;
        else if (difference == 0)
            super.discount = 50;
        else
           super.discount = 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        return s.append(getName())
                .append(" ")
                .append(getBrand())
                .append('\n')
                .toString();

    }
}
