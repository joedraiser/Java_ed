package StoreInventory;

public class InventoryItem {
    Product product;
    Integer qtyTotal;
    Integer qtyReserved;
    Integer qtyReorder;
    Integer qtyLow;
    Double salesPrice;

    public InventoryItem(Product product, Integer qtyTotal, Integer qtyLow, Double salesPrice) {
        this.product = product;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.salesPrice = salesPrice;
        this.qtyReorder = 0;
        this.qtyReserved = 0;
    }

    public boolean reserveItem(Integer qtyReserved) {
        if((this.qtyReserved + qtyReserved) > qtyTotal)
            return false;
        else {
            this.qtyReserved = this.qtyReserved + qtyReserved;
            return true;
        }
    }

    public void releaseItem(Integer qtyReleased) {
        if (qtyReleased>=this.qtyReserved)
            this.qtyReserved = 0;
        else
            this.qtyReserved = this.qtyReserved - qtyReleased;
    }

    public void placeInventoryOrder(Integer qty) {
        this.qtyTotal = this.qtyTotal + qty;
    }

    public void sellItem() {
        this.qtyTotal = this.qtyTotal - this.qtyReserved;
        if (this.qtyTotal < this.qtyLow)
            placeInventoryOrder(2*this.qtyLow);
    }
}
