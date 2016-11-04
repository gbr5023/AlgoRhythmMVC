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
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gisward
 */
public class crudSongTableModel extends AbstractTableModel
{
    private ArrayList<Song> theSongDetailList; //initialized by theMediaList.getTheMediaNameList()
    private SongList theMediaList; //must access getter methods to initialize ArrayList<String> theMediaNameList & colMediaNameArray[]
    private String colMediaArray[]; // initialized by theMediaList.getColMediaNameArray()

    public crudSongTableModel()
    {
        theMediaList = new SongList();
        theSongDetailList = theMediaList.getTheSongList();
        colMediaArray = theMediaList.getColMediaArray();
    }
    
    public void addRow(Song rowData)
    {
        theSongDetailList.add(rowData);
        super.fireTableRowsInserted(theSongDetailList.size() - 1, theSongDetailList.size() - 1);
    }
    
    public void removeRow(int row)
    {
        theSongDetailList.remove(row);
        //Song theRowRemoved = theSongDetailList.get(row);
        //super.fireTableRowsDeleted(theSongDetailList.indexOf(theRowRemoved), theSongDetailList.indexOf(theRowRemoved));
        fireTableRowsDeleted(row, row);
    }
    
    public void updateName(String theName, int row, int column)
    {
        theSongDetailList.get(row).setMediaName(theName);
        //Song theRow = theSongDetailList.get(row);
        //theRow.setMediaName(theName);
        //theSongDetailList.set(row, theRow);
        super.fireTableRowsUpdated(row, row);
        //super.fireTableCellUpdated(row, column);
    }
    
    public void updateArtist(String theArtist, int row, int column)
    {
        theSongDetailList.get(row).setMediaArtist(theArtist);
        //Song theRow = theSongDetailList.get(row);
        //theRow.setMediaArtist(theArtist);
        //theSongDetailList.set(row, theRow);
        super.fireTableRowsUpdated(row, row);
        //super.fireTableCellUpdated(row, column);
    }
    
    public void updateDouble(String theDouble, int row, int column)
    {
        //Song theRow = theSongDetailList.get(row);
        double length = Double.parseDouble(theDouble);
        theSongDetailList.get(row).setMediaLength(length);
        //theRow.setMediaLength(length);
        //theSongDetailList.set(row, theRow);
        super.fireTableRowsUpdated(row, row);        
        //super.fireTableCellUpdated(row, column);
    }
    
    public void updateInteger(String theInt, int row, int column)
    {
        //Song theRow = theSongDetailList.get(row);
        int rating = Integer.parseInt(theInt);
        theSongDetailList.get(row).setMediaRating(rating);
        //theRow.setMediaRating(rating);
        //theSongDetailList.set(row, theRow);
        super.fireTableRowsUpdated(row, row);
        //super.fireTableCellUpdated(row, column);
    }
    
    @Override
    public int getRowCount() 
    {
        return theSongDetailList.size();
    }

    @Override
    public int getColumnCount() 
    {
        return colMediaArray.length;
    }

    @Override //must override original abstract method from AbstractTableModel
    public String getColumnName(int column) 
    {
        try
        {
            return colMediaArray[column];
        }
        catch(Exception e)
        {
            return "Media not updated.";
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) 
    {
        
        Song theSong = theSongDetailList.get(row);
        switch(column)
        {
            case 0:
                return theSong.getMediaName();
            case 1:
                return theSong.getMediaArtist();
            case 2:
                return theSong.getMediaLength();
            case 3:
                return theSong.getMediaRating();
            default:
                return null;
        }
    }
    
    public boolean isCellEditable(int row, int col) 
    {
        return false;//col == 3;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     
    public void setValueAt(Object value, int row, int col) {
        //data[row][col] = value;
        
        switch(col)
        {
            case 0:
                value = theSongDetailList.
                break;
                
            default:
                break;
        }
        
        fireTableCellUpdated(row, col);
    }
    */
    public Class getColumnClass(int c)
    {
        return getValueAt(0, c).getClass();
    }
}
