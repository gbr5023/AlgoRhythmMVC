/* 
• You can work with a partner on this problem 
• Implement Media (Song) import and app-wide data serialization 
• Uses should be able to:

– Navigate to the media list view (use a JTable to display the list of media)
– Media are imported from the songlist.TSV file or another source (you need a minimum of 1000 songs)
– Select a media (e.g., a song) and view the detail for the object 
– Create a Rating for the media, a media can have more than one Rating 
– Compute and display an aggregate Rating for the media based on all of its individual Ratings 
– Your implementation should conform to the MVC architecture pattern 
– All data should be saved (persisted) between application runs

• Zip the entire AlgoRhythm Netbeans project and submit to Canvas before the due data and time
• Important: Each successive version of AlgoRhythm should build on code you wrote for the prior submission
• Due Friday, 11 November @ 11:50pm
 */

package algorhythmmvc;

//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
//import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
//import java.awt.GridBagConstraints;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JPanel;

/**
 * @author gbr5023
 *
 */
public class LoginUIv2 extends JFrame implements ActionListener
{
	JFrame loginFrame;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JButton submitButton;
	private JButton exitButton;
        private JPanel textFieldPanel;
        private JPanel buttonPanel;
	GridBagConstraints layoutConst; //layout manager
	private LoginCntl theLoginCntl;
	
	public LoginUIv2(LoginCntl parentLoginCntl)
	{
                theLoginCntl = parentLoginCntl;
                setTheLayout();
	}
	
	private void setTheLayout()
	{   
            usernameLabel = new JLabel("Username");
            passwordLabel = new JLabel("Password");
            usernameTextField = new JTextField(15);
            passwordField = new JPasswordField(15);
            submitButton = new JButton("Submit");
            exitButton = new JButton("Exit");
              
            usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            usernameTextField.setFont(new Font("Arial", Font.PLAIN, 18));
            passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
            submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
            exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
            
            usernameTextField.setPreferredSize(new Dimension(50,30));
            passwordField.setPreferredSize(new Dimension(50, 30));
            submitButton.setPreferredSize(new Dimension(90, 30));
            exitButton.setPreferredSize(new Dimension(90, 30));
            
            textFieldPanel = new JPanel(new FlowLayout());
            textFieldPanel.add(usernameLabel);    
            textFieldPanel.add(usernameTextField);            
                usernameTextField.setEditable(true);
                    usernameTextField.addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            usernameTextFieldActionPerformed(evt);
                        }
                    });	
            textFieldPanel.add(passwordLabel);       
            textFieldPanel.add(passwordField);
                passwordField.setEditable(true);
                    passwordField.addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            passwordFieldActionPerformed(evt);
                        }
                    });
            textFieldPanel.setLayout(new FlowLayout());
            textFieldPanel.setSize(new Dimension(500, 500));       
                    
            buttonPanel = new JPanel();
            buttonPanel.add(submitButton); 
                submitButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        submitButtonActionPerformed(evt);
                    }
                }); 
            buttonPanel.add(exitButton);
                exitButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                            exitButtonActionPerformed(evt);
                    }
                });
                
            buttonPanel.setLayout(new FlowLayout());
            buttonPanel.setSize(new Dimension(500, 500));
            
            loginFrame = new JFrame("Login");    
            loginFrame.add(textFieldPanel);
            loginFrame.add(buttonPanel, BorderLayout.PAGE_END);
            
            //loginFrame.getContentPane().setBackground(Color.yellow);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.pack();
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setVisible(true);		
	}

	private void usernameTextFieldActionPerformed(ActionEvent evt) 
        {                                                  
        // TODO add your handling code here:
        }
        
        private void submitButtonActionPerformed(ActionEvent evt) 
        {                                             
        // TODO add your handling code here:
            String username = this.usernameTextField.getText();
            char[] password = this.passwordField.getPassword();
        
            boolean authenticated = this.theLoginCntl.requestAuthenticate(username, password);
            boolean submitSelected = submitButton.isSelected();
        
            if(authenticated)
            {
                loginFrame.setVisible(false);
                loginFrame.dispose();
                System.out.println("Authenticated.");
                this.theLoginCntl.requestNavigationCntl();
            }
            else
            {
                System.out.println("NOT Authenticated.");
                System.err.println("Please enter existing username and password.");
            }
        } 
        
        private void exitButtonActionPerformed(ActionEvent evt) 
        {                                             
            System.exit(0);
        }                                            

        private void passwordFieldActionPerformed(ActionEvent evt) 
        {                                              
            
        }

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }   
}


/*
You can work with a partner on this activity
Without using the Netbeans GUI editor, ie by writing code, complete the LoginUIv2 class to replicate the functionality provided by LoginUI (don’t delete LoginUI, just replace it with LoginUIv2 in the LoginCntl)
LoginUIv2 should look and behave like the existing LoginUI and include:
Labels and fields for username and password
A Submit and Cancel button
Event handlers for the Submit and Cancel buttons
Use one or more Java Swing layout managers to arrange your user interface components neatly
Submit to the Canvas dropbox before the end of class today

 

package algorhythmmvc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author gbr5023
 
public class LoginUIv2 extends JFrame
{
    public LoginUIv2()
    {
        this.setSize(400, 300);
        this.setTitle("The Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setVisible(true);
        
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout(4, 4));
        
        //create array of jpanels, size 16, one for every cell in grid
        JPanel[] cellNumbers = new JPanel[16];
        for(int i = 0; i < 16; i++)
        {
            JPanel nextPanel = new JPanel();
            thePanel.add(nextPanel); // these 2 might be mixed up
            cellNumbers[i] = nextPanel; // these 2 might be mixed up DOUBLE CHECK
        }
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setSize(30, 40); //length, width
        cellNumbers[15].add(cancelButton);
        this.add(thePanel);
        cancelButton.addActionListener(new CancelListener());
    }
    
    class CancelListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            JOptionPane.showMessageDialog(null, "Cancel button was clicked.");
        }
    }
}
*/
