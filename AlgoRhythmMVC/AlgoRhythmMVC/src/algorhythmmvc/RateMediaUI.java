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
/**
 *
 * @author Gisward
 */
public class RateMediaUI implements TableModelListener
{
    private MediaListCntl theMediaListCntl;
    private RateMediaDetailsUI theRateMediaDetailsUI;
    
    private JFrame rateMediaFrame;
    private JPanel rateMediaPanel;
    private JTable rateMediaTable;
    
    private TableModel theRateMediaTableModel;
    private JTableHeader theTableHeader;
    
    private JScrollPane rateMediaScrollPane;
    
    private JLabel nameLabel;
    private JLabel artistLabel;
    private JLabel lengthLabel;
    private JLabel ratingLabel;
    
    private JTextField nameTextField;
    private JTextField artistTextField;
    private JTextField lengthTextField;
    private JTextField ratingTextField;
    
    private JButton updateButton;
    private JButton infoButton;
    private JButton backButton;
    private JButton exitButton;
    
    public RateMediaUI(MediaListCntl parentMediaListCntl)
    {
        this.theMediaListCntl = parentMediaListCntl;
        this.theRateMediaTableModel = theMediaListCntl.getCRUDSongTableModel();
        setTheLayout();
    }
    
    public void setTheLayout()
    {
        this.rateMediaFrame = new JFrame("Rate Media");
        
        rateMediaTable = new JTable(this.theRateMediaTableModel);
        rateMediaTable.getModel().addTableModelListener(this);
        rateMediaTable.setFont(new Font("Arial", Font.PLAIN, 14));
            for(int i = 0; i < rateMediaTable.getRowCount(); i++)
            {
                rateMediaTable.setRowHeight(i, 28);
            }       
        rateMediaTable.setPreferredScrollableViewportSize(new Dimension(450,63));
        rateMediaTable.setFillsViewportHeight(true);
        
        Font font = new Font("",1,18);
        rateMediaTable.setFont(font);
        rateMediaTable.setRowHeight(28);
        rateMediaTable.addMouseListener(new MouseAdapter()
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
        
        nameTextField = new JTextField();
        artistTextField = new JTextField();
        lengthTextField = new JTextField();
        ratingTextField = new JTextField();
        
        nameTextField.setText("Select Row".toString());
        artistTextField.setText("Select Row".toString());
        lengthTextField.setText(Double.toString(0.0));
        ratingTextField.setText(Double.toString(0.0));
        
        nameTextField.setEditable(false);
        artistTextField.setEditable(false);
        lengthTextField.setEditable(false);
        ratingTextField.setEditable(true);
        
        nameLabel.setBounds(20, 220, 100, 30);
        artistLabel.setBounds(230, 220, 100, 30);
        lengthLabel.setBounds(440, 220, 100, 30);
        ratingLabel.setBounds(650, 220, 200, 30);
        
        nameTextField.setBounds(100, 220, 100, 30);
        artistTextField.setBounds(310, 220, 100, 30);
        lengthTextField.setBounds(530, 220, 100, 30);
        ratingTextField.setBounds(760, 220, 100, 30);
        
        updateButton = new JButton("Update");
        infoButton = new JButton("Media Info");
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
        
        updateButton.setBounds(320, 260, 100, 25);
            updateButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    updateButtonActionPerformed(evt);
                }
            });
            
        infoButton.setBounds(440, 260, 100, 25);
            infoButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    infoButtonActionPerformed(evt);
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
        theTableHeader = rateMediaTable.getTableHeader();        
        theTableHeader.setFont(new Font("Arial", Font.PLAIN, 18));
        theTableHeader.setPreferredSize(new Dimension(100, 40));
        
        rateMediaScrollPane = new JScrollPane(rateMediaTable);
        rateMediaScrollPane.setBounds(0, 0, 880, 200);
        rateMediaScrollPane.setViewportView(rateMediaTable); 
        rateMediaScrollPane.setSize(new Dimension(880, 200));
        rateMediaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        rateMediaScrollPane.setVisible(true);
        
        rateMediaPanel = new JPanel();
        rateMediaPanel.add(theTableHeader, BorderLayout.PAGE_START);
        rateMediaPanel.add(rateMediaScrollPane);
        
        rateMediaFrame.setLayout(null);
        rateMediaFrame.add(rateMediaScrollPane);
        //crudSongFrame.add(regularButtonPanel, BorderLayout.PAGE_END);
        
        rateMediaFrame.add(nameLabel);
        rateMediaFrame.add(artistLabel);
        rateMediaFrame.add(lengthLabel);
        rateMediaFrame.add(ratingLabel);
        
        rateMediaFrame.add(nameTextField);
        rateMediaFrame.add(artistTextField);
        rateMediaFrame.add(lengthTextField);
        rateMediaFrame.add(ratingTextField);
        
        rateMediaFrame.add(updateButton);
        rateMediaFrame.add(infoButton);
        rateMediaFrame.add(backButton);
        rateMediaFrame.add(exitButton);
        
        
        rateMediaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rateMediaFrame.pack();
        rateMediaFrame.setSize(new Dimension(900, 450));
        rateMediaFrame.setLocationRelativeTo(null);
        rateMediaFrame.setVisible(true);
    }

    public void setCRUDSongTable()
    {
        theMediaListCntl.setCRUDSongTable(rateMediaTable);
    }
     
    public void updateButtonActionPerformed(ActionEvent evt)
    {
        // i = the index of the selected row
        int row = rateMediaTable.getSelectedRow();
        double rating = Double.parseDouble(ratingTextField.getText());
        String theName = nameTextField.getText();
        String theArtist = artistTextField.getText();
        double theLength = Double.parseDouble(lengthTextField.getText());
                
        if(row >= 0) 
        {
            if(rating > 5)
            {
                System.err.println("Update Error. ENTER RATING LESSER OR EQUAL TO 5.");
            }
            else
            {
                if(theName.equalsIgnoreCase("Select Row") || theArtist.equalsIgnoreCase("Select Row") || theLength == 0)
                {
                    System.err.println("Update Error. SELECT A ROW.");
                }
                else if(row == -1)
                {
                    System.err.println("Update Error. SELECT A ROW.");
                }
                else
                {
                    theMediaListCntl.updateName(nameTextField.getText(), row, 0);
                    theMediaListCntl.updateArtist(artistTextField.getText(), row, 1);
                    theMediaListCntl.updateDoubleLength(lengthTextField.getText(), row, 2);
                    theMediaListCntl.updateDoubleRating(ratingTextField.getText(), row, 3);
                }
                
            }
        }
        else
        {
            System.err.println("Update Error. SELECT A ROW.");
        }
            
    }
    
    public void infoButtonActionPerformed(ActionEvent evt)
    {
        int row = rateMediaTable.getSelectedRow();
        
        if(row == -1)
        {
            System.err.println("Media Info Error. SELECT A ROW.");
        }
        else
        {
            this.rateMediaFrame.setVisible(false);
            this.theRateMediaDetailsUI = new RateMediaDetailsUI(this.theMediaListCntl, row, "rate");
        }
    }
    
    public void mouseClickedActionPerformed(MouseEvent evt)
    {
        int i = rateMediaTable.getSelectedRow();
            
            nameTextField.setText(theRateMediaTableModel.getValueAt(i, 0).toString());
            artistTextField.setText(theRateMediaTableModel.getValueAt(i, 1).toString());
            lengthTextField.setText(theRateMediaTableModel.getValueAt(i, 2).toString());
            ratingTextField.setText(theRateMediaTableModel.getValueAt(i, 3).toString());
    }
    
    public void backButtonActionPerformed(ActionEvent evt)
    {
        //theCRUDSongTableModel.
        rateMediaFrame.setVisible(false);
        theMediaListCntl.requestCRUDMenuUI();
    }
    
    public void exitButtonActionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }
    
    @Override
    public void tableChanged(TableModelEvent tme) {
        int row = tme.getFirstRow();
        int col = tme.getColumn();
        TableModel model = (TableModel)tme.getSource();
        String columnName = model.getColumnName(col);
        Object data = model.getValueAt(row, col);    }
}
