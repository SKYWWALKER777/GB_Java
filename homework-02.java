
//1) Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//String input_str = "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"
//Ввод данных: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String inputStr = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        JSONObject json = new JSONObject(inputStr);
        StringBuilder whereClause = new StringBuilder();

        for (String key : json.keySet()) {
            String value = json.getString(key);
            if (!value.equals("null")) {
                whereClause.append(key).append("=").append(value).append(" AND ");
            }
        }

        if (whereClause.length() > 0) {
            whereClause.delete(whereClause.length() - 5, whereClause.length()); // Удаляем последний " AND "
        }

        String sqlQuery = "select * from students WHERE " + whereClause.toString();
        System.out.println(sqlQuery);
    }
}

// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат
// после каждой итерации запишите в лог-файл.
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 4};
        sortWithBubbleSort(array);
    }

    private static void sortWithBubbleSort(int[] array) {
        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to create log file.", e);
            return;
        }

        logger.info("Original array: " + Arrays.toString(array));

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    logger.info("Intermediate array: " + Arrays.toString(array));
                }
            }
        }

        logger.info("Sorted array: " + Arrays.toString(array));
