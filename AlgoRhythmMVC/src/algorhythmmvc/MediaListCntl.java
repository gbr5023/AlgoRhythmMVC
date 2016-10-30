/*
Problem Set #4

Implement the AlgoRhythm use case Add Media

Users should be able to:
-Navigate to the media list view (use a JTable to display the list of media)
view the detail for the object
-Create new media, edit existing media, delete
-Select a media (eg a song) and view the detail for the object
-Create new media, edit existing media, delete media from the list
-Your implementation should conform to the MVC architecture pattern

Zip entire AlgoRhythm Netbeans project and submit to Canvas before due date and time
 */

package algorhythmmvc;

import java.util.ArrayList;


public class MediaListCntl 
{
    private SongList theSongList;
    private NavigationCntl theNavigationCntl;
    private MediaMenuUI theMediaMenuUI;
    private MediaListUI theMediaListUI;
    private MediaDetailUI theMediaDetailUI;
    private crudSongUI theCRUDSongUI;
    private SongTableModel theSongTableModel;
    private VideoTableModel theVideoTableModel;
    private crudSongTableModel theCRUDSongTableModel;
    
    public MediaListCntl()
    {
        System.out.println("Made it to MediaListCntl");
        requestMediaMenuUI();
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
       theCRUDSongUI = new crudSongUI(this); 
    }
    
    public void requestMediaMenuUI()
    {
        theMediaMenuUI = new MediaMenuUI(this);
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
