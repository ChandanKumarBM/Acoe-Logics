package acoeLogics;
import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;


	public class AudioExtensionConverter {
		public static void main(String[] args) {
			String mp3InputFile = "C:\\Users\\Chandan\\Downloads\\PTT-20231005-WA0002.opus";
			String wavOutputFile = "C:\\Users\\Chandan\\Downloads\\test.aac";
	
			try {
				Converter converter = new Converter();
				converter.convert(mp3InputFile, wavOutputFile);
				System.out.println("MP3 to WAV conversion complete.");
		    	} catch (JavaLayerException e) {
				e.printStackTrace();
			}
		}
	}
