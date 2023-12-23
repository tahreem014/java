package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;


class HomePage extends JFrame {

	 private JLabel emailLabel;
	 private JPanel emailPanel;
	 private JButton deleteButton;
	
    public HomePage() {
        setTitle("Home Page");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        
//          Create components
            JButton receive = new JButton("Receive");
            JButton send = new JButton("Send");
            JButton backarrow = new JButton("<");
            
            emailLabel = new JLabel("");
                
//          Add
            add(receive);
            add(send);
            add(emailLabel);
            add(backarrow);
          
//          Bounds
            send.setBounds(380, 30, 80, 25);
            receive.setBounds(120, 30, 80, 25);
            emailLabel.setBounds(105, 90, 300, 30);
            backarrow.setBounds(10, 10, 45, 20);
            
//          Color to the components 
            backarrow.setBackground(Color.lightGray);


//          Add ActionListener to the send button to go to the home page
            send.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                  Perform login action (you can add your logic here)
                    EmailPage emailPage = new EmailPage();
                    emailPage.setVisible(true);

//                  Close the current login page if needed
                    dispose();
                }
            });
            

//             Add ActionListener to the back arrow button to go to the login page
               backarrow.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
//                     Perform login action 
                       LoginPage loginPage = new LoginPage();
                       loginPage.setVisible(true);

//                        Close the current login page if needed
                       dispose();
                   }
               });
               
               
//                Add ActionListener to the back arrow button to go to the login page
               backarrow.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
//                     Perform login action 
                       LoginPage loginPage = new LoginPage();
                       loginPage.setVisible(true);

//                        Close the current login page if needed
                       dispose();
                   }
               });
            
            
//         Add ActionListener to the receive button
            receive.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                     Perform action when "Receive" button is clicked
                    receiveEmail("Emmi", "Project.pdf");
                }
            });
        }
        
         
    private void receiveEmail(String senderName, String fileName) {
       
        // Create a panel to hold the email details and delete button
        emailPanel = new JPanel();
        emailPanel.setBounds(100, 70, 300, 50);
        emailPanel.setLayout(null);

        // Display email details on the panel
        JLabel emailDetails = new JLabel( senderName + " :           " + fileName);
        emailDetails.setBounds(0, 20, 300, 30);
        emailPanel.add(emailDetails);

        // Add "Delete" button to the panel
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(380, 90, 80, 25);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform delete action 
                clearEmailDetails();
            }
        });

        // Add the panel to the frame
        add(emailPanel);
        add(deleteButton);
        repaint();
        revalidate();

        
    }
    
    
    

    private void clearEmailDetails() {
//         Remove the email panel from the frame
        if (emailPanel != null) {
            remove(emailPanel);
            remove(deleteButton);
            repaint();
            revalidate();
        }
        
        
    }
}  

    

