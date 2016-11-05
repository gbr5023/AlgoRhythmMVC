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

public class crudSongUI implements TableModelListener
{
    private JFrame crudSongFrame;
    private JPanel crudSongPanel;
    //private JPanel crudFieldsPanel;
    //private JPanel crudButtonPanel;
    //private JPanel regularButtonPanel;
    private JTable crudSongTable;
    
    private TableModel theCRUDSongTableModel;
    private JTableHeader theTableHeader;
    
    private JScrollPane crudSongScrollPane;
    
    private JLabel nameLabel;
    private JLabel artistLabel;
    private JLabel lengthLabel;
    private JLabel ratingLabel;
    
    private JTextField nameTextField;
    private JTextField artistTextField;
    private JTextField lengthTextField;
    private JTextField ratingTextField;
    
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton backButton;
    private JButton exitButton;
    
    private MediaListCntl theMediaListCntl;
    
    public crudSongUI(MediaListCntl parentMediaListCntl)
    {
        this.theMediaListCntl = parentMediaListCntl;
        this.theCRUDSongTableModel = theMediaListCntl.getCRUDSongTableModel();
        setTheLayout();
    }
    
    public void setTheLayout()
    {
        crudSongFrame = new JFrame("Create, Read, Update, Delete Media");
        
        crudSongTable = new JTable(this.theCRUDSongTableModel);
        crudSongTable.getModel().addTableModelListener(this);
        crudSongTable.setFont(new Font("Arial", Font.PLAIN, 14));
            for(int i = 0; i < crudSongTable.getRowCount(); i++)
            {
                crudSongTable.setRowHeight(i, 28);
            }       
        crudSongTable.setPreferredScrollableViewportSize(new Dimension(450,63));
        crudSongTable.setFillsViewportHeight(true);
        
        //crudSongTable.setBackground(Color.LIGHT_GRAY);
        //crudSongTable.setForeground(Color.black);
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
        
        nameLabel = new JLabel("Media Name");
        artistLabel = new JLabel("Media Artist");
        lengthLabel = new JLabel("Media Length");
        ratingLabel = new JLabel("Media Avg Rating");
        
        //nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        //artistLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        //lengthLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        //ratingLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        
        nameTextField = new JTextField();
        artistTextField = new JTextField();
        lengthTextField = new JTextField();
        ratingTextField = new JTextField();
        
        nameTextField.setText("Select Row".toString());
        artistTextField.setText("Select Row".toString());
        lengthTextField.setText(Double.toString(0.0));
        ratingTextField.setText(Double.toString(0.0));
        
        //nameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        //artistTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        //lengthTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        //ratingTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");
        exitButton = new JButton("Exit");
        
        nameLabel.setBounds(20, 220, 100, 30);
        artistLabel.setBounds(230, 220, 100, 30);
        lengthLabel.setBounds(440, 220, 100, 30);
        ratingLabel.setBounds(650, 220, 200, 30);
        
        nameTextField.setBounds(100, 220, 100, 30);
        artistTextField.setBounds(310, 220, 100, 30);
        lengthTextField.setBounds(530, 220, 100, 30);
        ratingTextField.setBounds(760, 220, 100, 30);
        
        addButton.setBounds(260, 260, 100, 25);
            addButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    addButtonActionPerformed(evt);
                }
            });
        updateButton.setBounds(380, 260, 100, 25);
            updateButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    updateButtonActionPerformed(evt);
                }
            });
        deleteButton.setBounds(500, 260, 100, 25);
            deleteButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    deleteButtonActionPerformed(evt);
                }
            });        
        backButton.setBounds(320, 340, 100, 25);
            backButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    backButtonActionPerformed(evt);
                }
            });
        exitButton.setBounds(440, 340, 100, 25);
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
        
        crudSongPanel = new JPanel();
        crudSongPanel.add(theTableHeader, BorderLayout.PAGE_START);
        crudSongPanel.add(crudSongScrollPane);
        
        //crudFieldsPanel = new JPanel();
        
        //crudButtonPanel = new JPanel(new FlowLayout());
        
        //regularButtonPanel = new JPanel(new FlowLayout());
        //regularButtonPanel.add(backButton);
        //regularButtonPanel.add(exitButton);
        //regularButtonPanel.setSize(new Dimension(500, 500));
        
        crudSongFrame.setLayout(null);
        crudSongFrame.add(crudSongScrollPane);
        //crudSongFrame.add(regularButtonPanel, BorderLayout.PAGE_END);
        
        crudSongFrame.add(nameLabel);
        crudSongFrame.add(artistLabel);
        crudSongFrame.add(lengthLabel);
        crudSongFrame.add(ratingLabel);
        
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
        crudSongFrame.setSize(new Dimension(900, 450));
        crudSongFrame.setLocationRelativeTo(null);
        crudSongFrame.setVisible(true);
    }
    
    public void setCRUDSongTable()
    {
        theMediaListCntl.setCRUDSongTable(crudSongTable);
    }
    
    public void addButtonActionPerformed(ActionEvent evt)
    {
        String name = nameTextField.getText();
        String artist = artistTextField.getText();
        double length = Double.parseDouble(lengthTextField.getText());
        double rating = Double.parseDouble(ratingTextField.getText());
        
        if(name.equalsIgnoreCase("Select Row") || artist.equalsIgnoreCase("Select Row"))
        {
            System.err.println("Add Error. ENTER MEDIA NAME AND/OR ARTIST.");
        }
        else if(length == 0)
        {
            System.err.println("Add Error. ENTER LENGTH GREATER THAN 0.");
        }
        else if(rating > 5)
        {
            System.err.println("Add Error. ENTER RATING LESSER OR EQUAL TO 5.");
        }
        else
        {
            Song row = new Song(name, artist, length, rating);
            theMediaListCntl.addRow(row);
        }
    }
    
    public void updateButtonActionPerformed(ActionEvent evt)
    {
        // i = the index of the selected row
        int row = crudSongTable.getSelectedRow();
        double rating = Double.parseDouble(ratingTextField.getText());
                
        if(row >= 0) 
        {
            if(rating > 5)
            {
                System.err.println("Update Error. ENTER RATING LESSER OR EQUAL TO 5.");
            }
            else
            {
                theMediaListCntl.updateName(nameTextField.getText(), row, 0);
                theMediaListCntl.updateArtist(artistTextField.getText(), row, 1);
                theMediaListCntl.updateDoubleLength(lengthTextField.getText(), row, 2);
                theMediaListCntl.updateDoubleRating(ratingTextField.getText(), row, 3);
            }
        }
        else
        {
            System.err.println("Update Error. SELECT A ROW.");
        }
            
    }
    
    public void mouseClickedActionPerformed(MouseEvent evt)
    {
        int i = crudSongTable.getSelectedRow();
            
            nameTextField.setText(theCRUDSongTableModel.getValueAt(i, 0).toString());
            artistTextField.setText(theCRUDSongTableModel.getValueAt(i, 1).toString());
            lengthTextField.setText(theCRUDSongTableModel.getValueAt(i, 2).toString());
            ratingTextField.setText(theCRUDSongTableModel.getValueAt(i, 3).toString());
    }
    
    public void deleteButtonActionPerformed(ActionEvent evt)
    {
        int row = crudSongTable.getSelectedRow();
        if(row >= 0)
        {
            theMediaListCntl.removeRow(row);
            row = crudSongTable.getRowCount();
        }
        else
        {
            System.err.println("Delete Error. SELECT A ROW.");
        }
    }
    
    public void backButtonActionPerformed(ActionEvent evt)
    {
        //theCRUDSongTableModel.
        crudSongFrame.setVisible(false);
        theMediaListCntl.requestCRUDMenuUI();
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
