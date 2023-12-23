package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.PreparedStatement;


import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
	
    private JTextField emailTextField;
    private JPasswordField passwordField;

    public LoginPage() {
        setTitle("Login Page");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create components
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");

        emailTextField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");
        
//        Add
        add(emailLabel);
        add(passwordLabel);
        add(emailTextField);
        add(passwordField);
        add(loginButton);
        add(signupButton);
        
//        Bounds
        emailLabel.setBounds(130, 80, 60, 13);
        emailTextField.setBounds(210, 75,  180, 27);
        passwordLabel.setBounds(105, 145, 75, 13);
        passwordField.setBounds(210, 140, 180, 27);
        loginButton.setBounds(190, 220, 80, 25);
        signupButton.setBounds(320, 220, 80, 25);

//         Add ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);

//                 Close the current login page if needed
                dispose();
            }
        });

//         Add ActionListener to the sign up button
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignupPage signupPage = new SignupPage();
                signupPage.setVisible(true);
            }
        });
        
        
//     // JDBC URL for MS Access
//        String url = "jdbc:ucanaccess:C:\\Users\\Style Setters\\Documents\\EmailSoftware.accdb";
//
//        // Database credentials
//        String username = ""; // Leave it blank for MS Access
//        String email = ""; // Leave it blank for MS Access
//
//        try {
//            // Register JDBC driver
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//
//            // Open a connection
//            try (Connection connection = DriverManager.getConnection(url, username, email)) {
//
//                // Your SQL query to insert login data
//                String insertQuery = "INSERT INTO LoginTable (username, password) VALUES (?, ?)";
//
//                // Example login data
//                String usernameInput = "sampleUser";
//                String passwordInput = "samplePassword";
//
//                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
//                    // Set parameters
//                    preparedStatement.setString(1, usernameInput);
//                    preparedStatement.setString(2, passwordInput);
//
//                    // Execute the update
//                    int rowsAffected = preparedStatement.executeUpdate();
//
//                    System.out.println(rowsAffected + " row(s) affected");
//                }
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        
        
    }

    public static void main(String[] args) {
//         Create and display the login page
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
            }
        });
    }
}
