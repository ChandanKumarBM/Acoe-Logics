package acoeLogics;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class TextToSpeech {

	public static void main(String[] args) {
		String text = "Hello good morning";
		String accent = "Aditi";

		try {
			URL url = new URL("https://ttsmp3.com/makemp3_new.php");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");

			Map<String, String> headers = new HashMap<>();
			headers.put("Content-Type", "application/x-www-form-urlencoded");
			headers.put("Connection", "keep-alive");
			headers.put("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8");
			headers.put("Accept", "*/*");

			for (Map.Entry<String, String> entry : headers.entrySet()) {
				connection.setRequestProperty(entry.getKey(), entry.getValue());
			}

			connection.setDoOutput(true);
			connection.setDoInput(true);

			String urlParameters = "msg=" + text + "&lang=" + accent + "&source=ttsmp3";

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.writeBytes(urlParameters);
				wr.flush();
			}

			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				System.out.println("Response: " + response.toString());
				playAudio(response.toString());
			}

			connection.disconnect();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 private static void playAudio(String audioUrl) {
	        try {
	            // Create an InputStream from the audio URL
	            InputStream audioStream = new URL(audioUrl).openStream();

	            // Create an AdvancedPlayer with the audio stream
	            AdvancedPlayer player = new AdvancedPlayer(audioStream);

	            // Add a PlaybackListener to handle events (optional)
	            player.setPlayBackListener(new PlaybackListener() {
	                @Override
	                public void playbackFinished(PlaybackEvent evt) {
	                    System.out.println("Playback finished");
	                }
	            });

	            // Start playing the audio in a separate thread
	            new Thread(() -> {
	                try {
	                    player.play();
	                } catch (JavaLayerException e) {
	                    e.printStackTrace();
	                }
	            }).start();

	        } catch (IOException | JavaLayerException e) {
	            e.printStackTrace();
	        }
	    }
}