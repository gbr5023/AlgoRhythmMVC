/*
You can work with a partner on this problem 
• Implement the AlgoRhythm use case Rate Media 

• Uses should be able to:
– Navigate to the media list view (use a JTable to display the list of media) 
– Select a media (e.g., a song) and view the detail for the object 
– Create a Rating for the media, a media can have more than one Rating 
– Compute and display an aggregate Rating for the media based on all of its individual Ratings 
– Your implementation should conform to the MVC architecture pattern

• Zip the entire AlgoRhythm Netbeans project and submit to Canvas before the due data and time
• Important: Each successive version of AlgoRhythm should build on code you wrote for the prior submission
• Due Friday, 4 November @ 11:50pm
 */

package algorhythmmvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;

//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

/**
 *
 * @author Gisward
 */
public class MainMenuUI extends JFrame implements ActionListener
{
    JFrame mainMenuFrame;
    private JRadioButton addMediaButton;
    private JRadioButton crudPlaylistButton;
    private JRadioButton rateButton;
    private JRadioButton playButton;
    private JRadioButton shareButton;
    private JButton goButton;
    private JButton exitButton;
    //private GridBagConstraints layoutConst;
    private ButtonGroup radioButtonGroup;
    private ButtonGroup regularButtonGroup;
    private JPanel radioButtonPanel;
    private JPanel regularButtonPanel;
    
    private NavigationCntl theNavigationCntl;
    
    /**
     * MainMenuUI(): Instantiates a new NavigationCntl object = theNavigationCntl
     *               with the parameter NavigationCntl parentNavigationCntl.
     *               Calls setTheLayout() to layout the MainMenuUI.
     * @param parentNavigationCntl 
     */
    public MainMenuUI(NavigationCntl parentNavigationCntl) 
    {
        this.theNavigationCntl = parentNavigationCntl;
        setTheLayout();
    }
    
    /**
     * setTheLayout(): Instantiates JFrame and JButton components.
     *                 Sets layout, size, and location of frame.
     * 
     */
    private void setTheLayout() 
    {
        mainMenuFrame = new JFrame("Main Menu");
        addMediaButton = new JRadioButton("CRUD Media");
        crudPlaylistButton = new JRadioButton("CRUD Playlist");
        rateButton = new JRadioButton("Rate Media");
        playButton = new JRadioButton("Play Media");
        shareButton = new JRadioButton("Share Media");
        goButton = new JButton("Go");
        exitButton = new JButton("Exit");
        radioButtonPanel = new JPanel(new BorderLayout());
        radioButtonGroup = new ButtonGroup();
        regularButtonPanel = new JPanel(new BorderLayout());
        //regularButtonGroup = new ButtonGroup();
        
        addMediaButton.setFont(new Font("Arial", Font.PLAIN, 18));
        crudPlaylistButton.setFont(new Font("Arial", Font.PLAIN, 18));
        rateButton.setFont(new Font("Arial", Font.PLAIN, 18));
        playButton.setFont(new Font("Arial", Font.PLAIN, 18));
        shareButton.setFont(new Font("Arial", Font.PLAIN, 18));
        goButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        
        addMediaButton.setPreferredSize(new Dimension(140, 80));
        crudPlaylistButton.setPreferredSize(new Dimension(150, 80));
        rateButton.setPreferredSize(new Dimension(130, 80));
        playButton.setPreferredSize(new Dimension(130, 80));
        shareButton.setPreferredSize(new Dimension(140, 80));
        goButton.setPreferredSize(new Dimension(70, 30));
        exitButton.setPreferredSize(new Dimension(70, 30));
        
        //mainMenuFrame.setLayout(new GridBagLayout());
        //mainMenuFrame.setSize(800, 400);
        
        
        //RADIO BUTTONS    
                //ADD MEDIA BUTTON add ActionListener via nested class
                addMediaButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        addMediaButtonActionPerformed(evt);
                    }
                });
                // PLAY MEDIA BUTTON add ActionListener via nested class
                playButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        playButtonActionPerformed(evt);
                    }
                });
                // CRUD PLAYLIST BUTTON add ActionListener via nested class
                crudPlaylistButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        crudPlaylistButtonActionPerformed(evt);
                    }
                });
                // RATE BUTTON add ActionListener via nested class
                rateButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        rateButtonActionPerformed(evt);
                    }
                });
                // SHARE BUTTON add ActionListener via nested class
                shareButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        shareButtonActionPerformed(evt);
                    }
                });
                
                //add Buttons to radioButtonGroup to ensure that one radio button
                //is selected at a time
                radioButtonGroup.add(addMediaButton);
                radioButtonGroup.add(playButton);
                radioButtonGroup.add(crudPlaylistButton);
                radioButtonGroup.add(rateButton);
                radioButtonGroup.add(shareButton);
                
                //add radioButtons to the panel to group them together
                radioButtonPanel.add(addMediaButton);
                radioButtonPanel.add(playButton);
                radioButtonPanel.add(crudPlaylistButton);
                radioButtonPanel.add(rateButton);
                radioButtonPanel.add(shareButton);
                radioButtonPanel.setLayout(new FlowLayout());
                radioButtonPanel.setSize(new Dimension(500,500));
                //add radioButtonPanel to mainMenuFrame to organize by BorderLayout
                mainMenuFrame.add(radioButtonPanel, BorderLayout.PAGE_START);
        
        // JUST GO AND EXIT BUTTONS
        // if taken out of panel, go and exit buttons shift one down from location WITH panel
                // GO BUTTON add ActionListener via nested class
                goButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        goButtonActionPerformed(evt);
                    }
                });
                //EXIT BUTTON add ActionListener via nested class
                exitButton.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        exitButtonActionPerformed(evt);
                    }
                });

                //add buttons to regularButtonGroup and regularButtonPanel to organize together
                //regularButtonGroup.add(goButton);
                //regularButtonGroup.add(exitButton);
                regularButtonPanel.add(goButton);
                regularButtonPanel.add(exitButton);
                regularButtonPanel.setLayout(new FlowLayout());
                //regularButtonPanel.setSize(new Dimension(500,500));
                //add regularButtonPanel to mainMenuFrame to organize by BorderLayout
                mainMenuFrame.add(regularButtonPanel, BorderLayout.PAGE_END);
                mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program by clicking  "x"
                mainMenuFrame.pack(); //clean up
                mainMenuFrame.setLocationRelativeTo(null);
                mainMenuFrame.setVisible(true); //make JFrame visible  
    }
    
    /**
     * addMediaButtonActionPerformed(): Handles clicks to addMediaButton.
     * @param evt 
     */
    private void addMediaButtonActionPerformed(ActionEvent evt) 
    {
        
    }
    
    /**
     * playButtonActionPerformed(): Handles clicks to playButton.
     * @param evt 
     */
    private void playButtonActionPerformed(ActionEvent evt) 
    {
                
    }
    
    /**
     * crudPlaylistButtonActionPerformed(): Handles clicks to crudPlaylistButton.
     * @param evt 
     */
    private void crudPlaylistButtonActionPerformed(ActionEvent evt) 
    {
                
    }
    
    /**
     * rateButtonActionPerformed(): Handles clicks to rateButton.
     * @param evt 
     */
    private void rateButtonActionPerformed(ActionEvent evt) 
    {
                
    }
    
    /**
     * shareButtonActionPerformed(): Handles clicks to shareButton.
     * @param evt 
     */
    private void shareButtonActionPerformed(ActionEvent evt) 
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
        boolean addSelected = addMediaButton.isSelected();
        boolean playSelected = playButton.isSelected();
        //boolean crudSelected = crudPlaylistButton.isSelected();
        boolean rateSelected = rateButton.isSelected();
        boolean shareSelected = shareButton.isSelected();
        
        if(addSelected)
        {
            mainMenuFrame.setVisible(false);
            this.theNavigationCntl.requestMediaListCntl();
        }
        else if(playSelected)
        {
            
        }
        /*
        else if(crudSelected)
        {
            
        }
        */
        else if(rateSelected)
        {
            /*
            mainMenuFrame.setVisible(false);
            this.theNavigationCntl.requestRateMediaCntl();
            */
            mainMenuFrame.setVisible(false);
            this.theNavigationCntl.requestMediaListCntl();
        }
        else if(shareSelected)
        {
            
        }
        else
        {
            System.err.println("Choose a menu option.");
        }
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

    /**
     * actionPerformed: Handles random exceptions.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
stuff that dont work

layoutConst = new GridBagConstraints();
                layoutConst.gridx = 0;
                layoutConst.gridy = 2;
                layoutConst.insets = new Insets(10, 10, 10, 10);
                mainMenuFrame.add(addMediaButton, layoutConst);

layoutConst = new GridBagConstraints();
                layoutConst.gridx = 1;
                layoutConst.gridy = 2;
                layoutConst.insets = new Insets(10, 10, 10, 10);
                mainMenuFrame.add(playButton, layoutConst);

layoutConst = new GridBagConstraints();
                layoutConst.gridx = 2;
                layoutConst.gridy = 2;
                layoutConst.insets = new Insets(10, 10, 10, 10);
                mainMenuFrame.add(crudPlaylistButton, layoutConst);
                
layoutConst = new GridBagConstraints();
                layoutConst.gridx = 3;
                layoutConst.gridy = 2;
                layoutConst.insets = new Insets(10, 10, 10, 10);
                mainMenuFrame.add(rateButton, layoutConst);

layoutConst = new GridBagConstraints();
                layoutConst.gridx = 4;
                layoutConst.gridy = 2;
                layoutConst.insets = new Insets(10, 10, 10, 10);
                mainMenuFrame.add(shareButton, layoutConst);

layoutConst = new GridBagConstraints();
                layoutConst.gridx = 1;
                layoutConst.gridy = 2;
                layoutConst.insets = new Insets(10, 10, 10, 10);
                mainMenuFrame.add(goButton, layoutConst);

layoutConst = new GridBagConstraints();
                layoutConst.gridx = 2;
                layoutConst.gridy = 2;
                layoutConst.insets = new Insets(10, 10, 10, 10);
                mainMenuFrame.add(exitButton, layoutConst);

*/
