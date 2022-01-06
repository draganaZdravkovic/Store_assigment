import java.util.Date;

public abstract class Product {

    private String name, brand;
    private double price;
    protected int discount;

    public Product(String name, String brand, double price){
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public abstract void countDiscount();

    public abstract void setPurchaseDate(Date purchaseDate);

}
