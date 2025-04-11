/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Tahsel.UI;

import Tahsel.Database.SearchHelper;
import Tahsel.Objects.Comment;
import Tahsel.Objects.Parent;
import Tahsel.Objects.User;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mbaiu
 */
public class JPanelUserComments extends javax.swing.JPanel {

    ArrayList<Comment> comments;
    Date startDate, endDate;
    JDateChooser dateChooserFromDate, dateChooserToDate;
    User user;
    ArrayList<Parent> parentsList;
    
    public JPanelUserComments(ArrayList<Comment> comments, User user, ArrayList<Parent> parentsList) {
        initComponents();
        this.user = user;
        this.comments = comments;
        this.parentsList = parentsList;
        endDate= new Date();
        startDate=comments.get(comments.size()-1).getDateCreated();
        this.jLabelUserName.setText(comments.get(0).getCreatedBy()+":");
        this.jLabelTotalNumOfComments.setText(String.valueOf(comments.size()));
        
        
        
        jPanelFromDate.setLayout(new FlowLayout()); // Ensure proper layout
        jPanelToDate.setLayout(new FlowLayout()); // Ensure proper layout

        // Create and configure JDateChooser
        dateChooserFromDate = new JDateChooser();
        dateChooserFromDate.setDate(startDate); // Set default date
        dateChooserFromDate.setDateFormatString("yyyy-MM-dd"); // Set date format
        dateChooserFromDate.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        jPanelFromDate.add(dateChooserFromDate);

        // Create and configure JDateChooser
        dateChooserToDate = new JDateChooser();
        dateChooserToDate.setDate(new Date()); // Set default date
        dateChooserToDate.setDateFormatString("yyyy-MM-dd"); // Set date format
        dateChooserToDate.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        jPanelToDate.add(dateChooserToDate); 
        
        
        this.jTableComments.setModel(createCommentsTableModel(this.comments));
        formatTable(this.jTableComments);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelUserName = new javax.swing.JLabel();
        jLabelTotalNumOfComments = new javax.swing.JLabel();
        jLabelRangeCommentCount = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelToDate = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelFromDate = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelDateRange = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComments = new javax.swing.JTable();

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabelUserName.setFont(new java.awt.Font("sansserif", 1, 32)); // NOI18N
        jLabelUserName.setText("«”„ «·„” Œœ„");

        jLabelTotalNumOfComments.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabelTotalNumOfComments.setText("#");

        jLabelRangeCommentCount.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        jLabelRangeCommentCount.setForeground(new java.awt.Color(0, 102, 51));
        jLabelRangeCommentCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRangeCommentCount.setToolTipText("");

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        jButton1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton1.setText("»ÕÀ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel1.setText("- «Ê -");

        jButton2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton2.setText("«·ﬂ·");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel6.setText("Õ Ì:");

        javax.swing.GroupLayout jPanelToDateLayout = new javax.swing.GroupLayout(jPanelToDate);
        jPanelToDate.setLayout(jPanelToDateLayout);
        jPanelToDateLayout.setHorizontalGroup(
            jPanelToDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        jPanelToDateLayout.setVerticalGroup(
            jPanelToDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanelToDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelToDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel4.setText("«· ⁄·Ìﬁ«  „‰  «—ÌŒ:");

        javax.swing.GroupLayout jPanelFromDateLayout = new javax.swing.GroupLayout(jPanelFromDate);
        jPanelFromDate.setLayout(jPanelFromDateLayout);
        jPanelFromDateLayout.setHorizontalGroup(
            jPanelFromDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        jPanelFromDateLayout.setVerticalGroup(
            jPanelFromDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelFromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jPanelFromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelTotalNumOfComments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelUserName)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelRangeCommentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUserName)
                    .addComponent(jLabelTotalNumOfComments))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRangeCommentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jLabelDateRange.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDateRange, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDateRange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jTableComments.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableComments);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date fromDate = dateChooserFromDate.getDate();
        Date toDate = dateChooserToDate.getDate();
        String range = new SimpleDateFormat("dd/MM/yy").format(fromDate) + "  -  " + new SimpleDateFormat("dd/MM/yy").format(toDate);

        jLabelDateRange.setText(range);
        ArrayList<Comment> newCommentsList = new ArrayList<>();
        for(Comment c: comments){
            if(!c.getDateCreated().before(fromDate) && !c.getDateCreated().after(toDate)){
                newCommentsList.add(c);
            }
        }
        jLabelRangeCommentCount.setText("⁄œœ «· ⁄·Ìﬁ«  Õ”» «· «—ÌŒ «·„Õœœ: "+newCommentsList.size() );
        jLabelRangeCommentCount.setForeground(Color.GREEN);
        this.jTableComments.setModel(createCommentsTableModel(newCommentsList));
        formatTable(this.jTableComments);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jTableComments.setModel(createCommentsTableModel(this.comments));
        formatTable(this.jTableComments);
        jLabelRangeCommentCount.setText("⁄œœ «· ⁄·Ìﬁ«  Õ”» «· «—ÌŒ «·„Õœœ: "+this.comments.size() );
        jLabelRangeCommentCount.setForeground(Color.black);
        jLabelDateRange.setText("«·ﬂ·");
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public DefaultTableModel createCommentsTableModel(ArrayList<Comment> comments) {

        // Column names
        String[] columnNames = {"’«›Ì «·„ »ﬁÌ", "«Ã„«·Ì «·„” Õﬁ", "„»·€ «· Õ’Ì·", "„Ê⁄œ «· Õ’Ì·", "«· ⁄·Ìﬁ",  " «—ÌŒ «· ⁄·Ìﬁ","—ﬁ„ Ê·Ì «·«„—","#"};

        // Convert ArrayList to 2D Object array
        Object[][] data = new Object[comments.size()][8];
        for (int i = 0; i < comments.size(); i++) {
            String dateToCollect = new SimpleDateFormat("dd/MM/yyyy").format(comments.get(i).getDateToCollect());
            String dateCreated = new SimpleDateFormat("dd/MM/yyyy").format(comments.get(i).getDateCreated());
            
            data[i][7] = String.valueOf(i+1);
            data[i][6] = comments.get(i).getParentID();
            data[i][5] = dateCreated;
//            data[i][5] = comments.get(i).getCreatedBy();
            data[i][4] = comments.get(i).getComment();
            data[i][3] = dateToCollect;
            data[i][2] = comments.get(i).getToGetCollected();
            data[i][1] = comments.get(i).getTotalOwed();
            data[i][0] = comments.get(i).getRemaining();

        }

        // Create a DefaultTableModel using the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        return model;
    }

    public void formatTable(JTable table) {
        table.setRowHeight(25);

        table.getColumnModel().getColumn(5).setPreferredWidth(10);
        table.getColumnModel().getColumn(6).setPreferredWidth(20);
        table.getColumnModel().getColumn(5).setPreferredWidth(10);
//        table.getColumnModel().getColumn(5).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(15);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);

        // Apply a custom renderer to all columns
        for (int col = 0; col < table.getColumnCount(); col++) {
            table.getColumnModel().getColumn(col).setCellRenderer(new DefaultTableCellRenderer() {

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    // Apply borders to all sides of the cell
                    label.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
                    if (column != 4) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                    } else {
                        label.setHorizontalAlignment(SwingConstants.RIGHT);
                    }

                    // Maintain selection styling
                    if (isSelected) {
                        label.setBackground(table.getSelectionBackground());
                        label.setForeground(table.getSelectionForeground());
                    } else {
                        label.setBackground(table.getBackground());
                        label.setForeground(table.getForeground());
                    }

                    return label;
                }
            });
        }
        
        
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Get the selected row index
                int selectedRow = jTableComments.getSelectedRow();
                // Check if a row is selected
                if (selectedRow != -1) {
                    // Get data from the selected row and print it
                    int id = (Integer) Integer.parseInt(jTableComments.getValueAt(selectedRow, 6).toString()); // ID column
                    Parent toFindParent = new Parent();
                    toFindParent.setParentID(id);
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (e.getClickCount() == 2) {
                            // Create table model and table
                            DefaultTableModel model = createCommentsTableModel(id);
                            JTable table = new JTable(model);

                            // Format the table
                            formatDialogTable(table);

                            // Create a scroll pane and put the table in it
                            JScrollPane scrollPane = new JScrollPane(table);
                            scrollPane.setPreferredSize(new Dimension(1200, 600)); // adjust size as needed
                            String title =
                                " ›«’Ì· «· ⁄·Ìﬁ«  ·Ê·Ì «·«„—: "
                                +parentsList.get(parentsList.indexOf(toFindParent)).getParentName()     
                                +" ("+toFindParent.getParentID()+") ";
                            // Show in a dialog
                            JOptionPane.showMessageDialog(null, scrollPane,title, JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                    
                }
            }
        });
    }
    
    
    
    public static DefaultTableModel createCommentsTableModel(int id) {
        ArrayList<Comment> comments = SearchHelper.getCommentsByParentID(id);

        // Column names
        String[] columnNames = {"’«›Ì «·„ »ﬁÌ", "«Ã„«·Ì «·„” Õﬁ", "„»·€ «· Õ’Ì·", "„Ê⁄œ «· Õ’Ì·", "«· ⁄·Ìﬁ", "«·„Õ’·", " «—ÌŒ «· ⁄·Ìﬁ"};

        // Convert ArrayList to 2D Object array
        Object[][] data = new Object[comments.size()][7];
        for (int i = 0; i < comments.size(); i++) {
            String dateToCollect = new SimpleDateFormat("dd/MM/yyyy").format(comments.get(i).getDateToCollect());
            String dateCreated = new SimpleDateFormat("dd/MM/yyyy").format(comments.get(i).getDateCreated());
            data[i][6] = dateCreated;
            data[i][5] = comments.get(i).getCreatedBy();
            data[i][4] = comments.get(i).getComment();
            data[i][3] = dateToCollect;
            data[i][2] = comments.get(i).getToGetCollected();
            data[i][1] = comments.get(i).getTotalOwed();
            data[i][0] = comments.get(i).getRemaining();

        }

        // Create a DefaultTableModel using the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        return model;
    }

    public void formatDialogTable(JTable table) {
        table.setRowHeight(25);

        table.getColumnModel().getColumn(6).setPreferredWidth(10);
        table.getColumnModel().getColumn(5).setPreferredWidth(10);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(15);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);

        // Apply a custom renderer to all columns
        for (int col = 0; col < table.getColumnCount(); col++) {
            table.getColumnModel().getColumn(col).setCellRenderer(new DefaultTableCellRenderer() {

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    // Apply borders to all sides of the cell
                    label.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
                    if (column != 4) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                    } else {
                        label.setHorizontalAlignment(SwingConstants.RIGHT);
                    }

                    // Maintain selection styling
                    if (isSelected) {
                        label.setBackground(table.getSelectionBackground());
                        label.setForeground(table.getSelectionForeground());
                    } else {
                        label.setBackground(table.getBackground());
                        label.setForeground(table.getForeground());
                    }

                    return label;
                }
            });
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDateRange;
    private javax.swing.JLabel jLabelRangeCommentCount;
    private javax.swing.JLabel jLabelTotalNumOfComments;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelFromDate;
    private javax.swing.JPanel jPanelToDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableComments;
    // End of variables declaration//GEN-END:variables
}
