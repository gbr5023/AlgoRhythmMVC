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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Gisward
 */
public class CRUDMenuUI extends JFrame implements ActionListener
{
    JFrame mediaMenuFrame;
    private JRadioButton readButton;
    private JRadioButton createButton;
    private JRadioButton rateButton;
    private JRadioButton updateButton;
    private JRadioButton deleteButton;
    private JButton goButton;
    private JButton backButton;
    private JButton exitButton;
    //private GridBagConstraints layoutConst;
    private ButtonGroup radioButtonGroup;
    private ButtonGroup regularButtonGroup;
    private JPanel radioButtonPanel;
    private JPanel regularButtonPanel;
    
    private MediaListCntl theMediaListCntl;
    
    /**
     * CRUDMenuUI(): Instantiates a new NavigationCntl object = theNavigationCntl
     *               with the parameter NavigationCntl parentNavigationCntl.
     *               Calls setTheLayout() to layout the CRUDMenuUI.
     * @param parentNavigationCntl 
     */
    public CRUDMenuUI(MediaListCntl parentMediaListCntl) 
    {
        this.theMediaListCntl = parentMediaListCntl;
        setTheLayout();
    }
    
    /**
     * setTheLayout(): Instantiates JFrame and JButton components.
     *                 Sets layout, size, and location of frame.
     * 
     */
    private void setTheLayout() 
    {
        mediaMenuFrame = new JFrame("Media Menu");
        createButton = new JRadioButton("Create Media");
        readButton = new JRadioButton("Read Media");
        rateButton = new JRadioButton("Rate Media");
        updateButton = new JRadioButton("Update Media");
        deleteButton = new JRadioButton("Delete Media");
        goButton = new JButton("Go");
        backButton = new JButton("Back");
        exitButton = new JButton("Exit");
        radioButtonPanel = new JPanel(new BorderLayout());
        radioButtonGroup = new ButtonGroup();
        regularButtonPanel = new JPanel(new BorderLayout());
        regularButtonGroup = new ButtonGroup();
        
        readButton.setFont(new Font("Arial", Font.PLAIN, 18));
        createButton.setFont(new Font("Arial", Font.PLAIN, 18));
        rateButton.setFont(new Font("Arial", Font.PLAIN, 18));
        updateButton.setFont(new Font("Arial", Font.PLAIN, 18));
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 18));
        goButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        
        createButton.setPreferredSize(new Dimension(150, 80));
        readButton.setPreferredSize(new Dimension(130, 80));
        rateButton.setPreferredSize(new Dimension(130, 80));
        updateButton.setPreferredSize(new Dimension(150, 80));
        deleteButton.setPreferredSize(new Dimension(150, 80));
        goButton.setPreferredSize(new Dimension(100, 40));
        exitButton.setPreferredSize(new Dimension(100, 40));
        backButton.setPreferredSize(new Dimension(100, 40));
        
        //mediaMenuFrame.setLayout(new GridBagLayout());
        //mediaMenuFrame.setSize(800, 400);
        
        
        //RADIO BUTTONS    
                //VIEW MEDIA BUTTON add ActionListener via nested class
                readButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        readButtonActionPerformed(evt);
                    }
                });
                // CREATE MEDIA BUTTON add ActionListener via nested class
                createButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        createButtonActionPerformed(evt);
                    }
                });
                // RATE MEDIA BUTTON add ActionListener via nested class
                rateButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent evt)
                    {
                        rateButtonActionPerformed(evt);
                    }
                });
                
                // EDIT MEDIA BUTTON add ActionListener via nested class
                updateButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        editButtonActionPerformed(evt);
                    }
                });
                // DELETE MEDIA BUTTON add ActionListener via nested class
                deleteButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        deleteButtonActionPerformed(evt);
                    }
                });
                
                //add Buttons to radioButtonGroup to ensure that one radio button
                //is selected at a time
                radioButtonGroup.add(createButton);
                radioButtonGroup.add(readButton);
                radioButtonGroup.add(rateButton);
                radioButtonGroup.add(updateButton);
                radioButtonGroup.add(deleteButton);
                
                //add radioButtons to the panel to group them together
                radioButtonPanel.add(createButton);
                radioButtonPanel.add(readButton);
                radioButtonPanel.add(rateButton);
                radioButtonPanel.add(updateButton);
                radioButtonPanel.add(deleteButton);
                radioButtonPanel.setLayout(new FlowLayout());
                radioButtonPanel.setSize(new Dimension(500, 500));
                //add radioButtonPanel to mainMenuFrame to organize by BorderLayout
                mediaMenuFrame.add(radioButtonPanel, BorderLayout.PAGE_START);
        
        // JUST GO AND EXIT BUTTONS
        // if taken out of panel, go and exit buttons shift one down from location WITH panel
                // GO BUTTON add ActionListener via nested class
                backButton = new JButton("Back");
                    backButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            backButtonActionPerformed(evt);
                        }
                    });
                goButton = new JButton("Go");
                goButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        goButtonActionPerformed(evt);
                    }
                });
                exitButton = new JButton("Exit");
                exitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        exitButtonActionPerformed(evt);
                    }
                });

                //add buttons to regularButtonGroup and regularButtonPanel to organize together
                regularButtonGroup.add(backButton);
                regularButtonGroup.add(goButton);
                regularButtonGroup.add(exitButton);
                regularButtonGroup.add(backButton);
                
                regularButtonPanel.add(backButton);
                regularButtonPanel.add(goButton);
                regularButtonPanel.add(exitButton);
                regularButtonPanel.setLayout(new FlowLayout());
                regularButtonPanel.setSize(new Dimension(500, 700));
                //add regularButtonPanel to mainMenuFrame to organize by BorderLayout
                mediaMenuFrame.add(regularButtonPanel, BorderLayout.PAGE_END);
                mediaMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program by clicking  "x"
                mediaMenuFrame.pack(); //clean up
                mediaMenuFrame.setLocationRelativeTo(null);
                mediaMenuFrame.setVisible(true); //make JFrame visible  
    }
    
    /**
     * viewButtonActionPerformed(): Handles clicks to viewButton.
     * @param evt 
     */
    private void readButtonActionPerformed(ActionEvent evt) 
    {
        
    }
    
    /**
     * createButtonActionPerformed(): Handles clicks to createButton.
     * @param evt 
     */
    private void createButtonActionPerformed(ActionEvent evt) 
    {
                
    }
    
    private void rateButtonActionPerformed(ActionEvent evt) 
    {
        
    }
    
    /**
     * editButtonActionPerformed(): Handles clicks to editButton.
     * @param evt 
     */
    private void editButtonActionPerformed(ActionEvent evt) 
    {
                
    }
    
    /**
     * deleteButtonActionPerformed(): Handles clicks to deleteButton.
     * @param evt 
     */
    private void deleteButtonActionPerformed(ActionEvent evt) 
    {
                
    }
    
    /**
     * goButtonActionPerformed(): Handles clicks/event forwarding to goButton.
     *                            Checks which button was selected and, if selected,
     *                            closes mainMenuFrame and takes program to specific
     *                            controller (i.e, theNavigationCntl.requestMediaListCntl).
     * @param evt 
     */
    private void goButtonActionPerformed(ActionEvent evt) 
    {
        boolean readSelected = readButton.isSelected();
        boolean createSelected = createButton.isSelected();
        boolean rateSelected = rateButton.isSelected();
        boolean editSelected = updateButton.isSelected();
        boolean deleteSelected = deleteButton.isSelected();
        
        if(createSelected || editSelected || deleteSelected || readSelected || rateSelected)
        {
            if(rateSelected)
            {
                //mediaMenuFrame.setVisible(false);
                //this.theMediaListCntl.requestRateMediaUI();
            }
            else
            {
                //mediaMenuFrame.setVisible(false);
                //this.theMediaListCntl.requestCRUDSongUI();
            }
            
        }
        /*
        else if(readSelected)
        {
            mediaMenuFrame.setVisible(false);
            this.theMediaListCntl.requestMediaListUI();
        }
        */
        else
        {
            System.err.println("Choose a menu option.");
        }
    }
    
    private void backButtonActionPerformed(ActionEvent evt) 
    {
        mediaMenuFrame.setVisible(false);
        this.theMediaListCntl.requestNavigationCntl();
    }
    
    /**
     * exitButtonActionPerformed(): Handles click to exitButton.
     *                              Exits from program if clicked.
     * @param evt 
     */
    private void exitButtonActionPerformed(ActionEvent evt) 
    {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * actionPerformed: Handles random exceptions.
     * @param ae 
     */
}
