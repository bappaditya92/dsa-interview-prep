import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Scenarios02 {

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order(1, "Rahul", "Laptop", 70000),
                new Order(2, "Rahul", "Mouse", 1000),
                new Order(3, "Amit", "Keyboard", 2000),
                new Order(4, "Neha", "Laptop", 70000),
                new Order(5, "Amit", "Monitor", 15000),
                new Order(6, "Rahul", "Monitor", 15000)
        );

        // 271 Total Revenue
        double revenue = orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();

        System.out.println(revenue);

        // 272 Revenue By Customer
        Map<String, Double> revenueByCustomer =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.summingDouble(
                                        Order::getAmount)));

        System.out.println(revenueByCustomer);

        // 273 Highest Spending Customer
        revenueByCustomer.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 274 Lowest Spending Customer
        revenueByCustomer.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 275 Product Sales Count
        Map<String, Long> productCount =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getProduct,
                                Collectors.counting()));

        System.out.println(productCount);

        // 276 Most Sold Product
        productCount.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 277 Least Sold Product
        productCount.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 278 Customer -> Products
        Map<String, List<String>> customerProducts =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.mapping(
                                        Order::getProduct,
                                        Collectors.toList())));

        System.out.println(customerProducts);

        // 279 Product -> Revenue
        Map<String, Double> productRevenue =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getProduct,
                                Collectors.summingDouble(
                                        Order::getAmount)));

        System.out.println(productRevenue);

        // 280 Highest Revenue Product
        productRevenue.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 281 Orders Above Average Value
        double avg =
                orders.stream()
                        .mapToDouble(Order::getAmount)
                        .average()
                        .orElse(0);

        orders.stream()
                .filter(o -> o.getAmount() > avg)
                .forEach(System.out::println);

        // 282 Orders Below Average Value
        orders.stream()
                .filter(o -> o.getAmount() < avg)
                .forEach(System.out::println);

        // 283 Sort Orders By Amount Desc
        orders.stream()
                .sorted(
                        Comparator.comparing(
                                Order::getAmount)
                                .reversed())
                .forEach(System.out::println);

        // 284 Top 3 Orders
        orders.stream()
                .sorted(
                        Comparator.comparing(
                                Order::getAmount)
                                .reversed())
                .limit(3)
                .forEach(System.out::println);

        // 285 Customer Order Count
        Map<String, Long> customerOrderCount =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.counting()));

        System.out.println(customerOrderCount);

        // 286 Repeat Customers
        customerOrderCount.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .forEach(System.out::println);

        // 287 Unique Customers
        orders.stream()
                .map(Order::getCustomer)
                .distinct()
                .forEach(System.out::println);

        // 288 Product Name Length Map
        Map<String,Integer> productLength =
                orders.stream()
                        .map(Order::getProduct)
                        .distinct()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                String::length));

        System.out.println(productLength);

        // 289 Partition Expensive Orders
        Map<Boolean,List<Order>> partition =
                orders.stream()
                        .collect(Collectors.partitioningBy(
                                o -> o.getAmount() > 10000));

        System.out.println(partition);

        // 290 Revenue Statistics
        DoubleSummaryStatistics stats =
                orders.stream()
                        .collect(Collectors.summarizingDouble(
                                Order::getAmount));

        System.out.println(stats);
    }
}

class Order {

    private int id;
    private String customer;
    private String product;
    private double amount;

    public Order(int id,
                 String customer,
                 String product,
                 double amount) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return customer + " - " +
               product + " - " +
               amount;
    }
}
