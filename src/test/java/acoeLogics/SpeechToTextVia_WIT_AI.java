package acoeLogics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import javax.print.DocFlavor.INPUT_STREAM;

import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
public class SpeechToTextVia_WIT_AI {
	public static void main(String[] args) throws JavaLayerException, NoSuchFieldException, SecurityException, FileNotFoundException, IllegalArgumentException, IllegalAccessException {
		String accessToken = "DHKY6WXOLHHIMERAYUWR3VAPTRTOR6GF";                                 // Replace with your WIT.ai API token
		String mp3InputFile = "C:\\Users\\Chandan\\Downloads\\Hi good morning (1).mp3";		
		
		String wavfile=mp3InputFile.replace("mp3", "wav");
		Converter converter = new Converter();
		converter.convert(mp3InputFile, wavfile);


		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("audio/wav");


		RequestBody requestBody = RequestBody.create(new File(wavfile), mediaType);
		Request request = new Request.Builder()
				.url("https://api.wit.ai/speech")
				.post(requestBody)	
				.addHeader("authorization", "Bearer " + accessToken)
				.addHeader("content-type", "audio/wav")
				.build();

		try {
			Response response = client.newCall(request).execute();
			String responseJson = response.body().string();
			//System.out.println("Final output "+responseJson);
			int index=responseJson.lastIndexOf("text");
			int index1=responseJson.lastIndexOf(",");
			System.out.println(responseJson.substring(index+7,index1));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}




