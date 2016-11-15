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

import java.util.ArrayList;
//mport javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gisward
 */
public class CRUDSongTableModel extends AbstractTableModel
{
    private ArrayList<Media> theMediaDetailList; //initialized by theMediaList.getTheMediaNameList()
    private MediaList theMediaList; //must access getter methods to initialize ArrayList<String> theMediaNameList & colMediaNameArray[]
    private String colMediaArray[]; // initialized by theMediaList.getColMediaNameArray()

    public CRUDSongTableModel()
    {
        theMediaList = new MediaList();
        theMediaDetailList = theMediaList.getTheMediaList();
        colMediaArray = theMediaList.getColMediaArray();
    }
    
    public ArrayList<Media> getUpdatedMediaDetailList()
    {
        return this.theMediaDetailList;
    }
    
    public void addRow(Media rowData)
    {
        theMediaDetailList.add(rowData);
        //super.fireTableRowsInserted(theSongDetailList.size() - 1, theSongDetailList.size() - 1);
        super.fireTableDataChanged();
    }
    
    public void removeRow(int row)
    {
        theMediaDetailList.remove(row);
        //Song theRowRemoved = theSongDetailList.get(row);
        //super.fireTableRowsDeleted(theSongDetailList.indexOf(theRowRemoved), theSongDetailList.indexOf(theRowRemoved));
        //fireTableRowsDeleted(row, row);
        super.fireTableDataChanged();
    }
    
    public void updateName(String theName, int row, int column)
    {
        theMediaDetailList.get(row).setMediaName(theName);
        //Song theRow = theSongDetailList.get(row);
        //theRow.setMediaName(theName);
        //theSongDetailList.set(row, theRow);
        //super.fireTableRowsUpdated(row, row);
        //super.fireTableCellUpdated(row, column);
        super.fireTableDataChanged();
    }
    
    public void updateArtist(String theArtist, int row, int column)
    {
        theMediaDetailList.get(row).setMediaArtist(theArtist);
        //Song theRow = theSongDetailList.get(row);
        //theRow.setMediaArtist(theArtist);
        //theSongDetailList.set(row, theRow);
        //super.fireTableRowsUpdated(row, row);
        //super.fireTableCellUpdated(row, column);
        super.fireTableDataChanged();
    }
    
    public void updateDoubleLength(String theDoubleLength, int row, int column)
    {
        //Song theRow = theSongDetailList.get(row);
        double length = Double.parseDouble(theDoubleLength);
        theMediaDetailList.get(row).setMediaLength(length);
        //theRow.setMediaLength(length);
        //theSongDetailList.set(row, theRow);
        //super.fireTableRowsUpdated(row, row);        
        //super.fireTableCellUpdated(row, column);
        super.fireTableDataChanged();
    }
    
    public void updateDoubleRating(String theDoubleRating, int row, int column)
    {
        //Song theRow = theSongDetailList.get(row);
        double rating = Double.parseDouble(theDoubleRating);
        
        theMediaDetailList.get(row).getMediaAvgRating();
        //theRow.setMediaRating(rating);
        //theSongDetailList.set(row, theRow);
        //super.fireTableRowsUpdated(row, row);
        //super.fireTableCellUpdated(row, column);
        super.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() 
    {
        return theMediaDetailList.size();
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
        
        Media theSong = theMediaDetailList.get(row);
        switch(column)
        {
            case 0:
                return theSong.getMediaName();
            case 1:
                return theSong.getMediaArtist();
            case 2:
                return theSong.getMediaLength();
            case 3:
                return theSong.getMediaAvgRating();
            default:
                return null;
        }
    }
    
    public boolean isCellEditable(int row, int column) 
    {
        /*
        switch(column)
        {
            
        }
        */
        return false;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     
    public void setValueAt(int row, int column) {
        //data[row][col] = value;
        Song theSong = theSongDetailList.get(row);
   
        switch(column)
        {
            case 0:
                //alue = theSongDetailList
                break;
                
            default:
                break;
        }
        
        fireTableCellUpdated(row, column);
    }
    
    public Class getColumnClass(int c)
    {
        return getValueAt(0, c).getClass();
    }
*/
}
