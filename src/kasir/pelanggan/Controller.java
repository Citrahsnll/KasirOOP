/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.pelanggan;

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
      String[] kolom = {"PelangganID","NamaPelanggan","Alamat","NomorTelepon"};
        oke = new DefaultTableModel (null,kolom);
        ViewPelanggan.tabel_pelanggan.setModel(oke);
        
        try{
            String sql = "SELECT * FROM pelanggan ORDER BY PelangganID Asc";
            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String[] baris = {
                    rs.getString("PelangganID"),
                    rs.getString("NamaPelanggan"),
                    rs.getString("Alamat"),
                    rs.getString("NomorTelepon")
                };
                oke.addRow(baris);
            }
        }
        catch(Exception e){
             System.out.println("kasir.pelanggan.Controller.tampildata()" + e);
        }
  }
    
    public String tambahdata(Pelanggan P){
        String pesan = "gagal";
    
        try{
            String sqlTambah = "INSERT INTO pelanggan VALUES (?,?,?,?)";
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlTambah);
            ps.setInt(1, P.getId_pelanggan());
            ps.setString(2, P.getNama());
            ps.setString(3, P.getAlamat());
            ps.setString(4, P.getNo());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil Disimpan";
            }
            tampildata();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            System.out.println("kasir.pelanggan.Controller.tambahdata()" + e);
        }
        return pesan;
    }
    
    public String edit(Pelanggan P){
        String pesan = "gagal";
    
        try{
            String sqlEdit = "UPDATE pelanggan SET NamaPelanggan = ?, Alamat = ?, NomorTelepon = ? WHERE PelangganID = ?";
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlEdit);
            ps.setString(1, P.getNama());
            ps.setString(2, P.getAlamat());
            ps.setString(3, P.getNo());
            ps.setInt(4, P.getId_pelanggan());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil Diubah";
            }
            tampildata();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            System.out.println("kasir.pelanggan.Controller.edit()" + e);
        }
        return pesan;
    }
    
    public String hapus(Pelanggan P){
        String pesan = "gagal";
    
        try{
            String sqlHapus = "DELETE FROM pelanggan WHERE PelangganID = ?";
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlHapus);
            ps.setInt(1, P.getId_pelanggan());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil Dihapus";
            }
            tampildata();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            System.out.println("kasir.pelanggan.Controller.hapus()" + e);
        }
        return pesan;
    }
//--------------------------------------------------------------------------------------------------------------   
    public void cari(String cari){
      String[] kolom = {"PelangganID","NamaPelanggan","Alamat","NomorTelepon"};
        oke = new DefaultTableModel (null,kolom);
        ViewPelanggan.tabel_pelanggan.setModel(oke);
        
        try{
            String sql = "SELECT * FROM pelanggan WHERE PelangganID LIKE '%"+cari+"%'"
                       + "OR NamaPelanggan LIKE '%"+cari+"%' ORDER BY PelangganID Asc";

            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String[] baris = {
                    rs.getString("PelangganID"),
                    rs.getString("NamaPelanggan"),
                    rs.getString("Alamat"),
                    rs.getString("NomorTelepon")
                };
                oke.addRow(baris);
            }
        }
        catch(Exception e){
             System.out.println("kasir.pelanggan.Controller.cari()" + e);
        }
  }
    
}
