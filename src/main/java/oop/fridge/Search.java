package oop.fridge;

import java.util.List;

public interface Search {
    List<Product> searchProductsByName(String name);
    List<Product> searchProductsByCategory(ProductCategory category);
}
