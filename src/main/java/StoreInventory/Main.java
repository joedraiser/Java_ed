package StoreInventory;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Product colgate = new Product("Colgate", "P&G", Product.Category.CHEMISTRY);
        Product bread = new Product("Bread", "local", Product.Category.FOOD);
        Cart cart = new Cart(new Date(),CartType.PHYSICAL);

        cart.addItem(colgate,1);
        cart.addItem(colgate, 2);
        cart.addItem(bread,1);
        cart.removeItem(colgate, 1);
        cart.printSalesSlip();
        cart.removeItem(colgate, 10);
        cart.printSalesSlip();
        return;
    }
}
