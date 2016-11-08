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

import java.util.ArrayList;
import javax.swing.JTable;

public class MediaListCntl 
{
    private SongList theSongList;
    private NavigationCntl theNavigationCntl;
    private CRUDMenuUI theCRUDMenuUI;
    private RateMediaUI theRateMediaUI;
    private MediaListUI theMediaListUI;
    private MediaDetailUI theMediaDetailUI;
    private crudSongUI theCRUDSongUI;
    //private SongTableModel theSongTableModel;
    private VideoTableModel theVideoTableModel;
    private CRUDSongTableModel theCRUDSongTableModel;
    private JTable CRUDSongTable;
    //private CRUDSongTableModel theCRUDSongTableModel;
    private ArrayList<Song> newSongList;
    
    public MediaListCntl()
    {
        System.out.println("Made it to MediaListCntl");
        theSongList = new SongList();
        requestCRUDMenuUI();
    }
    
    public void updateTheSongList()
    {
        newSongList = theCRUDSongTableModel.getUpdatedSongDetailList();
        theSongList.setSongList(newSongList);
    }
    
    public Song getTheSongList(int row)
    {
        updateTheSongList();
        Song theSongDetail = theSongList.getSongDetail(row);
        
        return theSongDetail;
    }
    
    
    public ArrayList<Song> getTheCRUDSongList()
    {
        updateTheSongList();
        return this.newSongList;
    }
    
    
    public void setCRUDSongTable(JTable theCRUDSongTable)
    {
        this.CRUDSongTable = theCRUDSongTable;
    }
    
    public JTable getCRUDSongTable()
    {
        return this.CRUDSongTable;
    }
    
    public void requestCRUDSongUI()
    {
       theCRUDSongUI = new crudSongUI(this); 
    }
    
    public void requestCRUDMenuUI()
    {
        theCRUDMenuUI = new CRUDMenuUI(this);
    }
    
    public void requestRateMediaUI()
    {
        theRateMediaUI = new RateMediaUI(this);
    }
    
    public void requestNavigationCntl()
    {
        theNavigationCntl = new NavigationCntl();
    }
    
    public void requestMediaListUI()
    {
        theMediaListUI = new MediaListUI(this);
    }
    
    public void requestMediaDetailUI(int row)
    {
        theMediaDetailUI = new MediaDetailUI(this, row);
    }
    
    /*
    public SongTableModel getSongTableModel()
    {
        theSongTableModel = new SongTableModel();
        
        return theSongTableModel;
    }
    */
    
    public CRUDSongTableModel getCRUDSongTableModel()
    {
        theCRUDSongTableModel = new CRUDSongTableModel();
        
        return theCRUDSongTableModel;
    }
    
    public void addRow(Song newSong)
    {
        theCRUDSongTableModel.addRow(newSong);
    }
    
    public void removeRow(int row)
    {
        theCRUDSongTableModel.removeRow(row);
    }
    
    public void updateName(String theName, int row, int column)
    {
        theCRUDSongTableModel.updateName(theName, row, column);
    }
    
    public void updateArtist(String theArtist, int row, int column)
    {
        theCRUDSongTableModel.updateArtist(theArtist, row, column);
    }
    
    public void updateDoubleLength(String theDoubleLength, int row, int column)
    {
        theCRUDSongTableModel.updateDoubleLength(theDoubleLength, row, column);
    }
    
    public void updateDoubleRating(String theDoubleRating, int row, int column)
    {
        theCRUDSongTableModel.updateDoubleRating(theDoubleRating, row, column);
    }

    public VideoTableModel getVideoTableModel()
    {
        theVideoTableModel = new VideoTableModel();
        
        return theVideoTableModel;
    }
}
