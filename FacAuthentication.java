import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FacAuthentication {

    /**
     * Creates a new faculty account.
     * 
     * @param userName The username for the new account.
     * @param Password The password for the new account.
     * @throws IOException If there is an issue with file operations.
     */
    void createAc(String userName, String Password) throws IOException {
        boolean flag = true; // To check if the username already exists

        // Open the file to check existing accounts
        FileReader fr = new FileReader("F:\\UniversityMgmt\\FacCredentials.txt");
        BufferedReader br = new BufferedReader(fr);

        String data;
        // Read the file line by line
        while ((data = br.readLine()) != null) {
            // Split each line into username and password
            String[] parts = data.split(":");
            if (parts.length > 0 && parts[0].equals(userName)) {
                flag = false; // Username already exists
                break;
            }
        }
        br.close(); // Close the file after reading

        if (flag) {
            // If username doesn't exist, add the new account
            FileWriter fw = new FileWriter("F:\\UniversityMgmt\\FacCredentials.txt", true); // Open in append mode
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(userName + ":" + Password); // Write the username and password
            bw.newLine(); // Move to the next line
            bw.close(); // Close the writer

            System.out.println("User added successfully.");
            fw.close(); // Close the file
        } else {
            // If username exists, show a message
            System.out.println("User already exists!");
        }
    }

    /**
     * Logs in a faculty member by checking their username and password.
     * 
     * @param uname The username entered by the user.
     * @param upass The password entered by the user.
     * @return "fac" if login is successful, "false" if login fails.
     * @throws IOException If there is an issue with file operations.
     */
    public String login(String uname, String upass) throws IOException {
        // Open the file to read existing accounts
        FileReader fr = new FileReader("F:\\UniversityMgmt\\FacCredentials.txt");
        BufferedReader br = new BufferedReader(fr);

        String data;
        // Read the file line by line
        while ((data = br.readLine()) != null) {
            // Split each line into username and password
            String[] parts = data.split(":");
            // Check if the entered username and password match
            if (parts.length > 1 && parts[0].equals(uname) && parts[1].equals(upass)) {
                return "fac"; // Login successful
            }
        }
        br.close(); // Close the file after reading
        return "false"; // Login failed
    }
}
