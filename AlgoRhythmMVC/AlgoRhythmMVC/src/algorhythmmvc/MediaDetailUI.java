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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Gisward
 */
public class MediaDetailUI 
{
    private MediaListCntl theMediaListCntl;
    private int row; // row of the mediaList ArrayList in SongList class
    private JTextArea mediaDetailTextArea;
    private JFrame mediaDetailFrame;
    private JPanel mediaDetailPanel;
    private JPanel buttonPanel;
    private JScrollPane mediaDetailScrollPane;
    private JTableHeader mediaDetailTableHeader;
    private JButton backButton;
    private JButton exitButton;
    
    public MediaDetailUI(MediaListCntl parentMediaListCntl, int row)
    {
        this.theMediaListCntl = parentMediaListCntl;
        this.row = row;
        setTheLayout();
    }
    
    private void setTheLayout()
    {
        Song theMedia = theMediaListCntl.getTheSongList(row);
        mediaDetailTextArea = new JTextArea(
                                            "Media: " + theMedia.getMediaName() +
                                            "\nArtist: " + theMedia.getMediaArtist() +
                                            "\nLength: " + theMedia.getMediaLength() + 
                                            "\nAverage Rating: " + theMedia.getMediaAvgRating()
                                           );
        mediaDetailTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
        mediaDetailTextArea.setLineWrap(true);
        mediaDetailTextArea.setWrapStyleWord(true);
        mediaDetailTextArea.setEditable(false);
                
        mediaDetailScrollPane = new JScrollPane(mediaDetailTextArea);
        mediaDetailScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mediaDetailScrollPane.setPreferredSize(new Dimension(250, 250));
        
        mediaDetailPanel = new JPanel(new BorderLayout());
        mediaDetailPanel.add(mediaDetailScrollPane);
        
        buttonPanel = new JPanel(new BorderLayout());
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(backButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(exitButton);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setSize(new Dimension(500, 500));
        
        mediaDetailFrame = new JFrame(theMedia.getMediaName());
        mediaDetailFrame.add(mediaDetailPanel);
        mediaDetailFrame.add(buttonPanel, BorderLayout.PAGE_END);
        mediaDetailFrame.pack();
        mediaDetailFrame.setSize(500, 500);
        mediaDetailFrame.setLocationRelativeTo(null);
        mediaDetailFrame.setVisible(true);
        mediaDetailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    public void backButtonActionPerformed(ActionEvent evt)
    {
        mediaDetailFrame.setVisible(false);
        theMediaListCntl.requestMediaListUI();
    }
    
    public void exitButtonActionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }
}
