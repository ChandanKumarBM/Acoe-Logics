package acoeLogics;

import java.io.FileInputStream;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

	public class VerifyPPTData {
	    public static void main(String[] args) {
	        try {
	            // Load the PPT file
	            XMLSlideShow ppt = new XMLSlideShow(new FileInputStream("C:\\Users\\Chandan\\Downloads\\MobiKwik_new.pptx"));

	            // Iterate through slides
	            for (XSLFSlide slide : ppt.getSlides()) {
	            	// Iterate through text shapes on each slide
	                for (XSLFShape shape : slide.getShapes()) {
	                    if (shape instanceof XSLFTextShape) {
	                        XSLFTextShape textShape = (XSLFTextShape) shape;
	                        for (XSLFTextParagraph paragraph : textShape) {
	                            String text = paragraph.getText();
	                            // Check if 'text' contains the data you want to verify
	                            if (text.contains("Company Overview")) {
	                                System.out.println("Data found: " + text);
	                            }
	                        }
	                    }
	                }
	            }

	           // ppt.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


