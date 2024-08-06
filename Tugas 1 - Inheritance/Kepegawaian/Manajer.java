class Manajer extends Pegawai {
    protected int tunjanganKesehatan;

    public Manajer(String nama, int gajiPokok, int hariKerja, int tunjanganTransport) {
        super(nama, gajiPokok, hariKerja, tunjanganTransport);
        this.tunjanganKesehatan = 1000000;
    }

    public int getTunjanganKesehatan() {
        return tunjanganKesehatan;
    }

    public void hitungGaji() {
        int totalGaji = (getGajiPokok()*2) + getTunjanganTransport() + getTunjanganKesehatan();
        System.out.println("   Total gaji : " + totalGaji);
    }
}