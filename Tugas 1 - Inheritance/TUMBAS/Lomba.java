class Lomba {
    protected String id;
    protected String namaKelompok;
    protected String kategori;

    public Lomba(String id, String namaKelompok, String kategori) {
        this.id = id;
        this.namaKelompok = namaKelompok;
        this.kategori = kategori;
    }

    public String getId() {
        return id;
    }

    public String getNamaKelompok() {
        return namaKelompok;
    }

    public String getKategori() {
        return kategori;
    }
}
