class Algoritma extends Lomba {
    protected int ketepatanHasil;
    protected int waktuEksekusi;
    protected int pemanfaatanResource;

    public Algoritma(String id, String namaKelompok, String kategori) {
        super(id, namaKelompok, kategori);
    }

    public void setKetepatanHasil(int ketepatanHasil) {
        this.ketepatanHasil = ketepatanHasil;
    }

    public int getKetepatanHasil() {
        return ketepatanHasil;
    }

    public void setWaktuEksekusi(int waktuEksekusi) {
        this.waktuEksekusi = waktuEksekusi;
    }

    public int getWaktuEksekusi() {
        return waktuEksekusi;
    } 

    public void setPemanfaatanResource(int pemanfaatanResource) {
        this.pemanfaatanResource = pemanfaatanResource;
    }

    public int getPemanfatanResource() {
        return pemanfaatanResource;
    } 

    public double hitungRataRata() {
        return (ketepatanHasil + waktuEksekusi + pemanfaatanResource) / 3;
    }
}
