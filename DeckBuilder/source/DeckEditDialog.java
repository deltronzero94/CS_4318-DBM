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

public class DeckEditDialog extends javax.swing.JDialog {

    private int deckid;
    
    public DeckEditDialog(java.awt.Frame parent, boolean modal, int deckid) 
    {
        super(parent, modal);
        initComponents();
        this.deckid = deckid;
        refresh();
    }

    private void refresh()
    {
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try
        {        
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmagicdb?" + "user=root&password=notmustard");
            preparedStatement = connect.prepareStatement("SELECT c.id, c.cardname, s.setname, c.manacost, c.cmc, c.cardtype, c.power, c.toughness, c.multiverseid, dhc.mainboardqty, dhc.sideboardqty" +
                                                            "\nFROM card c " +
                                                            "\nINNER JOIN deck_has_card dhc ON dhc.card_id = c.id " +
                                                            "\nINNER JOIN mtgset s ON s.idset = c.mtgset_idset " +
                                                            "\nWHERE dhc.deck_idDeck = ?");
            preparedStatement.setInt(1, deckid);
            resultSet = preparedStatement.executeQuery();
            DefaultTableModel tbl = (DefaultTableModel)tblDeck.getModel();
            tbl.setRowCount(0); 
            
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("cardname");
                String set = resultSet.getString("setname");
                String mana = resultSet.getString("manacost");
                float cmc = resultSet.getFloat("cmc");
                String type = resultSet.getString("cardtype");
                String power = resultSet.getString("power");
                String toughness = resultSet.getString("toughness");
                String multiverseid = resultSet.getString("multiverseid");
                int mainboardQty = resultSet.getInt("mainboardqty");
                int sideboardQty = resultSet.getInt("sideboardqty");
                Object [] arr = {id, name, set, mana, cmc, type, power, toughness, multiverseid, mainboardQty, sideboardQty};
                tbl.addRow(arr);
            }
            tblDeck.setModel(tbl);
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
        tblDeck = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        spnMainboard = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        spnSideboard = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDeck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CardID", "Card Name", "Set Name", "Mana", "CMC", "Type", "Power", "Toughness", "MultiverseID", "Mainboard Quantity", "Sideboard Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDeck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeckMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDeck);

        btnAdd.setText("Add Cards");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        spnMainboard.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));
        spnMainboard.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnMainboardStateChanged(evt);
            }
        });

        jLabel1.setText("Mainboard Quantity:");

        spnSideboard.setModel(new javax.swing.SpinnerNumberModel(0, 0, 4, 1));
        spnSideboard.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSideboardStateChanged(evt);
            }
        });

        jLabel2.setText("Sideboard Quantity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spnMainboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(jLabel1)
                            .addComponent(spnSideboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnAdd)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnMainboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnSideboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        SearchDialogue newSearch = new SearchDialogue((JFrame) SwingUtilities.getWindowAncestor(this)
, false, deckid);
        newSearch.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblDeckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeckMouseClicked
        //spnMainboard.setValue(tblDeck.getValueAt(tblDeck.getSelectedRow(), 9));
        //spnSideboard.setValue(tblDeck.getValueAt(tblDeck.getSelectedRow(), 10));
    }//GEN-LAST:event_tblDeckMouseClicked

    private void spnSideboardStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSideboardStateChanged
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        try
        {        
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmagicdb?" + "user=root&password=notmustard");
            preparedStatement = connect.prepareStatement("UPDATE deck_has_card SET sideboardqty = ?");
            preparedStatement.setInt(1, (int)spnSideboard.getValue());
            preparedStatement.executeUpdate();
            refresh();
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
    }//GEN-LAST:event_spnSideboardStateChanged

    private void spnMainboardStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnMainboardStateChanged
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        try
        {        
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmagicdb?" + "user=root&password=notmustard");
            preparedStatement = connect.prepareStatement("UPDATE deck_has_card SET mainboardqty = ?");
            preparedStatement.setInt(1, (int)spnMainboard.getValue());
            preparedStatement.executeUpdate();
            refresh();
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
    }//GEN-LAST:event_spnMainboardStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnMainboard;
    private javax.swing.JSpinner spnSideboard;
    private javax.swing.JTable tblDeck;
    // End of variables declaration//GEN-END:variables
}
