import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserAuthentication {
    public static boolean authenticateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error authenticating user: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
