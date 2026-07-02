import java.util.*;
import java.util.stream.Collectors;

public class Java8Scenarios05 {

    public static void main(String[] args) {

        List<Customer> customers = Arrays.asList(
                new Customer(1,"Rahul","Gold",85000),
                new Customer(2,"Amit","Silver",45000),
                new Customer(3,"Neha","Gold",95000),
                new Customer(4,"Priya","Platinum",150000),
                new Customer(5,"Ankit","Silver",55000),
                new Customer(6,"Pooja","Gold",65000)
        );

        // 331 Group Customers By Membership
        Map<String,List<Customer>> membership =
                customers.stream()
                        .collect(Collectors.groupingBy(
                                Customer::getMembership));

        System.out.println(membership);

        // 332 Membership Wise Customer Count
        Map<String,Long> count =
                customers.stream()
                        .collect(Collectors.groupingBy(
                                Customer::getMembership,
                                Collectors.counting()));

        System.out.println(count);

        // 333 Membership Wise Total Spending
        Map<String,Double> spending =
                customers.stream()
                        .collect(Collectors.groupingBy(
                                Customer::getMembership,
                                Collectors.summingDouble(
                                        Customer::getSpending)));

        System.out.println(spending);

        // 334 Membership Wise Average Spending
        Map<String,Double> avg =
                customers.stream()
                        .collect(Collectors.groupingBy(
                                Customer::getMembership,
                                Collectors.averagingDouble(
                                        Customer::getSpending)));

        System.out.println(avg);

        // 335 Highest Spending Customer
        customers.stream()
                .max(Comparator.comparing(
                        Customer::getSpending))
                .ifPresent(System.out::println);

        // 336 Lowest Spending Customer
        customers.stream()
                .min(Comparator.comparing(
                        Customer::getSpending))
                .ifPresent(System.out::println);

        // 337 Top 3 Customers
        customers.stream()
                .sorted(
                        Comparator.comparing(
                                Customer::getSpending)
                                .reversed())
                .limit(3)
                .forEach(System.out::println);

        // 338 Customers Above Average Spending
        double avgSpend =
                customers.stream()
                        .mapToDouble(Customer::getSpending)
                        .average()
                        .orElse(0);

        customers.stream()
                .filter(c -> c.getSpending() > avgSpend)
                .forEach(System.out::println);

        // 339 Membership With Highest Revenue
        spending.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 340 Customer Names By Membership
        Map<String,List<String>> names =
                customers.stream()
                        .collect(Collectors.groupingBy(
                                Customer::getMembership,
                                Collectors.mapping(
                                        Customer::getName,
                                        Collectors.toList()
                                )));

        System.out.println(names);

        // 341 Sort By Membership Then Spending
        customers.stream()
                .sorted(
                        Comparator.comparing(
                                Customer::getMembership)
                                .thenComparing(
                                        Customer::getSpending))
                .forEach(System.out::println);

        // 342 Membership Revenue Percentage
        double total =
                customers.stream()
                        .mapToDouble(Customer::getSpending)
                        .sum();

        spending.forEach((k,v) ->
                System.out.println(
                        k + " = " +
                        (v * 100 / total) + "%"
                ));

        // 343 Distinct Membership Types
        customers.stream()
                .map(Customer::getMembership)
                .distinct()
                .forEach(System.out::println);

        // 344 Create Name -> Spending Map
        Map<String,Double> spendingMap =
                customers.stream()
                        .collect(Collectors.toMap(
                                Customer::getName,
                                Customer::getSpending));

        System.out.println(spendingMap);

        // 345 Partition High Value Customers
        Map<Boolean,List<Customer>> partition =
                customers.stream()
                        .collect(Collectors.partitioningBy(
                                c -> c.getSpending() > 80000));

        System.out.println(partition);

        // 346 Customer Summary Statistics
        DoubleSummaryStatistics stats =
                customers.stream()
                        .collect(Collectors.summarizingDouble(
                                Customer::getSpending));

        System.out.println(stats);

        // 347 Find Platinum Customers
        customers.stream()
                .filter(c ->
                        "Platinum".equals(
                                c.getMembership()))
                .forEach(System.out::println);

        // 348 Membership Wise Highest Spender
        Map<String, Optional<Customer>> highestSpender =
                customers.stream()
                        .collect(Collectors.groupingBy(
                                Customer::getMembership,
                                Collectors.maxBy(
                                        Comparator.comparing(
                                                Customer::getSpending)
                                )));

        System.out.println(highestSpender);

        // 349 Membership Wise Lowest Spender
        Map<String, Optional<Customer>> lowestSpender =
                customers.stream()
                        .collect(Collectors.groupingBy(
                                Customer::getMembership,
                                Collectors.minBy(
                                        Comparator.comparing(
                                                Customer::getSpending)
                                )));

        System.out.println(lowestSpender);

        // 350 Membership -> Total Revenue Sorted
        spending.entrySet()
                .stream()
                .sorted(
                        Map.Entry
                                .<String,Double>comparingByValue()
                                .reversed())
                .forEach(System.out::println);
    }
}

class Customer {

    private int id;
    private String name;
    private String membership;
    private double spending;

    public Customer(int id,
                    String name,
                    String membership,
                    double spending) {
        this.id = id;
        this.name = name;
        this.membership = membership;
        this.spending = spending;
    }

    public String getName() {
        return name;
    }

    public String getMembership() {
        return membership;
    }

    public double getSpending() {
        return spending;
    }

    @Override
    public String toString() {
        return name + " " +
               membership + " " +
               spending;
    }
}
