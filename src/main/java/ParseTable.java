import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseTable {
    private static final String  PATH_OF_CSV_FILE = "src/data/movementList.csv";
    static List<Double> incomeList = new ArrayList<>();
    static List<Double> expensesList = new ArrayList<>();
    static Map<String,Double> expensesOperationMap = new HashMap<>();
    static Map<String,Double> incomeOperationMap = new HashMap<>();

    public static void parseColumns() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(PATH_OF_CSV_FILE));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
            .withFirstRecordAsHeader()
            .withIgnoreHeaderCase()
            .withTrim());
            for (CSVRecord record : csvParser) {
                String operations = record.get("Описание операции");
                operations = operations.substring((operations.indexOf("\\")+1)|(operations.indexOf("/")+1),60).trim();
                double income = Double.parseDouble(record.get("Приход"));
                double expenses =Double.parseDouble(record.get("Расход").replaceAll(",","."));
                incomeList.add(income);
                expensesList.add(expenses);
                expensesOperationMap = Operation.expensesOperations(operations,expenses);
                incomeOperationMap = Operation.incomeOperations(operations,income);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ParseTable{}" + "\n";
    }
}
