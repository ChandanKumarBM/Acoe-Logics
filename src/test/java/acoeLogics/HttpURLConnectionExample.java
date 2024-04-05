package acoeLogics;


 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

	 public class HttpURLConnectionExample {

	     public static void main(String[] args) {
	         try {
	             URL url = new URL("https://ncpuat.olamagri.com/bidding/api/Approval/InitiateEvent?eventId=1881&isStatusInReject=false");
	             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	             
	             // Set the request method
	             connection.setRequestMethod("POST");

	             // Set the request headers
	             connection.setRequestProperty("authority", "ncpuat.olamagri.com");
	             connection.setRequestProperty("accept", "text/plain");
	             connection.setRequestProperty("accept-language", "en-GB,en-US;q=0.9,en;q=0.8");
	             connection.setRequestProperty("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLcTdwS3VfRklPa3pJaU5RQTJJdnZLa2M0cjdFRE0zYkdyaHQza1BPMHBJIn0..."); // your token here
	             connection.setRequestProperty("content-length", "0");
	             connection.setRequestProperty("cookie", "visid_incap_2894213=spReWwm+QwGjDwk8I+MJqDp4m2UAAAAAQUIPAAAAAABBzi1eM+U16vZ9xVEgbUw7;..."); // your cookie here
	             connection.setRequestProperty("origin", "https://ncpuat.olamagri.com");
	             connection.setRequestProperty("referer", "https://ncpuat.olamagri.com/");
	             connection.setRequestProperty("sec-ch-ua", "\"Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121\"");
	             connection.setRequestProperty("sec-ch-ua-mobile", "?0");
	             connection.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");
	             connection.setRequestProperty("sec-fetch-dest", "empty");
	             connection.setRequestProperty("sec-fetch-mode", "cors");
	             connection.setRequestProperty("sec-fetch-site", "same-origin");
	             connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36");

	             // Get the response code
	             int responseCode = connection.getResponseCode();
	             System.out.println("Response Code: " + responseCode);

	             // Read the response
	             BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	             String line;
	             StringBuilder response = new StringBuilder();
	             while ((line = reader.readLine()) != null) {
	                 response.append(line);
	             }
	             reader.close();

	             // Print the response
	             System.out.println("Response Body: " + response.toString());

	             // Disconnect the connection
	             connection.disconnect();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	     }
	 }
	

