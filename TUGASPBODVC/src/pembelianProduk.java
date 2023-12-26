class pembelianProduk extends pembelian implements TotalBayar {

    public pembelianProduk(String noFaktur, String kodeBarang,  String namaPembeli, String noHp, String alamatPelanggan ,String namaProduk, double hargaProduk, int jumlahBeli) {
        super(noFaktur, kodeBarang, namaPembeli, noHp,alamatPelanggan, namaProduk, hargaProduk, jumlahBeli);
    }

    @Override
    public double hitungTotalBayar() {
        return hargaProduk * jumlahBeli;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("TOTAL BAYAR: " + hitungTotalBayar());
        System.out.println("+++++++++++++++++++++");
        System.out.println("Kasir:   ISRA ");
        System.out.println(" TERIMA KASIH TELAH MEMBELI DI TOKO KAMI");
        System.out.println("              -------------       ");
    }
}
