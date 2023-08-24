package StoreInventory;

import java.util.Objects;

public class Product {
    enum Category {
        FOOD, CHEMISTRY, DISHES, HOME_STUFF, FURNITURE
    }

    private static int id = 1;
    private int sku;
    private String name;
    private String manufacturer;
    private Category category;

    public Product(String name, String manufacturer, Category category) {
        this.sku = id++;
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku=" + sku +
                ", name='" + name +
                ", manufacturer='" + manufacturer +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return sku == product.sku;
    }

    @Override
    public int hashCode() {
        return sku;
    }
}
