package mtg_dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class DeckBuilder extends javax.swing.JPanel {
    
    public DeckBuilder() 
    {
        Credentials cred = new Credentials("name", "password");
        Authenticator auth = Authenticator.getInstance();
        auth.authenticate("name", "password", cred);
        initComponents();
        refresh();
    }
    
    private void refresh()
    {
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        Authenticator auth = Authenticator.getInstance();
        
        ResultSet resultSet;
        try
        {        
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmagicdb?" + "user=root&password=notmustard");
            preparedStatement = connect.prepareStatement("SELECT d.iddeck, d.deckname, d.format, ud.visible "
                    + "FROM userdeck ud "
                    + "INNER JOIN deck d "
                    + "WHERE user_username = ?");
            preparedStatement.setString(1, auth.getLoggedInUser());
            resultSet = preparedStatement.executeQuery();
            DefaultTableModel tbl = (DefaultTableModel)tblDecks.getModel();
            tbl.setRowCount(0); 
            
            while (resultSet.next())
            {
                String Name = resultSet.getString("DeckName");
                String Format = resultSet.getString("Format");
                String Visible = resultSet.getString("Visible");
                int deckid = resultSet.getInt("iddeck");
                Object [] arr = {Name, Format, Visible, deckid};
                tbl.addRow(arr);
            }
            tblDecks.setModel(tbl);
        }   
        catch (Exception e)
        {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(DeckBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        finally
        {
            try
            {
                if (connect != null)
                {
                    connect.close();
                }
            }
            catch (Exception e)
            {
                
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDecks = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();

        tblDecks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Format", "Visible", "ID"
            }
        ));
        jScrollPane1.setViewportView(tblDecks);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnNew))
                .addContainerGap(184, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        DeckEditDialog editor = new DeckEditDialog((JFrame) SwingUtilities.getWindowAncestor(this)
, false, (int) tblDecks.getValueAt(tblDecks.getSelectedRow(), 3));
        editor.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        NewDeckDialog myDialogue = new NewDeckDialog((JFrame) SwingUtilities.getWindowAncestor(this)
, false);
        myDialogue.setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDecks;
    // End of variables declaration//GEN-END:variables
}
