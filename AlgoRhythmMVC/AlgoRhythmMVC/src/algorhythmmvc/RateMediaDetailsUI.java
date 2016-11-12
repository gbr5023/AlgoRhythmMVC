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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Gisward
 */
public class RateMediaDetailsUI 
{
    private MediaListCntl theMediaListCntl;
    private ArrayList<Media> theMediaList;
    private int row; // row of the mediaList ArrayList in SongList class
    private JTextArea rateMediaDetailTextArea;
    private JFrame rateMediaDetailFrame;
    private JPanel rateMediaDetailPanel;
    private JPanel buttonPanel;
    private JScrollPane rateMediaDetailScrollPane;
    private JTableHeader raetMediaDetailTableHeader;
    private JButton backButton;
    private JButton exitButton;
    private String previousUI;
    private RateMediaUI theRateMediaUI;
    private crudSongUI theCRUDSongUI;
    
    public RateMediaDetailsUI(MediaListCntl parentMediaListCntl, int row, String newPreviousUI)
    {
        this.theMediaListCntl = parentMediaListCntl;
        theMediaList = theMediaListCntl.getTheCRUDSongList();
        this.row = row;
        this.previousUI = newPreviousUI;
        setTheLayout();
    }
    
    private void setTheLayout()
    { 
        Media theMedia = theMediaListCntl.getTheSongList(row);
        ArrayList<Double> theRatingList = theMedia.getMediaRatingList();
        rateMediaDetailTextArea = new JTextArea(
                                            "Media: " + theMedia.getMediaName() +
                                            "\nArtist: " + theMedia.getMediaArtist() +
                                            "\nLength: " + theMedia.getMediaLength() + 
                                            "\nAverage Rating: " + theMedia.getMediaAvgRating() +
                                            "\nAll Ratings: "
                                           );
        for (int i = 0; i < theRatingList.size(); i++) 
        {
            String theRating = "\n" + (i + 1) + ": " + theRatingList.get(i);
            rateMediaDetailTextArea.append(theRating);
        }
        rateMediaDetailTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
        rateMediaDetailTextArea.setLineWrap(true);
        rateMediaDetailTextArea.setWrapStyleWord(true);
        rateMediaDetailTextArea.setEditable(false);
                
        rateMediaDetailScrollPane = new JScrollPane(rateMediaDetailTextArea);
        rateMediaDetailScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        rateMediaDetailScrollPane.setPreferredSize(new Dimension(250, 250));
        
        rateMediaDetailPanel = new JPanel(new BorderLayout());
        rateMediaDetailPanel.add(rateMediaDetailScrollPane);
        
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
        
        rateMediaDetailFrame = new JFrame(theMedia.getMediaName());
        rateMediaDetailFrame.add(rateMediaDetailPanel);
        rateMediaDetailFrame.add(buttonPanel, BorderLayout.PAGE_END);
        rateMediaDetailFrame.pack();
        rateMediaDetailFrame.setSize(500, 500);
        rateMediaDetailFrame.setLocationRelativeTo(null);
        rateMediaDetailFrame.setVisible(true);
        rateMediaDetailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    public void backButtonActionPerformed(ActionEvent evt)
    {
        if(this.previousUI.equalsIgnoreCase("rate"))
        {
            rateMediaDetailFrame.setVisible(false);
            theMediaListCntl.requestRateMediaUI();
        }
        else
        {
            rateMediaDetailFrame.setVisible(false);
            theMediaListCntl.requestCRUDSongUI();
        }
    }
    
    public void exitButtonActionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }
}
