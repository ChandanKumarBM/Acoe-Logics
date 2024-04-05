package acoeLogics;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class test {
    public static int getRowIndexForData(String csvPath, String searchData) throws IOException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            String[] headers = reader.readNext(); // Assuming the first row contains headers
            String[] values;

            if (headers != null) {
                int rowIndex = 0;
                while ((values = reader.readNext()) != null) {
                    for (int i = 0; i < values.length && i < headers.length; i++) {
                        if (values[i].equalsIgnoreCase(searchData)) {
                            return rowIndex; // Return the index of the row with the specified data
                        }
                    }
                    rowIndex++;
                }
            }
        }

        return -1; // Return -1 if the specified data is not found
    }

    public static void main(String[] args) throws IOException, CsvValidationException {
        String csvPath = "C:\\Users\\Chandan\\Documents\\RmgYantra_HRM.csv"; // Replace with your CSV file path
        String searchData = "TestCaseId"; // Replace with the specific data to search for

        int rowIndex = getRowIndexForData(csvPath, searchData);

        if (rowIndex != -1) {
            System.out.println("Row Index for the specified data: " + rowIndex);
        } else {
            System.out.println("Data not found: " + searchData);
            
        }
    }
}

