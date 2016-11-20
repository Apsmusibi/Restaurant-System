/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Apollo Musibi
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form 
     */
    public Admin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user1 = new javax.swing.JTextField();
        pass1 = new javax.swing.JTextField();
        login1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        login1.setText("login");
        login1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(user1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(pass1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(login1)))
                .addContainerGap(432, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(user1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(login1)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login1ActionPerformed
        
          try {
            String url = "jdbc:mysql://localhost:3306/la bambino?zeroDateTimeBehavior=convertToNull";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/la bambino","root","");
            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            rs = stmt.executeQuery("SELECT* FROM users");
            String user=new String(user1.getText());
            String pwd=new String(pass1.getPassword());
                
            while ( rs.next() ) {
                String uname=rs.getString("Username");
                String password=rs.getString("Password");
                
                if(user.equals(uname)&&pwd.equals(password))
                {
                    new Successful().setVisible(true);      
                }
                
                else if(user!=uname&&pwd!=password)
                        {
                 new Unsuccessful().setVisible(true);
                     }
                else {
JOptionPane.showMessageDialog(this, "Incorrect Username or Password!");
}
            }
            conn.close();
        } 
          catch (Exception e) 
          {
            System.err.println("Got an exception! ");
        }
        
    }
                                        
    }//GEN-LAST:event_login1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login1;
    private javax.swing.JTextField pass1;
    private javax.swing.JTextField user1;
    // End of variables declaration//GEN-END:variables
}
