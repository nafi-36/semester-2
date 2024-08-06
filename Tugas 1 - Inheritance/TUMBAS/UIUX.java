class UIUX extends Lomba {
    protected int penjelasanProduk;
    protected int skenarioPenggunaan;
    protected int desain;
    protected int konsistensi;

    public UIUX(String id, String namaKelompok, String kategori) {
        super(id, namaKelompok, kategori);
    }

    public void setPenjelasanProduk(int penjelasanProduk) {
        this.penjelasanProduk = penjelasanProduk;
    }

    public int getPenjelasanProduk() {
        return penjelasanProduk;
    }

    public void setSkenarioPenggunaan(int skenarioPenggunaan) {
        this.skenarioPenggunaan = skenarioPenggunaan;
    }

    public int getSkenarioPenggunaan() {
        return skenarioPenggunaan;
    }

    public void setDesain(int desain) {
        this.desain = desain;
    }

    public int getDesain() {
        return desain;
    }

    public void setKonsistensi(int konsistensi) {
        this.konsistensi = konsistensi;
    }

    public int getKonsistensi() {
        return konsistensi;
    }

    public double hitungRataRata() {
        return (penjelasanProduk + skenarioPenggunaan + desain + konsistensi) / 4;
    }
}
