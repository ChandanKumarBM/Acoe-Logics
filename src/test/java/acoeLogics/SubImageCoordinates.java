package acoeLogics;
import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SubImageCoordinates {
	public static void main(String[] args) throws InterruptedException {
		// Specify the path where you want to save the screenshot
		String mainImagePath = "C:\\Users\\Chandan\\Downloads\\opencv\\mainimage.png";
		String subimagePath = "C:\\Users\\Chandan\\Downloads\\opencv\\subimage.png";
		System.setProperty("java.library.path", "C:\\Users\\Chandan\\Downloads\\OpenCv_exe\\opencv\\build\\java\\x64");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat mainImage = Imgcodecs.imread(mainImagePath);
		Mat subimage = Imgcodecs.imread(subimagePath);

		// Convert images to grayscale
		Mat mainGray = new Mat();
		Mat subimageGray = new Mat();
		Imgproc.cvtColor(mainImage, mainGray, Imgproc.COLOR_BGR2GRAY);
		Imgproc.cvtColor(subimage, subimageGray, Imgproc.COLOR_BGR2GRAY);

		// Match the template
		Mat result = new Mat();
		Imgproc.matchTemplate(mainGray, subimageGray, result, Imgproc.TM_CCOEFF_NORMED);

		// Find the location of the best match
		Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
		Point matchLoc = mmr.maxLoc;

		// Get the coordinates of the matched region
		double x1 = matchLoc.x;
		double y1 = matchLoc.y;
		double x2 = matchLoc.x + subimage.cols();
		double y2 = matchLoc.y + subimage.rows();

		// Draw a rectangle around the matched region
		Imgproc.rectangle(mainImage, matchLoc, new Point(x2, y2), new Scalar(0, 255, 0), 2);

		// Save the output image
		String outputPath = "C:\\Users\\Chandan\\Downloads\\opencv\\result.png";
		Imgcodecs.imwrite(outputPath, mainImage);
		System.out.println("Successfully highlighted the image");

		// Print the coordinates
		System.out.println("Top-left corner coordinates: (" + x1 + ", " + y1 + ")");
		System.out.println("Bottom-right corner coordinates: (" + x2 + ", " + y2 + ")");


	}
}
