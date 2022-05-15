package oop.fridge;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class InventoryManager {
    private final Map<String, Queue<Product>> productsBySku;
    private final Map<String, Integer> quantityBySku;
    private final Map<String, List<CheckOutLog>> logsBySku;

    public InventoryManager() {
        this.productsBySku = new HashMap<>();
        this.quantityBySku = new HashMap<>();
        this.logsBySku = new HashMap<>();
    }

    public void checkIn(Product product) {
        String sku = product.getSku();
        if (!productsBySku.containsKey(sku)) {
            populateBySku(sku);
        }
        product.setChekInDate(Instant.now());

        quantityBySku.put(sku, quantityBySku.getOrDefault(sku, 0) + product.getQuantity());
        productsBySku.get(sku).add(product);
    }

    public void checkOut(String sku, int itemsRequested) {
        if (quantityBySku.get(sku) == null || quantityBySku.get(sku) == 0) {
            return;
        }

        Queue<Product> queue = productsBySku.get(sku);

        int itemsTakenCount = itemsRequested;
        while (itemsTakenCount != 0 && !queue.isEmpty()) {
            Product product = queue.poll();
            int itemsToTake = Math.min(product.getQuantity(), itemsRequested);
            itemsTakenCount -= itemsToTake;
            product.setQuantity(itemsToTake);

            if (product.getQuantity() > 0) {
                queue.add(product);
            }
        }

        if (!queue.isEmpty()) {
            productsBySku.put(sku, queue);
        }
        quantityBySku.put(sku, itemsRequested - itemsTakenCount);
        logsBySku.get(sku).add(new CheckOutLog(Instant.now(), sku, itemsRequested - itemsTakenCount));
    }

    private void populateBySku(String sku) {
        productsBySku.put(sku, new PriorityQueue<>(new ProductComparator()));
        logsBySku.put(sku, new ArrayList<>());
    }
}
