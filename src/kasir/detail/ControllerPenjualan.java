/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.detail;

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
public class ControllerPenjualan {
    
    DefaultTableModel oke;
    Connection conn;
    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    

    public void tampilPenjualan(){
        
        String[] kolom = {"PenjualanID","TanggalPenjualan","TotalHarga","PelangganID"};
        oke = new DefaultTableModel (null,kolom);
        ViewBelanja.tabel_penjualan.setModel(oke);
        
        try{
            String sql = "SELECT * FROM penjualan ORDER BY PenjualanID ASC";
            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String[] baris = {
                    rs.getString("PenjualanID"),
                    rs.getString("TanggalPenjualan"),
                    rs.getString("TotalHarga"),
                    rs.getString("PelangganID")
                };
                oke.addRow(baris);
            }
        }
        catch(Exception e){
             System.out.println("kasir.tampilPelanggan.tampildata()" + e);
        }
        
    }
    
   public void cariData(String cari){
       
        String[] kolom = {"PenjualanID","TanggalPenjualan","TotalHarga","PelangganID"};
        oke = new DefaultTableModel (null,kolom);
        ViewBelanja.tabel_penjualan.setModel(oke);
        
        try{
            String sql = "SELECT * FROM penjualan WHERE PenjualanID LIKE '%"+cari+"%' ORDER BY PenjualanID ASC";
            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String[] baris = {
                    rs.getString("PenjualanID"),
                    rs.getString("TanggalPenjualan"),
                    rs.getString("TotalHarga"),
                    rs.getString("PelangganID")
                };
                oke.addRow(baris);
            }
        }
        catch(Exception e){
             System.out.println("kasir.cariData.tampildata()" + e);
        }
   }
    
   public String tambahData(Penjualan P){
        String pesan = "gagal";
        try{
            
            String sqlTambah = "INSERT INTO penjualan VALUES (?,?,?,?)";
            
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlTambah);
            ps.setInt(1, P.getId_penjualan());
            ps.setDate(2, P.getTgl_penjualan());
            ps.setBigDecimal(3,P.getTotal_harga());
            ps.setInt(4, P.getId_pelanggan());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil Disimpan";
            }
            tampilPenjualan();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            System.out.println("kasir.tambahData.tambahdata()" + e);
        }
        return pesan;
   }
   
   public String updateData(Penjualan P){
        String pesan = "gagal";
        try{
            
            String sqlTambah = "UPDATE penjualan SET TotalHarga = ? WHERE PenjualanID = ?";
            
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlTambah);
            ps.setBigDecimal(1, P.getTotal_harga());
            ps.setInt(2,P.getId_penjualan());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil diubah";
            }
            tampilPenjualan();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal diubah");
            System.out.println("kasir.updateData.tambahdata()" + e);
        }
        return pesan;
   }
   
   public String hapusData(Penjualan P){
        String pesan = "gagal";
        try{
            
            String sqlTambah = "DELETE FROM penjualan WHERE PenjualanID = ?";
            
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlTambah);
            ps.setInt(1, P.getId_penjualan());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil dihapus";
            }
            
            tampilPenjualan();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal diubah");
            System.out.println("kasir.hapusData.tambahdata()" + e);
        }
        return pesan;
   }
    


//tamu
    public String tampil_pelangganID(){
        String tampil = "";
        try{
            String sql = "SELECT * FROM pelanggan";
            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                ViewBelanja.combo_id_pel.addItem(rs.getString("PelangganID"));
            }
        }
        catch(Exception e){
             System.out.println("kasir.tampilPelanggan.tampildata()" + e);
        }
         return tampil;
    }
    
    public String tampil_tamu(String id){
        String tampil = "";
        try{
            String sql = "SELECT * FROM pelanggan WHERE PelangganID='"+id+"'";
            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                tampil =  rs.getString("NamaPelanggan");
            }
        }
        catch(Exception e){
             System.out.println("kasir.tampilPelanggan.tampildata()" + e);
        }
        
         return tampil;
    }
    
}
