package oop.fridge;

import java.time.Instant;
import java.util.Objects;

//TODO: Enhanced Comparator
public class Product  {
    private String id;
    private String sku;
    private String barcode;
    private ProductCategory category;
    private String name;
    private String description;
    private int quantity;
    private Instant expiryDate;
    private Instant chekInDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Instant getChekInDate() {
        return chekInDate;
    }

    public void setChekInDate(Instant chekInDate) {
        this.chekInDate = chekInDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return quantity == product.quantity &&
            id.equals(product.id) &&
            sku.equals(product.sku) &&
            barcode.equals(product.barcode) &&
            category == product.category &&
            Objects.equals(name, product.name) &&
            Objects.equals(description, product.description) &&
            expiryDate.equals(product.expiryDate) &&
            chekInDate.equals(product.chekInDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, barcode, category, name, description, quantity, expiryDate, chekInDate);
    }

    @Override
    public String toString() {
        return "Product{" +
            "id='" + id + '\'' +
            ", sku='" + sku + '\'' +
            ", barcode='" + barcode + '\'' +
            ", category=" + category +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", quantity=" + quantity +
            ", expiryDate=" + expiryDate +
            ", chekInDate=" + chekInDate +
            '}';
    }
}
