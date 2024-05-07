import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationLogin extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public RegistrationLogin() {
        setTitle("Athlete Statbook - Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (e.getActionCommand().equals("Login")) {
            if (UserAuthentication.authenticateUser(username, password)) {
                System.out.println("Login successful!");
                // Proceed to main menu or next screen
            } else {
                System.out.println("Invalid username or password.");
            }
        } else if (e.getActionCommand().equals("Register")) {
            UserData.registerUser(username, password);
        }
    }

}
