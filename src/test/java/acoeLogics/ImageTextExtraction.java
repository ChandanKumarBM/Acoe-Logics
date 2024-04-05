package acoeLogics;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.File;

public class ImageTextExtraction {
    public static void main(String[] args) throws TesseractException {
    	String adharNumber="4444 5555 6666";
    	String adharLastNum="6666";
    	
    	        File inputFile = new File("C:\\Users\\Chandan\\Downloads\\kettan singh.jpg");

    	        File outputFile = new File("C:\\Users\\Chandan\\Downloads\\adhar\\kettan.png");

    	        try {
    	            // Read the JPG file into BufferedImage
    	            BufferedImage image = ImageIO.read(inputFile);

    	            // Write the BufferedImage as a PNG file
    	            ImageIO.write(image, "png", outputFile);

    	            System.out.println("Conversion completed successfully.");
    	        } catch (IOException e) {
    	            System.out.println("Error occurred during conversion: " + e.getMessage());
    	        }

    	ITesseract image = new Tesseract1();
    	String sectionData = image.doOCR(outputFile);
    	System.out.println(sectionData);
    	
    	if(sectionData.contains(adharNumber)) {
    		System.out.println("adharcard is not masked");
    		
    	}else if(sectionData.contains(adharLastNum)  )
    	{
    		System.out.println("adhar card has been masked");
    	}
    }
}
