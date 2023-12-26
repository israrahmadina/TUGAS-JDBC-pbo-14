import java.text.SimpleDateFormat;
import java.util.Date;

class pembelian {
    protected String noFaktur;
    protected String kodeBarang ;
    protected String namaPembeli;
    protected String noHp;
    protected String alamatPelanggan;
    protected String namaProduk;
    protected double hargaProduk;
    protected int jumlahBeli;

    public pembelian(String noFaktur,String kodeBarang, String namaPembeli, String noHp,  String alamatPelanggan, String namaProduk, double hargaProduk, int jumlahBeli) {
        this.noFaktur = noFaktur;
        this.kodeBarang = kodeBarang;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
        this.alamatPelanggan = alamatPelanggan;
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
        this.jumlahBeli = jumlahBeli;
       
    }

    public void tampilkanInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy 'waktu :' HH:mm:ss z");

        System.out.println(" -------------------------------");
        System.out.println(" SUPER MARKET ISRA RAHMA DINA");
        System.out.println( "tanggal: " + dateFormat.format(new Date()));
        System.out.println("DATA PELANGGAN");
        System.out.println("----------------------------");
        System.out.println("Nama Pelanggan  : " + namaPembeli);
        System.out.println("NoHP            : " + noHp);
        System.out.println("Alamat Pelanggan: " + alamatPelanggan);
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("DATA PEMBELIAN BARANG ");
        System.out.println("-------------------------------- ");
        System.out.println("Nomor Faktur    : " + noFaktur);
        System.out.println("Kode Barang     : " + kodeBarang);
        System.out.println("Nama Barang     : " + namaProduk);
        System.out.println("Harga Barang    : " + hargaProduk);
        System.out.println("Jumlah Beli     : " + jumlahBeli);
        System.out.println("+++++++++++++++++++++++++++++");
    
        
    }
    }


