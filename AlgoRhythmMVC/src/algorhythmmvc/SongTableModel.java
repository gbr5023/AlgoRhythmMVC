/*
Problem Set #4

Implement the AlgoRhythm use case Add Media

Users should be able to:
-Navigate to the media list view (use a JTable to display the list of media)

-Select a media (eg a song) and view the detail for the object
-Create new media, edit existing media, delete media from the list
-Your implementation should conform to the MVC architecture pattern

Zip entire AlgoRhythm Netbeans project and submit to Canvas before due date and time
 */

package algorhythmmvc;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gisward
 */
public class SongTableModel extends AbstractTableModel
{
    private ArrayList<String> theMediaNameList; //initialized by theMediaList.getTheMediaNameList()
    private SongList theMediaList; //must access getter methods to initialize ArrayList<String> theMediaNameList & colMediaNameArray[]
    private String colMediaNameArray[]; // initialized by theMediaList.getColMediaNameArray()

    /**
     * SongNamesTableModel(): Constructor that initializes theMediaNameList, 
     *                        theMediaList object and colMediaNameArray String array.
     *                        Access theMediaList's methods to obtain the 
     *                        theMediaNameList and colMediaNameArray String array.
     */
    public SongTableModel() 
    {
        theMediaList = new SongList();
        theMediaNameList = theMediaList.getTheMediaNameList();
        colMediaNameArray = theMediaList.getColMediaNameArray();
    } 
    
    /**
     * getRowCount(): Return the number of rows in ArrayList<String> theMediaNameList.
                      Necessary to set the number of rows in the JTable theMediaTable.
     * @return number of rows in ArrayList<String> theMediaNameList.
     */
    @Override //must override original abstract method from AbstractTableModel
    public int getRowCount() 
    {
        return theMediaNameList.size();
    }

    /**
     * getColumnCount(): Return the number of columns in String[] colMediaNameArray.
                         Necessary to set the number of columns in the JTable theMediaTable.
     * @return number of columns in String[] colMediaNameArray.
     */
    @Override //must override original abstract method from AbstractTableModel
    public int getColumnCount() 
    {
        return this.colMediaNameArray.length;
    }
    
    /**
     * getColumnName(): Displays column headers in String[] colMediaNameArray.
                        Necessary for getTableHeader() to display the JTable headers.
                        In this case, the header is only "Media".
     * @param column
     * @return columnName from colMediaNameArray[column] = "Media"
     */
    @Override //must override original abstract method from AbstractTableModel
    public String getColumnName(int column) 
    {
        return colMediaNameArray[column];
    }

    /**
     * getValueAt(): Returns the object that is at the intersection of the row and column.
                     Necessary for filling the JTable with String objects from
                     theMediaNameList.
     * @param row
     * @param col
     * @return Object that is at the intersection of the row and column
     */
    @Override
    public Object getValueAt(int row, int col) 
    {
        Object objectToReturn = new Object();
        switch(col)
        {
            case 0:
                objectToReturn = theMediaNameList.get(row);
                break;
            default:
                return null;
        }
        
        return objectToReturn;
    }
    
    public Class getColumnClass(int c) 
    {
        return getValueAt(0, c).getClass();
    }
    
    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        //data[row][col] = value;
        
        switch(col)
        {
            case 0:
                value = theMediaNameList.get(row);
                break;
            default:
                break;
        }
        
        fireTableCellUpdated(row, col);
    }
}
