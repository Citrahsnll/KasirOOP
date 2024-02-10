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
import kasir.produk.Produk;

/**
 *
 * @author USER
 */
public class ControllerDetailPenjualan {
    
    DefaultTableModel oke;
    Connection conn;
    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    

    public void tampilDetailPenjualanDua(String id_penjualan){  // TAMPILAN DARI TABEL PRODUK YANG ADA DI PENJUALAN
        
        String[] kolom = {"Produk","Harga","Jumlah","Total"};
        oke = new DefaultTableModel (null,kolom);
        ViewBelanja.tabel_detail_penjualan.setModel(oke);
        
        try{
            String sql = "SELECT detailpenjualan.*, produk.* FROM detailpenjualan INNER JOIN"
                    + " produk ON (detailpenjualan.ProdukID = produk.ProdukID) WHERE penjualanID = '"+id_penjualan+"' ORDER BY DetailID ASC";
            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String[] baris = {
                      rs.getString("NamaProduk"),
                    rs.getString("Harga"),
                    rs.getString("JumlahProduk"),
                    rs.getString("SubTotal")
                };
                oke.addRow(baris);
            }
        }
        catch(Exception e){
             System.out.println("kasir.tampilPenjualan.tampildata()" + e);
        }
        
    }
    
    public void tampilDetailPenjualanBelanja(String id_penjualan){ // TAMPILAN TABEL BELANJA
        
        String[] kolom = {"ID Detail" ,"Produk","Harga","Jumlah","Total","Sisa Stok"};
        oke = new DefaultTableModel (null,kolom);
        ViewBelanja.tabel_detail_belanja.setModel(oke);
        
        try{
            String sql = "SELECT detailpenjualan.*, produk.* FROM detailpenjualan INNER JOIN"
                    + " produk ON (detailpenjualan.ProdukID = produk.ProdukID) WHERE penjualanID = '"+id_penjualan+"' ORDER BY DetailID ASC";
            conn = koneksi.konek();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String[] baris = {
                    rs.getString("DetailID"),
                    rs.getString("NamaProduk"),
                    rs.getString("Harga"),
                    rs.getString("JumlahProduk"),
                    rs.getString("SubTotal"),
                    rs.getString("Stok")
                };
                oke.addRow(baris);
            }
            
        }
        catch(Exception e){
             System.out.println("kasir.tampilPenjualan.tampildata()" + e);
        }
        
    }
    
    public String tambahData(DetailPenjualan DP){
        String pesan = "gagal";
        try{
            
            String sqlTambah = "INSERT INTO detailpenjualan VALUES (?,?,?,?,?)";
            
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlTambah);
            ps.setInt(1,DP.getId_detail());
            ps.setInt(2, DP.getId_penjualan());
            ps.setInt(3,DP.getId_produk());
            ps.setInt(4, DP.getJumlah());
            ps.setBigDecimal(5, DP.getSub_total());
            
            int status = ps.executeUpdate();
            if(status == 1){
                pesan = "Data Berhasil Disimpan";
            }
            tampilDetailPenjualanBelanja(String.valueOf(DP.getId_penjualan()));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            System.out.println("kasir.tambahData.tambahdata()" + e);
        }
        return pesan;
   }
    
     public String hapusItem(String id_detail){
        
        String hasil = "";
        try{
            String sqlTambah = "DELETE FROM detailpenjualan WHERE DetailID = '"+id_detail+"'";
            
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlTambah);
            
            int status = ps.executeUpdate();
            if(status == 1){
                hasil = "Data Berhasil dihapus";
            }
        }
        catch(Exception e){
             System.out.println("kasir.hapusItem.tampildata()" + e);
        }
        
        return hasil;
    }
     
     public String updateStok(Produk P, DetailPenjualan DP){
        String hasil = "";
        try{
            String sqlTambah = "UPDATE produk SET Stok = ? WHERE ProdukID = ?";
            
            conn = koneksi.konek();
            ps = conn.prepareStatement(sqlTambah);
            ps.setInt(1,P.getStok());
            ps.setInt(2,P.getId_produk());
            
            int status = ps.executeUpdate();
            if(status == 1){
                hasil = "Stok berhasil diupdate";
            }
            tampilDetailPenjualanBelanja(String.valueOf(DP.getId_penjualan()));
        }
        catch(Exception e){
             System.out.println("kasir.updateStok.tampildata()" + e);
        }
        
        return hasil;
     }
    
}
