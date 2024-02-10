/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import kasir.koneksi.koneksi;

/**
 *
 * @author USER
 */
public class ControllerLogin {
    
    DefaultTableModel oke;
    Connection conn;
    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    
    public String tambahAkun(User U){
        String pesan = "";
        String sqlTambah = "INSERT INTO user VALUES (?,?,?,?)";
       
        try{
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlTambah);
            ps.setInt(1, U.getId());
            ps.setString(2, U.getUsername());
            
            ps.setInt(1, U.getId());
            ps.setString(2, U.getUsername());
            ps.setString(3, U.getPassword());
            ps.setString(4, U.getJabatan());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil Disimpan";
            }
           
        }
        catch(Exception e){
            System.out.println("kasir.login.ControllerLogin.tambahAkun()" + e);
        }
        return pesan;
    }
    
    public String loginAkun(String user, String pass){
        String pesan ="";
        
        try{
            String sqlLogin = "SELECT * FROM user WHERE username='"+user+"' AND password='"+pass+"'";
            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sqlLogin);
            if(rs.next()){
               pesan = "Berhasil";
               ViewLogin.label_jabatan.setText(rs.getString("jabatan"));
                
            }
        }
        catch(Exception e){
            System.out.println("kasir.login.ControllerLogin.loginAkun()" + e);
        }
        return pesan;
    }
    
    
   
    
    
    
}
