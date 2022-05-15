package oop.fridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventorySearch implements Search {
    private final Map<String, List<Product>> productNames;
    private final Map<ProductCategory, List<Product>> productCategories;

    public InventorySearch() {
        this.productNames = new HashMap<>();
        this.productCategories = new HashMap<>();
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productNames.get(name);
    }

    @Override
    public List<Product> searchProductsByCategory(ProductCategory category) {
        return productCategories.get(category);
    }
}
