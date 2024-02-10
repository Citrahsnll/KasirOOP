/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.login;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ViewRegister extends javax.swing.JFrame {
    private ControllerLogin CL = new ControllerLogin();

    /**
     * Creates new form ViewRegister
     */
    public ViewRegister() {
        initComponents();
        labelmaaf.setVisible(false);
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
        txt_username = new rojerusan.RSMetroTextPlaceHolder();
        txt_pass1 = new rojerusan.RSPasswordTextPlaceHolder();
        txt_pass2 = new rojerusan.RSPasswordTextPlaceHolder();
        labelmaaf = new javax.swing.JLabel();
        btn_daftar = new rojeru_san.RSButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Register", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        txt_username.setForeground(new java.awt.Color(0, 0, 0));
        txt_username.setBorderColor(new java.awt.Color(0, 102, 0));
        txt_username.setBotonColor(new java.awt.Color(255, 51, 51));
        txt_username.setPhColor(new java.awt.Color(0, 0, 0));
        txt_username.setPlaceholder("Masukan Username :");

        txt_pass1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        txt_pass1.setForeground(new java.awt.Color(0, 0, 0));
        txt_pass1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_pass1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_pass1.setPhColor(new java.awt.Color(0, 0, 0));
        txt_pass1.setPlaceholder("Masukan Password :");
        txt_pass1.setSelectionColor(new java.awt.Color(255, 51, 51));

        txt_pass2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        txt_pass2.setForeground(new java.awt.Color(0, 0, 0));
        txt_pass2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_pass2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_pass2.setPhColor(new java.awt.Color(0, 0, 0));
        txt_pass2.setPlaceholder("Masukan Password Sekali Lagi :");
        txt_pass2.setSelectionColor(new java.awt.Color(255, 51, 51));
        txt_pass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pass2KeyReleased(evt);
            }
        });

        labelmaaf.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        labelmaaf.setForeground(new java.awt.Color(255, 0, 0));
        labelmaaf.setText("Maaf password yang anda masukan tidak sama");

        btn_daftar.setBackground(new java.awt.Color(51, 153, 0));
        btn_daftar.setText("DAFTAR AKUN");
        btn_daftar.setColorHover(new java.awt.Color(0, 51, 0));
        btn_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_pass1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_pass2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelmaaf, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_daftar, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txt_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txt_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelmaaf)
                .addGap(66, 66, 66)
                .addComponent(btn_daftar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftarActionPerformed
        // TODO add your handling code here:
        User U = new User();
        U.setUsername(txt_username.getText());
        U.setPassword(txt_pass1.getText());
        U.setJabatan("Adminidtrator");
        
        CL.tambahAkun(U);
        JOptionPane.showMessageDialog(null, "Berhasil Register");
        
        txt_username.setText("");
        txt_pass1.setText("");
        txt_pass2.setText("");
    }//GEN-LAST:event_btn_daftarActionPerformed

    private void txt_pass2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pass2KeyReleased
        // TODO add your handling code here:
        String passwordPertama = txt_pass1.getText();
        String passwordKedua = txt_pass2.getText();
        
        if(!passwordPertama.equals(passwordKedua)){
            labelmaaf.setVisible(true);
            btn_daftar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Gagal Register"); //ini masih salah soalnya blum selesai ngetik langsung gagal
            txt_username.setText("");
            txt_pass1.setText("");
            txt_pass2.setText("");
        }
        else{
            labelmaaf.setVisible(false);
            btn_daftar.setEnabled(true);
        }
        
    }//GEN-LAST:event_txt_pass2KeyReleased

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
            java.util.logging.Logger.getLogger(ViewRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btn_daftar;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel labelmaaf;
    public static rojerusan.RSPasswordTextPlaceHolder txt_pass1;
    public static rojerusan.RSPasswordTextPlaceHolder txt_pass2;
    private rojerusan.RSMetroTextPlaceHolder txt_username;
    // End of variables declaration//GEN-END:variables
}
