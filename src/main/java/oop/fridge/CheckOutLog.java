package oop.fridge;

import java.time.Instant;

public class CheckOutLog {
    private Instant checkOutDate;
    private String sku;
    private int quantity;

    public CheckOutLog(Instant checkOutDate, String sku, int quantity) {
        this.checkOutDate = checkOutDate;
        this.sku = sku;
        this.quantity = quantity;
    }

    public Instant getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Instant checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
