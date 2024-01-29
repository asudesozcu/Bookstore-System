/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bookstoreautomation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sozcu
 */
public class ManageCustomer extends javax.swing.JFrame {

    private void refreshTable() {
        Connection connection = null;

        try {
            String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
            connection = DriverManager.getConnection(url, "root", "root");

            // Sorgu hazırlama
            String sql = "SELECT username, name, surname, id FROM customers";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Sorguyu yürütme
            ResultSet resultSet = preparedStatement.executeQuery();

            // jTable1'e veri eklemek için DefaultTableModel kullanma
            DefaultTableModel model = (DefaultTableModel) memberDetailTable.getModel();
            model.setRowCount(0); // Tabloyu temizleme

            // ResultSet'ten verileri okuma ve jTable1'e ekleme
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getString("username"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getInt("id"),};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Bağlantıyı kapatma
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    String[] columnNames = {"Username", "Name", "Surname", "ID"};

    DefaultTableModel model = new DefaultTableModel();

    public ManageCustomer() {

        initComponents();
        model.setColumnIdentifiers(columnNames);
        memberDetailTable.setModel(model);
        refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberDetailTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        BackBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        SpamBtn = new javax.swing.JButton();
        QueryBtn = new javax.swing.JButton();
        QueryBtn1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 248, 232));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(253, 217, 135), 2));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 228, 168));
        jLabel1.setText("Costumer Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        memberDetailTable.setBackground(new java.awt.Color(204, 204, 204));
        memberDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Name", "Surname", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(memberDetailTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("ID : ");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Name : ");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Surname :");

        txtSurname.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("User Name : ");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        BackBtn.setBackground(new java.awt.Color(255, 255, 255));
        BackBtn.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        BackBtn.setText("Back ");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setText("Member Detail");

        SpamBtn.setBackground(new java.awt.Color(255, 255, 255));
        SpamBtn.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        SpamBtn.setText("Spam");
        SpamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpamBtnActionPerformed(evt);
            }
        });

        QueryBtn.setBackground(new java.awt.Color(255, 255, 255));
        QueryBtn.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        QueryBtn.setText("Query");
        QueryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueryBtnActionPerformed(evt);
            }
        });

        QueryBtn1.setBackground(new java.awt.Color(255, 255, 255));
        QueryBtn1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        QueryBtn1.setText("Record Data To File");
        QueryBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueryBtn1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Show All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(323, 323, 323))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QueryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QueryBtn1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(SpamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QueryBtn)
                                .addGap(24, 24, 24)))
                        .addComponent(SpamBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(QueryBtn1)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BackBtn)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        AdminNavigator newp = new AdminNavigator();
        newp.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BackBtnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


    }//GEN-LAST:event_formWindowOpened


    private void SpamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpamBtnActionPerformed
        int selectedRow = memberDetailTable.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Get the ID from the selected row
    int selectedId = Integer.parseInt(model.getValueAt(selectedRow, 3).toString());

    // Remove the book from the ArrayList
    Customer removedcustomer = null;
    for (Customer customer : DataBase.customers) {
        if (customer.getId() == selectedId) {
            removedcustomer = customer;
            break;
        }
    }
    if (removedcustomer != null) {
        DataBase.customers.remove(removedcustomer);
    }

    // Remove the selected row from the JTable
    model.removeRow(selectedRow);

    // Remove the corresponding record from the database
    removeFromDatabase(selectedId); // Pass the customer ID instead of the row index

    JOptionPane.showMessageDialog(this, "Record removed successfully");



    }//GEN-LAST:event_SpamBtnActionPerformed
   private static void removeFromDatabase(int customerId) {
    String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";

    try (Connection connection = DriverManager.getConnection(url, "root", "root")) {

        // Delete the corresponding record from the database
        String sql = "DELETE FROM customers WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customerId);
            preparedStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    private void QueryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueryBtnActionPerformed
        try {
            if (txtID.getText().isEmpty() && txtName.getText().isEmpty() && txtSurname.getText().isEmpty() && txtUsername.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill at least one field", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Initialize SQL query
            StringBuilder sqlQuery = new StringBuilder("SELECT username, name, surname, id FROM customers WHERE ");

            // Build the WHERE clause based on the filled criteria
            if (!txtID.getText().isEmpty()) {
                try {
                    sqlQuery.append("id = ? AND ");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid id format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (!txtUsername.getText().isEmpty()) {
                sqlQuery.append("username = ? AND ");
            }
            if (!txtName.getText().isEmpty()) {
                sqlQuery.append("name = ? AND ");
            }
            if (!txtSurname.getText().isEmpty()) {
                sqlQuery.append("surname = ? AND ");
            }

            // Remove the trailing " AND " if it exists
            if (sqlQuery.toString().endsWith(" AND ")) {
                sqlQuery.setLength(sqlQuery.length() - 5);
            }

            // Prepare the statement
            try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "root");  PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery.toString())) {

                int parameterIndex = 1;

                // Set parameters based on filled criteria
                if (!txtID.getText().isEmpty()) {
                    try {
                        preparedStatement.setInt(parameterIndex++, Integer.parseInt(txtID.getText()));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid ID format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                if (!txtUsername.getText().isEmpty()) {
                    preparedStatement.setString(parameterIndex++, txtUsername.getText());
                }
                if (!txtName.getText().isEmpty()) {
                    preparedStatement.setString(parameterIndex++, txtName.getText());
                }
                if (!txtSurname.getText().isEmpty()) {
                    preparedStatement.setString(parameterIndex++, txtSurname.getText());
                }

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Populate the table model
                DefaultTableModel model = (DefaultTableModel) memberDetailTable.getModel();
                model.setRowCount(0);

                while (resultSet.next()) {
                    model.addRow(new Object[]{
                        resultSet.getString("username"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("id")
                    });
                }

                // Notify the table about the changes
                model.fireTableDataChanged();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error querying the database", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_QueryBtnActionPerformed

    private void QueryBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueryBtn1ActionPerformed
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt"))) {
            // Başlık satırı
            writer.newLine();

            // Kitap bilgileri
            for (Customer customer : DataBase.customers) {
                String line = String.format("%s, %d, %s, %s, %s,%s,%s,%s,%s, %d",
                        customer.getUsername(), customer.getId(), customer.getName(),
                        customer.getSurname(), customer.getEmail(), customer.getPhone(), customer.getPassword(), customer.getAddress(), customer.getGender().toString(), customer.getAge());
                writer.write("Username, ID, Name, Surname, Email ,Phone ,Password ,Address ,Gender ,Age");

                writer.write(line);
                writer.newLine();
                writer.write("------------------");
                writer.newLine();
            }

            System.out.println("Customers written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_QueryBtn1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        refreshTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton QueryBtn;
    private javax.swing.JButton QueryBtn1;
    private javax.swing.JButton SpamBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable memberDetailTable;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
