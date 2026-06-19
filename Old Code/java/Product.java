import java.util.*;

class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemTotal() {
        return product.getPrice() * quantity;
    }
}

class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void removeProduct(int productId) {
        items.removeIf(item ->
                item.getProduct().getProductId() == productId);
    }

    public void displayCart() {
        System.out.println("Cart Items:");
        for (CartItem item : items) {
            System.out.println(
                    item.getProduct().getName() +
                    " | Qty: " + item.getQuantity() +
                    " | Total: ₹" + item.getItemTotal()
            );
        }
    }

    public double calculateTotal() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getItemTotal();
        }

        if (total > 5000) {
            total = total * 0.90; // 10% discount
        }

        return total;
    }
}

public class Product {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 4500);
        Product p2 = new Product(102, "Mouse", 700);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(p1, 1);
        cart.addProduct(p2, 2);

        cart.displayCart();

        System.out.println("Final Bill: ₹" +
                cart.calculateTotal());
    }
}
