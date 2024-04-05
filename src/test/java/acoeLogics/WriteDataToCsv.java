package acoeLogics;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class WriteDataToCsv {
	public static void updateCsvColumn(String csvPath, String testCaseId, String columnName, String newValue) throws IOException, CsvValidationException {
		List<String[]> lines = new ArrayList<>();

		try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
			String[] headers = reader.readNext(); 
			lines.add(headers); 

			int testCaseIdIndex = -1;
			int columnIndex = -1;

			// Find the index of the specified column
			for (int i = 0; i < headers.length; i++) {
				if (headers[i].equals(columnName)) {
					columnIndex = i;
					break;
				}
			}

			if (columnIndex != -1) {
				String[] values;
				while ((values = reader.readNext()) != null) {
					// Check if the TestCaseId matches in the first column
					if (values.length > 0 && values[0].equals(testCaseId)) {
						// Update the value for the specified column
						values[columnIndex] = newValue;
					}
					lines.add(values); // Add the current line to the list
				}
			}
		}

		// Write back the updated data to the CSV file
		FileInputStream fis = new FileInputStream(csvPath);
        FileDescriptor fd = fis.getFD();

        FileOutputStream fos = new FileOutputStream(fd);
		writeCsvFile(fos, lines);
	}

	private static void writeCsvFile(FileOutputStream fos, List<String[]> lines) {
     CSVWriter writer=new CSVWriter(null);
     writer.writeAll(lines);
	}

	private static void writeCsvFile(Writer csvPath, List<String[]> lines) throws IOException {
		CSVWriter writer = new CSVWriter(csvPath);
			// Write lines to CSV
//			writer.writeAll(lines);
		
	}
	public static void main(String[] args) throws IOException, CsvValidationException {
		String csvPath = "C:\\Users\\Chandan\\Documents\\RmgYantra_HRM.csv";
		String testCaseIdToUpdate = "DD002";
		String columnNameToUpdate = "EmployeeName";
		String newValue = "Vikram";

		updateCsvColumn(csvPath, testCaseIdToUpdate, columnNameToUpdate, newValue);
	}
}
