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
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class CRUDSongUI implements TableModelListener
{
    private JFrame crudSongFrame;
    private JPanel crudSongPanel;
    private JTable crudSongTable;
    private TableModel theSongTableModel;
    private JTableHeader theTableHeader;
    
    private JScrollPane crudSongScrollPane;
    
    private JTextField nameTextField;
    private JTextField artistTextField;
    private JTextField lengthTextField;
    private JTextField ratingTextField;
    
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton backButton;
    private JButton exitButton;
    
    private CRUDMediaCntl theCRUDMediaCntl;
    
    public CRUDSongUI(CRUDMediaCntl parentMediaListCntl)
    {
        this.theCRUDMediaCntl = parentMediaListCntl;
        this.theSongTableModel = theCRUDMediaCntl.getCRUDSongTableModel();
        setTheLayout();
    }
    
    public void setTheLayout()
    {
        crudSongFrame = new JFrame("Create, ReadS, Update, Delete Media");
        
        crudSongTable = new JTable(this.theSongTableModel);
        crudSongTable.getModel().addTableModelListener(this);
        crudSongTable.setFont(new Font("Arial", Font.PLAIN, 14));
            for(int i = 0; i < crudSongTable.getRowCount(); i++)
            {
                crudSongTable.setRowHeight(i, 28);
            }      
        crudSongTable.setPreferredScrollableViewportSize(new Dimension(450,63));
        crudSongTable.setFillsViewportHeight(true);
        
        crudSongTable.setBackground(Color.LIGHT_GRAY);
        crudSongTable.setForeground(Color.black);
        Font font = new Font("",1,18);
        crudSongTable.setFont(font);
        crudSongTable.setRowHeight(28);
        crudSongTable.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                mouseClickedActionPerformed(evt);
            }
        });
        
        nameTextField = new JTextField();
        artistTextField = new JTextField();
        lengthTextField = new JTextField();
        ratingTextField = new JTextField();
        
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");
        exitButton = new JButton("Exit");
        
        nameTextField.setBounds(20, 220, 100, 25);
        artistTextField.setBounds(20, 250, 100, 25);
        lengthTextField.setBounds(20, 280, 100, 25);
        ratingTextField.setBounds(20, 310, 100, 25);
        
        addButton.setBounds(150, 220, 100, 25);
            addButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    addButtonActionPerformed(evt);
                }
            });
        updateButton.setBounds(150, 265, 100, 25);
            updateButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    updateButtonActionPerformed(evt);
                }
            });
        deleteButton.setBounds(150, 310, 100, 25);
            deleteButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    deleteButtonActionPerformed(evt);
                }
            });
        backButton.setBounds(150, 355, 100, 25);
            backButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    backButtonActionPerformed(evt);
                }
            });
        exitButton.setBounds(150, 400, 100, 25);
            exitButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    exitButtonActionPerformed(evt);
                }
            });
            
        theTableHeader = new JTableHeader();          
        theTableHeader = crudSongTable.getTableHeader();        
        theTableHeader.setFont(new Font("Arial", Font.PLAIN, 18));
        theTableHeader.setPreferredSize(new Dimension(100, 40));
        
        crudSongScrollPane = new JScrollPane(crudSongTable);
        crudSongScrollPane.setBounds(0, 0, 880, 200);
        crudSongScrollPane.setViewportView(crudSongTable); 
        crudSongScrollPane.setSize(new Dimension(880, 200));
        crudSongScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        crudSongScrollPane.setVisible(true);
        
        crudSongPanel = new JPanel(new BorderLayout());
        crudSongPanel.setSize(new Dimension(500,500));         
        crudSongPanel.add(crudSongScrollPane);
        crudSongPanel.add(theTableHeader, BorderLayout.PAGE_START);
        
        crudSongFrame.setLayout(null);
        
        crudSongFrame.add(crudSongScrollPane);
        crudSongFrame.add(nameTextField);
        crudSongFrame.add(artistTextField);
        crudSongFrame.add(lengthTextField);
        crudSongFrame.add(ratingTextField);
        
        crudSongFrame.add(addButton);
        crudSongFrame.add(updateButton);
        crudSongFrame.add(deleteButton);
        crudSongFrame.add(backButton);
        crudSongFrame.add(exitButton);
        
        
        crudSongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crudSongFrame.pack();
        crudSongFrame.setSize(new Dimension(900, 500));
        crudSongFrame.setLocationRelativeTo(null);
        crudSongFrame.setVisible(true);
    }
    
    public void addButtonActionPerformed(ActionEvent evt)
    {
        String name = nameTextField.getText();
        String artist = artistTextField.getText();
        double length = Double.parseDouble(lengthTextField.getText());
        int rating = Integer.parseInt(ratingTextField.getText());
        Song row = new Song(name, artist, length, rating);
        theCRUDMediaCntl.addRow(row);
    }
    
    public void updateButtonActionPerformed(ActionEvent evt)
    {
        // i = the index of the selected row
        int row = crudSongTable.getSelectedRow();
                
        if(row >= 0) 
        {
            theCRUDMediaCntl.updateName(nameTextField.getText(), row, 0);
            theCRUDMediaCntl.updateArtist(artistTextField.getText(), row, 1);
            theCRUDMediaCntl.updateDouble(lengthTextField.getText(), row, 2);
            theCRUDMediaCntl.updateInteger(ratingTextField.getText(), row, 3);
        }
        else
        {
            System.out.println("Update Error");
        }
            
    }
    
    public void mouseClickedActionPerformed(MouseEvent evt)
    {
        int i = crudSongTable.getSelectedRow();
            
            nameTextField.setText(theSongTableModel.getValueAt(i, 0).toString());
            artistTextField.setText(theSongTableModel.getValueAt(i, 1).toString());
            lengthTextField.setText(theSongTableModel.getValueAt(i, 2).toString());
            ratingTextField.setText(theSongTableModel.getValueAt(i, 3).toString());
    }
    
    public void deleteButtonActionPerformed(ActionEvent evt)
    {
        int row = crudSongTable.getSelectedRow();
        if(row >= 0)
        {
            theCRUDMediaCntl.removeRow(row);
        }
        else
        {
            System.out.println("Delete Error");
        }
    }
    
    public void backButtonActionPerformed(ActionEvent evt)
    {
        crudSongFrame.setVisible(false);
        theCRUDMediaCntl.requestCRUDMenuUI();
    }
    
    public void exitButtonActionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }
    
    public void tableChanged(TableModelEvent tme) {
        int row = tme.getFirstRow();
        int col = tme.getColumn();
        TableModel model = (TableModel)tme.getSource();
        String columnName = model.getColumnName(col);
        Object data = model.getValueAt(row, col);
        
        // Do something with the data
    }
}
