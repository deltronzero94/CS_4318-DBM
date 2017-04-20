package mtg_dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewDeckDialog extends javax.swing.JDialog {

    public NewDeckDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDeckName = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtDeckName.setText("jTextField1");

        btnCreate.setText("jButton1");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(txtDeckName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreate)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeckName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate))
                .addGap(124, 124, 124))
        );

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
            preparedStatement.setString(2, null);
            preparedStatement.executeUpdate();
            preparedStatement = connect.prepareStatement("INSERT INTO UserDeck VALUES (?, LAST_INSERT_ID(), true)");
            preparedStatement.setString(1, auth.getLoggedInUser());
            preparedStatement.executeUpdate();
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
    }//GEN-LAST:event_btnCreateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JTextField txtDeckName;
    // End of variables declaration//GEN-END:variables
}
