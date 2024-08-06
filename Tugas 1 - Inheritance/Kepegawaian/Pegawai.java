class Pegawai {
    protected String nama;
    protected int gajiPokok;
    protected int hariKerja;
    protected int tunjanganTransport;
    
    public Pegawai(String nama, int gajiPokok, int hariKerja, int tunjanganTransport) {
        this.nama = nama;
        this.gajiPokok = gajiPokok;
        this.hariKerja = hariKerja;
        this.tunjanganTransport = tunjanganTransport;
    }

    public String getNama() {
        return nama;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public int getHariKerja() {
        return hariKerja;
    }

    public int getTunjanganTransport() {
        return tunjanganTransport * hariKerja;
    }

    public void hitungGaji() {
        int totalGaji = getGajiPokok() + getTunjanganTransport();
        System.out.println("   Total gaji : " + totalGaji);
    }
}