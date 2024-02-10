/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.detail;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class Penjualan {
    
     private int id_penjualan;
    private Date tgl_penjualan;
    private BigDecimal total_harga;
    
    private int id_pelanggan;
    private String nama_pelanggan; //tamu

    public int getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(int id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public Date getTgl_penjualan() {
        return tgl_penjualan;
    }

    public void setTgl_penjualan(Date tgl_penjualan) {
        this.tgl_penjualan = tgl_penjualan;
    }

    public BigDecimal getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(BigDecimal total_harga) {
        this.total_harga = total_harga;
    }

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }
    
    
    
}
