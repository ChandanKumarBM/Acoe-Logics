package acoeLogics;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CsvFile {
    public static Map<String, String> readCsvHeadersAndValuesForTestCase(String csvPath, String targetTestCaseId) throws IOException, CsvValidationException {
        Map<String, String> headersAndValues = new LinkedHashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            String[] headers = reader.readNext(); // Assuming the first row contains headers
            String[] values;

            while ((values = reader.readNext()) != null) {
                if (values.length > 0 && values[0].equals(targetTestCaseId)) {
                    // Matched the target TestCaseId, populate the headersAndValues map
                    for (int i = 0; i < headers.length && i < values.length; i++) {
                        headersAndValues.put(headers[i], values[i]);
                    }
                    break; // Stop processing after finding the first matching row
                }
            }
        }

        return headersAndValues;
    }

    public static void main(String[] args) throws IOException, CsvValidationException {
        String csvPath = "C:\\Users\\Chandan\\Documents\\RmgYantra_HRM.csv";
        String targetTestCaseId = "DD002";

        Map<String, String> headersAndValues = readCsvHeadersAndValuesForTestCase(csvPath, targetTestCaseId);

        if (!headersAndValues.isEmpty()) {
            System.out.println("Headers and Values for TestCaseId " + targetTestCaseId + ":");
            for (Map.Entry<String, String> entry : headersAndValues.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("No data found for TestCaseId " + targetTestCaseId);
        }
    }
}
