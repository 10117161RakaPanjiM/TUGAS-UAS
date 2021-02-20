package TugasBesar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class JavaPBO {
    static String user="root";
    static String pwd="";
    static String host="localhost";
    static String db="tugasbesarpbo";
    static String urlValue="";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    public static void main(String[] args) {
        JavaPBO obj = new JavaPBO();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue="jdbc:mysql://"+host+"/"+db+"?user="+user+"&password="+pwd;
            conn = DriverManager.getConnection(urlValue);
            stmt = conn.createStatement();
            Scanner key = new Scanner(System.in);            
            Connection conn = DriverManager.getConnection(urlValue);
            conn.close();
        }
        catch(SQLException e){
            System.out.println("Koneksi Gagal" + e.toString());
        }
        catch(ClassNotFoundException e){
            System.out.println("JBDC Driver Tidak Ditemukan");
        }
        obj.menu_utama();
    }
    
    public void menu_utama(){    
        Scanner key = new Scanner(System.in);
        int pilihan, pilihan1;
        
        
        try {
            do{
                clrscr();
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|            USAHA JUAL BAHAN-BAHAN BAKSO                |");
                System.out.println("|                       JUMADI                           |");
                System.out.println("|                +-------------------+                   |");
                System.out.println("|                |   SELAMAT DATANG  |                   |");
                System.out.println("|                +-------------------+                   |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.println("|             SILAHKAN PILIH MENU DIBAWAH                |");
                System.out.println("|                                                        |");
                System.out.println("|    1. DATA BAHAN                                       |");
                System.out.println("|    2. DATA KARYAWAN                                    |");
                System.out.println("|    3. PENJUALAN                                        |");
                System.out.println("|    4. RESTOK                                           |");
                System.out.println("|                                                        |");
                System.out.println("|    0. KELUAR                                           |");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("");
                System.out.print("  Pilihan Anda : ");
                pilihan = key.nextInt();
                if(pilihan>4 || pilihan < 0){
                    System.out.println("Pilihan Hanya Ada 0/1/2/3/4. Masukkan 0 Untuk Coba Lagi . . .");
                    pilihan1 = key.nextInt();
                }
                else{
                    switch(pilihan){
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            data_bahan();
                            break;
                        case 2:
                            data_karyawan();
                            break;
                        case 3:
                            penjualan();
                            menu_utama();
                            break;
                        case 4:
                            restok();
                            menu_utama();
                    }
                }
            }while(pilihan!=0);
        }
        catch (Exception e) {
        }
    }
    
    public void data_bahan(){
        Scanner key = new Scanner(System.in);
        int pilihandatabahan,pilihandatabahan1;
        
        try {
            do{
                clrscr();
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|                +-------------------+                   |");
                System.out.println("|                |  MENU DATA BAHAN  |                   |");
                System.out.println("|                +-------------------+                   |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.println("|             SILAHKAN PILIH MENU DIBAWAH                |");
                System.out.println("|                                                        |");
                System.out.println("|    1. TAMBAH DATA BAHAN                                |");
                System.out.println("|    2. HAPUS DATA BAHAN                                 |");
                System.out.println("|    3. UBAH DATA BAHAN                                  |");
                System.out.println("|    4. CARI DATA BAHAN                                  |");
                System.out.println("|    5. TAMPIL DATA BARANG                               |");
                System.out.println("|                                                        |");
                System.out.println("|    0. KEMBALI                                          |");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("");
                System.out.print("  Pilihan Anda : ");
                    pilihandatabahan = key.nextInt();
                if(pilihandatabahan>5 || pilihandatabahan < 0){
                    System.out.println("Pilihan Hanya Ada 0/1/2/3/4/5. Masukkan 0 Untuk Coba Lagi . . .");
                    pilihandatabahan1 = key.nextInt();
                }
                else{   
                switch(pilihandatabahan){
                    case 0:
                        menu_utama();
                        break;
                    case 1:
                        tambah_data_bahan();
                        data_bahan();
                        break;
                    case 2:
                        hapus_data_bahan();
                        data_bahan();
                        break;
                    case 3:
                        ubah_data_bahan();
                        data_bahan();
                        break;
                    case 4:
                        cari_data_bahan();
                        data_bahan();
                        break;
                    case 5:
                        tampil_data_bahan();
                        data_bahan();
                        break;
                    }
                }
            }while (pilihandatabahan!=0);
        } 
        catch (Exception e) {
        }
    }
    public void tambah_data_bahan(){
        int pilihan1;
        String nama, satuan, kode_brg, jumlah, harga_satuan;
        Scanner key = new Scanner(System.in);
        do{
            clrscr();
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|            +--------------------------+                |");
            System.out.println("|            |    TAMBAH DATA BAHAN     |                |");
            System.out.println("|            +--------------------------+                |");
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|                                                        |");
            System.out.println("|            SILAHKAN MASUKKAN DATA BARANG               |");
            System.out.println("|                                                        |");
            System.out.print("       MASUKKAN KODE BARANG   : ");
            kode_brg = key.next();
            nama = key.nextLine();
            System.out.print("       MASUKKAN NAMA BARANG   : ");
            nama = key.nextLine();
            System.out.print("       MASUKKAN SATUAN BARANG : ");
            satuan = key.next();
            System.out.print("       MASUKKAN HARGA SATUAN  : ");
            harga_satuan = key.next();
            System.out.print("       MASUKKAN JUMLAH BARANG : ");
            jumlah = key.next();
            System.out.println("|                                                        |");
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("");
            /*Untuk satuan dan harga dijadiin if else*/
            System.out.println("");
            try{
                PreparedStatement ps = null;
                String sqlinput = "INSERT INTO data_bahan(Kode_Barang,Nama_Barang,Satuan,Harga_Satuan,Kuantitas)"+"VALUES (?,?,?,?,?);";
                ps = conn.prepareStatement(sqlinput);
                            ps.setString(1, kode_brg);
                            ps.setString(2, nama);
                            ps.setString(3, satuan);
                            ps.setString(4, harga_satuan);
                            ps.setString(5, jumlah);
                int intbaris = ps.executeUpdate();
                if(intbaris>0){
                    System.out.println("INPUT DATA BERHASIL . . .");
                    System.out.println("");
                }else{
                    System.out.println("INPUT DATA GAGAL . . .");
                    System.out.println("");
                }
                ps.close();
            }catch (Exception e){
            }
            System.out.print("Ingin Memasukkan Data Lagi ? [1/0]");
            System.out.println("1=ya   0=tidak");
            System.out.print("Pilihan Anda ?");
            pilihan1 = key.nextInt();
        }while(pilihan1 != 0);
    }  
    public void hapus_data_bahan(){
        int pilihan1;
        Scanner key = new Scanner(System.in);
        do{
            try{
                clrscr();
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|              +-------------------------+               |");
                System.out.println("|              |    HAPUS DATA BAHAN     |               |");
                System.out.println("|              +-------------------------+               |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.print("    KODE BARANG YANG AKAN DIHAPUS   : " );
                int kode_brg = Integer.parseInt(input.readLine());
                System.out.println("                                                          ");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("");
                System.out.println("");
                String sql = String.format("DELETE FROM data_bahan WHERE Kode_Barang=%d", kode_brg);
                stmt.execute(sql);
                System.out.println("  DATA TELAH TERHAPUS . . .");
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(" Ingin Menghapus Data Lagi ? [1/0]      ");
            System.out.println(" 1=ya   0=tidak                          ");
            System.out.print  (" Pilihan anda ? ");
            pilihan1 = key.nextInt();
        }while(pilihan1 !=0);
    }
    public void ubah_data_bahan(){
        int pilihan1,kode_brg,intbaris;
        String nama, satuan, kode_brg1, jumlah, harga_satuan;
        Scanner key = new Scanner(System.in);
        do{
            clrscr();
            try{
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|              +-------------------------+               |");
                System.out.println("|              |     UBAH DATA BAHAN     |               |");
                System.out.println("|              +-------------------------+               |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.print("       KODE BARANG YANG AKAN DIUBAH  : " );
                kode_brg = key.nextInt();
                String sql = String.format("DELETE FROM data_bahan WHERE Kode_Barang=%d", kode_brg);
                stmt.execute(sql);
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.print("       MASUKKAN KODE BARANG   : ");
                kode_brg1 = key.next();
                nama = key.nextLine();
                System.out.print("       MASUKKAN NAMA BARANG   : ");
                nama = key.nextLine();
                System.out.print("       MASUKKAN SATUAN BARANG : ");
                satuan = key.next();
                System.out.print("       MASUKKAN HARGA SATUAN  : ");
                harga_satuan = key.next();
                System.out.print("       MASUKKAN JUMLAH BARANG : ");
                jumlah = key.next();
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                try{
                    PreparedStatement ps = null;
                    String sqlinput = "INSERT INTO data_bahan(Kode_Barang,Nama_Barang,Satuan,Harga_Satuan,Kuantitas)"+"VALUES (?,?,?,?,?);";
                    ps = conn.prepareStatement(sqlinput);
                            ps.setString(1, kode_brg1);
                            ps.setString(2, nama);
                            ps.setString(3, satuan);
                            ps.setString(4, harga_satuan);
                            ps.setString(5, jumlah);
                    intbaris = ps.executeUpdate();
                    if(intbaris>0){
                        System.out.println("");
                        System.out.println("    UBAH DATA BERHASIL . . .");
                        System.out.println("");
                    }else{
                        System.out.println("");
                        System.out.println("    UBAH DATA GAGAL . . .");
                        System.out.println("");
                    }
                ps.close();
                }catch (Exception e){
                }
            }catch(Exception e){
            }
            System.out.println(" Ingin Mengubah Data Lagi ? [1/0]      ");
            System.out.println(" 1=ya   0=tidak                        ");
            System.out.print  (" Pilihan anda ? ");
            pilihan1 = key.nextInt();
        }while(pilihan1 !=0);
    }
    public void cari_data_bahan(){
        int pilihan,pilihan1;
        int kode =0;
        Scanner key = new Scanner(System.in);
                
        try {
            do{
                clrscr();
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|              +-------------------------+               |");
                System.out.println("|              |     CARI DATA BAHAN     |               |");
                System.out.println("|              +-------------------------+               |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.println("|    CARI BERDASARKAN :                                  |");
                System.out.println("|                                                        |");
                System.out.println("|    1. KODE BAHAN                                       |");
                System.out.println("|    2. NAMA BAHAN                                       |");
                System.out.println("|    3. SATUAN BAHAN                                     |");
                System.out.println("|    0. KEMBALI                                          |");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("");
                System.out.println("");
                System.out.print  (" Pilihan anda ? ");
                pilihan = key.nextInt();
                if(pilihan>3 || pilihan < 0){
                    System.out.println("Pilihan Hanya Ada 0/1/2/3. Masukkan 0 Untuk Coba Lagi . . .");
                    pilihan1 = key.nextInt();
                }
                else{
                    switch(pilihan){
                        case 0:
                            data_bahan();
                            break;
                        case 1:
                            cari_data_bahan_kode();
                            cari_data_bahan();
                            break;
                        case 2:
                            cari_data_bahan_nama();
                            cari_data_bahan();
                            break;
                        case 3:
                            cari_data_bahan_satuan();
                            cari_data_bahan();
                            break;
                    }
                }
            }while(pilihan!=0);
        }
        catch (Exception e) {
        }
    }
    public void cari_data_bahan_kode(){
        String kode_brg;
        int pilihan = 0;
        Scanner key = new Scanner(System.in);
        clrscr();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                                                        |");
        System.out.println("|              +-------------------------+               |");
        System.out.println("|              |     CARI DATA BAHAN     |               |");
        System.out.println("|              +-------------------------+               |");
        System.out.println("|                                                        |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                                                        |");
        System.out.println("|                                                        |");
        System.out.print("     KODE BAHAN YANG DICARI : ");
        kode_brg = key.next();
        System.out.println("|                                                        |");
        System.out.println("|                                                        |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("");
        System.out.println("");
        String sql = String.format("SELECT * FROM data_bahan WHERE Kode_Barang=%s", kode_brg);
        do{
            try{
                rs = stmt.executeQuery(sql);
                String tbl = "| %-11s | %-21s | %-14s | %-12s | %-9s |%n";
                clrscr();
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.println("|                                                                                 |");
                System.out.println("|                             +-------------------+                               |");
                System.out.println("|                             |     DATA BAHAN    |                               |");
                System.out.println("|                             +-------------------+                               |");
                System.out.println("|                                                                                 |");
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.println("| Kode Barang |      Nama Barang      |     Satuan     | Harga Satuan | Kuantitas |");
                System.out.println("+---------------------------------------------------------------------------------+");
                while(rs.next()){
                    kode_brg = rs.getString("Kode_Barang");
                    String nama = rs.getString("Nama_Barang");
                    String satuan = rs.getString("Satuan");
                    String harga_satuan = rs.getString("Harga_Satuan");
                    String jumlah = rs.getString("Kuantitas");
                    System.out.format(tbl, kode_brg, nama, satuan, harga_satuan, jumlah);
                }
                System.out.println("+---------------------------------------------------------------------------------+");
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.print("0. Kembali . . .");
            pilihan = key.nextInt();
        }while(pilihan != 0);
    }
    public void cari_data_bahan_nama(){
        String nama;
        int pilihan = 0;
        Scanner key = new Scanner(System.in);
        clrscr();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                                                        |");
        System.out.println("|              +-------------------------+               |");
        System.out.println("|              |     CARI DATA BAHAN     |               |");
        System.out.println("|              +-------------------------+               |");
        System.out.println("|                                                        |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                                                        |");
        System.out.println("|                                                        |");
        System.out.print("     NAMA BAHAN YANG DICARI : ");
        nama = key.nextLine();
        System.out.println("|                                                        |");
        System.out.println("|                                                        |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("");
        System.out.println("");
        String sql = String.format("SELECT * FROM data_bahan WHERE Nama_Barang ='"+ nama + "'");
        do{
            try{
                rs = stmt.executeQuery(sql);
                String tbl = "| %-11s | %-21s | %-14s | %-12s | %-9s |%n";
                clrscr();
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.println("|                                                                                 |");
                System.out.println("|                             +-------------------+                               |");
                System.out.println("|                             |     DATA BAHAN    |                               |");
                System.out.println("|                             +-------------------+                               |");
                System.out.println("|                                                                                 |");
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.println("| Kode Barang |      Nama Barang      |     Satuan     | Harga Satuan | Kuantitas |");
                System.out.println("+---------------------------------------------------------------------------------+");
                while(rs.next()){
                    String kode_brg = rs.getString("Kode_Barang");
                    nama = rs.getString("Nama_Barang");
                    String satuan = rs.getString("Satuan");
                    String harga_satuan = rs.getString("Harga_Satuan");
                    String jumlah = rs.getString("Kuantitas");
                    System.out.format(tbl, kode_brg, nama, satuan, harga_satuan, jumlah);
                }
                System.out.println("+---------------------------------------------------------------------------------+");
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.print("0. Kembali . . .");
            pilihan = key.nextInt();
        }while(pilihan != 0);
    }
    public void cari_data_bahan_satuan(){
        String satuan;
        int pilihan = 0;
        Scanner key = new Scanner(System.in);
        clrscr();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                                                        |");
        System.out.println("|              +-------------------------+               |");
        System.out.println("|              |     CARI DATA BAHAN     |               |");
        System.out.println("|              +-------------------------+               |");
        System.out.println("|                                                        |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                                                        |");
        System.out.println("|                                                        |");
        System.out.print("     SATUAN BAHAN YANG DICARI : ");
        satuan = key.next();
        System.out.println("|                                                        |");
        System.out.println("|                                                        |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("");
        System.out.println("");
        String sql = String.format("SELECT * FROM data_bahan WHERE Satuan ='"+ satuan + "'");
        do{
            try{
                rs = stmt.executeQuery(sql);
                String tbl = "| %-11s | %-21s | %-14s | %-12s | %-9s |%n";
                clrscr();
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.println("|                                                                                 |");
                System.out.println("|                             +-------------------+                               |");
                System.out.println("|                             |     DATA BAHAN    |                               |");
                System.out.println("|                             +-------------------+                               |");
                System.out.println("|                                                                                 |");
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.println("| Kode Barang |      Nama Barang      |     Satuan     | Harga Satuan | Kuantitas |");
                System.out.println("+---------------------------------------------------------------------------------+");
                while(rs.next()){
                    String kode_brg = rs.getString("Kode_Barang");
                    String nama = rs.getString("Nama_Barang");
                    satuan = rs.getString("Satuan");
                    String harga_satuan = rs.getString("Harga_Satuan");
                    String jumlah = rs.getString("Kuantitas");
                    System.out.format(tbl, kode_brg, nama, satuan, harga_satuan, jumlah);
                }
                System.out.println("+---------------------------------------------------------------------------------+");
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.print("0. Kembali . . .");
            pilihan = key.nextInt();
        }while(pilihan != 0);
    }
    public void tampil_data_bahan(){
        int pilihan1;
        Scanner key = new Scanner(System.in);
        String sql = "SELECT * FROM data_bahan";
        do{
            clrscr();
            try{
                rs = stmt.executeQuery(sql);
                String tbl = "| %-11s | %-21s | %-14s | %-12s | %-9s |%n";
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.println("|                                                                                 |");
                System.out.println("|                             +-------------------+                               |");
                System.out.println("|                             |     DATA BAHAN    |                               |");
                System.out.println("|                             +-------------------+                               |");
                System.out.println("|                                                                                 |");
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.println("| Kode Barang |      Nama Barang      |     Satuan     | Harga Satuan | Kuantitas |");
                System.out.println("+---------------------------------------------------------------------------------+");
                while(rs.next()){
                    String kode_brg = rs.getString("Kode_Barang");
                    String nama = rs.getString("Nama_Barang");
                    String satuan = rs.getString("Satuan");
                    String harga_satuan = rs.getString("Harga_Satuan");
                    String jumlah = rs.getString("Kuantitas");
                    System.out.format(tbl, kode_brg, nama, satuan, harga_satuan, jumlah);
                }
                System.out.println("+---------------------------------------------------------------------------------+");
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.print("0. Kembali . . .");
            pilihan1 = key.nextInt();
        }while(pilihan1!=0);
    }
    
    
    private void data_karyawan(){
        Scanner key = new Scanner(System.in);
        int pilihandatakaryawan,pilihandatakaryawan1;
        
        try {
            do{
            clrscr();
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|                +--------------------+                  |");
            System.out.println("|                | MENU DATA KARYAWAN |                  |");
            System.out.println("|                +--------------------+                  |");
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|                                                        |");
            System.out.println("|             SILAHKAN PILIH MENU DIBAWAH                |");
            System.out.println("|                                                        |");
            System.out.println("|    1. TAMBAH DATA KARYAWAN                             |");
            System.out.println("|    2. HAPUS DATA KARYAWAN                              |");
            System.out.println("|    3. TAMPIL DATA KARYAWAN                             |");
            System.out.println("|                                                        |");
            System.out.println("|    0. KEMBALI                                          |");
            System.out.println("|                                                        |");
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("");
            System.out.print("  Pilihan Anda : ");
            pilihandatakaryawan = key.nextInt();
            if(pilihandatakaryawan>3 || pilihandatakaryawan < 0){
                System.out.println("Pilihan Hanya Ada 0/1/2/3. Masukkan 0 Untuk Coba Lagi . . .");
                pilihandatakaryawan1 = key.nextInt();
            }
            else{
                switch(pilihandatakaryawan){
                    case 0:
                        clrscr();
                        menu_utama();
                        break;
                    case 1:
                        clrscr();
                        tambah_data_karyawan();
                        clrscr();
                        data_karyawan();
                        break;
                    case 2:
                        clrscr();
                        hapus_data_karyawan();
                        clrscr();
                        data_karyawan();
                        break;
                    case 3:
                        clrscr();
                        tampil_data_karyawan();
                        clrscr();
                        data_karyawan();
                        break;
                }
            }
            }while(pilihandatakaryawan!=0);
        }catch (Exception e) {
        }
    }
    public void tambah_data_karyawan(){
        int pilihan1;
        String id,nama,jenkel,alamat,no_hp;
        do{
            clrscr();        
            Scanner key = new Scanner(System.in);
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|            +--------------------------+                |");
            System.out.println("|            |   TAMBAH DATA KARYAWAN   |                |");
            System.out.println("|            +--------------------------+                |");
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|  SILAHKAN MASUKKAN DATA KARYAWAN                       |");
            System.out.println("|                                                        |");
            System.out.print("   MASUKKAN ID KARYAWAN   : ");
            id = key.next();
            nama = key.nextLine();
            System.out.print("   MASUKKAN NAMA KARYAWAN : ");
            nama = key.nextLine();
            System.out.print("   MASUKKAN JENIS KELAMIN : ");
            jenkel = key.next();
            alamat = key.nextLine();
            System.out.print("   MASUKKAN ALAMAT        : ");
            alamat = key.nextLine();
            System.out.print("   MASUKKAN NO HP         : ");
            no_hp = key.next();
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("");
            try{
                PreparedStatement ps = null;
                String sqlinput = "INSERT INTO Data_Karyawan(ID,Nama_Karyawan,Jenis_Kelamin,Alamat,No_HP)"+"VALUES (?,?,?,?,?);";
                ps = conn.prepareStatement(sqlinput);
                            ps.setString(1, id);
                            ps.setString(2, nama);
                            ps.setString(3, jenkel);
                            ps.setString(4, alamat);
                            ps.setString(5, no_hp);
                int intbaris = ps.executeUpdate();
                if(intbaris>0){
                    System.out.println("INPUT DATA BERHASIL . . .");
                    System.out.println("");
                }else{
                    System.out.println("INPUT DATA GAGAL . . .");
                    System.out.println("");
                }
                ps.close();
            }catch (Exception e){
            }
            System.out.println("");
            System.out.print("Ingin Memasukkan Data Lagi ? [1/0]");
            System.out.println("1=ya   0=tidak");
            System.out.print("Pilihan Anda ?");
            pilihan1 = key.nextInt();
        }while(pilihan1 != 0);
    }
    public void hapus_data_karyawan(){
        int pilihan1;
        Scanner key = new Scanner(System.in);
        do{
            clrscr();
            try {
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|            +--------------------------+                |");
                System.out.println("|            |    HAPUS DATA KARYAWAN   |                |");
                System.out.println("|            +--------------------------+                |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.print("    ID KARYAWAN YANG AKAN DIHAPUS : " );
                //id = key.nextInt();
                int id = Integer.parseInt(input.readLine());
                System.out.println("                                         ");
                System.out.println("|                                                        |");
                System.out.println("|                                                        |");
                System.out.println("+--------------------------------------------------------+");
                System.out.println("");
                System.out.println("");
                String sql = String.format("DELETE FROM data_karyawan WHERE ID=%d", id);
                        stmt.execute(sql);
                        System.out.println("DATA TELAH TERHAPUS . . .");
            }catch(Exception e){
                e.printStackTrace();
            }
        System.out.println(" Ingin Menghapus Data Lagi ? [1/0]      ");
        System.out.println(" 1=ya   0=tidak                          ");
        System.out.print  (" Pilihan anda ? ");
        pilihan1 = key.nextInt(); 
        }while(pilihan1 !=0);
    }
    public void tampil_data_karyawan(){
        int pilihan1;
        Scanner key = new Scanner(System.in);
        String sql = "SELECT * FROM data_karyawan";
        do{
            clrscr();
            try{
                rs = stmt.executeQuery(sql);
                String tbl = "| %-11s | %-21s | %-13s | %-39s | %-15s |%n";
                System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                System.out.println("|                                                                                                                 |");
                System.out.println("|                                              +-------------------+                                              |");
                System.out.println("|                                              |   DATA KARYAWAN   |                                              |");
                System.out.println("|                                              +-------------------+                                              |");
                System.out.println("|                                                                                                                 |");
                System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                System.out.println("|     ID      |      Nama Karyawan    | Jenis Kelamin |                 Alamat                  |      No HP      |");
                System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
                while(rs.next()){
                    String id = rs.getString("ID");
                    String nama = rs.getString("Nama_Karyawan");
                    String jenkel = rs.getString("jenis_kelamin");
                    String alamat = rs.getString("alamat");
                    String no_hp = rs.getString("no_hp");
                    System.out.format(tbl, id, nama, jenkel, alamat, no_hp);
                }
                System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.print("0. Kembali . . .");
            pilihan1 = key.nextInt();
        }while(pilihan1!=0);
    }
    
    public void penjualan(){
        int pilihan1;
        int kode=1;
        int id = 0;
        int stok = 1;
        int jumlah1=0;
        int ks=0;
        String kode_brg;
        int kuantitas1;
        int pilihan5;
        String nama_k="";
        do{
            clrscr();        
            Scanner key = new Scanner(System.in);
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|            +--------------------------+                |");
            System.out.println("|            |     PENJUALAN BAHAN      |                |");
            System.out.println("|            +--------------------------+                |");
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|                                                        |");
            System.out.println("|   MASUKKAN DATA BAHAN YANG TERJUAL                     |");
            System.out.println("|                                                        |");
            System.out.print("    KODE BAHAN YANG TERJUAL       : " );
            kode_brg = key.nextLine();
            System.out.print("    JUMLAH BAHAN YANG TERJUAL     : ");
            kuantitas1 = key.nextInt();
            System.out.print("    KARYAWAN                      : ");
            id = key.nextInt    ();
            System.out.println("|                                                        |");
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("");
            System.out.println("");
            try{
                String sql = String.format("SELECT * FROM data_bahan WHERE Kode_Barang=%s", kode_brg);
                rs = stmt.executeQuery(sql);
                int x = 0; 
                int jumlah = 0;
                String nama="";
                String satuan="";
                while(rs.next()){
                    jumlah = rs.getInt("Kuantitas");
                    nama = rs.getString("Nama_Barang");
                    satuan = rs.getString("Satuan");
                    x = jumlah-kuantitas1; 
                }
                if(kuantitas1>jumlah-1){
                    System.out.println("Stok Barang Tidak Mencukupi");
                }
                else{
                    System.out.println("Barang Berhasil Terjual.");
                    System.out.println("Sisa " + nama + " = " + x +" " + satuan+". Transaksi Dilakukan Oleh Karyawan : "+ id );
                    stmt.execute(sql);
                    String sqlu = String.format("UPDATE data_bahan SET Kuantitas="+x+" WHERE Kode_Barang=%s", kode_brg);
                    stmt.execute(sqlu);    
                }
                System.out.println("");
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.print("Apakah ada barang yang terjual lagi ? [1/0]");
            System.out.println("1=ya   0=tidak");
            System.out.print("Pilihan Anda ?");
            pilihan1 = key.nextInt();
        }while(pilihan1 != 0);
    }
    public void restok(){
        int pilihan1;
        int kode=1;
        int stok = 1;
        int jumlah1=0;
        String kode_brg;
        int kuantitas1;
        int x = 0; 
        int jumlah = 0;
        String nama="";
        String satuan="";
        int id=0;
        do{
            clrscr();        
            Scanner key = new Scanner(System.in);
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|            +--------------------------+                |");
            System.out.println("|            |       RESTOK BAHAN       |                |");
            System.out.println("|            +--------------------------+                |");
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|                                                        |");
            System.out.println("|                                                        |");
            System.out.println("|   MASUKKAN DATA BAHAN YANG DI RESTOK                   |");
            System.out.println("|                                                        |");
            System.out.print("    KODE BAHAN YANG DI RESTOK     : " );
            kode_brg = key.nextLine();
            System.out.print("    JUMLAH BAHAN YANG DI RESTOK   : ");
            kuantitas1 = key.nextInt();
            System.out.print("    KARYAWAN                      : ");
            id = key.nextInt();
            System.out.println("|                                                        |");
            System.out.println("|                                                        |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("");
            System.out.println("");
            int pilihan5;
            try{
                String sql = String.format("SELECT * FROM data_bahan WHERE Kode_Barang=%s", kode_brg);
                rs = stmt.executeQuery(sql);
                
                while(rs.next()){
                    jumlah = rs.getInt("Kuantitas");
                    nama = rs.getString("Nama_Barang");
                    satuan = rs.getString("Satuan");
                    x = jumlah+kuantitas1; 
                }
                System.out.println("Barang Berhasil Di Restok.");
                System.out.println("Stok " + nama + " = " + x +" " + satuan + ". Restok Dilakukan Oleh Karyawan : "+ id );
                stmt.execute(sql);
                String sqlu = String.format("UPDATE data_bahan SET Kuantitas="+x+" WHERE Kode_Barang=%s", kode_brg);
                stmt.execute(sqlu);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.print("Apakah ada barang yang akan di restok lagi ? [1/0]");
            System.out.println("1=ya   0=tidak");
            System.out.print("Pilihan Anda ?");
            pilihan1 = key.nextInt();
        }while(pilihan1 != 0);
    }
   
    public void clrscr(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}