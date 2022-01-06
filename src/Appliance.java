import java.util.Calendar;
import java.util.Date;

public class Appliance extends Product{

    private String model;
    private Date productionDate, purchaseDate;
    private double weight;

    public Appliance(String name, String brand, double price, String model, Date productionDate, double weight) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    @Override
    public void countDiscount() {
        Calendar c = Calendar.getInstance();
        c.setTime(purchaseDate);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if((dayOfWeek==1 || dayOfWeek==7) && getPrice()>999)
            super.discount = 5;
        else
            super.discount = 0;
    }

    @Override
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        return s.append(getName())
                .append(" ")
                .append(getBrand())
                .append(" ")
                .append(getModel())
                .append('\n')
                .toString();
    }
}
