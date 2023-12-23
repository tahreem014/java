package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

class SignupPage extends JFrame {
	
	private JTextField nameTextField;
	private JTextField emailTextField;
    private JPasswordField passwordField;

    public SignupPage() {
        setTitle("Signup Page");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        
     // Create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");

        nameTextField = new JTextField(20);
        emailTextField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JButton signupButton = new JButton("Signup");
        JButton backarrow = new JButton("<");
        
//      Add
        add(nameLabel);
        add(emailLabel);
        add(passwordLabel);
        add(emailTextField);
        add(passwordField);
        add(nameTextField);
        add(signupButton);
        add(backarrow);
      
//      Bounds
        nameLabel.setBounds(130, 50, 60, 13);
        nameTextField.setBounds(210, 45,  180, 27);
        emailLabel.setBounds(130, 105, 75, 13);
        emailTextField.setBounds(210, 100, 180, 27);
        passwordLabel.setBounds(105, 160, 75, 13);
        passwordField.setBounds(210, 160, 180, 27);
        signupButton.setBounds(250, 230, 80, 25);
        backarrow.setBounds(10, 10, 45, 20);
        
//      Color to the components 
        backarrow.setBackground(Color.lightGray);


//      Add ActionListener to the sign up button to go to the home page
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             // Perform login action (you can add your logic here)
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

//                 Placeholder logic - print the email and password
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                
                HomePage homePage = new HomePage();
                homePage.setVisible(true);

//                 Close the current login page if needed
                dispose();
            }
        });
        
        
     // JDBC URL for MS Access
        String url = "jdbc:ucanaccess://C:/Users/Style Setters/Documents/EmailSoftware.accdb";

//        try {
//            // Register JDBC driver
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Open a connection
            try (Connection connection = DriverManager.getConnection(url)) {

             // Example sign-up data
                String username = nameTextField.getText().trim();
                String email = emailTextField.getText().trim();

                System.out.println("Username: " + username);
                System.out.println("Email: " + email);


                // Your SQL query to insert sign up data
                String insertQuery = "INSERT INTO Signup (username, email) VALUES (?, ?)";
                
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set parameters
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, email);

                    // Execute the update
                    int rowsAffected = preparedStatement.executeUpdate();
                    connection.commit();

                    System.out.println(rowsAffected + " row(s) affected");
                }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        

//         Add ActionListener to the back arrow button to go to the login page
           backarrow.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                // Perform login action 
                   LoginPage loginPage = new LoginPage();
                   loginPage.setVisible(true);

                   // Close the current login page if needed
                   dispose();
               }
           });
        
        
    }

    
}