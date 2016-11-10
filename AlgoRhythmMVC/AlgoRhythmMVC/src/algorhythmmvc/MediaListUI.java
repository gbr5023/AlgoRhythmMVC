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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
/*
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author Gisward
 */
public class MediaListUI implements TableModelListener
{
    private MediaListCntl theMediaListCntl;
    private JFrame theMediaNameFrame;
    private JTable theMediaNameTable;
    private JScrollPane theScrollPane;
    private JPanel theMediaTablePanel;
    private JPanel theButtonPanel;
    private JButton goButton;
    private JButton exitButton;
    private JButton backButton;
    //private TableModel theSongTableModel;
    private TableModel theCRUDSongTableModel;
    private TableModel theVideoTableModel;
    private JTableHeader theTableHeader;
    GridBagConstraints layoutConst; //layout manager
    
    public MediaListUI(MediaListCntl parentMediaListCntl)
    {
        this.theMediaListCntl = parentMediaListCntl;
        this.theCRUDSongTableModel = theMediaListCntl.getCRUDSongTableModel();
        setTheLayout();
    }
    
    private void setTheLayout()
    {
        theMediaNameTable = new JTable(this.theCRUDSongTableModel);
        //theMediaNameTable.repaint();
        
        theMediaNameTable.getModel().addTableModelListener(this);
        theMediaNameTable.setFont(new Font("Arial", Font.PLAIN, 15));
            for(int i = 0; i < theMediaNameTable.getRowCount(); i++)
            {
                theMediaNameTable.setRowHeight(i, 30);
            }      
        theMediaNameTable.setPreferredScrollableViewportSize(new Dimension(450,63));
        theMediaNameTable.setFillsViewportHeight(true);
        
        theTableHeader = new JTableHeader();          
        theTableHeader = theMediaNameTable.getTableHeader();        
        theTableHeader.setFont(new Font("Arial", Font.PLAIN, 20));
        theTableHeader.setPreferredSize(new Dimension(100, 40));
        
        theScrollPane = new JScrollPane(theMediaNameTable);
        theScrollPane.setViewportView(theMediaNameTable); 
        theScrollPane.setSize(new Dimension(40, 100));
        theScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        theScrollPane.setVisible(true);
        
        theMediaTablePanel = new JPanel(new BorderLayout());
        theMediaTablePanel.setSize(new Dimension(500,500));         
        theMediaTablePanel.add(theScrollPane);
        theMediaTablePanel.add(theTableHeader, BorderLayout.PAGE_START);
        
        theButtonPanel = new JPanel(new BorderLayout());
        
        backButton = new JButton("Back");
            backButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    backButtonActionPerformed(evt);
                }
            });  
        goButton = new JButton("Go");
            goButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    goButtonActionPerformed(evt);
                }
            }); 
        exitButton = new JButton("Exit");
            exitButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    exitButtonActionPerformed(evt);
                }
            });
            
        theButtonPanel.add(backButton);
        theButtonPanel.add(goButton);
        theButtonPanel.add(exitButton);
        theButtonPanel.setLayout(new FlowLayout());
        theButtonPanel.setSize(new Dimension(500,500));
        
        theMediaNameFrame = new JFrame("Media List");
        
        theMediaNameFrame.add(theMediaTablePanel); 
        
        theMediaNameFrame.add(theButtonPanel, BorderLayout.PAGE_END);
        
        theMediaNameFrame.pack();
        theMediaNameFrame.setSize(500, 500);
        theMediaNameFrame.setLocationRelativeTo(null);
        theMediaNameFrame.setVisible(true);
        theMediaNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    private void goButtonActionPerformed(ActionEvent evt) 
    {
        int row = theMediaNameTable.getSelectedRow();
        
        if(row == -1)
        {
            System.err.println("No row selected. Select 1 row");
        }
        else
        {
            theMediaNameFrame.setVisible(false);
            theMediaListCntl.requestMediaDetailUI(row);
        }
    }
    
    private void backButtonActionPerformed(ActionEvent evt)
    {
        theMediaNameFrame.setVisible(false);
        theMediaListCntl.requestCRUDMenuUI();
    }
    
    private void exitButtonActionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }
    
    @Override
    public void tableChanged(TableModelEvent tme) {
        int row = tme.getFirstRow();
        int col = tme.getColumn();
        TableModel model = (TableModel)tme.getSource();
        String columnName = model.getColumnName(col);
        Object data = model.getValueAt(row, col);
        
        // Do something with the data
    }
}
