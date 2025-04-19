/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Tahsel.UI;

import Tahsel.Database.DatabaseHelper;
import Tahsel.Database.SearchHelper;
import Tahsel.Objects.Comment;
import Tahsel.Objects.Parent;
import Tahsel.Objects.User;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bat
 */
public class JPanelComment extends javax.swing.JPanel {

    javax.swing.JFrame parentFrame;
    JDialog dialog;
    public static User user;
    Date maxDate;
    JDateChooser dateChooser;
    private Parent parent;
    ParentsDialog parentsDialog;
    public static int rowToSelect;
    public static int tabIndex;
    

    public JPanelComment(javax.swing.JFrame parentFrame, User user, JDialog dialog, Parent parent, ParentsDialog parentsDialog,int rowToSelect,int tabIndex) {
        initComponents();
        this.parentFrame = parentFrame;
        this.user = user;
        this.dialog = dialog;
        this.parent = parent;
        this.tabIndex=tabIndex;
        this.rowToSelect=rowToSelect;
        this.parentsDialog = parentsDialog;
        jPanelDate.setLayout(new FlowLayout()); // Ensure proper layout
        jTextAreaComment.setRows(1); // Sets to 8 rows high

        // Get today's date
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        
        // Calculate 45 days from today
        calendar.add(Calendar.DAY_OF_MONTH, 45);
        maxDate = calendar.getTime();

        // Create and configure JDateChooser
        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date()); // Set default date
        dateChooser.setDateFormatString("yyyy-MM-dd"); // Set date format
        dateChooser.setPreferredSize(new Dimension(150, 30)); // Set preferred size
        
         
        
        // Set the date range
        dateChooser.setSelectableDateRange(today, maxDate);
        
        jPanelDate.add(dateChooser);

        this.jLabelParentID.setText(parent.getParentID() + "");
        this.jTextFieldParentName.setText(parent.getParentName());

        this.jTableComments.setModel(createCommentsTableModel(parent.getParentID()));
        formatTable(this.jTableComments);

        setPrograssbAR();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelParentID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldParentName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaComment = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextFieldToCollect = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelDate = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComments = new javax.swing.JTable();

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("��� ��� �����:");

        jLabelParentID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelParentID.setText("#");

        jLabel6.setText("��� ��� �����:");

        jTextFieldParentName.setEditable(false);
        jTextFieldParentName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldParentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldParentNameActionPerformed(evt);
            }
        });

        jLabel7.setText("�������:");

        jTextAreaComment.setColumns(10);
        jTextAreaComment.setLineWrap(true);
        jTextAreaComment.setRows(5);
        jTextAreaComment.setWrapStyleWord(true);
        jTextAreaComment.setBorder(null);
        jTextAreaComment.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextAreaComment.setInheritsPopupMenu(true);
        jTextAreaComment.setMinimumSize(new java.awt.Dimension(13, 80));
        jScrollPane2.setViewportView(jTextAreaComment);

        jLabel8.setText("������ ������ ������:");

        jProgressBar1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(0, 204, 0));
        jProgressBar1.setValue(22);

        jTextFieldToCollect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldToCollectActionPerformed(evt);
            }
        });

        jLabel1.setText("����� �������:");

        javax.swing.GroupLayout jPanelDateLayout = new javax.swing.GroupLayout(jPanelDate);
        jPanelDate.setLayout(jPanelDateLayout);
        jPanelDateLayout.setHorizontalGroup(
            jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );
        jPanelDateLayout.setVerticalGroup(
            jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jButton1.setText("�����");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                            .addComponent(jTextFieldParentName))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(2, 262, Short.MAX_VALUE)
                        .addComponent(jTextFieldToCollect, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelParentID)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelParentID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldParentName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldToCollect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))
                        .addContainerGap())))
        );

        jSplitPane1.setTopComponent(jPanel2);

        jTableComments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTableComments);

        jSplitPane1.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldToCollectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldToCollectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldToCollectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.jTextAreaComment.setBorder(BorderFactory.createLineBorder(null));
            int parentID = parent.getParentID();
            String commentText = jTextAreaComment.getText().trim();
            double toGetCollected = Double.parseDouble(jTextFieldToCollect.getText().trim());
            double totalOwed = parent.getTotalOwed(), remaining = parent.getRemaining();
            Date dateToCollect = dateChooser.getDate();
//            Date dateCreated = Date.from(LocalDate.now().minusDays(3).atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date dateCreated = new Date();
            Comment comment = new Comment(parentID, commentText, toGetCollected, dateToCollect, dateCreated, totalOwed, remaining, user.getName());
            if (commentText.equals("")) {
                JOptionPane.showMessageDialog(this, "���� �����");
                this.jTextAreaComment.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
            else if(commentText.contains("����") && commentText.length()<10){
//                JOptionPane.show
                JOptionPane.showMessageDialog(this, "����� ����� ������ ������ �� ����� ������� ������ ������ \n ���� ���� ����� �� ���� ��.....","�����!!",2);
                this.jTextAreaComment.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
            else if((commentText.contains("�� ���")||commentText.contains("�� ���")||commentText.contains("�� ��")||commentText.contains("�� ���� ��")||commentText.contains("�� ��� ����")||commentText.contains("�� ��� ����")||commentText.contains("�� ����")) && commentText.length()<12){
                JOptionPane.showMessageDialog(this, "�� ��� ��� ���� �� ��� ����� ����� � ��� ������ ������� ��� ���� ��� ��� ��� ���� �� ��� ����� �� ��� ������","�����!!",2);
                this.jTextAreaComment.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
            else if(dateToCollect.after(maxDate)){
                JOptionPane.showMessageDialog(this, "���� ������� ��� �� �� ����� 45 ��� �� ����� �����!","�����!!",2);
            }
            else{
                DatabaseHelper.addComment(comment);
                this.dialog.dispose();
                this.parentsDialog.dispose();
                ParentsDialog newParentsDialog = new ParentsDialog(parentsDialog.getParentFrame(), parentsDialog.isModel(), parentsDialog.getParentsAll(),parentsDialog.getCommentMap(), parentsDialog.getFlag(),rowToSelect,tabIndex);
                newParentsDialog.setVisible(true);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "������ ������ ������ ��� �� ���� ��� ���");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldParentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldParentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldParentNameActionPerformed

    public static DefaultTableModel createCommentsTableModel(int id) {
        ArrayList<Comment> comments = SearchHelper.getCommentsByParentID(id);

        // Column names
        String[] columnNames = {"���� �������", "������ �������", "���� �������", "���� �������", "�������", "������", "����� �������"};

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

    public void formatTable(JTable table) {
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

    public void setPrograssbAR() {
        int percentage = this.parent.getPaymentStatusPercentage();
        this.jProgressBar1.setValue(percentage);
        if (percentage < 50) {
            this.jProgressBar1.setForeground(Color.red);
        } else if (percentage < 75) {
            this.jProgressBar1.setForeground(Color.yellow);
        } else {
            this.jProgressBar1.setForeground(Color.green);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelParentID;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDate;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableComments;
    private javax.swing.JTextArea jTextAreaComment;
    private javax.swing.JTextField jTextFieldParentName;
    private javax.swing.JTextField jTextFieldToCollect;
    // End of variables declaration//GEN-END:variables
}
