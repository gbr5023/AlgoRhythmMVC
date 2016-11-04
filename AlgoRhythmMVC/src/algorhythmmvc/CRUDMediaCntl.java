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


public class CRUDMediaCntl 
{
    private SongList theSongList;
    private NavigationCntl theNavigationCntl;
    private CRUDMenuUI theCRUDMenuUI;
    private MediaListUI theMediaListUI;
    private MediaDetailUI theMediaDetailUI;
    private CRUDSongUI theCRUDSongUI;
    private SongTableModel theSongTableModel;
    private VideoTableModel theVideoTableModel;
    private crudSongTableModel theCRUDSongTableModel;
    
    public CRUDMediaCntl()
    {
        System.out.println("Made it to MediaListCntl");
        requestCRUDMenuUI();
    }
    
    public Song getTheSongList(int row)
    {
        theSongList = new SongList();
        Song theSongDetail = theSongList.getSongDetail(row);
        
        return theSongDetail;
    }
    
    /*
    public Song getTheCRUDSongList(int row)
    {
        theSongList = new SongList();  
    }
    */
    
    public void requestCRUDSongUI()
    {
       theCRUDSongUI = new CRUDSongUI(this); 
    }
    
    public void requestCRUDMenuUI()
    {
        theCRUDMenuUI = new CRUDMenuUI(this);
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
    
    public SongTableModel getSongTableModel()
    {
        theSongTableModel = new SongTableModel();
        
        return theSongTableModel;
    }
    
    public crudSongTableModel getCRUDSongTableModel()
    {
        theCRUDSongTableModel = new crudSongTableModel();
        
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
    
    public void updateDouble(String theDouble, int row, int column)
    {
        theCRUDSongTableModel.updateDouble(theDouble, row, column);
    }
    
    public void updateInteger(String theInt, int row, int column)
    {
        theCRUDSongTableModel.updateInteger(theInt, row, column);
    }

    public VideoTableModel getVideoTableModel()
    {
        theVideoTableModel = new VideoTableModel();
        
        return theVideoTableModel;
    }
}
