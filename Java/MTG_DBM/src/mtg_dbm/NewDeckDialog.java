package mtg_dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class NewDeckDialog extends javax.swing.JDialog {

    public NewDeckDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cbFormat.setModel(new DefaultComboBoxModel(populateComboListFormat().toArray()));
    }
    
    /**
     * populateComboListFormat () function
     * -------------------------------------
     * Returns ArrayList<String> of Formats currently available in database
     */
    private ArrayList<String> populateComboListFormat()
    {
        //Declared Variables
        ArrayList<String> l = new ArrayList<String>();  //Stores ArrayList of Formats
        l.add("");  //Adds Default Blank 
        
        try 
        {   Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/temp_mtg?" + "user=root&password=q1w2e3r4");
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Format");
            
            while(resultSet.next())
            {
                l.add(resultSet.getString("FormatName"));
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error with importing Format List");
        }
        
        return l;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDeckName = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbFormat = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Deck");
        setResizable(false);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel1.setText("Deck Name");

        jLabel2.setText("Format:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDeckName, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(cbFormat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate)
                    .addComponent(txtDeckName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreate, jLabel1, txtDeckName});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        Authenticator auth = Authenticator.getInstance();
        
        System.out.println(auth.getLoggedInUser());
        
        try
        {        
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/temp_mtg?" + "user=root&password=q1w2e3r4");
            preparedStatement = connect.prepareStatement("INSERT INTO Deck (DeckName, Format)"
                    + " VALUES(?, ?)");
            preparedStatement.setString(1, txtDeckName.getText());
            preparedStatement.setString(2, (String)cbFormat.getSelectedItem());
            preparedStatement.executeUpdate();
            preparedStatement = connect.prepareStatement("INSERT INTO UserDeck VALUES (?, LAST_INSERT_ID(), true)");
            preparedStatement.setString(1, auth.getLoggedInUser());
            preparedStatement.executeUpdate();
            
            this.dispose();
            
        }   
        catch (Exception e)
        {
            
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<String> cbFormat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtDeckName;
    // End of variables declaration//GEN-END:variables
}
