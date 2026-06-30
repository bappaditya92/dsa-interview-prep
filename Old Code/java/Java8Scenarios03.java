import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Java8Scenarios03 {

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction(1,"ACC101",5000,"CREDIT", LocalDate.of(2024,1,10)),
                new Transaction(2,"ACC101",2000,"DEBIT", LocalDate.of(2024,1,12)),
                new Transaction(3,"ACC102",7000,"CREDIT", LocalDate.of(2024,2,5)),
                new Transaction(4,"ACC103",3000,"DEBIT", LocalDate.of(2024,2,20)),
                new Transaction(5,"ACC102",1000,"DEBIT", LocalDate.of(2024,3,15)),
                new Transaction(6,"ACC101",9000,"CREDIT", LocalDate.of(2024,4,1))
        );

        // 291 Total Credit Amount
        double totalCredit =
                transactions.stream()
                        .filter(t -> "CREDIT".equals(t.getType()))
                        .mapToDouble(Transaction::getAmount)
                        .sum();

        System.out.println(totalCredit);

        // 292 Total Debit Amount
        double totalDebit =
                transactions.stream()
                        .filter(t -> "DEBIT".equals(t.getType()))
                        .mapToDouble(Transaction::getAmount)
                        .sum();

        System.out.println(totalDebit);

        // 293 Account Wise Transaction Count
        Map<String, Long> txCount =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                Transaction::getAccount,
                                Collectors.counting()));

        System.out.println(txCount);

        // 294 Account Wise Total Amount
        Map<String, Double> totalAmount =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                Transaction::getAccount,
                                Collectors.summingDouble(
                                        Transaction::getAmount)));

        System.out.println(totalAmount);

        // 295 Account With Highest Transaction Value
        totalAmount.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // 296 Largest Transaction
        transactions.stream()
                .max(Comparator.comparing(
                        Transaction::getAmount))
                .ifPresent(System.out::println);

        // 297 Smallest Transaction
        transactions.stream()
                .min(Comparator.comparing(
                        Transaction::getAmount))
                .ifPresent(System.out::println);

        // 298 Transactions Above Average
        double avg =
                transactions.stream()
                        .mapToDouble(Transaction::getAmount)
                        .average()
                        .orElse(0);

        transactions.stream()
                .filter(t -> t.getAmount() > avg)
                .forEach(System.out::println);

        // 299 Transactions Below Average
        transactions.stream()
                .filter(t -> t.getAmount() < avg)
                .forEach(System.out::println);

        // 300 Monthly Transaction Count
        Map<Integer, Long> monthlyCount =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                t -> t.getDate().getMonthValue(),
                                Collectors.counting()));

        System.out.println(monthlyCount);

        // 301 Monthly Revenue
        Map<Integer, Double> monthlyRevenue =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                t -> t.getDate().getMonthValue(),
                                Collectors.summingDouble(
                                        Transaction::getAmount)));

        System.out.println(monthlyRevenue);

        // 302 Sort By Date
        transactions.stream()
                .sorted(
                        Comparator.comparing(
                                Transaction::getDate))
                .forEach(System.out::println);

        // 303 Sort By Amount Desc
        transactions.stream()
                .sorted(
                        Comparator.comparing(
                                Transaction::getAmount)
                                .reversed())
                .forEach(System.out::println);

        // 304 Top 2 Transactions
        transactions.stream()
                .sorted(
                        Comparator.comparing(
                                Transaction::getAmount)
                                .reversed())
                .limit(2)
                .forEach(System.out::println);

        // 305 Recent Transactions
        transactions.stream()
                .filter(t ->
                        t.getDate()
                                .isAfter(
                                        LocalDate.of(2024,2,1)))
                .forEach(System.out::println);

        // 306 CREDIT vs DEBIT Count
        Map<String, Long> typeCount =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                Transaction::getType,
                                Collectors.counting()));

        System.out.println(typeCount);

        // 307 CREDIT vs DEBIT Amount
        Map<String, Double> typeAmount =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                Transaction::getType,
                                Collectors.summingDouble(
                                        Transaction::getAmount)));

        System.out.println(typeAmount);

        // 308 Distinct Accounts
        transactions.stream()
                .map(Transaction::getAccount)
                .distinct()
                .forEach(System.out::println);

        // 309 Summary Statistics
        DoubleSummaryStatistics stats =
                transactions.stream()
                        .collect(Collectors.summarizingDouble(
                                Transaction::getAmount));

        System.out.println(stats);

        // 310 Group By Account And Type
        Map<String,
                Map<String,List<Transaction>>> result =
                transactions.stream()
                        .collect(Collectors.groupingBy(
                                Transaction::getAccount,
                                Collectors.groupingBy(
                                        Transaction::getType)));

        System.out.println(result);
    }
}

class Transaction {

    private int id;
    private String account;
    private double amount;
    private String type;
    private LocalDate date;

    public Transaction(int id,
                       String account,
                       double amount,
                       String type,
                       LocalDate date) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public String getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return account + " " +
               amount + " " +
               type + " " +
               date;
    }
}
