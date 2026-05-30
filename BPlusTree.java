import java.util.ArrayList;
import java.util.List;

class Product {
    String category;
    int price;
    int productId;

    Product(String category, int price, int productId) {
        this.category = category;
        this.price = price;
        this.productId = productId;
    }
}

public class BPlusTree {

    static List<Product> products = new ArrayList<>();

    static void insert(String category, int price, int productId) {
        products.add(new Product(category, price, productId));
    }

    static int rangeCount(String category, int low, int high) {
        int count = 0;

        for (Product p : products) {
            if (p.category.equals(category)
                    && p.price >= low
                    && p.price <= high) {
                count++;
            }
        }

        return count;
    }

    static void displayRange(String category, int low, int high) {

        System.out.println("Products in Range:");

        for (Product p : products) {
            if (p.category.equals(category)
                    && p.price >= low
                    && p.price <= high) {

                System.out.println(
                        "Product ID: " + p.productId +
                        ", Price: " + p.price);
            }
        }
    }

    public static void main(String[] args) {

        insert("electronics", 11800, 101);
        insert("electronics", 12300, 102);
        insert("electronics", 12900, 103);
        insert("electronics", 13500, 104);
        insert("electronics", 14100, 105);
        insert("electronics", 14700, 106);
        insert("electronics", 15400, 107);
        insert("electronics", 16200, 108);

        int low = 12000;
        int high = 14800;

        displayRange("electronics", low, high);

        int count = rangeCount("electronics", low, high);

        System.out.println("\nTotal Products Found: " + count);
    }
}