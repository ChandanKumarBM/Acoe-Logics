package acoeLogics;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class PdfContainsData {
	public static void main(String[] args) {

		// Specify the path to your downloaded PDF file
		String pdfFilePath = "C:\\Users\\Chandan\\Desktop\\test.pdf";

		try (
			PDDocument document = PDDocument.load(new File(pdfFilePath))) {
			PDFTextStripper pdfTextStripper = new PDFTextStripper();
			String pdfText = pdfTextStripper.getText(document);
			// Now, you can check for specific data within 'pdfText'
			System.out.println(pdfText);
			if (pdfText.contains("Akash")) {
				System.out.println("Data is present");
			} else {
				System.out.println("Data is not present");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
