package mtg_dbm;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class DeckEditDialog extends javax.swing.JDialog {

    private int deckid;
    private Connection connect;
    
    public DeckEditDialog(java.awt.Frame parent, boolean modal, int deckid, Connection connect) 
    {
        super(parent, modal);
        initComponents();
        this.deckid = deckid;
        this.connect = connect;
        refresh();
        resizeColumnWidth(tblDeck);
    }

    private void refresh()
    {
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try
        {        
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/temp_mtg?" + "user=root&password=q1w2e3r4");
            preparedStatement = connect.prepareStatement("SELECT c.ID, c.CardName, s.SetName, c.ManaCost, c.CMC, c.CardType, c.Power, c.Toughness, c.MultiverseID, dhc.MainboardQty, dhc.SideboardQty" +
                                                            "\nFROM Card c " +
                                                            "\nINNER JOIN Deck_has_Card dhc ON dhc.Card_ID = c.ID " +
                                                            "\nINNER JOIN MTGSet s ON s.SetName = c.SetName " +
                                                            "\nWHERE dhc.idDeck = ?");
            preparedStatement.setInt(1, deckid);
            resultSet = preparedStatement.executeQuery();
            DefaultTableModel tbl = (DefaultTableModel)tblDeck.getModel();
            tbl.setRowCount(0); 
            
            while (resultSet.next())
            {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("CardName");
                String set = resultSet.getString("SetName");
                String mana = resultSet.getString("ManaCOst");
                float cmc = resultSet.getFloat("CMC");
                String type = resultSet.getString("CardType");
                String power = resultSet.getString("Power");
                String toughness = resultSet.getString("Toughness");
                String multiverseid = resultSet.getString("MultiverseID");
                int mainboardQty = resultSet.getInt("MainboardQty");
                int sideboardQty = resultSet.getInt("SideboardQty");
                Object [] arr = {id, name, set, mana, cmc, type, power, toughness, multiverseid, mainboardQty, sideboardQty};
                tbl.addRow(arr);
            }
            tblDeck.setModel(tbl);
        }   
        catch (Exception e)
        {
            e.printStackTrace();
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
        setTitle("Modify Deck");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(jLabel1)
                            .addComponent(spnSideboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
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
        //SearchDialog newSearch = new SearchDialog((JFrame) this.getOwner(), false, deckid);
        SearchDialog newSearch = new SearchDialog(deckid, connect);
        newSearch.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblDeckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeckMouseClicked
        //spnMainboard.setValue(tblDeck.getValueAt(tblDeck.getSelectedRow(), 9));
        //spnSideboard.setValue(tblDeck.getValueAt(tblDeck.getSelectedRow(), 10));
    }//GEN-LAST:event_tblDeckMouseClicked

    
    /**
     * resizeColumnWidth(JTable table) function
     * -------------------------------------
     * Resizes each column of the JTable according to its contents
     */
    public void resizeColumnWidth(JTable table) 
    {
        final TableColumnModel columnModel = table.getColumnModel();
        
        for (int column = 0; column < table.getColumnCount(); column++) {
            
            int width = 15; // Min width
            
            for (int row = 0; row < table.getRowCount(); row++) 
            {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
                if(width > 300)
                    width=300;
                else if (width < 300 && width >=200)
                    width = 250;
                else if (width < 200)
                    width = 200;
                     
                columnModel.getColumn(column).setPreferredWidth(width);
        }   
    }
    
    private void spnSideboardStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSideboardStateChanged
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        try
        {        
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/temp_mtg?" + "user=root&password=q1w2e3r4");
            preparedStatement = connect.prepareStatement("UPDATE Deck_has_Card SET SideboardQty = ?");
            preparedStatement.setInt(1, (int)spnSideboard.getValue());
            preparedStatement.executeUpdate();
            refresh();
        }   
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_spnSideboardStateChanged

    private void spnMainboardStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnMainboardStateChanged
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        try
        {        
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp_mtg?" + "user=root&password=q1w2e3r4");
            preparedStatement = connect.prepareStatement("UPDATE Deck_has_Card SET MainboardQty = ?");
            preparedStatement.setInt(1, (int)spnMainboard.getValue());
            preparedStatement.executeUpdate();
            refresh();
        }   
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_spnMainboardStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
            refresh();
    }//GEN-LAST:event_formWindowActivated

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
