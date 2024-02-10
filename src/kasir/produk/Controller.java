/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.produk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kasir.koneksi.koneksi;

/**
 *
 * @author USER
 */

public class Controller {
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    DefaultTableModel oke;
    
    public void tampildata(){
      String[] kolom = {"ProdukID","NamaProduk","Harga","Stok"};
        oke = new DefaultTableModel (null,kolom);
        ViewProduk.tabel_produk.setModel(oke);
        
        try{
            String sql = "SELECT * FROM produk ORDER BY ProdukID Asc";
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
             System.out.println("kasir.produk.Controller.tampildata()" + e);
        }
  }
    
    public String tambahdata(Produk P){
        String pesan = "gagal";
    
        try{
            String sqlTambah = "INSERT INTO produk VALUES (?,?,?,?)";
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlTambah);
            ps.setInt(1, P.getId_produk());
            ps.setString(2, P.getNama());
            ps.setBigDecimal(3, P.getHarga());
            ps.setInt(4, P.getStok());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil Disimpan";
            }
            tampildata();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            System.out.println("kasir.Pelanggan.tambahdata()" + e);
        }
        return pesan;
    }
    
    public String edit(Produk P){
        String pesan = "gagal";
    
        try{
            String sqlEdit = "UPDATE produk SET namaProduk = ?, Harga = ?, Stok = ? WHERE ProdukID = ?";
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlEdit);
            ps.setString(1, P.getNama());
            ps.setBigDecimal(2, P.getHarga());
            ps.setInt(3, P.getStok());
            ps.setInt(4, P.getId_produk());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil Diubah";
            }
            tampildata();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            System.out.println("kasir.produk.Controller.edit()" + e);
        }
        return pesan;
    }
    
    public String hapus(Produk P){
        String pesan = "gagal";
    
        try{
            String sqlHapus = "DELETE FROM produk WHERE ProdukID = ?";
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlHapus);
            ps.setInt(1, P.getId_produk());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil Dihapus";
            }
            tampildata();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            System.out.println("kasir.produk.Controller.hapus()" + e);
        }
        return pesan;
    }
//--------------------------------------------------------------------------------------------------------------   
    public void cari(String cari){
      String[] kolom = {"ProdukID","NamaProduk","Harga","Stok"};
        oke = new DefaultTableModel (null,kolom);
        ViewProduk.tabel_produk.setModel(oke);
        
        try{
            String sql = "SELECT * FROM produk WHERE ProdukID LIKE '%"+cari+"%'"
                       + "OR NamaProduk LIKE '%"+cari+"%' ORDER BY ProdukID Asc";

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
             System.out.println("kasir.produk.Controller.cari()" + e);
        }
  }
    
    
}
