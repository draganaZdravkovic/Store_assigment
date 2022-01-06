import java.util.*;

public class Cashier {


    private Map<Product, Integer> cart; //    Map to store all produce with number of their occurence
    private Date purchaseDate;

    public Cashier(Date purchaseDate, Product ... product){
        this.purchaseDate = purchaseDate;

        this.cart = new HashMap<>();

        for(Product p: product) {
            Integer numOccurence = cart.get(p);
            this.cart.put(p, (numOccurence == null) ? 1 : numOccurence+1);
        }

        for(Map.Entry<Product, Integer> p: cart.entrySet()){
            p.getKey().setPurchaseDate(purchaseDate);
        }
    }
//  Total sum for all products
    private double subtotal(Map<Product, Integer> cart) {
        double sum = 0;
        for(Map.Entry<Product, Integer> p: cart.entrySet()) {

            Product product = p.getKey();
            Integer numberOfProduct = p.getValue();

            sum += product.getPrice()*numberOfProduct;
        }
        return sum;
    }
//  sum of all discounts
    private double finalDiscount(Map<Product, Integer> cart){
        double sum = 0;
        for(Map.Entry<Product, Integer> p: cart.entrySet()) {

            Product product = p.getKey();
            Integer numberOfProduct = p.getValue();

            product.countDiscount();
            sum += (product.getPrice() * numberOfProduct) * (product.getDiscount() / 100.0);
        }
        return Math.round(sum*100.0)/100.0;
    }

//    sum to pay
    private double total(Map<Product,Integer> cart){
        return Math.round((subtotal(cart) - finalDiscount(cart))*100.0)/100.0;
    }

    public void print() {
        System.out.println("Date:" + purchaseDate + '\n' + "--Products--\n");

        StringBuilder s = new StringBuilder();

        for(Map.Entry<Product, Integer> p: cart.entrySet()) {

            Product product = p.getKey();
            Integer numberOfProduct = p.getValue();

            s.append(product.toString())
                    .append(numberOfProduct)
                    .append(" x $")
                    .append(product.getPrice()).append(" = $")
                    .append(Math.round(product.getPrice()*numberOfProduct*100.0)/100.0)
                    .append('\n');

            product.countDiscount();

            if(product.getDiscount() != 0)
                s.append("#discount ")
                        .append(product.getDiscount())
                        .append("% -$")
                        .append(Math.round((product.getPrice()*numberOfProduct)*product.getDiscount())/100.0);

            s.append("\n\n");
        }
        s.append("--------------------------------------------\n");
        s.append("SUBTOTAL: $")
                .append(subtotal(cart))
                .append("\nDISCOUNT: -$")
                .append(finalDiscount(cart))
                .append("\n\nTOTAL: $")
                .append(total(cart));

        System.out.println(s);
    }
}
