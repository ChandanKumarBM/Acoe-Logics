package acoeLogics;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;



public class ShellCommandExecution {
    public static void main(String[] args) {
        try {
            // Destination directory for pulled files
            String destinationDirectory = "C:\\Users\\Chandan\\Documents\\Cloneapplication\\New folder (3)";

            // Create the destination directory if it doesn't exist
//            File dir = new File(destinationDirectory);
//            if (!dir.exists()) {
//                dir.mkdirs();
//                System.out.println("mmmm i have exectuted once agin");
//            }

            // Command to execute
            String command = "adb shell pm path com.example.mybank";

            // Execute command
            Process process = Runtime.getRuntime().exec(command);

            // Read output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder outputBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                // Construct adb pull command
                String adbPullCommand = "adb pull " + line.replace("package:", "").trim() + " \"" + destinationDirectory + "\"";

                // Print adb pull command
                System.out.println(adbPullCommand);
                outputBuilder.append(adbPullCommand).append("\n");

                // Execute adb pull command
                Process pullProcess = Runtime.getRuntime().exec(adbPullCommand);
                BufferedReader pullReader = new BufferedReader(new InputStreamReader(pullProcess.getInputStream()));
                String pullLine;
                while ((pullLine = pullReader.readLine()) != null) {
                    // Print output of adb pull command
                    System.out.println(pullLine);
                    outputBuilder.append(pullLine).append("\n");
                }
                pullReader.close();
                
                // Wait for adb pull command to finish
                pullProcess.waitFor();
            }

            // Close reader
            reader.close();

            // Print the output
            System.out.println(outputBuilder.toString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
