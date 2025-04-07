package Tahsel.UI;

import Tahsel.Database.SearchHelper;
import Tahsel.Objects.Comment;
import Tahsel.Objects.Parent;
import static Tahsel.UI.TheMainTable.ALL;
import static Tahsel.UI.TheMainTable.user;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ParentsDialog extends javax.swing.JDialog {

    public ArrayList<Parent> parentsAll;
    public static ArrayList<Parent> gradeParents;
    public static ArrayList<Parent> kgParents;
    public static int flag;
    public javax.swing.JFrame parentFrame;
    public static boolean model;
    public static int rowToSelect;
    public static int activeTab;

    public ParentsDialog(javax.swing.JFrame parent, boolean modal, ArrayList<Parent> parentsAll, int flag, int rowToSelect, int activeTab) {
        super(parent, modal);
        initComponents();
        this.rowToSelect = rowToSelect;
        this.activeTab = activeTab;
        // Get screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        // Set the dialog size to the screen size (maximize it)
        this.setSize(screenSize.width, screenSize.height - 40);

        // Optionally, center the dialog on the screen
        this.setLocationRelativeTo(null);
        this.setResizable(true);  // Ensure the dialog is resizable


        parentFrame = parent;
        this.parentsAll = parentsAll;
        this.flag = flag;
        this.model = model;
        setData();
        this.jTableGrade.setModel(createParentsTableModel(gradeParents));
        this.jTableKG.setModel(createParentsTableModel(kgParents));
        formatAllTableTab(jTableGrade);
        formatAllTableTab(jTableKG);
        jTableGrade.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Get the selected row index
                int selectedRow = jTableGrade.getSelectedRow();
                // Check if a row is selected
                if (selectedRow != -1) {
                    // Get data from the selected row and print it
                    int id = (Integer) Integer.parseInt(jTableGrade.getValueAt(selectedRow, 11).toString()); // ID column
                    Parent toFindParent = new Parent();
                    toFindParent.setParentID(id);
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (e.getClickCount() == 2) {
                            showCommentDialog(ParentsDialog.this.parentFrame, ParentsDialog.this.gradeParents.get(ParentsDialog.this.gradeParents.indexOf(toFindParent)), selectedRow, 0);
                        }
                    }
                    if (SwingUtilities.isRightMouseButton(e)) {
                        copyToClipboard(ParentsDialog.this.gradeParents.get(ParentsDialog.this.gradeParents.indexOf(toFindParent)));
                    }
                }
            }
        });
        jTableKG.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Get the selected row index
                int selectedRow = jTableKG.getSelectedRow();
                // Check if a row is selected
                if (selectedRow != -1) {
                    // Get data from the selected row and print it
                    int id = (Integer) Integer.parseInt(jTableKG.getValueAt(selectedRow, 11).toString()); // ID column
                    Parent toFindParent = new Parent();
                    toFindParent.setParentID(id);
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (e.getClickCount() == 2) {
                            showCommentDialog(ParentsDialog.this.parentFrame, ParentsDialog.this.kgParents.get(ParentsDialog.this.kgParents.indexOf(toFindParent)), selectedRow, 1);
                        }
                    }
                    if (SwingUtilities.isRightMouseButton(e)) {
                        copyToClipboard(ParentsDialog.this.kgParents.get(ParentsDialog.this.kgParents.indexOf(toFindParent)));
                    }
                }
            }
        });

        if (activeTab == 0 && !this.gradeParents.isEmpty()) {
            jTableGrade.setRowSelectionInterval(rowToSelect, rowToSelect);
            // Scroll to make sure the selected row is visible
            Rectangle rect = jTableGrade.getCellRect(rowToSelect, 0, true);
            jTableGrade.scrollRectToVisible(rect);
        } else if (activeTab == 1 && !this.kgParents.isEmpty()) {
            jTableKG.setRowSelectionInterval(rowToSelect, rowToSelect);
            // Scroll to make sure the selected row is visible
            Rectangle rect = jTableKG.getCellRect(rowToSelect, 0, true);
            jTableKG.scrollRectToVisible(rect);
        }
        jTabbedPane.setSelectedIndex(activeTab);
        if(this.flag==TheMainTable.ALL){
            this.setTitle("All");
            this.jPanel.setBackground(Color.WHITE);
            this.jTabbedPane.setBackground(Color.WHITE);
        }
        else if(this.flag==TheMainTable.TOCALL){
            this.setTitle("To Call");
            this.jPanel.setBackground(new Color(153,255,255));
            this.jTabbedPane.setBackground(new Color(153,255,255));
        }
        else if(this.flag==TheMainTable.OVERDUE){
            this.setTitle("Over Due");
            this.jPanel.setBackground(Color.RED);
            this.jTabbedPane.setBackground(Color.RED);
        }
        else if(this.flag==TheMainTable.UNDERCOLLECTION){
            this.setTitle("Under Collection");
            this.jPanel.setBackground(Color.YELLOW);
            this.jTabbedPane.setBackground(Color.YELLOW);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelGrade = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldSearchGrade = new javax.swing.JTextField();
        jButtonSearchGrade = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGrade = new javax.swing.JTable();
        jPanelKG = new javax.swing.JPanel();
        jSplitPaneKG = new javax.swing.JSplitPane();
        jPanel3KG = new javax.swing.JPanel();
        jTextFieldSearchKG = new javax.swing.JTextField();
        jButtonSearchKG = new javax.swing.JButton();
        jLabelKG = new javax.swing.JLabel();
        jPanelKG2 = new javax.swing.JPanel();
        jScrollPaneKG = new javax.swing.JScrollPane();
        jTableKG = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jButtonSearchGrade.setText("»ÕÀ");
        jButtonSearchGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchGradeActionPerformed(evt);
            }
        });

        jLabel1.setText("»ÕÀ »—ﬁ„ Ê·Ì «·«„—:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jButtonSearchGrade)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldSearchGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearchGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchGrade)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel2);

        jTableGrade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTableGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableGrade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jTableGrade);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel3);

        javax.swing.GroupLayout jPanelGradeLayout = new javax.swing.GroupLayout(jPanelGrade);
        jPanelGrade.setLayout(jPanelGradeLayout);
        jPanelGradeLayout.setHorizontalGroup(
            jPanelGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelGradeLayout.setVerticalGroup(
            jPanelGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        jTabbedPane.addTab("Grade", jPanelGrade);

        jSplitPaneKG.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jButtonSearchKG.setText("»ÕÀ");
        jButtonSearchKG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchKGActionPerformed(evt);
            }
        });

        jLabelKG.setText("»ÕÀ »—ﬁ„ Ê·Ì «·«„—:");

        javax.swing.GroupLayout jPanel3KGLayout = new javax.swing.GroupLayout(jPanel3KG);
        jPanel3KG.setLayout(jPanel3KGLayout);
        jPanel3KGLayout.setHorizontalGroup(
            jPanel3KGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3KGLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jButtonSearchKG)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldSearchKG, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelKG)
                .addContainerGap())
        );
        jPanel3KGLayout.setVerticalGroup(
            jPanel3KGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3KGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3KGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearchKG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchKG)
                    .addComponent(jLabelKG))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPaneKG.setTopComponent(jPanel3KG);

        jTableKG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTableKG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableKG.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPaneKG.setViewportView(jTableKG);

        javax.swing.GroupLayout jPanelKG2Layout = new javax.swing.GroupLayout(jPanelKG2);
        jPanelKG2.setLayout(jPanelKG2Layout);
        jPanelKG2Layout.setHorizontalGroup(
            jPanelKG2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneKG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanelKG2Layout.setVerticalGroup(
            jPanelKG2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneKG, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );

        jSplitPaneKG.setRightComponent(jPanelKG2);

        javax.swing.GroupLayout jPanelKGLayout = new javax.swing.GroupLayout(jPanelKG);
        jPanelKG.setLayout(jPanelKGLayout);
        jPanelKGLayout.setHorizontalGroup(
            jPanelKGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPaneKG, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelKGLayout.setVerticalGroup(
            jPanelKGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPaneKG)
        );

        jTabbedPane.addTab("KG", jPanelKG);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchGradeActionPerformed
        Parent parent = new Parent();
        try{
        parent.setParentID(Integer.parseInt(jTextFieldSearchGrade.getText().toString().trim()));
        int index =gradeParents.indexOf(parent);
        if(index<0)
            index=0;
        System.out.println(index);
        jTableGrade.setRowSelectionInterval(index,index);
            // Scroll to make sure the selected row is visible
            Rectangle rect = jTableGrade.getCellRect(index, 0, true);
            jTableGrade.scrollRectToVisible(rect);
        } catch (NumberFormatException ex) {
            jTableGrade.setRowSelectionInterval(0,0);
            // Scroll to make sure the selected row is visible
            Rectangle rect = jTableGrade.getCellRect(0, 0, true);
            jTableGrade.scrollRectToVisible(rect);
        }
        
    }//GEN-LAST:event_jButtonSearchGradeActionPerformed

    private void jButtonSearchKGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchKGActionPerformed
        Parent parent = new Parent();
        try{
        parent.setParentID(Integer.parseInt(jTextFieldSearchKG.getText().toString().trim()));
        int index =kgParents.indexOf(parent);
        if(index<0)
            index=0;
        jTableKG.setRowSelectionInterval(index,index);
            // Scroll to make sure the selected row is visible
            Rectangle rect = jTableKG.getCellRect(index, 0, true);
            jTableKG.scrollRectToVisible(rect);
        } catch (NumberFormatException ex) {
            jTableKG.setRowSelectionInterval(0,0);
            // Scroll to make sure the selected row is visible
            Rectangle rect = jTableKG.getCellRect(0, 0, true);
            jTableKG.scrollRectToVisible(rect);
        }
    }//GEN-LAST:event_jButtonSearchKGActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ParentsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParentsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParentsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParentsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ParentsDialog dialog = new ParentsDialog(new javax.swing.JFrame(), true, gradeParents, flag, rowToSelect, activeTab);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public static DefaultTableModel createParentsTableModel(ArrayList<Parent> parents) {
        // Column names
        String[] columnNames = {"„Ê⁄œ «· Õ’Ì·", "«· ⁄·Ìﬁ", "«Ã„«·Ì «·„œ›Ê⁄", "’«›Ì «·„ »ﬁÌ", "«Ã„«·Ì «·„” Õﬁ", "„»·€ «Œ— ”œ«œ", " «—ÌŒ «Œ— ”œ«œ", "«·’›Ê›", "«”„«¡ «·«»‰«¡", "«·«»‰«¡", "«”„ Ê·Ì «·«„—", "Ê·Ì «·«„—"};
        // Convert ArrayList to 2D Object array
        Object[][] data = new Object[parents.size()][12];
        for (int i = 0; i < parents.size(); i++) {

            data[i][11] = parents.get(i);
            data[i][10] = parents.get(i).getParentName();
            data[i][9] = parents.get(i).getNumberOfChildren();
            data[i][8] = parents.get(i).getChildrensNames();
            data[i][7] = parents.get(i).getGrades();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = formatter.format(parents.get(i).getLastPaidDate());
            data[i][6] = formattedDate;
            data[i][5] = parents.get(i).getLastPaidMoney();
            data[i][4] = parents.get(i).getTotalOwed();
            data[i][3] = parents.get(i).getRemaining();
            data[i][2] = parents.get(i).getTotalPaied();
            data[i][1] = parents.get(i).getComment();
            data[i][0] = parents.get(i).getLastDateToCollect();

        }

        // Create a DefaultTableModel using the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //Make all cells non-editable
            }
        };
        return model;
    }

    public void formatAllTableTab(JTable table) {
        table.setRowHeight(30);

        table.getColumnModel().getColumn(11).setPreferredWidth(28);
        table.getColumnModel().getColumn(10).setPreferredWidth(165);
        table.getColumnModel().getColumn(9).setPreferredWidth(18);
        table.getColumnModel().getColumn(8).setPreferredWidth(145);
        table.getColumnModel().getColumn(7).setPreferredWidth(140);
        table.getColumnModel().getColumn(6).setPreferredWidth(62);
        table.getColumnModel().getColumn(5).setPreferredWidth(62);
        table.getColumnModel().getColumn(4).setPreferredWidth(65);
        table.getColumnModel().getColumn(3).setPreferredWidth(62);
        table.getColumnModel().getColumn(2).setPreferredWidth(62);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(0).setPreferredWidth(62);

        // Apply a custom renderer to all columns
        for (int col = 0; col < table.getColumnCount(); col++) {
            table.getColumnModel().getColumn(col).setCellRenderer(new DefaultTableCellRenderer() {

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    Parent p = (Parent) table.getValueAt(row, 11);
                    // Apply borders to all sides of the cell
                    label.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
                    if (column == 10 || column == 1) {
                        label.setHorizontalAlignment(SwingConstants.RIGHT);
                    } else {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                    }
                    // Apply custom styling for the 3rd column
                    if (column == 2) {
                        int percentage = p.getPaymentStatusPercentage();
                        if (percentage < 50) {
                            label.setBackground(Color.RED);
                        } else if (percentage < 75) {
                            label.setBackground(Color.yellow);
                        } else {
                            label.setBackground(Color.green);
                        }
                    }
                    if (column == 4) {
                        double remainingOldFees = p.getRemainingOldFees();
                        System.out.println(p.getRemainingOldFees());
                        if (remainingOldFees > 0) {
                            label.setBackground(Color.gray);
                        } else {
                            label.setBackground(table.getBackground());
                        }
                    }
                    // Maintain selection styling
                    if (isSelected) {
                        label.setBackground(table.getSelectionBackground());
                        label.setForeground(table.getSelectionForeground());
                    } else {
                        if (column != 2 && column != 4) {
                            label.setBackground(table.getBackground());
                            label.setForeground(table.getForeground());
                        }
                        label.setForeground(table.getForeground());
                    }

                    return label;
                }
            });
        }
    }

    private void showCommentDialog(javax.swing.JFrame parentFrame, Parent parent, int row, int tab) {

        JDialog dialog = new JDialog(parentFrame, "«÷«›…  ⁄·Ìﬁ", true);
        dialog.setSize(900, 900);
        dialog.setLocationRelativeTo(parentFrame);
        JPanelComment panel = new JPanelComment(parentFrame, user, dialog, parent, ParentsDialog.this, row, tab);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.setVisible(true);

    }
    
    private static void copyToClipboard(Parent parent) {
//        String stringToCopy = parent.getParentID()+"\t"+parent.getParentName()+"\t"+parent.getChildrensNames();
        String stringToCopy = parent.getRemaining()+"\t"+parent.getTotalPaied()+"\t"+parent.getTotalOwed()+"\t"+parent.getChildrensNames()+"\t"+parent.getParentName()+"\t" + parent.getParentID();
        StringSelection stringSelection = new StringSelection(stringToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        JOptionPane.showMessageDialog(null, "Copied to clipboard: " + stringToCopy);
    }

    public void setData() {
        if (this.flag == TheMainTable.ALL) {
            showAllParents();
        } else if (this.flag == TheMainTable.TOCALL) {
            showToCallParents();
        } else if (this.flag == TheMainTable.OVERDUE) {
            showOverDueParents();
        } else if (this.flag == TheMainTable.UNDERCOLLECTION) {
            showUnderCollectionParents();
        }
    }

    public void showAllParents() {
        Map<Integer, ArrayList<Comment>> commentMap = SearchHelper.getComments();
        kgParents = new ArrayList();
        gradeParents = new ArrayList();
        ArrayList<Parent> parents = this.parentsAll;

        parents.sort(Comparator.comparing(Parent::getLastPaidDate));
        for (Parent parent : parents) {
            if (parent.getRemaining() > 0) { //for all 
                if (commentMap.get(parent.getParentID()) != null) {
                    Comment lastComment = commentMap.get(parent.getParentID()).get(0);
                    parent.setLastDateToCollect(lastComment.getDateToCollect());
                    parent.setComment(lastComment.getComment());
                }
                ArrayList<String> gradesList = new ArrayList<>(Arrays.asList(parent.getGrades().split(", ")));
                if ((!gradesList.contains("G1")) && (!gradesList.contains("G2")) && (!gradesList.contains("G3"))
                        && (!gradesList.contains("G4")) && (!gradesList.contains("G5")) && (!gradesList.contains("G6"))
                        && (!gradesList.contains("G7")) && (!gradesList.contains("G8")) && (!gradesList.contains("G9"))) {
                    kgParents.add(parent);
                } else {
                    gradeParents.add(parent);
                }
            }
        }
    }

    public void showToCallParents() {
        Map<Integer, ArrayList<Comment>> commentMap = SearchHelper.getComments();
        kgParents = new ArrayList();
        gradeParents = new ArrayList();
        ArrayList<Parent> parents = this.parentsAll;
        parents.sort(Comparator.comparing(Parent::getLastPaidDate));
        for (Parent parent : parents) {
            if (parent.getRemaining() > 0) { //for all
                ArrayList<String> gradesList = new ArrayList<>(Arrays.asList(parent.getGrades().split(", ")));
                if (commentMap.get(parent.getParentID()) != null) {
                    Comment lastComment = commentMap.get(parent.getParentID()).get(0);
                    parent.setLastDateToCollect(lastComment.getDateToCollect());
                    parent.setComment(lastComment.getComment());
                    if (parent.getLastPaidDate().after(parent.getLastDateToCollect())) {
                        if ((!gradesList.contains("G1")) && (!gradesList.contains("G2")) && (!gradesList.contains("G3"))
                                && (!gradesList.contains("G4")) && (!gradesList.contains("G5")) && (!gradesList.contains("G6"))
                                && (!gradesList.contains("G7")) && (!gradesList.contains("G8")) && (!gradesList.contains("G9"))) {
                            kgParents.add(parent);
                        } else {
                            gradeParents.add(parent);
                        }
                    }
                } else {
                    if ((!gradesList.contains("G1")) && (!gradesList.contains("G2")) && (!gradesList.contains("G3"))
                            && (!gradesList.contains("G4")) && (!gradesList.contains("G5")) && (!gradesList.contains("G6"))
                            && (!gradesList.contains("G7")) && (!gradesList.contains("G8")) && (!gradesList.contains("G9"))) {
                        kgParents.add(parent);
                    } else {
                        gradeParents.add(parent);
                    }
                }
            }
        }
    }

    public void showOverDueParents() {
        Map<Integer, ArrayList<Comment>> commentMap = SearchHelper.getComments();
        ArrayList<Parent> parentsWithComments = new ArrayList<Parent>();

        kgParents = new ArrayList();
        gradeParents = new ArrayList();
        for (Parent parent : this.parentsAll) {
            if (parent.getRemaining() > 0) { //for all
                if (commentMap.get(parent.getParentID()) != null) {
                    Comment lastComment = commentMap.get(parent.getParentID()).get(0);
                    parent.setLastDateToCollect(lastComment.getDateToCollect());
                    parent.setComment(lastComment.getComment());
                    parentsWithComments.add(parent);
                }
            }
        }
        parentsWithComments.sort(Comparator.comparing(Parent::getLastDateToCollect));
        for (Parent parent : parentsWithComments) {
            if (commentMap.get(parent.getParentID()) != null) {
                if (parent.getLastDateToCollect().before(new Date()) && parent.getLastPaidDate().before(parent.getLastDateToCollect())) {
                    if (parent.getRemaining() > 0) { //for all
                        ArrayList<String> gradesList = new ArrayList<>(Arrays.asList(parent.getGrades().split(", ")));
                        if ((!gradesList.contains("G1")) && (!gradesList.contains("G2")) && (!gradesList.contains("G3"))
                                && (!gradesList.contains("G4")) && (!gradesList.contains("G5")) && (!gradesList.contains("G6"))
                                && (!gradesList.contains("G7")) && (!gradesList.contains("G8")) && (!gradesList.contains("G9"))) {
                            kgParents.add(parent);
                        } else {
                            gradeParents.add(parent);
                        }
                    }
                }
            }
        }

    }

    public void showUnderCollectionParents() {
        Map<Integer, ArrayList<Comment>> commentMap = SearchHelper.getComments();
        ArrayList<Parent> parentsWithComments = new ArrayList<Parent>();

        kgParents = new ArrayList();
        gradeParents = new ArrayList();
        for (Parent parent : this.parentsAll) {
            if (parent.getRemaining() > 0) { //for all
                if (commentMap.get(parent.getParentID()) != null) {
                    Comment lastComment = commentMap.get(parent.getParentID()).get(0);
                    parent.setLastDateToCollect(lastComment.getDateToCollect());
                    parent.setComment(lastComment.getComment());
                    parentsWithComments.add(parent);
                }
            }
        }
        parentsWithComments.sort(Comparator.comparing(Parent::getLastDateToCollect));
        for (Parent parent : parentsWithComments) {
            if (commentMap.get(parent.getParentID()) != null) {
                if (parent.getLastDateToCollect().after(new Date()) && parent.getLastPaidDate().before(parent.getLastDateToCollect())) {
                    if (parent.getRemaining() > 0) { //for all
                        ArrayList<String> gradesList = new ArrayList<>(Arrays.asList(parent.getGrades().split(", ")));
                        if ((!gradesList.contains("G1")) && (!gradesList.contains("G2")) && (!gradesList.contains("G3"))
                                && (!gradesList.contains("G4")) && (!gradesList.contains("G5")) && (!gradesList.contains("G6"))
                                && (!gradesList.contains("G7")) && (!gradesList.contains("G8")) && (!gradesList.contains("G9"))) {
                            kgParents.add(parent);
                        } else {
                            gradeParents.add(parent);
                        }
                    }
                }
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSearchGrade;
    private javax.swing.JButton jButtonSearchKG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelKG;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel3KG;
    private javax.swing.JPanel jPanelGrade;
    private javax.swing.JPanel jPanelKG;
    private javax.swing.JPanel jPanelKG2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneKG;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPaneKG;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableGrade;
    private javax.swing.JTable jTableKG;
    private javax.swing.JTextField jTextFieldSearchGrade;
    private javax.swing.JTextField jTextFieldSearchKG;
    // End of variables declaration//GEN-END:variables

    public ArrayList<Parent> getParentsAll() {
        return parentsAll;
    }

    public static int getFlag() {
        return flag;
    }

    public JFrame getParentFrame() {
        return parentFrame;
    }

    public static boolean isModel() {
        return model;
    }

    public static int getRowToSelect() {
        return rowToSelect;
    }

}
