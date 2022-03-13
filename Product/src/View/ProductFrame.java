/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Service.ProductService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ListProduct;

/**
 *
 * @author FSC
 */
public class ProductFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProductFrame
     */
    public ProductFrame() throws SQLException {
        initComponents();
        DefaultTableModel defaultTableModel;
        ProductService ps = new ProductService();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
        productTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("ID Sản Phẩm");
        defaultTableModel.addColumn("Tên Sản Phẩm");
        defaultTableModel.addColumn("Số Lượng");
        defaultTableModel.addColumn("Giá Tiền");
        setData(ps.getAllListProduct());
    }
    
    private void setData(List<ListProduct> products) throws SQLException {
        DefaultTableModel defaultTableModel;
        ProductService us = new ProductService();
        defaultTableModel = new DefaultTableModel();
        productTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("ID Sản Phẩm");
        defaultTableModel.addColumn("Tên Sản Phẩm");
        defaultTableModel.addColumn("Số Lượng");
        defaultTableModel.addColumn("Giá Tiền");
        for (ListProduct product : products) {
            defaultTableModel.addRow(new Object[]{product.getIdSP(), product.getTenSp(), product.getSoLuong(),
                product.getGiaTien()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(productTable);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("PRODUCT");

        deleteBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        refreshBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        refreshBtn.setText("REFRESH");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        logOutBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        logOutBtn.setText("LOG OUT");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logOutBtn)
                        .addGap(43, 43, 43)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(addBtn)
                        .addGap(31, 31, 31)
                        .addComponent(updateBtn)
                        .addGap(28, 28, 28)
                        .addComponent(refreshBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deleteBtn)
                    .addComponent(refreshBtn)
                    .addComponent(addBtn)
                    .addComponent(logOutBtn)
                    .addComponent(updateBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        ProductService ps = new ProductService();
        int row = productTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(ProductFrame.this, "Vui lòng chọn Sách muốn xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int comfirm = JOptionPane.showConfirmDialog(ProductFrame.this, "Bạn có chắc chắn muốn xóa!");

            if (comfirm == JOptionPane.YES_OPTION) {
                int ID = Integer.valueOf(String.valueOf(productTable.getValueAt(row, 0)));

                try {
                    ps.deleteProduct(ID);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    setData(ps.getAllListProduct());
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        ProductService ps = new ProductService();
        try {
            setData(ps.getAllListProduct());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        new AddFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int row = productTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(ProductFrame.this, "Vui lòng chọn sản phẩm muốn sửa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }else{
            int id = Integer.valueOf(String.valueOf(productTable.getValueAt(row, 0)));
            try {
                new UpdateFrame(id).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        } 
    }//GEN-LAST:event_updateBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
        new Product.SignIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ProductFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JTable productTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}