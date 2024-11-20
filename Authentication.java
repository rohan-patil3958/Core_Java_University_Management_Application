import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Authentication class handles the creation and validation of user accounts.
 * It uses a text file to store credentials in the format: username:password.
 */
public class Authentication {

    /**
     * Creates a new user account by adding the username and password to the credentials file.
     * 
     * @param userName The username for the new account.
     * @param Password The password for the new account.
     * @throws IOException If an error occurs while reading or writing to the file.
     */
    void createAc(String userName, String Password) throws IOException {
        boolean flag = true; // Flag to check if the username already exists

        // Open the credentials file for reading
        FileReader fr = new FileReader("F:\\UniversityMgmt\\Credentials.txt");
        BufferedReader br = new BufferedReader(fr);

        String data;
        // Loop through each line to check if the username already exists
        while ((data = br.readLine()) != null) {
            String[] parts = data.split(":"); // Split the line into username and password
            if (parts.length > 0 && parts[0].equals(userName)) { // Check if the username matches
                flag = false; // Username exists, set flag to false
                break;
            }
        }
        br.close(); // Close the BufferedReader

        if (flag) { // If the username does not exist
            // Open the credentials file for appending
            FileWriter fw = new FileWriter("F:\\UniversityMgmt\\Credentials.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Write the new username and password
            bw.write(userName + ":" + Password);
            bw.newLine(); // Add a new line
            bw.close(); // Close the BufferedWriter

            System.out.println("User added successfully.");
        } else {
            System.out.println("User already exists!");
        }
    }

    /**
     * Logs in a user by validating the provided username and password against the credentials file.
     * 
     * @param uname The username to validate.
     * @param upass The password to validate.
     * @return A string indicating success ("Administration") or failure ("false").
     * @throws IOException If an error occurs while reading the file.
     */
    public String login(String uname, String upass) throws IOException {
        // Open the credentials file for reading
        FileReader fr = new FileReader("F:\\UniversityMgmt\\Credentials.txt");
        BufferedReader br = new BufferedReader(fr);

        String data;
        // Loop through each line to find a matching username and password
        while ((data = br.readLine()) != null) {
            String[] parts = data.split(":"); // Split the line into username and password
            if (parts.length > 0 && parts[0].equals(uname) && parts[1].equals(upass)) {
                return "Administration"; // Return "Administration" if credentials match
            }
        }
        br.close(); // Close the BufferedReader
        return "false"; // Return "false" if no match is found
    }
}
