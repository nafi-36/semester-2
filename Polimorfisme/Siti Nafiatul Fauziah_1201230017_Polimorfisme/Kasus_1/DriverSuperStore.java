import java.util.ArrayList;

class Barang {
    private String kodeBarang;
    private String namaBarang;
    private int harga = 0;
    private int jumlah = 0;

    Barang(String kodeBarang, String namaBarang, int harga, int jumlah) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    Barang(String kodeBarang, String namaBarang, int harga) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
    }

    public String getKodeBarang() {
        return this.kodeBarang;
    }

    public String getNamaBarang() {
        return this.namaBarang;
    }

    public int getHarga() {
        return this.harga;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void infoBarang() {
        System.out.println("Kode 	: " + kodeBarang);
        System.out.println("Nama 	: " + namaBarang);
        System.out.println("Harga 	: " + harga);
        System.out.println("Jumlah  : " + jumlah);
    }
}

class Superstore {
    private ArrayList<Barang> arrBarang = new ArrayList<>();
    private int noItem = 0;

    public void tambahBarang(String kodeBarang, String namaBarang, int harga) {
        System.out.println("\n=== Menambahkan Daftar Barang Baru ===");
        arrBarang.add(new Barang(kodeBarang, namaBarang, harga));
        arrBarang.get(noItem).infoBarang();
        System.out.println("Jumlah barang 0, lakukan penambahan stock sebelum melakukan penjualan");
        noItem++;
    }

    public void tambahBarang(String kodeBarang, String namaBarang, int harga, int jumlah) {
        System.out.println("\n=== Menambahkan Daftar Barang Baru ===");
        arrBarang.add(new Barang(kodeBarang, namaBarang, harga, jumlah));
        arrBarang.get(noItem).infoBarang();
        noItem++;
    }

    public void updateHarga(String kodeBarang, int hargaBaru) {
        System.out.println("\n=== Update Harga Barang ===");
        boolean ketemu = false;
        for (Barang brg : arrBarang) {
            if (brg.getKodeBarang().equals(kodeBarang)) {
                ketemu = true;
                if (hargaBaru > 0) {
                    System.out.println("--- Data awal ---");
                    brg.infoBarang();
                    brg.setHarga(hargaBaru);
                    System.out.println("--- Data baru ---");
                    brg.infoBarang();
                } else {
                    System.out.println("Harga barang harus lebih dari 0");
                }
            }
        }
        if (!ketemu) {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan");
        }
    }

    public void updateHargaJumlah(String kodeBarang, int hargaBaru, int jumlahBaru) {
        System.out.println("\n=== Update Harga dan Jumlah Barang ===");
        boolean ketemu = false;
        for (Barang brg : arrBarang) {
            if (brg.getKodeBarang().equals(kodeBarang)) {
                ketemu = true;
                if (hargaBaru > 0 && jumlahBaru >= 0) {
                    System.out.println("--- Data awal ---");
                    brg.infoBarang();
                    brg.setHarga(hargaBaru);
                    brg.setJumlah(jumlahBaru);
                    System.out.println("--- Data baru ---");
                    brg.infoBarang();
                } else {
                    System.out.println("Harga barang harus lebih dari 0 & jumlah barang minimal harus 0");
                }
            }
        }
        if (!ketemu) {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan");
        }
    }

    public void penjualanBarang(ArrayList<String> kodeBarangTerjual, ArrayList<Integer> jumlahBarangTerjual) {
        System.out.println("\n=== Penjualan Barang ===");
        int totalPenjualan = 0;

        for (int i = 0; i < kodeBarangTerjual.size(); i++) {
            String kodeBarang = kodeBarangTerjual.get(i);
            int jumlahTerjual = jumlahBarangTerjual.get(i);

            for (Barang brg : arrBarang) {
                if (brg.getKodeBarang().equals(kodeBarang)) {
                    if (brg.getJumlah() >= jumlahTerjual) {
                        brg.setJumlah(brg.getJumlah() - jumlahTerjual);
                        int subtotal = brg.getHarga() * jumlahTerjual;
                        totalPenjualan += subtotal;
                        System.out.println(
                                "Barang dengan kode " + kodeBarang + " berhasil terjual sebanyak : " + jumlahTerjual);
                        System.out.println("Total penjualan : " + subtotal);
                    } else {
                        System.out.println("Stok barang dengan kode " + kodeBarang + " tidak mencukupi");
                    }
                }
            }
        }
        System.out.println("==============================================");
        System.out.println("Total penjualan keseluruhan : " + totalPenjualan);
    }

    public void infoStockAllBarang() {
        System.out.println("\n=== Daftar Barang ===");
        if (!arrBarang.isEmpty()) {
            for (Barang brg : arrBarang) {
                System.out.println("\tKode Barang : " + brg.getKodeBarang());
                System.out.println("\tNama Barang : " + brg.getNamaBarang());
                System.out.println("\tHarga       : " + brg.getHarga());
                System.out.println("\tJumlah      : " + brg.getJumlah());
                System.out.println();
            }
        } else {
            System.out.println("Belum ada barang dalam list data");
        }
    }
}

class DriverSuperStore {
    public static void main(String[] args) {
        Superstore st = new Superstore();

        st.tambahBarang("AO1000", "Susu Bendera", 50000);
        st.tambahBarang("BO1000", "Kertas HVS", 28000, 3);
        st.tambahBarang("CO1000", "Kacang Kedelai", 4700, 5);

        st.infoStockAllBarang();

        st.updateHarga("BO1000", 0);
        st.updateHarga("CO1000", 6000);

        st.updateHargaJumlah("AO1000", 52000, 7);

        ArrayList<String> kodeBarangTerjual = new ArrayList<>();
        kodeBarangTerjual.add("AO1000");
        kodeBarangTerjual.add("CO1000");
        kodeBarangTerjual.add("BO1000");
        ArrayList<Integer> jumlahBarangTerjual = new ArrayList<>();
        jumlahBarangTerjual.add(2);
        jumlahBarangTerjual.add(3);
        jumlahBarangTerjual.add(7);
        st.penjualanBarang(kodeBarangTerjual, jumlahBarangTerjual);

        st.infoStockAllBarang();
    }
}