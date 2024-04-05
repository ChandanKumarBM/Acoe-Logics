package acoeLogics;


import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class PngToPdfConverter {
	public static void main(String[] args) {
		String pngFile = "C:\\Users\\Chandan\\Desktop\\IvV2y.png";

		String outputPdfFile = "C:\\Users\\Chandan\\Desktop\\test.pdf";

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(outputPdfFile));
			document.open();


			Image image = Image.getInstance(pngFile);
			document.add(image);


			document.close();
			System.out.println("PDF created successfully: " + outputPdfFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


