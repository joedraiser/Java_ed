package StoreInventory;

import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;

public class Store {
    Set<InventoryItem> inventory;
    NavigableSet<Cart> carts;
    Map<Product.Category, Product[]> aisleInventory;


}
