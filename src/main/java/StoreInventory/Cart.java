package StoreInventory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private static int id = 1;

    private int cart_id;
    private Map<Product, Integer> products;
    Date date;
    CartType type;

    public Cart(Map<Product, Integer> products, Date date, CartType type) {
        cart_id = id++;
        this.products = products;
        this.date = date;
        this.type = type;
    }

    public Cart(Date date, CartType type) {
        this.date = date;
        this.type = type;
        products = new HashMap<>();
    }

    public void addItem(Product product, Integer quantity) {
        products.compute(product, (pkey, qval) ->
            qval = (qval==null) ? quantity : qval + quantity
        );
    }

    public void removeItem(Product product, Integer quantity) {
        products.compute(product, (pkey, qval) -> {
            if ( quantity>qval )
                return null;
            else
                return (qval - quantity);
        });
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", date=" + date +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        return cart_id == cart.cart_id;
    }

    @Override
    public int hashCode() {
        return cart_id;
    }

    public void printSalesSlip() {
        System.out.println("\n" + this);
        System.out.println("-----------------------------------");
        products.forEach((pname, pqty) -> System.out.println("%-80s : %3s".formatted(pname, pqty)));
        System.out.println("-----------------------------------");
    }
}
