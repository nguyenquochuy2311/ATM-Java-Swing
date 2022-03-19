/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Manager;

import Controller.ManagerController;
import Model.Card;
import View.ATM.*;
import Model.Transaction;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ADMIN
 */
public class TransactionHistory extends javax.swing.JDialog {

    /**
     * Creates new form TransactionHistory
     */
    public TransactionHistory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void getHistoryTransaction(List<Transaction> listTran){
        cardID = listTran.get(0).getCardID();
        DefaultTableModel tableModelTran = (DefaultTableModel)tblHistoryTransaction.getModel();
        tableModelTran.setRowCount(0);
        TableColumnModel tableColumnModel = tblHistoryTransaction.getColumnModel();
        tableColumnModel.getColumn(0).setPreferredWidth(60);
        tableColumnModel.getColumn(1).setPreferredWidth(60);
        tableColumnModel.getColumn(2).setPreferredWidth(180);
        tableColumnModel.getColumn(3).setPreferredWidth(60);
        tblHistoryTransaction.setRowHeight(30);
        for (int i = 0; i < listTran.size(); i++) {
            Transaction t = listTran.get(i);
            Vector row = new Vector<>();
            row.add(t.getCardID());
            row.add(t.getMoney());
            row.add(t.getNote());
            row.add(t.getCreated_at());
            tableModelTran.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistoryTransaction = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbbChangeTime = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LỊCH SỬ GIAO DỊCH");

        tblHistoryTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tài khoản", "Số tiền", "Nội dung", "Thời gian"
            }
        ));
        jScrollPane1.setViewportView(tblHistoryTransaction);

        jLabel2.setText("Thống kê theo");

        cbbChangeTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Hôm nay", "1 tuần", "1 tháng", "1 năm" }));
        cbbChangeTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbChangeTimeMouseClicked(evt);
            }
        });
        cbbChangeTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionThongKeLichSuGD(evt);
            }
        });
        cbbChangeTime.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbbChangeTimePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbChangeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbChangeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actionThongKeLichSuGD(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionThongKeLichSuGD
        ManagerController m = new ManagerController();
        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction = m.ViewHistoryTransactionByTime(cardID, cbbChangeTime.getSelectedIndex());
        DefaultTableModel tableModelTran = (DefaultTableModel)tblHistoryTransaction.getModel();
        tableModelTran.setRowCount(0);
        TableColumnModel tableColumnModel = tblHistoryTransaction.getColumnModel();
        tableColumnModel.getColumn(0).setPreferredWidth(60);
        tableColumnModel.getColumn(1).setPreferredWidth(60);
        tableColumnModel.getColumn(2).setPreferredWidth(180);
        tableColumnModel.getColumn(3).setPreferredWidth(60);
        tblHistoryTransaction.setRowHeight(30);
        for (int i = 0; i < listTransaction.size(); i++) {
            Transaction t = listTransaction.get(i);
            Vector row = new Vector<>();
            row.add(t.getCardID());
            row.add(t.getMoney());
            row.add(t.getNote());
            row.add(t.getCreated_at());
            tableModelTran.addRow(row);
        }
    }//GEN-LAST:event_actionThongKeLichSuGD

    private void cbbChangeTimePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbbChangeTimePropertyChange
        
    }//GEN-LAST:event_cbbChangeTimePropertyChange

    private void cbbChangeTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbChangeTimeMouseClicked
        ManagerController m = new ManagerController();
        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction = m.ViewHistoryTransactionByTime(cardID, cbbChangeTime.getSelectedIndex());
        DefaultTableModel tableModelTran = (DefaultTableModel)tblHistoryTransaction.getModel();
        tableModelTran.setRowCount(0);
        TableColumnModel tableColumnModel = tblHistoryTransaction.getColumnModel();
        tableColumnModel.getColumn(0).setPreferredWidth(60);
        tableColumnModel.getColumn(1).setPreferredWidth(60);
        tableColumnModel.getColumn(2).setPreferredWidth(180);
        tableColumnModel.getColumn(3).setPreferredWidth(60);
        tblHistoryTransaction.setRowHeight(30);
        for (int i = 0; i < listTransaction.size(); i++) {
            Transaction t = listTransaction.get(i);
            Vector row = new Vector<>();
            row.add(t.getCardID());
            row.add(t.getMoney());
            row.add(t.getNote());
            row.add(t.getCreated_at());
            tableModelTran.addRow(row);
        }
    }//GEN-LAST:event_cbbChangeTimeMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TransactionHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                TransactionHistory dialog = new TransactionHistory(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    private BigInteger cardID;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbChangeTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistoryTransaction;
    // End of variables declaration//GEN-END:variables


}
