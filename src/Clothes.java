import java.util.Calendar;
import java.util.Date;

public class Clothes extends Product{

    private String size, color;
    private Date purchaseDate;

    public Clothes(String name, String brand, double price, String size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    @Override
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }


    @Override
    public void countDiscount() {
        Calendar c = Calendar.getInstance();
        c.setTime(purchaseDate);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek==2 || dayOfWeek==3 || dayOfWeek==4 || dayOfWeek==5 || dayOfWeek==6)
            super.discount = 10;
        else
            super.discount = 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        return s.append(getName())
                .append(" ")
                .append(getBrand())
                .append(" ")
                .append(getSize())
                .append(" ")
                .append(getColor())
                .append('\n')
                .toString();
    }
}
