package mtg_dbm;

import java.awt.Component;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SearchDialog extends javax.swing.JDialog {

        private int deckid;
    public SearchDialog(java.awt.Frame parent, boolean modal, int deckid) {
        super(parent, modal);
        initComponents();
        this.deckid = deckid;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCardName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblPicture = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCardResult = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbSearchColorWhite = new javax.swing.JCheckBox();
        cbSearchColorBlue = new javax.swing.JCheckBox();
        cbSearchColorBlack = new javax.swing.JCheckBox();
        cbSearchColorRed = new javax.swing.JCheckBox();
        cbSearchColorGreen = new javax.swing.JCheckBox();
        comboSearchFormat = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboSearchSet = new javax.swing.JComboBox<>();
        btnResetFormat = new javax.swing.JButton();
        btnResetSet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbSearchColorIdentityWhite = new javax.swing.JCheckBox();
        cbSearchColorIdentityBlue = new javax.swing.JCheckBox();
        cbSearchColorIdentityBlack = new javax.swing.JCheckBox();
        cbSearchColorIdentityRed = new javax.swing.JCheckBox();
        cbSearchColorIdentityGreen = new javax.swing.JCheckBox();
        txtType = new javax.swing.JTextField();
        comboSearchType = new javax.swing.JComboBox<>();
        btnResetAll = new javax.swing.JButton();
        comboSearchColor = new javax.swing.JComboBox<>();
        comboSearchColorIdentity = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbSearchCommon = new javax.swing.JCheckBox();
        cbSearchUncommon = new javax.swing.JCheckBox();
        cbSearchRare = new javax.swing.JCheckBox();
        cbSearchMythicRare = new javax.swing.JCheckBox();
        txtText = new javax.swing.JTextField();
        comboSearchText = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboSearchPrinting = new javax.swing.JComboBox<>();
        btnResetPrinting = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboSearchPowerSign = new javax.swing.JComboBox<>();
        comboSearchToughnessSign = new javax.swing.JComboBox<>();
        comboSearchPower = new javax.swing.JComboBox<>();
        comboSearchToughness = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboSearchCMCSign = new javax.swing.JComboBox<>();
        comboSearchCMC = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPanelInfo = new javax.swing.JTextPane();
        btnSearchDisplayRule = new javax.swing.JButton();
        btnSearchDisplayText = new javax.swing.JButton();
        btnSearchCardFlip = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(1250, 820));

        txtCardName.setText("Name");
        txtCardName.setToolTipText("Name");
        txtCardName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCardNameMouseClicked(evt);
            }
        });
        txtCardName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCardNameKeyReleased(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jScrollPane2.setMaximumSize(new java.awt.Dimension(440, 415));

        tblCardResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CardID", "Card Name", "Set Name", "Mana", "CMC", "Type", "Power", "Toughness", "MultiverseID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCardResult.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCardResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCardResultMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCardResult);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Search Color");

        cbSearchColorWhite.setText("White");

        cbSearchColorBlue.setText("Blue");

        cbSearchColorBlack.setText("Black");

        cbSearchColorRed.setText("Red");

        cbSearchColorGreen.setText("Green");

        comboSearchFormat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "Modern", "Legacy", "Commander", "Vintage" }));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Filter By:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Format:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Set:");

        comboSearchSet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnResetFormat.setText("Reset");
        btnResetFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetFormatActionPerformed(evt);
            }
        });

        btnResetSet.setText("Reset");
        btnResetSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetSetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Seach Color Identity");

        cbSearchColorIdentityWhite.setText("White");

        cbSearchColorIdentityBlue.setText("Blue");

        cbSearchColorIdentityBlack.setText("Black");

        cbSearchColorIdentityRed.setText("Red");

        cbSearchColorIdentityGreen.setText("Green");

        txtType.setText("Type");
        txtType.setToolTipText("(Super)Type");
        txtType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTypeMouseClicked(evt);
            }
        });

        comboSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All types", "Any type(s)", "NOT any selected type(s)" }));

        btnResetAll.setText("Reset All");
        btnResetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAllActionPerformed(evt);
            }
        });

        comboSearchColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Match Any Color(s)", "Match Colors Exactly", "Exclude Unselected Colors", "Match Multicolored Cards Only" }));

        comboSearchColorIdentity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "May include any color(s)", "Exact (all selected and no others)" }));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setText("Rarity:");

        cbSearchCommon.setText("Common");

        cbSearchUncommon.setText("Uncommon");

        cbSearchRare.setText("Rare");

        cbSearchMythicRare.setText("Mythic Rare");

        txtText.setText("Text");
        txtText.setToolTipText("Text");
        txtText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTextMouseClicked(evt);
            }
        });

        comboSearchText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Words", "Any Word(s)", "Exact Phrase" }));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("Printing:");

        comboSearchPrinting.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Most Recent Printing", "Original Printing", "All Printing", "Reprints Only" }));

        btnResetPrinting.setText("Reset");
        btnResetPrinting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPrintingActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setText("Power:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setText("Toughness:");

        comboSearchPowerSign.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<", ">", "<=", ">=" }));

        comboSearchToughnessSign.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<", ">", "<=", ">=" }));

        comboSearchPower.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSearchToughness.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel10.setText("CMC:");

        comboSearchCMCSign.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<", ">", "<=", ">=" }));

        comboSearchCMC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jScrollPane1.setViewportView(txtPanelInfo);

        btnSearchDisplayRule.setText("Rules");
        btnSearchDisplayRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDisplayRuleActionPerformed(evt);
            }
        });

        btnSearchDisplayText.setText("Card Text");
        btnSearchDisplayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDisplayTextActionPerformed(evt);
            }
        });

        btnSearchCardFlip.setText("Flip");
        btnSearchCardFlip.setEnabled(false);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtText, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtType, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCardName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResetAll))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboSearchCMCSign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboSearchCMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboSearchToughnessSign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboSearchToughness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboSearchPowerSign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboSearchPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboSearchFormat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboSearchSet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboSearchPrinting, 0, 231, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnResetFormat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResetSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResetPrinting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSearchUncommon)
                            .addComponent(cbSearchCommon))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSearchRare)
                            .addComponent(cbSearchMythicRare))
                        .addContainerGap(103, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbSearchColorIdentityWhite)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSearchColorIdentityBlue)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSearchColorIdentityBlack)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSearchColorIdentityRed)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSearchColorIdentityGreen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboSearchColorIdentity, 0, 1, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbSearchColorWhite)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSearchColorBlue)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSearchColorBlack)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSearchColorRed)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSearchColorGreen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboSearchColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(159, 159, 159)
                                .addComponent(btnSearchCardFlip, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnAdd))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(btnSearchDisplayRule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchDisplayText)
                                .addGap(44, 44, 44))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCardName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch)
                                .addComponent(btnResetAll))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSearchColorWhite)
                            .addComponent(cbSearchColorBlue)
                            .addComponent(cbSearchColorBlack)
                            .addComponent(cbSearchColorRed)
                            .addComponent(cbSearchColorGreen)
                            .addComponent(comboSearchColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(comboSearchSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnResetPrinting)
                                    .addComponent(comboSearchPrinting, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(comboSearchFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnResetFormat)
                                    .addComponent(jLabel8)
                                    .addComponent(comboSearchPowerSign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboSearchPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(btnResetSet))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(comboSearchToughnessSign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboSearchToughness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(comboSearchCMCSign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboSearchCMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbSearchCommon)
                                .addComponent(jLabel6))
                            .addComponent(cbSearchRare))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSearchUncommon)
                            .addComponent(cbSearchMythicRare))
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSearchColorIdentityWhite)
                    .addComponent(cbSearchColorIdentityBlue)
                    .addComponent(cbSearchColorIdentityBlack)
                    .addComponent(cbSearchColorIdentityRed)
                    .addComponent(cbSearchColorIdentityGreen)
                    .addComponent(comboSearchColorIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCardFlip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearchDisplayRule)
                            .addComponent(btnSearchDisplayText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                .addGap(398, 398, 398)))
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1268, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCardNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCardNameMouseClicked
        JTextField temp = (JTextField)evt.getSource();
        String s = temp.getText();

        if (s.equals("Name"))
        temp.setText("");
        if (txtType.getText().equals("Type"))
        txtType.setText("");
        if (txtText.getText().equals("Text"))
        txtText.setText("");
    }//GEN-LAST:event_txtCardNameMouseClicked

    private void txtCardNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCardNameKeyReleased

        if (evt.getKeyCode()== 10)
        {
            btnSearchActionPerformed(null);
        }
    }//GEN-LAST:event_txtCardNameKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        //Create Variables
        String searchCard = txtCardName.getText();  //Card Being Searched
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmagicdb?" + "user=root&password=notmustard");
            statement = connect.createStatement();

            if (isSearchSettingsDefault() == true) //Blank or Default settings search pulls all recent cards in database
            {
                // Result set get the result of the SQL query
                resultSet = statement.executeQuery("SELECT s1.*\n" +
                                                    "FROM testmagicdb.Card s1\n" +
                                                    "JOIN (\n" +
                                                    "  SELECT  MAX(ID) AS ID, CardName\n" +
                                                    "  FROM testmagicdb.Card\n" +
                                                    "  GROUP BY CardName) AS s2\n" +
                                                    "  ON s1.CardName = s2.CardName AND s1.ID = s2.ID\n" +
                                                    "  LEFT JOIN testmagicdb.MTGSet z ON s1.SetName = z.SetName");

                 //Instanced Variables
                DefaultTableModel tbl = (DefaultTableModel)tblCardResult.getModel();

                tbl.setRowCount(0); //Set Table Row Count = 0


                while (resultSet.next())
                {
                    
                    int CardID = resultSet.getInt("ID");
                    String CardName = resultSet.getString("CardName");
                    String SetName = resultSet.getString("SetName");
                    String Mana = resultSet.getString("ManaCost");
                    float CMC = resultSet.getFloat("CMC");
                    String Type = resultSet.getString("CardType");
                    String Power = resultSet.getString("Power");
                    String Toughness = resultSet.getString(("Toughness"));
                    int MultiverseID = resultSet.getInt("MultiverseID");
                    Object [] arr = {CardID, CardName, SetName, Mana, CMC, Type,
                                     Power, Toughness, MultiverseID};
                    tbl.addRow(arr);
                }
                
                tblCardResult.setModel(tbl);
                resizeColumnWidth(tblCardResult);
                
            }
            else //If Search Settings are not default
            {
                boolean [] c = changedSearchSettings();                
                String sqlStatement = "";
                
                //Printing
                if (c[12] == true) // Prepare Statement for Cards based on Printings and if setting are not default
                {
                    int selection = comboSearchPrinting.getSelectedIndex(); //Currently Selected Option in Printing
                    
                    //Card
                    if (selection == 1) //Original Printing
                    {
                        String temp = "SELECT s1.*\n" +
                                    "FROM testmagicdb.Card s1\n" +
                                    "JOIN (\n" +
                                    "  SELECT  MIN(ID) AS ID, CardName\n" +
                                    "  FROM testmagicdb.Card\n" +
                                    "  GROUP BY CardName) AS s2\n" +
                                    "  ON s1.CardName = s2.CardName AND s1.ID = s2.ID ";
                        sqlStatement = temp;
                    }
                    else if (selection == 2) //All Printings
                    {
                        String temp = "SELECT s1.* FROM testmagicdb.Card s1 ";
                        sqlStatement = temp;
                    }
                    else if (selection == 3) //Reprints Only
                    {
                        String temp = "SELECT s1.*\n" +
                                    "FROM testmagicdb.Card s1\n" +
                                    "JOIN (\n" +
                                    "  SELECT  ID, CardName\n" +
                                    "  FROM testmagicdb.Card\n" +
                                    "  WHERE ID NOT IN (SELECT MIN(ID) AS CardID FROM Card GROUP BY CardName)) AS s2\n" +
                                    "  ON s1.CardName = s2.CardName AND s1.ID = s2.ID ";
                        sqlStatement = temp;
                    }
                }
                else    //Create Default Search for Most Recent Printing
                {
                    
                    String temp = "SELECT s1.*\n" +
                                    "FROM testmagicdb.Card s1\n" +
                                    "JOIN (\n" +
                                    "  SELECT  MAX(ID) AS ID, CardName\n" +
                                    "  FROM testmagicdb.Card\n" +
                                    "  GROUP BY CardName) AS s2\n" +
                                    "  ON s1.CardName = s2.CardName AND s1.ID = s2.ID ";
                    sqlStatement = temp;
                    
                }
                
                //Format
                if (c[10] == true) //Adds SQLStatement based on Format non-default settings
                {
                    String temp = "";
                    
                    temp = "\nJOIN(\n" +
                            "      SELECT CardID,\n" +
                            "             BanType,\n" +
                            "             FormatName\n" +
                            "      FROM Format_Card \n" +
                            "      WHERE BanType = \"Legal\" AND FormatName = \""+ (String)comboSearchFormat.getSelectedItem() + "\"\n" +
                            "  ) fc ON fc.CardID = s1.ID ";
                    sqlStatement +=  temp;
                }
                
                //Set
                if (c[11] == true) //Adds SQLStatement based on Set non-default settings
                {
                    String temp = "";
                    
                    temp = "\nJOIN(\n" +
                            "      SELECT ID,\n" +
                            "             SetName\n" +
                            "      FROM Card \n" +
                            "      WHERE SetName = \""+ (String)comboSearchSet.getSelectedItem() + "\"\n" +
                            "  ) sc ON sc.ID = s1.ID ";
                    sqlStatement +=  temp;
                }
                
                //Color Identity
                if (c[6] == true) //Adds SQL Statement based on Color Identity non-default settings
                {
                    String temp = "";
                    int i = comboSearchColorIdentity.getSelectedIndex();
                    boolean [] l = getChangedColors("Color Identity"); //Stores which buttons have been pressed
                    ArrayList<String> s = new ArrayList<String>();  //Stores Colors selected
                    
                    
                    if (i == 0) //Match Any Color(s)
                    {
                        temp = "JOIN (\n"
                            + "      SELECT cc.CardID,\n"
                            + "             cc.ColorID,\n"
                            + "             c.ColorName\n"
                            + "     FROM Card_ColorIdentity cc, ColorIdentity c\n"
                            + "     WHERE cc.ColorID = c.ColorID AND (";
                        
                        if (l[0] == true)   //White Selected
                        {
                            s.add("c.ColorName = \"White\"");
                        }
                        
                        if (l[1] == true)   //Blue Selected
                        {
                            s.add("c.ColorName = \"Blue\"");
                        }
                        
                        if (l[2] == true)   //Black Selected
                        {
                            s.add("c.ColorName = \"Black\"");
                        }
                        
                        if (l[3] == true)   //Red Selected
                        {
                            s.add("c.ColorName = \"Red\"");
                        }
                        
                        if (l[4] == true)   //Green Selected
                        {
                            s.add("c.ColorName = \"Green\"");
                        }
                        
                        for (int x = 0; x < s.size(); x++)
                        {
                            if (x != s.size()-1)
                            {
                                temp += s.get(x) + " OR ";
                            }
                            else
                            {
                                temp += s.get(x) + ")\n";
                            }
                        }
                        temp += ") colorIdentity ON colorIdentity.CardID = s1.ID ";
                    }
                    else if (i == 1) //Match Exact Colors
                    {
                        temp = "JOIN (\n"
                            + "      SELECT cc.CardID,\n"
                            + "             c.ColorName\n"
                            + "     FROM Card_ColorIdentity cc\n "
                            + "     JOIN ColorIdentity c\n"
                            + "     ON cc.ColorID = c.ColorID\n"
                            + "     JOIN Card crd\n"
                            + "     ON crd.ID = cc.CardID\n"
                            + "     WHERE cc.CardID ";
                        
                        ArrayList<String> e = new ArrayList<String>();  //Stores Colors not selected
                        
                        if (l[0] == true)   //White Selected
                        {
                            s.add("c.ColorName = \"White\"");
                        }
                        else
                        {
                            e.add("3");
                        }
                        
                        if (l[1] == true)   //Blue Selected
                        {
                            s.add("c.ColorName = \"Blue\"");
                        }
                        else
                        {
                            e.add("1");
                        }
                        
                        if (l[2] == true)   //Black Selected
                        {
                            s.add("c.ColorName = \"Black\"");
                        }
                        else
                        {
                            e.add("2");
                        }
                        
                        if (l[3] == true)   //Red Selected
                        {
                            s.add("c.ColorName = \"Red\"");
                        }
                        else
                        {
                            e.add("5");
                        }
                        
                        if (l[4] == true)   //Green Selected
                        {
                            s.add("c.ColorName = \"Green\"");
                        }
                        else
                        {
                            e.add("4");
                        }
                        
                        if (s.size() != 5 && s.size() != 0)  //If there are atleast 1 to 4 buttons selected in ColorIdentity
                        {
                            temp += "NOT IN (SELECT CardID FROM Card_ColorIdentity WHERE ColorID IN (";
                            
                            for (int x = 0; x < e.size(); x++)  //Select Cards with ColorIdentity more than what is currently selected
                            {
                                if ( x != e.size()-1)
                                {
                                    temp += e.get(x) + ",";
                                }
                                else
                                {
                                    temp += e.get(x) + ")) AND (";
                                }   
                            }
                            
                            for (int x = 0; x < s.size(); x++)
                            {
                                if (x != s.size()-1)
                                {
                                    temp += s.get(x) + " OR ";
                                }
                                else 
                                {
                                    temp += s.get(x) + ")\n";
                                }
                            }

                            temp += ") colorIdentity ON colorIdentity.CardID = s1.ID ";
                        }
                        else if (s.size () == 5)    // For all 5 identities
                        {
                            temp += "IN (SELECT CardID FROM Card_ColorIdentity WHERE ColorID IN (1,2,3,4,5))";
                            temp += ") colorIdentity ON colorIdentity.CardID = s1.ID ";
                        }
                        else if (s.size() == 0) //For Colorless Search
                        {
                            temp = "JOIN (SELECT crd.ID\n" +
                                   "      FROM Card crd\n" +
                                   "      WHERE crd.ID NOT IN (SELECT CardID FROM Card_ColorIdentity)";
                            temp += ") colorIdentity ON colorIdentity.ID = s1.ID ";
                        }
                    }
                    
                    sqlStatement += temp;   //Adds Color SQL Statement to sqlStatement String
                }
                
                //Color
                if (c[5] == true) //Adds SQL Statement based on Set non-default settings
                {
                    String temp = "";
                    int i = comboSearchColor.getSelectedIndex();
                    boolean [] l = getChangedColors("Color"); //Stores which buttons have been pressed
                    ArrayList<String> s = new ArrayList<String>();  //Stores Colors selected

                    
                    if (i == 0) //Match Any Color(s)
                    {
                        temp = "JOIN (\n"
                            + "      SELECT cc.CardID,\n"
                            + "             c.ColorName\n"
                            + "     FROM Card_Color cc, Color c\n"
                            + "     WHERE cc.ColorID = c.ColorID AND (";
                        
                        if (l[0] == true)   //White Selected
                        {
                            s.add("c.ColorName = \"White\"");
                        }
                        
                        if (l[1] == true)   //Blue Selected
                        {
                            s.add("c.ColorName = \"Blue\"");
                        }
                        
                        if (l[2] == true)   //Black Selected
                        {
                            s.add("c.ColorName = \"Black\"");
                        }
                        
                        if (l[3] == true)   //Red Selected
                        {
                            s.add("c.ColorName = \"Red\"");
                        }
                        
                        if (l[4] == true)   //Green Selected
                        {
                            s.add("c.ColorName = \"Green\"");
                        }
                        
                        for (int x = 0; x < s.size(); x++)
                        {
                            if (x != s.size()-1)
                            {
                                temp += s.get(x) + " OR ";
                            }
                            else
                            {
                                temp += s.get(x) + ")\n";
                            }
                        }
                        temp += ") color ON color.CardID = s1.ID ";
                    }
                    else if (i == 1) //Match Exact Colors
                    {
                        ArrayList<String> e = new ArrayList<String>();  //Stores Colors not selected
                        
                        temp = "JOIN (\n"
                            + "      SELECT cc.CardID,\n"
                            + "             c.ColorName\n"
                            + "     FROM Card_Color cc\n "
                            + "     JOIN Color c\n"
                            + "     ON cc.ColorID = c.ColorID\n"
                            + "     JOIN Card crd\n"
                            + "     ON crd.ID = cc.CardID\n"
                            + "     WHERE cc.CardID ";
                        
                        if (l[0] == true)   //White Selected
                        {
                            s.add("c.ColorName = \"White\"");
                        }
                        else
                        {
                            e.add("3");
                        }
                        
                        if (l[1] == true)   //Blue Selected
                        {
                            s.add("c.ColorName = \"Blue\"");
                        }
                        else
                        {
                            e.add("1");
                        }
                        
                        if (l[2] == true)   //Black Selected
                        {
                            s.add("c.ColorName = \"Black\"");
                        }
                        else
                        {
                            e.add("2");
                        }
                        
                        if (l[3] == true)   //Red Selected
                        {
                            s.add("c.ColorName = \"Red\"");
                        }
                        else
                        {
                            e.add("5");
                        }
                        
                        if (l[4] == true)   //Green Selected
                        {
                            s.add("c.ColorName = \"Green\"");
                        }
                        else
                        {
                            e.add("4");
                        }
                        
                        if (s.size() != 5 && s.size() != 0)  //If there are atleast 1 to 4 buttons selected in ColorIdentity
                        {
                            temp += "NOT IN (SELECT CardID FROM Card_Color WHERE ColorID IN (";
                            
                            for (int x = 0; x < e.size(); x++)  //Select Cards with ColorIdentity more than what is currently selected
                            {
                                if ( x != e.size()-1)
                                {
                                    temp += e.get(x) + ",";
                                }
                                else
                                {
                                    temp += e.get(x) + ")) AND (";
                                }   
                            }
                            
                            for (int x = 0; x < s.size(); x++)
                            {
                                if (x != s.size()-1)
                                {
                                    temp += s.get(x) + " OR ";
                                }
                                else 
                                {
                                    temp += s.get(x) + ")\n";
                                }
                            }

                            temp += ") color ON color.CardID = s1.ID ";
                        }
                        else if (s.size () == 5)    // For all 5 identities
                        {
                            temp += "IN (SELECT CardID FROM Card_Color WHERE ColorID IN (1,2,3,4,5))";
                            temp += ") color ON color.CardID = s1.ID ";
                        }
                        else if (s.size() == 0) //For Colorless Search
                        {
                            temp = "JOIN (SELECT crd.ID\n" +
                                   "      FROM Card crd\n" +
                                   "      WHERE crd.ID NOT IN (SELECT CardID FROM Card_Color)";
                            temp += ") color ON color.ID = s1.ID ";
                        }
                        
                    }
                    else if (i == 2) //Match Multicolored (2+ Colors)
                    {
                        int count= 0;   //MUST BE HIGHER THAN 2 TO EXECUTE SQL STATEMENT
                        ArrayList<String> e = new ArrayList<String>();
                        temp = "JOIN (\n"
                            + "      SELECT cc.CardID,\n"
                            + "             c.ColorName\n"
                            + "     FROM Card_Color cc\n "
                            + "     JOIN Color c\n"
                            + "     ON cc.ColorID = c.ColorID\n"
                            + "     JOIN Card crd\n"
                            + "     ON crd.ID = cc.CardID\n"
                            + "     WHERE cc.CardID ";
                        
                        if (l[0] == true)   //White Selected
                        {
                            s.add("c.ColorName = \"White\"");
                        }
                        else
                        {
                            e.add("3");
                        }
                        
                        if (l[1] == true)   //Blue Selected
                        {
                            s.add("c.ColorName = \"Blue\"");
                        }
                        else
                        {
                            e.add("1");
                        }
                        
                        if (l[2] == true)   //Black Selected
                        {
                            s.add("c.ColorName = \"Black\"");
                        }
                        else
                        {
                            e.add("2");
                        }
                        
                        if (l[3] == true)   //Red Selected
                        {
                            s.add("c.ColorName = \"Red\"");
                        }
                        else
                        {
                            e.add("5");
                        }
                        
                        if (l[4] == true)   //Green Selected
                        {
                            s.add("c.ColorName = \"Green\"");
                        }
                        else
                        {
                            e.add("4");
                        }
                        
                        if (s.size() >= 2 && s.size() <5)   //Greater Than 2 and Less 5 Colors
                        {
                            temp += "NOT IN (SELECT CardID FROM Card_Color WHERE ColorID IN (";
                            String n = Integer.toString(s.size());
                            
                            for (int x = 0; x < e.size(); x++)
                            {
                                if (x != e.size()-1)
                                {
                                    temp += e.get(x) + ",";
                                }
                                else
                                {
                                    temp += e.get(x) + ") ";
                                }
                            }
                            
                            temp+= ") AND cc.CardID NOT IN (SELECT CardID FROM Card_Color Group BY CardID HAVING COUNT(*) < " + n + ")";
                            
                            temp += ") color ON color.CardID = s1.ID ";
                        }
                        else if (s.size() == 5)
                        {
                            String n = Integer.toString(s.size());
                            temp += "IN (SELECT CardID FROM Card_Color WHERE ColorID IN (1,2,3,4,5))\n"
                                    + "AND cc.CardID NOT IN (SELECT CardID FROM Card_Color Group BY CardID HAVING COUNT(*) < " + n + ")";
                            temp += ") color ON color.CardID = s1.ID ";
                        }
                        else
                        {
                            temp = "";
                        }
                    }
                    
                    sqlStatement += temp;   //Adds Color SQL Statement to sqlStatement String
                }
                
                //Rarity
                if (c[13] == true)  //Adds SQL Statement based on Rarity non-default settings
                {
                    String temp = "JOIN(\n"
                            + "    SELECT ID\n"
                            + "    FROM Card\n"
                            + "    WHERE Rarity = ";
                    
                    ArrayList<String> s = new ArrayList<String>();
                    
                    if (cbSearchCommon.isSelected())
                    {
                        s.add("\"Common\"");
                    }
                    
                    if (cbSearchUncommon.isSelected())
                    {
                        s.add("\"Uncommon\"");
                    }
                    
                    if (cbSearchRare.isSelected())
                    {
                        s.add("\"Rare\"");
                    }
                    
                    if (cbSearchMythicRare.isSelected())
                    {
                        s.add("\"Mythic Rare\"");
                    }
                    
                    for (int x = 0; x < s.size(); x++)
                    {
                        if (x != s.size()-1)
                        {
                            temp += s.get(x) + " OR Rarity = ";
                        }
                        else
                        {
                            temp += s.get(x) + ") ";
                        }
                    }
                    temp += "rarity ON rarity.ID = s1.ID ";
                    sqlStatement += temp;
                    
                }
                
                //Card Name
                if(c[0] == true) //Adds SQL Statement based on Card name non-default setting
                {
                    String temp = "JOIN (\n"
                            + "         SELECT ID\n"
                            + "         FROM Card\n"
                            + "         WHERE CardName LIKE \"%" + txtCardName.getText() + "%\"\n"
                            + "    ) cardName ON cardName.ID = s1.ID ";
                    
                    sqlStatement += temp;
                }
                
                //Card Type
                if(c[1] == true) //Adds SQL Statement based on Card Type non-default settings
                {
                    
                    String temp = "JOIN (\n"
                            + "         SELECT ct.CardID\n"
                            + "         FROM Card_Type ct\n"
                            + "         JOIN Type t\n"
                            + "         ON  ct.TypeID = t.TypeID\n"
                            + "         JOIN Card crd\n"
                            + "         ON crd.ID = ct.CardID\n"
                            + "         WHERE ct.TypeID IN (SELECT TypeID FROM Type WHERE Types LIKE ";
                    
                    if (comboSearchType.getSelectedIndex() == 0) //All types
                    {
                        String [] s = txtType.getText().split(" ");
                        
                        for (int x = 0; x < s.length ; x++)
                        {
                            if(x != s.length - 1)
                            {
                                temp += "\"%" + s[x] + "%\" OR Types LIKE ";
                            }
                            else
                            {
                                temp += "\"%" + s[x] + "%\" )\n";
                            }
                        }
                        
                        temp += " GROUP BY ct.CardID HAVING COUNT(*) = " + s.length
                                + "\n) cardType ON cardType.CardID = s1.ID ";
                        
                        if (txtType.getText().trim().equals(""))
                        {
                            temp = "";
                        }
                        
                        sqlStatement +=  temp;
                    }
                    else if (comboSearchType.getSelectedIndex() == 1) //Any type(s)
                    {
                        String [] s = txtType.getText().split(" ");
                        for (int x = 0; x < s.length ; x++)
                        {
                            if(x != s.length - 1)
                            {
                                temp += "\"%" + s[x] + "%\" OR Types LIKE ";
                            }
                            else
                            {
                                temp += "\"%" + s[x] + "%\" )\n";
                            }
                        }
                        
                        temp += ") cardType ON cardType.CardID = s1.ID ";
                        
                        if (txtType.getText().trim().equals(""))
                        {
                            temp = "";
                        }
                        
                        sqlStatement +=  temp;
                    }
                    else    //Exclude Selected
                    {
                        temp = "JOIN (\n"
                            + "         SELECT ct.CardID\n"
                            + "         FROM Card_Type ct\n"
                            + "         JOIN Type t\n"
                            + "         ON  ct.TypeID = t.TypeID\n"
                            + "         JOIN Card crd\n"
                            + "         ON crd.ID = ct.CardID\n"
                            + "         WHERE ct.CardID NOT IN (SELECT CardID FROM Card_Type WHERE TypeID\n"
                                + "                             IN (SELECT TypeID FROM Type WHERE Types LIKE ";
                        
                        String [] s = txtType.getText().split(" ");
                        
                        for (int x = 0; x < s.length ; x++)
                        {
                            if(x != s.length - 1)
                            {
                                temp += "\"%" + s[x] + "%\" OR Types LIKE ";
                            }
                            else
                            {
                                temp += "\"%" + s[x] + "%\")) \n";
                            }
                        }
                        
                        temp += ") cardType ON cardType.CardID = s1.ID ";
                        
                        if (txtType.getText().trim().equals(""))
                        {
                            temp = "";
                        }
                        
                        sqlStatement +=  temp;
                    }
                }
                
                //Text
                if (c[2] == true)
                {
                    String temp = "JOIN (\n"
                            + "         SELECT ID\n"
                            + "         FROM Card\n"
                            + "         WHERE ID IN (SELECT ID FROM Card WHERE CardText LIKE ";
                    String [] s = txtText.getText().split(" ");
                    
                    if (comboSearchText.getSelectedIndex() == 0) //All words
                    {
                        for (int x = 0; x < s.length; x++)
                        {
                            if(x != s.length - 1)
                            {
                                temp += "\"%" + s[x] + "%\" AND CardText LIKE ";
                            }
                            else
                            {
                                temp += "\"%" + s[x] + "%\")";
                            }
                        }
                        
                        temp +=  "\n) cardText ON cardText.ID = s1.ID ";
                        
                        if (txtText.getText().trim().equals(""))
                        {
                            temp = "";
                        }
                        
                        sqlStatement +=  temp;
                        
                    }
                    else if (comboSearchText.getSelectedIndex() == 1) //Any word(s)
                    {
                        for (int x = 0; x < s.length; x++)
                        {
                            if(x != s.length - 1)
                            {
                                temp += "\"%" + s[x] + "%\" OR CardText LIKE ";
                            }
                            else
                            {
                                temp += "\"%" + s[x] + "%\")";
                            }
                        }
                        
                        temp +=  "\n) cardText ON cardText.ID = s1.ID ";
                        
                        if (txtText.getText().trim().equals(""))
                        {
                            temp = "";
                        }
                        
                        sqlStatement +=  temp;
                    }
                    else     //Exact Phrase
                    {
                        for (int x = 0; x < s.length; x++)
                        {
                            if(x != s.length - 1)
                            {
                                temp += "\"%" + s[x] + " ";
                            }
                            else
                            {
                                temp +=  s[x] + "%\")";
                            }
                        }
                        
                        temp +=  "\n) cardText ON cardText.ID = s1.ID ";
                        
                        if (txtText.getText().trim().equals(""))
                        {
                            temp = "";
                        }
                        
                        sqlStatement +=  temp;
                    }
                }
                
                //Power
                if(c[7] == true) //Adds SQL Statement based on Power non-default settings 
                {
                    int i = comboSearchPowerSign.getSelectedIndex();
                    int p = comboSearchPower.getSelectedIndex();
                    String temp = "JOIN (\n"
                            + "         SELECT ID\n"
                            + "         FROM Card\n"
                            + "         WHERE Power ";
                    
                    if (i == 0) //Less than
                    {
                        temp += "< " + comboSearchPower.getItemAt(p)
                                +   "\n) cardPower ON cardPower.ID = s1.ID ";
                        sqlStatement += temp;
                    }
                    else if (i == 1) //Greater Than
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += "> " + comboSearchPower.getItemAt(p)
                                +   "\n) cardPower ON cardPower.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                    else if (i == 2) //Less Than or Equal to
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += "<= " + comboSearchPower.getItemAt(p)
                                +   "\n) cardPower ON cardPower.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                    else if (i == 3) //Greater Than or Equal to
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += ">= " + comboSearchPower.getItemAt(p)
                                +   "\n) cardPower ON cardPower.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                    else if (i == 4) //Equal to
                    {
                        if (p == 0) //Handle Null Fields (Ancestrall Call, Lotus Bloom, etc...)
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += "= " + comboSearchPower.getItemAt(p)
                                +   "\n) cardPower ON cardPower.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                }
                
                //Toughness
                if(c[8] == true) //Adds SQL Statement based on Toughness non-default settings 
                {
                    int i = comboSearchToughnessSign.getSelectedIndex();
                    int p = comboSearchToughness.getSelectedIndex();
                    String temp = "JOIN (\n"
                            + "         SELECT ID\n"
                            + "         FROM Card\n"
                            + "         WHERE Toughness ";
                    
                    if (i == 0) //Less than
                    {
                        temp += "< " + comboSearchToughness.getItemAt(p)
                                +   "\n) cardToughness ON cardToughness.ID = s1.ID ";
                        sqlStatement += temp;
                    }
                    else if (i == 1) //Greater Than
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += "> " + comboSearchToughness.getItemAt(p)
                                +   "\n) cardToughness ON cardToughness.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                    else if (i == 2) //Less Than or Equal to
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += "<= " + comboSearchToughness.getItemAt(p)
                                +   "\n) cardToughness ON cardToughness.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                    else if (i == 3) //Greater Than or Equal to
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += ">= " + comboSearchToughness.getItemAt(p)
                                +   "\n) cardToughness ON cardToughness.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                    else if (i == 4) //Equal to
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += "= " + comboSearchToughness.getItemAt(p)
                                +   "\n) cardToughness ON cardToughness.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                }
                
                //CMC
                if(c[9] == true) //Adds SQL Statement based on CMC non-default settings 
                {
                    int i = comboSearchCMCSign.getSelectedIndex();
                    int p = comboSearchCMC.getSelectedIndex();
                    String temp = "JOIN (\n"
                            + "         SELECT ID\n"
                            + "         FROM Card\n"
                            + "         WHERE CMC ";
                    
                    if (i == 0) //Less than
                    {
                        temp += "< " + comboSearchCMC.getItemAt(p)
                                +   "\n) cardCMC ON cardCMC.ID = s1.ID ";
                        sqlStatement += temp;
                    }
                    else if (i == 1) //Greater Than
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += "> " + comboSearchCMC.getItemAt(p)
                                +   "\n) cardCMC ON cardCMC.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                    else if (i == 2) //Less Than or Equal to
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += "<= " + comboSearchCMC.getItemAt(p)
                                +   "\n) cardCMC ON cardCMC.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                    else if (i == 3) //Greater Than or Equal to
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += ">= " + comboSearchCMC.getItemAt(p)
                                +   "\n) cardCMC ON cardCMC.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                    else if (i == 4) //Equal to
                    {
                        if (p == 0) //Handle Incorrect Fields
                        {
                            temp = "";
                        }
                        else
                        {
                            temp += "= " + comboSearchCMC.getItemAt(p)
                                +   "\n) cardCMC ON cardCMC.ID = s1.ID ";
                            sqlStatement += temp;
                        }
                    }
                }
                
                System.out.println( "\n"+ sqlStatement);
                resultSet = statement.executeQuery(sqlStatement + "GROUP BY s1.ID ORDER BY s1.CardName ASC" ); // + "ORDER BY s1.CardName ASC" <- add this to order from A-Z

                 //Instanced Variables
                DefaultTableModel tbl = (DefaultTableModel)tblCardResult.getModel();

                tbl.setRowCount(0); //Set Table Row Count = 0


                while (resultSet.next())
                {
                    
                    int CardID = resultSet.getInt("ID");
                    String CardName = resultSet.getString("CardName");
                    String SetName = resultSet.getString("SetName");
                    String Mana = resultSet.getString("ManaCost");
                    float CMC = resultSet.getFloat("CMC");
                    String Type = resultSet.getString("CardType");
                    String Power = resultSet.getString("Power");
                    String Toughness = resultSet.getString(("Toughness"));
                    int MultiverseID = resultSet.getInt("MultiverseID");
                    Object [] arr = {CardID, CardName, SetName, Mana, CMC, Type,
                                     Power, Toughness, MultiverseID};
                    tbl.addRow(arr);
                }
                
                tblCardResult.setModel(tbl);
                resizeColumnWidth(tblCardResult);
            }
            
            //TODO: Check if there is available connection
            
            //Displaying Images on JLabels
            URL url = new URL("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=99595959&type=card");
            BufferedImage img = ImageIO.read(url);
            ImageIcon i = new ImageIcon(img);
            
            lblPicture.setIcon(i);
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
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblCardResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCardResultMouseClicked
        JTable tbl = (JTable)evt.getSource();

        Object temp = tbl.getValueAt(tbl.getSelectedRow(), 8);
        if (temp != null)
        {
            Connection connect = null;
            Statement statement = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            int cID = (int)tbl.getValueAt(tbl.getSelectedRow(), 0); //Selected Card ID

            try
            {
                connect = DriverManager.getConnection("jdbc:mysql://localhost/testmagicdb?"
                    + "user=root&password=notmustard");
                statement = connect.createStatement();

                preparedStatement = connect.prepareStatement("select * from testmagicdb.Card where ID = ?");
                preparedStatement.setInt(1,  cID);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next())
                {
                    String cText = resultSet.getString("CardText");

                    if (cText != null)
                    {
                        txtPanelInfo.setText(cText);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            int x = (int)temp;

            try
            {
                //Displaying Images on JLabels
                URL url = new URL("http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=" + x +"&type=card");
                BufferedImage img = ImageIO.read(url);
                ImageIcon i = new ImageIcon(img);

                lblPicture.setSize(i.getIconWidth(), i.getIconHeight());
                //lblPicture.repaint();
                lblPicture.setIcon(i);

            }
            catch(Exception e)
            {
                System.out.println("Error with pulling image...");
            }
        }
    }//GEN-LAST:event_tblCardResultMouseClicked

    private void btnResetFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetFormatActionPerformed
        comboSearchFormat.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetFormatActionPerformed

    private void btnResetSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetSetActionPerformed
        comboSearchSet.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetSetActionPerformed

    private void txtTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTypeMouseClicked
        JTextField temp = (JTextField)evt.getSource();
        String s = temp.getText();

        if (s.equals("Type"))
        temp.setText("");
        if (txtCardName.getText().equals("Name"))
        txtCardName.setText("");
        if (txtText.getText().equals("Text"))
        txtText.setText("");
    }//GEN-LAST:event_txtTypeMouseClicked

    private void btnResetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetAllActionPerformed

        //Reset Text Fields
        txtCardName.setText("Name");
        txtType.setText("Type");
        txtText.setText("Text");
        txtPanelInfo.setText("");

        //Reset Buttons
        cbSearchColorWhite.setSelected(false);
        cbSearchColorBlue.setSelected(false);
        cbSearchColorBlack.setSelected(false);
        cbSearchColorRed.setSelected(false);
        cbSearchColorGreen.setSelected(false);
        cbSearchColorIdentityWhite.setSelected(false);
        cbSearchColorIdentityBlue.setSelected(false);
        cbSearchColorIdentityBlack.setSelected(false);
        cbSearchColorIdentityRed.setSelected(false);
        cbSearchColorIdentityGreen.setSelected(false);
        cbSearchCommon.setSelected(false);
        cbSearchUncommon.setSelected(false);
        cbSearchRare.setSelected(false);
        cbSearchMythicRare.setSelected(false);

        //Reset Combo Boxes
        comboSearchType.setSelectedIndex(0);
        comboSearchFormat.setSelectedIndex(0);
        comboSearchSet.setSelectedIndex(0);
        comboSearchColor.setSelectedIndex(0);
        comboSearchColorIdentity.setSelectedIndex(0);
        comboSearchText.setSelectedIndex(0);
        comboSearchPrinting.setSelectedIndex(0);
        comboSearchPowerSign.setSelectedIndex(0);
        comboSearchToughnessSign.setSelectedIndex(0);
        comboSearchCMCSign.setSelectedIndex(0);
        comboSearchPower.setSelectedIndex(0);
        comboSearchToughness.setSelectedIndex(0);
        comboSearchCMC.setSelectedIndex(0);

    }//GEN-LAST:event_btnResetAllActionPerformed

    private void txtTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTextMouseClicked
        JTextField temp = (JTextField)evt.getSource();
        String s = temp.getText();

        if (s.equals("Text"))
        temp.setText("");
        if (txtCardName.getText().equals("Name"))
        txtCardName.setText("");
        if (txtType.getText().equals("Type"))
        txtType.setText("");

    }//GEN-LAST:event_txtTextMouseClicked

    private void btnResetPrintingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPrintingActionPerformed
        comboSearchPrinting.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetPrintingActionPerformed

    private void btnSearchDisplayRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDisplayRuleActionPerformed
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (tblCardResult.getSelectedRow() >= 0)
        {
            Object o = tblCardResult.getValueAt(tblCardResult.getSelectedRow(), 0);
            int cID = (int)o;   //Holds Card ID
            ArrayList<String> t = new ArrayList<String>();  //Holds Text Rulings of a Card
            ArrayList<Date> y = new ArrayList<Date>();  //Holds Year of those rulings
            String s = "";   //Used to concatenate both year and ruling

            try
            {
                connect = DriverManager.getConnection("jdbc:mysql://localhost/testmagicdb?"
                    + "user=root&password=notmustard");
                statement = connect.createStatement();

                preparedStatement = connect.prepareStatement("SELECT TextRuling , RulingYear FROM Ruling WHERE CardID = ?");
                preparedStatement.setInt(1,  cID);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next())
                {
                    t.add(resultSet.getString("TextRuling"));
                    y.add(resultSet.getDate("RulingYear"));
                }

                //Concatenates each element of the ArrayList (Date and Ruling) to String s
                for (int x = 0; x < t.size(); x++)
                {
                    String temp;
                    temp = y.get(x) + ":" + t.get(x) + "\n\n";
                    s += temp;
                }

                txtPanelInfo.setText(s); //Sets txtPanelInfo to String s

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSearchDisplayRuleActionPerformed

    private void btnSearchDisplayTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDisplayTextActionPerformed
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (tblCardResult.getSelectedRow() >= 0)
        {
            Object o = tblCardResult.getValueAt(tblCardResult.getSelectedRow(), 0);
            int cID = (int)o;   //Holds Card ID

            try
            {
                connect = DriverManager.getConnection("jdbc:mysql://localhost/testmagicdb?"
                    + "user=root&password=notmustard");
                statement = connect.createStatement();

                preparedStatement = connect.prepareStatement("SELECT CardText FROM Card WHERE ID = ?");
                preparedStatement.setInt(1,  cID);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next())
                {
                    String cText = resultSet.getString("CardText");
                    if (cText != null)
                    {
                        txtPanelInfo.setText(cText);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSearchDisplayTextActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        
        try
        {        
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdbmagic?" + "user=root&password=notmustard");
            preparedStatement = connect.prepareStatement("INSERT INTO Deck_Has_Card VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, deckid);
            preparedStatement.setInt(2, (int)tblCardResult.getValueAt(tblCardResult.getSelectedRow(), 0));
            preparedStatement.setInt(3, 0);
            preparedStatement.setInt(4, 0);
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
    }//GEN-LAST:event_btnAddActionPerformed

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
                    width = 150;
                     
                columnModel.getColumn(column).setPreferredWidth(width);
        }   
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
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        l.add("");  //Adds Default Blank 
        
        try 
        {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/testmagicdb?" 
                                                + "user=root&password=notmustard");
            statement = connect.createStatement();
            
            resultSet = statement.executeQuery("select * from testmagicdb.Format");
            
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
    
    /**
     * populateComboListSet() function
     * -------------------------------------
     * Returns ArrayList<String> of MTGSet currently available in database
     */
    private ArrayList<String> populateComboListSet()
    {
        //Declared Variables
        ArrayList<String> l = new ArrayList<String>();  //Stores ArrayList of Formats
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        l.add("");  //Adds Default Blank 
        
        try 
        {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/testmagicdb?" 
                                                + "user=root&password=notmustard");
            statement = connect.createStatement();
            
            resultSet = statement.executeQuery("select * from testmagicdb.MTGSet");
            
            while(resultSet.next())
            {
                l.add(resultSet.getString("SetName"));
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error with importing MTGSet List");
        }
        
        return l;
    }
    
    /**
     * populateComboListNumber() function
     * -------------------------------------
     * Returns ArrayList<String> of empty string and #'s 0-10
     */
    public ArrayList<String> populateComboListNumber()
    {
        ArrayList<String> l = new ArrayList<String>();
        l.add("");
        
        for (int x = 0; x < 11; x++)
        {
            l.add(Integer.toString(x));
        }
        
        return l;
    }
    
    /**
     * isSearchSettingsDefault() function
     * -------------------------------------
     * Returns boolean true if all setting are default or if 
     * txtFields are blank and the rest comboBoxes are default, 
     * else return false
     */
    private boolean isSearchSettingsDefault()
    {
        boolean b = true;
        
        if(txtCardName.getText().equals("Name") || txtCardName.getText().equals(""))
        {
            if ((txtType.getText().equals("Type") || txtType.getText().equals(""))
                    && comboSearchType.getSelectedIndex() == 0)
            {
                if((txtText.getText().equals("Text") || txtText.getText().equals(""))
                        && comboSearchText.getSelectedIndex() == 0)
                {
                    if(cbSearchColorWhite.isSelected() == false 
                                    && cbSearchColorBlue.isSelected() == false
                                    && cbSearchColorBlack.isSelected() == false
                                    && cbSearchColorRed.isSelected() == false
                                    && cbSearchColorGreen.isSelected() == false
                                    && comboSearchColor.getSelectedIndex() == 0)
                    {
                        if (cbSearchColorIdentityWhite.isSelected() == false
                                && cbSearchColorIdentityBlue.isSelected() == false
                                && cbSearchColorIdentityBlack.isSelected() == false
                                && cbSearchColorIdentityRed.isSelected() == false
                                && cbSearchColorIdentityGreen.isSelected() == false
                                && comboSearchColorIdentity.getSelectedIndex() == 0)
                        {
                            if (comboSearchPowerSign.getSelectedIndex() == 0
                                    && comboSearchToughnessSign.getSelectedIndex() == 0
                                    && comboSearchCMCSign.getSelectedIndex() == 0
                                    && comboSearchPower.getSelectedIndex() == 0
                                    && comboSearchToughness.getSelectedIndex() == 0
                                    && comboSearchCMC.getSelectedIndex() == 0)
                            {
                                if (comboSearchFormat.getSelectedIndex() == 0
                                        && comboSearchSet.getSelectedIndex() == 0
                                        && comboSearchPrinting.getSelectedIndex() == 0)
                                {
                                    if (cbSearchCommon.isSelected() == false
                                            && cbSearchUncommon.isSelected() == false
                                            && cbSearchRare.isSelected() == false
                                            && cbSearchMythicRare.isSelected() == false)
                                    {
                                        b = true;
                                    }
                                    else //Rartiy are not default settings
                                    {
                                        b = false;
                                    }
                                }
                                else //Format, Set, and Printing are not default settings
                                {
                                    b = false;
                                }
                            }
                            else //Power, Toughness, and CMC settings are not default
                            {
                                b = false;
                            }
                        }
                        else //Color Identity settings are not default
                        {
                            b = false;
                        }
                    } //Color settings are not default
                    else
                    {
                        b = false;
                    }
                    
                } //Text settings are not default
                else
                {
                    b = false;
                }
            }//Type settings are not default
            else
            {
                b = false;
            }
        }//Name settings are not default
        else
        {
            b = false;
        }
        
        return b;
    }
    
    
    private boolean[] changedSearchSettings()
    {
        boolean [] c = new boolean[14]; //Holds 0's and 1's to signal change in each of the settings
        
        if (!(txtCardName.getText().equals("Name") ||  txtCardName.getText().equals("")))
        {
            c[0] = true; //Name settings are not default
        }
        else 
        {
            c[0] = false; //Name settings are default
        }
        
        if (!(txtType.getText().equals("Type") || txtType.getText().equals(""))
                || comboSearchType.getSelectedIndex() != 0)
        {
            c[1] = true; //Type setting are not default
        }
        else 
        {
            c[1] = false; //Type setting are default
        }
        
        if (!(txtText.getText().equals("Text") || txtText.getText().equals(""))
                || comboSearchText.getSelectedIndex() != 0)
        {
            c[2] = true; //Text setting are not default
        }
        else 
        {
            c[2] = false; //Text setting are default
        }
        
        if (!(cbSearchColorWhite.isSelected() == false && cbSearchColorBlue.isSelected() == false
                && cbSearchColorBlack.isSelected() == false && cbSearchColorRed.isSelected() == false
                && cbSearchColorGreen.isSelected() == false) || comboSearchColor.getSelectedIndex() != 0)
        {
            c[5] = true; //Color settings are not default
        }
        else
        {
            c[5] = false; //Color settings are default
        }
        
        if (!(cbSearchColorIdentityWhite.isSelected() == false && cbSearchColorIdentityBlue.isSelected() == false
                && cbSearchColorIdentityBlack.isSelected() == false && cbSearchColorIdentityRed.isSelected() == false
                && cbSearchColorIdentityGreen.isSelected() == false) || comboSearchColorIdentity.getSelectedIndex() != 0)
        {
            c[6] = true; //Color Identity settings are not default
        }
        else
        {
            c[6] = false; //Color Identity settings are not default
        }

        return c;
    }    
    
    /**
     * getChangedColors(String s) function
     * -------------------------------------------
     *  Returns boolean [] l that stores 5 elements, each that represent the color
     *  of either Color or Color Identity (Depending on the argument passes), that
     *  are either true or false depending on whether the color is selected
     */
    private boolean [] getChangedColors(String s)
    {
        boolean [] l = new boolean [5];
        
        if (s.equals("Color"))
        {
            if (cbSearchColorWhite.isSelected() == true) //Color White Selected
            {
                l[0] = true;
            }
            else //Color White Not Selected
            {
                l[0] = false;
            }
            
            if (cbSearchColorBlue.isSelected() == true) //Color Blue Selected
            {
                l[1] = true;
            }
            else //Color Blue Not Selected
            {
                l[1] = false;
            }
            
            if (cbSearchColorBlack.isSelected() == true) //Color Black Selected
            {
                l[2] = true;
            }
            else //Color Black Not Selected
            {
                l[2] = false;
            }
            
            if (cbSearchColorRed.isSelected() == true) //Color Red Selected
            {
                l[3] = true;
            }
            else //Color Red Not Selected
            {
                l[3] = false;
            }
            
            if (cbSearchColorGreen.isSelected() == true) //Color Green Selected
            {
                l[4] = true;
            }
            else //Color Green Not Selected
            {
                l[4] = false;
            }
        }
        else if (s.equals("Color Identity"))
        {
            if (cbSearchColorIdentityWhite.isSelected() == true) //Color Identity White Selected
            {
                l[0] = true;
            }
            else //Color Identity White Not Selected
            {
                l[0] = false;
            }
            
            if (cbSearchColorIdentityBlue.isSelected() == true) //Color Identity Blue Selected
            {
                l[1] = true;
            }
            else //Color Identity Blue Not Selected
            {
                l[1] = false;
            }
            
            if (cbSearchColorIdentityBlack.isSelected() == true) //Color Identity Black Selected
            {
                l[2] = true;
            }
            else //Color Identity Black Not Selected
            {
                l[2] = false;
            }
            
            if (cbSearchColorIdentityRed.isSelected() == true) //Color Identity Red Selected
            {
                l[3] = true;
            }
            else //Color Identity Red Not Selected
            {
                l[3] = false;
            }
            
            if (cbSearchColorIdentityGreen.isSelected() == true) //Color Identity Green Selected
            {
                l[4] = true;
            }
            else //Color Identity Green Not Selected
            {
                l[4] = false;
            }
        }
        return l;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnResetAll;
    private javax.swing.JButton btnResetFormat;
    private javax.swing.JButton btnResetPrinting;
    private javax.swing.JButton btnResetSet;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchCardFlip;
    private javax.swing.JButton btnSearchDisplayRule;
    private javax.swing.JButton btnSearchDisplayText;
    private javax.swing.JCheckBox cbSearchColorBlack;
    private javax.swing.JCheckBox cbSearchColorBlue;
    private javax.swing.JCheckBox cbSearchColorGreen;
    private javax.swing.JCheckBox cbSearchColorIdentityBlack;
    private javax.swing.JCheckBox cbSearchColorIdentityBlue;
    private javax.swing.JCheckBox cbSearchColorIdentityGreen;
    private javax.swing.JCheckBox cbSearchColorIdentityRed;
    private javax.swing.JCheckBox cbSearchColorIdentityWhite;
    private javax.swing.JCheckBox cbSearchColorRed;
    private javax.swing.JCheckBox cbSearchColorWhite;
    private javax.swing.JCheckBox cbSearchCommon;
    private javax.swing.JCheckBox cbSearchMythicRare;
    private javax.swing.JCheckBox cbSearchRare;
    private javax.swing.JCheckBox cbSearchUncommon;
    private javax.swing.JComboBox<String> comboSearchCMC;
    private javax.swing.JComboBox<String> comboSearchCMCSign;
    private javax.swing.JComboBox<String> comboSearchColor;
    private javax.swing.JComboBox<String> comboSearchColorIdentity;
    private javax.swing.JComboBox<String> comboSearchFormat;
    private javax.swing.JComboBox<String> comboSearchPower;
    private javax.swing.JComboBox<String> comboSearchPowerSign;
    private javax.swing.JComboBox<String> comboSearchPrinting;
    private javax.swing.JComboBox<String> comboSearchSet;
    private javax.swing.JComboBox<String> comboSearchText;
    private javax.swing.JComboBox<String> comboSearchToughness;
    private javax.swing.JComboBox<String> comboSearchToughnessSign;
    private javax.swing.JComboBox<String> comboSearchType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JTable tblCardResult;
    private javax.swing.JTextField txtCardName;
    private javax.swing.JTextPane txtPanelInfo;
    private javax.swing.JTextField txtText;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
