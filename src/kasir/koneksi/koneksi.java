/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class koneksi {
    
     public static Connection konek(){
        Connection konek = null;
        try{
            String url = "jdbc:mysql://localhost:3306/kasir";
            String user = "root";
            String pass ="";
            konek = DriverManager.getConnection(url, user, pass);
           
        }
        catch(Exception e){
            System.out.println("kasir.koneksi.konek()" + e);
          JOptionPane.showMessageDialog(null, "koneksi gagal");
        }
       return konek; 
}
    
}
