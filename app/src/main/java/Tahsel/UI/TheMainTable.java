package Tahsel.UI;

import Tahsel.App;
import Tahsel.Database.DatabaseHelper;
import Tahsel.Database.SearchHelper;
import Tahsel.ExcelHelper;
import Tahsel.Objects.Comment;
import Tahsel.Objects.Parent;
import Tahsel.Objects.User;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


public class TheMainTable extends javax.swing.JFrame {

    public static int ALL = 0;
    public static int TOCALL = 1;
    public static int OVERDUE = 2;
    public static int UNDERCOLLECTION = 3;

    public static boolean isLightMode = true;
    public static User user;
    ArrayList<Parent> parentsAll;
    public static Map<Integer, ArrayList<Comment>> commentMap;

    public TheMainTable(User user) {
        ImageIcon highResIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("T:\\logo.png"));
        Image scaledIcon = highResIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        this.setIconImage(scaledIcon);
        this.user = user;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle(user.getId());
        initComponents();
        jTableUsers.setModel(createUsersTableModel());

        this.parentsAll = readExcelFileForParents();
        commentMap=SearchHelper.getComments();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files (.xlsx)", "xlsx");
        jFileChooser1.setAcceptAllFileFilterUsed(false);
        jFileChooser1.setFileFilter(filter);
        if (!getUserID().equals("100")) {
            this.jTabbedPaneMain.removeTabAt(1);
            this.jTabbedPaneMain.removeTabAt(1);
            this.jTabbedPaneMain.removeTabAt(1);
        }
        if (getUserID().equals("100")) {
            this.jButtonDownload.setEnabled(true);
            this.jButtonDeleteAllComments.setEnabled(true);
            
        }

        jTableUsers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Get the selected row index
                int selectedRow = jTableUsers.getSelectedRow();
                if (selectedRow != -1) {
                    String id = (String) jTableUsers.getValueAt(selectedRow, 0); // ID column
                    String firstName = (String) jTableUsers.getValueAt(selectedRow, 1); // First Name column
                    showDialog(TheMainTable.this, id);
                    TheMainTable.this.dispose();
                    TheMainTable newPage = new TheMainTable(TheMainTable.this.user);
                    newPage.setVisible(true);
                    newPage.jTabbedPaneMain.setSelectedIndex(2);
                }
            }
        });

        jLabel4.setIcon(new ImageIcon("T:\\logo.png"));
        
        buildUserCommentsTab();
        
        
        
        
        
        for (Component comp : jFileChooser1.getComponents()) {
    if (comp instanceof Container) {
        for (Component sub : ((Container) comp).getComponents()) {
            if (sub instanceof JButton) {
                String text = ((JButton) sub).getText();
                if ("Open".equals(text) || "Cancel".equals(text)) {
                    ((Container) comp).remove(sub);
                }
            }
        }
    }
}
jFileChooser1.revalidate();
jFileChooser1.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPaneMain = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel10 = new javax.swing.JPanel();
        jButtonAll = new javax.swing.JButton();
        jButtonToCall = new javax.swing.JButton();
        jButtonOverDue = new javax.swing.JButton();
        jButtonUnderCollection = new javax.swing.JButton();
        jPanelParentsGlobal = new javax.swing.JPanel();
        jPanelImage = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelAddUser = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabelUserNumber = new javax.swing.JLabel();
        jTextFieldUserNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonAdd = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableUsers = new javax.swing.JTable();
        jPanelUploadFile = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButtonDownload = new javax.swing.JButton();
        jButtonDeleteAllComments = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel();
        jTabbedPaneCommentsForUser = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jButtonDarkMode = new javax.swing.JButton();
        jButtonLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jButtonAll.setText("«·ﬂ·");
        jButtonAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllActionPerformed(evt);
            }
        });

        jButtonToCall.setText("« ’«·");
        jButtonToCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToCallActionPerformed(evt);
            }
        });

        jButtonOverDue.setText("€Ì— „· “„ » «—ÌŒ «·”œ«œ");
        jButtonOverDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOverDueActionPerformed(evt);
            }
        });

        jButtonUnderCollection.setText(" Õ  «·«‰ Ÿ«—");
        jButtonUnderCollection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnderCollectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAll)
                .addGap(18, 18, 18)
                .addComponent(jButtonToCall)
                .addGap(18, 18, 18)
                .addComponent(jButtonOverDue)
                .addGap(18, 18, 18)
                .addComponent(jButtonUnderCollection)
                .addContainerGap(732, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAll)
                    .addComponent(jButtonToCall)
                    .addComponent(jButtonOverDue)
                    .addComponent(jButtonUnderCollection))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane2.setTopComponent(jPanel10);

        jPanelImage.setForeground(new java.awt.Color(255, 204, 102));

        javax.swing.GroupLayout jPanelImageLayout = new javax.swing.GroupLayout(jPanelImage);
        jPanelImage.setLayout(jPanelImageLayout);
        jPanelImageLayout.setHorizontalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImageLayout.createSequentialGroup()
                .addContainerGap(530, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(638, Short.MAX_VALUE))
        );
        jPanelImageLayout.setVerticalGroup(
            jPanelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImageLayout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(316, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelParentsGlobalLayout = new javax.swing.GroupLayout(jPanelParentsGlobal);
        jPanelParentsGlobal.setLayout(jPanelParentsGlobalLayout);
        jPanelParentsGlobalLayout.setHorizontalGroup(
            jPanelParentsGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelParentsGlobalLayout.setVerticalGroup(
            jPanelParentsGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParentsGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jPanelParentsGlobal);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        jTabbedPaneMain.addTab(" Õ’Ì·", jPanel9);

        jLabelUserNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUserNumber.setText("—ﬁ„ «·„” Œœ„:");

        jTextFieldUserNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("«”„ «·„” Œœ„:");

        jTextFieldUserName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldUserName.setToolTipText("«”„ «·„” Œœ„");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("«·—ﬁ„ «·”—Ì:");

        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jButtonAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAdd.setText("≈÷«›…");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUserNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                .addComponent(jPasswordField)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelUserNumber, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUserNumber)
                    .addComponent(jTextFieldUserNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(79, 79, 79)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(466, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel5);

        jTableUsers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTableUsers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableUsers);

        jSplitPane1.setLeftComponent(jScrollPane3);

        javax.swing.GroupLayout jPanelAddUserLayout = new javax.swing.GroupLayout(jPanelAddUser);
        jPanelAddUser.setLayout(jPanelAddUserLayout);
        jPanelAddUserLayout.setHorizontalGroup(
            jPanelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        jPanelAddUserLayout.setVerticalGroup(
            jPanelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        jTabbedPaneMain.addTab("«÷«›… „” Œœ„", jPanelAddUser);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("«Œ — «·„·›");

        jFileChooser1.setAcceptAllFileFilterUsed(false);
        jFileChooser1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        jButtonDownload.setBackground(new java.awt.Color(204, 255, 204));
        jButtonDownload.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButtonDownload.setText(" „·› „·Œ’  «· Õ’Ì·");
        jButtonDownload.setEnabled(false);
        jButtonDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDownloadActionPerformed(evt);
            }
        });

        jButtonDeleteAllComments.setText("Õ–› ﬂ· «· ⁄·Ìﬁ« ");
        jButtonDeleteAllComments.setEnabled(false);
        jButtonDeleteAllComments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAllCommentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButtonDeleteAllComments, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(15, 15, 15))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteAllComments, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanelUploadFileLayout = new javax.swing.GroupLayout(jPanelUploadFile);
        jPanelUploadFile.setLayout(jPanelUploadFileLayout);
        jPanelUploadFileLayout.setHorizontalGroup(
            jPanelUploadFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelUploadFileLayout.setVerticalGroup(
            jPanelUploadFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPaneMain.addTab("—›⁄ „·›", jPanelUploadFile);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneCommentsForUser)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(jTabbedPaneCommentsForUser)
                .addGap(0, 0, 0))
        );

        jTabbedPaneMain.addTab("«· ⁄·Ìﬁ« ", jPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMain)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPaneMain)
                .addContainerGap())
        );

        jButtonDarkMode.setText("œ«ﬂ‰");
        jButtonDarkMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDarkModeActionPerformed(evt);
            }
        });

        jButtonLogOut.setText("Œ—ÊÃ");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDarkMode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogOut)
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDarkMode)
                    .addComponent(jButtonLogOut))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        String filePath = jFileChooser1.getSelectedFile().getAbsolutePath();
        try {
            ArrayList<Parent> list = ExcelHelper.getParentsFromSheet(filePath);

            File excelFolder = new File("Excel");
            excelFolder.setWritable(true);

            // Check if the Sunrise folder exists, if not, create it
            if (!excelFolder.exists()) {
                boolean created = excelFolder.mkdir(); // Create the Sunrise folder
                if (created) {
                    System.out.println("Folder 'Excel' was created inside Documents.");
                } else {
                    System.out.println("Failed to create 'Excel' folder.");
                }
            }

            String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            // Copy the file
            Files.copy(Path.of(filePath), Path.of("Excel\\" + todayDate + ".xlsx"), StandardCopyOption.REPLACE_EXISTING);
            JOptionPane.showMessageDialog(this, " „  «·⁄„·Ì… »‰Ã«Õ.");
            this.parentsAll = readExcelFileForParents();
            jTabbedPaneMain.setSelectedIndex(0);
        } catch (IOException | ParseException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, "Œÿ«¡ ›Ì «·„·›:\n" + ex);
            Logger.getLogger(TheMainTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        String id = jTextFieldUserNumber.getText().toString();
        String name = jTextFieldUserName.getText().toString();
        String password = jPasswordField.getText().toString();
        if (SearchHelper.getAllUserIDs().contains(id) || id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ì—ÃÌ «œŒ«· «·—ﬁ„ «·”—Ì.");
        } else if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ì—ÃÌ «œŒ«· «”„ «·„” Œœ„.");
        } else if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ì—ÃÌ «œŒ«· «·—ﬁ„ «·”—Ì.");
        } else {
            DatabaseHelper.addUser(new User(id, name, password));
            JOptionPane.showMessageDialog(this, " „ «·«÷«›… »‰Ã«Õ");
            jTextFieldUserNumber.setText("");
            jTextFieldUserName.setText("");
            jPasswordField.setText("");
            this.jTableUsers.setModel(createUsersTableModel());

        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jButtonDarkModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDarkModeActionPerformed
        try {
            if (!isLightMode) {
                UIManager.setLookAndFeel(new FlatLightLaf()); // For dark theme
                isLightMode = true;
            } else {
                UIManager.setLookAndFeel(new FlatDarkLaf()); // For dark theme
                isLightMode = false;
            }
            this.dispose();
            TheMainTable w = new TheMainTable(TheMainTable.this.user);
            w.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_jButtonDarkModeActionPerformed

    private void jButtonDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDownloadActionPerformed
        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = folderChooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = folderChooser.getSelectedFile();
            File fileToSave = new File(selectedFolder, "tahsel.xlsx");
            
            
            
//            Map<Integer, ArrayList<Comment>> commentMap = SearchHelper.getComments();
            ArrayList<Parent> newList = new ArrayList<>();
            for (Parent parent : this.parentsAll) {
                if (parent.getRemaining() > 0) { //for all 
                    if (commentMap.get(parent.getParentID()) != null) {
                        Comment lastComment = commentMap.get(parent.getParentID()).get(0);
                        parent.setLastDateToCollect(lastComment.getDateToCollect());
                        parent.setComment(lastComment.getComment());     
                    }
                    else{
                        parent.setLastDateToCollect(null);
                        parent.setComment("-");
                    }
                    newList.add(parent);
                }
            }            
            ExcelHelper.writeParentsToSheet(newList, fileToSave.getAbsolutePath());
        }
    }//GEN-LAST:event_jButtonDownloadActionPerformed

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        File file = new File(new File(new File(System.getProperty("user.home"), "Documents"), "Sunrise"), "RM.txt");
        file.delete();
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jButtonAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllActionPerformed
        commentMap=SearchHelper.getComments();
        ParentsDialog dialog = new ParentsDialog(TheMainTable.this, false, parentsAll,commentMap, ALL, 0, 0);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                TheMainTable.this.setVisible(true);
                TheMainTable.this.setExtendedState(JFrame.NORMAL);
            }
        });
        TheMainTable.this.setState(JFrame.ICONIFIED);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonAllActionPerformed

    private void jButtonToCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToCallActionPerformed
        commentMap=SearchHelper.getComments();
        ParentsDialog dialog = new ParentsDialog(this, true, parentsAll,commentMap, TOCALL, 0, 0);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                TheMainTable.this.setVisible(true);
                TheMainTable.this.setExtendedState(JFrame.NORMAL);
            }
        });
        TheMainTable.this.setState(JFrame.ICONIFIED);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonToCallActionPerformed

    private void jButtonOverDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOverDueActionPerformed
        commentMap=SearchHelper.getComments();
        ParentsDialog dialog = new ParentsDialog(this, true, parentsAll,commentMap, OVERDUE, 0, 0);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                TheMainTable.this.setVisible(true);
                TheMainTable.this.setExtendedState(JFrame.NORMAL);
            }
        });
        TheMainTable.this.setState(JFrame.ICONIFIED);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonOverDueActionPerformed

    private void jButtonUnderCollectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnderCollectionActionPerformed
        commentMap=SearchHelper.getComments();
        ParentsDialog dialog = new ParentsDialog(this, true, parentsAll,commentMap, UNDERCOLLECTION, 0, 0);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                TheMainTable.this.setVisible(true);
                TheMainTable.this.setExtendedState(JFrame.NORMAL);
            }
        });
        TheMainTable.this.setState(JFrame.ICONIFIED);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonUnderCollectionActionPerformed

    private void jButtonDeleteAllCommentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAllCommentsActionPerformed
        DatabaseHelper.deleteAllComments();
        JOptionPane.showMessageDialog(this, " „ Õ–› Ã„Ì⁄ «· ⁄·Ìﬁ« . Ì—ÃÌ «€·«ﬁ «·»—‰«„Ã Ê«⁄«œ…  ‘€Ì·Â");
    }//GEN-LAST:event_jButtonDeleteAllCommentsActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TheMainTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TheMainTable(user).setVisible(true);
            }
        });
    }

    public static String getUserID() {
        String userHome = System.getProperty("user.home");
        File documentsFolder = new File(userHome, "Documents");
        File sunriseFolder = new File(documentsFolder, "Sunrise");
        if (!sunriseFolder.exists()) {
            boolean created = sunriseFolder.mkdir(); // Create the Sunrise folder
            if (created) {
                System.out.println("Folder 'Sunrise' was created inside Documents.");
            } else {
                System.out.println("Failed to create 'Sunrise' folder.");
                return "";
            }
        }
        File file = new File(sunriseFolder, "RM.txt");
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return "";
        }
        try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (SearchHelper.getAllUserIDs().contains(line)) {
                return line;
            } else {
                return "";
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return "";
        }
    }

    public static DefaultTableModel createUsersTableModel() {
        ArrayList<User> users = SearchHelper.getUsers();
        String[] columnNames = {"—ﬁ„ «·„” Œœ„", "«”„ «·„” Œœ„"};
        Object[][] data = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i).getId();
            data[i][1] = users.get(i).getName();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        return model;
    }

    private static void showDialog(javax.swing.JFrame parentFrame, String id) {
        User selectedUser = SearchHelper.getUserByID(id);

        // Create the dialog
        JDialog dialog = new JDialog(parentFrame, "Input Dialog", true);
        dialog.setSize(600, 95);
        dialog.setLocationRelativeTo(parentFrame);

        // Create the input field and button
        JTextField nameField = new JTextField(15);
        nameField.setText(selectedUser.getName());
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setText(selectedUser.getPassword());
        JButton submitButton = new JButton("Õ›Ÿ");

        // ActionListener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().toString(); // Get text from input field
                String password = passwordField.getText().toString();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Ì—ÃÌ «œŒ«· «”„ «·„” Œœ„.");
                    // Call the method with the input data

                }
                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Ì—ÃÌ «œŒ«· «·—ﬁ„ «·”—Ì.");
                    // Call the method with the input data

                } else {
                    User updatedUser = new User(id, name, password);
                    DatabaseHelper.updateUser(updatedUser);
                    dialog.dispose(); // Close the dialog

                }
            }
        });
        // Layout for the dialog
        JPanel panel = new JPanel();
        JLabel nameLabel = new JLabel(":«·«”„");
        nameLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel.add(nameLabel);
        panel.add(nameField);
        JLabel passwordLabel = new JLabel(":«·—ﬁ„ «·”—Ì");
        passwordLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(submitButton);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.setTitle(" ⁄œÌ· «·„” Œœ„");
        dialog.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAll;
    private javax.swing.JButton jButtonDarkMode;
    private javax.swing.JButton jButtonDeleteAllComments;
    private javax.swing.JButton jButtonDownload;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonOverDue;
    private javax.swing.JButton jButtonToCall;
    private javax.swing.JButton jButtonUnderCollection;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelUserNumber;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelAddUser;
    private javax.swing.JPanel jPanelImage;
    private javax.swing.JPanel jPanelParentsGlobal;
    private javax.swing.JPanel jPanelUploadFile;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPaneCommentsForUser;
    private javax.swing.JTabbedPane jTabbedPaneMain;
    private javax.swing.JTable jTableUsers;
    private javax.swing.JTextField jTextFieldUserName;
    private javax.swing.JTextField jTextFieldUserNumber;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Parent> readExcelFileForParents() {
        // Path to the folder containing the Excel files
        String folderPath = "Excel";
        File folder = new File(folderPath);

        // Define date format used in file names
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Ensure the folder exists and is a directory
        if (folder.exists() && folder.isDirectory()) {
            // Get all files in the folder
            File[] files = folder.listFiles(file -> file.isFile() && (file.getName().endsWith(".xlsx") || file.getName().endsWith(".xls")));

            ArrayList<String> fileNames = new ArrayList<>();
            for (File file : files) {
                String date = file.getName().substring(0, file.getName().lastIndexOf("."));
                fileNames.add(date);

            }
            String newestDate = fileNames.stream()
                    .map(date -> LocalDate.parse(date, formatter)) // Convert strings to LocalDate
                    .max(LocalDate::compareTo) // Find the max date
                    .map(date -> date.format(formatter)) // Convert back to string
                    .orElse(null); // Handle the case of an empty list

            ArrayList<Parent> parents = new ArrayList<Parent>();
            try {
                parents = ExcelHelper.getParentsFromSheet(folderPath + "\\" + newestDate + ".xlsx");
//                setTabsData(parents);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Œÿ«¡ ›Ì «·„·›:\n" + ex);
                Logger.getLogger(TheMainTable.class.getName()).log(Level.SEVERE, null, ex);
            }

            return parents;
        }
        return new ArrayList<Parent>();
    }

    private void buildUserCommentsTab() {
        Map<String, ArrayList<Comment>> comments= SearchHelper.getCommentsMapWithUser();
        
        
        
        for (Map.Entry<String, ArrayList<Comment>> entry : comments.entrySet()) {
            String user = entry.getKey();
            ArrayList<Comment> userComments = entry.getValue();
            JPanelUserComments tab = new JPanelUserComments(userComments, this.user, this.parentsAll,this.commentMap);
            this.jTabbedPaneCommentsForUser.addTab(user, tab);
        }

    }
}
