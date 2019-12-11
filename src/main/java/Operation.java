import java.util.HashMap;
import java.util.Map;

public class Operation {
    public static Map<String, Double> exMap = new HashMap<>();
    public static Map<String, Double> inMap = new HashMap<>();

    public static void TotalIncome() {
         double sum = ParseTable.incomeList.stream().mapToDouble(value -> value).sum();
        System.out.println("Total Income: " + sum);
    }

    public static void TotalExpenses() {
        double sum = ParseTable.expensesList.stream().mapToDouble(value -> value).sum();
        System.out.println("Total Expenses: " + sum);
    }

    public static Map<String, Double> expensesOperations (String operation, Double number) {
       exMap.put(operation, exMap.getOrDefault(operation, 0.0) + number);
        return exMap;
    }

    public static Map<String, Double> incomeOperations (String operation, Double number) {
        if (number != 0)
        inMap.put(operation, inMap.getOrDefault(operation, 0.0) + number);
        return inMap;
    }

    public static void printExpensesOperations () {
        ParseTable.expensesOperationMap.forEach((k,v) -> System.out.println("Operation " + k + " - " + v + "RUB") );
    }

    public static void printInputOperations () {
        ParseTable.incomeOperationMap.forEach((k,v) -> System.out.println("Operation " + k + " - " + v + "RUB") );
    }
}
