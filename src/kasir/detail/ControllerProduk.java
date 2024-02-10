/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.detail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import kasir.koneksi.koneksi;

/**
 *
 * @author USER
 */
public class ControllerProduk {
    
    DefaultTableModel oke;
    Connection conn;
    ResultSet rs;
    Statement st;
//    PreparedStatement ps;
    
    public void tampilProduk(){
        
        String[] kolom = {"ProdukID","NamaProduk","Harga","Stok"};
        oke = new DefaultTableModel (null,kolom);
        ViewBarang.tabel_produk.setModel(oke);
        
        try{
            String sql = "SELECT * FROM produk ORDER BY ProdukID ASC";
            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String[] baris = {
                    rs.getString("ProdukID"),
                    rs.getString("NamaProduk"),
                    rs.getString("Harga"),
                    rs.getString("Stok")
                };
                oke.addRow(baris);
            }
        }
        catch(Exception e){
             System.out.println("kasir.Produk.tampildata()" + e);
        }
        
    }
    
}
