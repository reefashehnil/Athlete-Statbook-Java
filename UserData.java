import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserData {
    public static void registerUser(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(username + ":" + password);
            writer.newLine();
            writer.flush();
            System.out.println("User registered successfully!");
        } catch (IOException e) {
            System.out.println("Error registering user: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
