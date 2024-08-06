class Direktur extends Pegawai {
    protected int tunjanganKesehatan;
    protected int tunjanganBensin;

    public Direktur(String nama, int gajiPokok, int hariKerja, int tunjanganTransport) {
        super(nama, gajiPokok, hariKerja, tunjanganTransport);
        this.tunjanganKesehatan = 2000000;
        this.tunjanganBensin = 500000;
    }

    public int getTunjanganKesehatan() {
        return tunjanganKesehatan;
    }

    public int getTunjunganBensin() {
        return tunjanganBensin;
    }

    public void hitungGaji() {
        int totalGaji = (getGajiPokok()*4) + getTunjanganTransport() + getTunjanganKesehatan() + getTunjunganBensin();
        System.out.println("   Total gaji : " + totalGaji);
    }
}
