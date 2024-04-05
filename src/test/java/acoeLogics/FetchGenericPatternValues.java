package acoeLogics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchGenericPatternValues {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		List<Integer> rowCount2 = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new File("C:\\Users\\Chandan\\Downloads\\Fireflink-Issues-_Jira_.xls"));

			Workbook workbook = WorkbookFactory.create(file);

			// Get the first sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);

			// Regular expression pattern to match lines starting with numbers followed by a period
			Pattern pattern = Pattern.compile("^\\d+\\..*");

			List<Integer> rowCount = new ArrayList<>();

			// Iterate through rows and cells
			for (Row row : sheet) {
				if (row != null) {
					for (Cell cell : row) {
						if (cell != null && cell.getCellType() == CellType.STRING) {
							String cellValue = cell.getStringCellValue().trim();

							// Check if cell content matches the specified pattern
							Matcher matcher = pattern.matcher(cellValue);
							if (matcher.find()) {
								rowCount.add(row.getRowNum());
								//System.out.println(cellValue);
							}
						}
					}
				}
			}

			// Print row indices where the pattern was found
			System.out.println("Rows with pattern match: " + rowCount);
			rowCount2.addAll(rowCount);




			// Close the workbook and file input stream
			workbook.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileInputStream file = new FileInputStream(new File("C:\\Users\\Chandan\\Downloads\\Fireflink-Issues-_Jira_.xls"));
		FileWriter writer = new FileWriter("C:\\Users\\Chandan\\Downloads\\excel\\output.txt");

		Workbook workbook = WorkbookFactory.create(file);

		// Get the first sheet from the workbook
		Sheet sheet = workbook.getSheetAt(0);
		for (Integer rowIndex : rowCount2) {
			Row row = sheet.getRow(rowIndex);
			if (row != null) {
				for (Cell cell : row) {
					if (cell != null) {
						//                        System.out.println("Row: " + rowIndex + ", Cell Value: " + cell.toString());
						writer.write(cell.toString() + "\n");
					}
				}
			}
		}
		txt();

	}
	public static void txt() {
		

		StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Chandan\\Downloads\\excel\\output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Split the content based on pattern "1."
        String[] parts = content.toString().split("(?m)(?=^1\\.)");

        // Create a new Excel workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Output");

        // Create a single cell to store the concatenated text
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < parts.length; i++) { // Start from index 1 to include "1." in the beginning
            if (i > 1) {
                result.append("\n\n"); // Add line breaks between sections
            }
            result.append(parts[i]);
        }

        // Write the concatenated text into the Excel cell
        cell.setCellValue(result.toString());

        // Write output to a new Excel file
        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Chandan\\Downloads\\Fireflink-Issues-_Jira_.xls")) {
            workbook.write(fileOut);
            System.out.println("Output written to output.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
}



