package test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EmailPage {
	
	private JTextField sendTextField;
	private JTextField subjectTextField;
    private JTextField attachmentField;
    private JTextArea  messageField;

    private JFrame frame;

    public EmailPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Send Email");
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

//      Create components
        JLabel sendLabel = new JLabel("Send To:");
        JLabel subjectLabel = new JLabel("Subject:");

        sendTextField = new JTextField(20);
        subjectTextField = new JTextField(20);
        attachmentField = new JPasswordField(20);
        
        messageField = new JTextArea("  Write your message!  ");

        JButton attachment = new JButton("Attachment");
        JButton send = new JButton("Send");
        JButton cancel = new JButton("Cancel");
        JButton backarrow = new JButton("<");
        
//      Add
        frame.add(sendLabel);
        frame.add(subjectLabel);
        frame.add(sendTextField);
        frame.add(subjectTextField);
        frame.add(messageField);
        frame.add(attachmentField);
        frame.add(attachment);
        frame.add(send);
        frame.add(cancel);
        frame.add(backarrow);
      
//      Bounds
        sendLabel.setBounds(130, 30, 60, 13);
        sendTextField.setBounds(210, 25,  180, 27);
        subjectLabel.setBounds(130, 85, 75, 13);
        subjectTextField.setBounds(210, 80, 180, 27);
        messageField.setBounds(130, 125, 300, 110);
        attachment.setBounds(130, 260, 100, 25);
        attachmentField.setBounds(250, 260, 210, 27);
        send.setBounds(190, 310, 80, 25);
        cancel.setBounds(300, 310, 80, 25);
        backarrow.setBounds(10, 10, 45, 20);
        
//      Color to the components 
        backarrow.setBackground(Color.lightGray);
        

//      Add ActionListener to the back arrow button to go to the home page
        backarrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             // Perform login action 
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                
            }
        });
        
    }
    
    
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
    
    

}