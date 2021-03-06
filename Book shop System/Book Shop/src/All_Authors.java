
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Classes.*;
import Function.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohmoud
 */
public class All_Authors extends javax.swing.JFrame {

    /**
     * Creates new form All_Authors
     */
    public All_Authors() {
                try {
            initComponents();
            taple.setModel((new Function.Authors().showAll()));
            this.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(Catogeries.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taple = new javax.swing.JTable();
        deleteAuthor = new javax.swing.JToggleButton();
        addBooks = new javax.swing.JToggleButton();
        text4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        text2 = new javax.swing.JTextField();
        updateBooks1 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        text5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnDump = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "الكُتاب ", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        taple.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "المعرف الرقمي للكاتب ", "اسم الكاتب", "بلد المنشأ ", "تاريخ الميلاد"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        taple.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tapleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taple);

        deleteAuthor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteAuthor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel1.png"))); // NOI18N
        deleteAuthor.setText("مسح الكاتب");
        deleteAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAuthorActionPerformed(evt);
            }
        });

        addBooks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/submit.png"))); // NOI18N
        addBooks.setText("اضافة كاتب");
        addBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBooksActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loupe.png"))); // NOI18N
        jButton1.setText("بحث");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("المعرف الرقمي للكاتب");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("اسم الكاتب");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("بلد المنشأ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اسم الكاتب", "بلد المنشأ" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("تاريخ الميلاد");

        text2.setEnabled(false);

        updateBooks1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateBooks1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back...png"))); // NOI18N
        updateBooks1.setText("تحديث معلومه");
        updateBooks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBooks1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Back.png"))); // NOI18N
        jButton3.setText("رجوع");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("الحساب البريدى");

        btnDump.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDump.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel1.png"))); // NOI18N
        btnDump.setText("تفريغ");
        btnDump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDumpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(updateBooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addBooks, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnDump, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(text2)
                    .addComponent(text4)
                    .addComponent(text3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(text5))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)))
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(addBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(text4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnDump, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateBooks1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAuthorActionPerformed
        // TODO add your handling code here:
         String s = String.valueOf(text2.getText());
        if(!s.equals(""))
        {
            try {
                int id = Integer.parseInt(s);
                (new Function.Authors()).delet(id);
                JOptionPane.showMessageDialog(rootPane,"Delet succes");
                btnDumpActionPerformed(evt);
            } catch (SQLException ex) {
                Logger.getLogger(Catogeries.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "selsct category");
        }
        
    }//GEN-LAST:event_deleteAuthorActionPerformed

    private void updateBooks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBooks1ActionPerformed
        // TODO add your handling code here:
        
        Function.Authors aufunction = new Function.Authors();
        Classes.Author au = new Classes.Author();

        if(!(text2.getText().equals("")&&text3.getText().equals("")&&text4.getText().equals(""))){
            try {
                au.setAuthorId(Integer.parseInt(String.valueOf(text2.getText())));
                au.setAuthorName(text3.getText());
                au.setAuthorCity(text4.getText());
                au.setAuthorEmail(text5.getText());
                au.setAuthorDB(jDateChooser1.getDate());
                aufunction.update(au);
                JOptionPane.showMessageDialog(rootPane, "Author update secces");
                taple.setModel((new Function.Authors().showAll()));
            } catch (SQLException ex) {
                Logger.getLogger(Catogeries.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        {
           JOptionPane.showMessageDialog(rootPane, "insert category info ");
        }
    }//GEN-LAST:event_updateBooks1ActionPerformed

    private void addBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBooksActionPerformed
        // TODO add your handling code here:
        
        Function.Authors aufunction = new Function.Authors();
        Classes.Author au = new Classes.Author();

        if(!(text2.getText().equals("")&&text3.getText().equals("")&&text4.getText().equals(""))){
            try {
                //au.setAuthorId(Integer.parseInt(String.valueOf(text2.getText())));
                au.setAuthorName(text3.getText());
                au.setAuthorCity(text4.getText());
                au.setAuthorEmail(text5.getText());
                au.setAuthorDB(jDateChooser1.getDate());
                aufunction.add(au);
                JOptionPane.showMessageDialog(rootPane, "Authour added secces");
                taple.setModel((new Function.Authors().showAll()));
            } catch (SQLException ex) {
                Logger.getLogger(Catogeries.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        {
           JOptionPane.showMessageDialog(rootPane, "insert category info ");
        }
        
    }//GEN-LAST:event_addBooksActionPerformed

    private void tapleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tapleMouseClicked
        int row=taple.getSelectedRow();
        try {
            // TODO add your handling code here:
            int row_num = taple.getSelectedRow();
            Classes.Author au = new Classes.Author();
            au.setAuthorId(Integer.parseInt(String.valueOf(taple.getValueAt(row_num, 0))));
            au = (new Function.Authors()).Showrow(au.getAuthorId());
            text2.setText(String.valueOf(au.getAuthorId()));
            text3.setText(au.getAuthorName());
            text4.setText(au.getAuthorCity());    
            text5.setText(au.getAuthorEmail()); 
            jDateChooser1.setDate(au.getAuthorDB());
        } catch (SQLException ex) {
            Logger.getLogger(Catogeries.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }//GEN-LAST:event_tapleMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        HOME home=new HOME();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{    
            String colmName = "";
            String keysersh = text1.getText();
            if(jComboBox1.getSelectedItem().equals("اسم الكاتب"))
                colmName = "authorName";
            else if(jComboBox1.getSelectedItem().equals("بلد المنشأ"))
                colmName = "authorCity";
            Function.Authors au = new Function.Authors();
            if(!(text1.getText().equals("")))
                taple.setModel(au.sersh(keysersh,colmName));
            else
                JOptionPane.showMessageDialog(rootPane, "please Enter wordto searsh");
        } catch (SQLException ex) {
            Logger.getLogger(Catogeries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDumpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDumpActionPerformed
        try {
            // TODO add your handling code here:
            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");
            jDateChooser1.setDate(null);
            taple.setModel((new Function.Authors().showAll()));
        } catch (SQLException ex) {
            Logger.getLogger(Catogeries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDumpActionPerformed

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
            java.util.logging.Logger.getLogger(All_Authors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(All_Authors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(All_Authors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(All_Authors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new All_Authors().setVisible(false);
                new Log_In().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addBooks;
    private javax.swing.JToggleButton btnDump;
    private javax.swing.JToggleButton deleteAuthor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable taple;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    private javax.swing.JTextField text3;
    private javax.swing.JTextField text4;
    private javax.swing.JTextField text5;
    private javax.swing.JToggleButton updateBooks1;
    // End of variables declaration//GEN-END:variables
}
