import java.util.ArrayList;

class Rekening {
    private String noRekening;
    private double saldo;
    private String namaPemilik;
    private String kartuIdentitas;
    private String namaPerusahaan;
    private String noIzinUsaha;

    Rekening(String noRekening, double saldo, String namaPemilik, String kartuIdentitas) {
        this.noRekening = noRekening;
        this.saldo = saldo;
        this.namaPemilik = namaPemilik;
        this.kartuIdentitas = kartuIdentitas;
    }

    Rekening(String noRekening, double saldo, String namaPerusahaan, String noIzinUsaha, String namaPemilik,
            String kartuIdentitas) {
        this.noRekening = noRekening;
        this.saldo = saldo;
        this.namaPerusahaan = namaPerusahaan;
        this.noIzinUsaha = noIzinUsaha;
        this.namaPemilik = namaPemilik;
        this.kartuIdentitas = kartuIdentitas;
    }

    public String getNoRekening() {
        return this.noRekening;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNamaPemilik() {
        return this.namaPemilik;
    }

    public String getKartuIdentitas() {
        return this.kartuIdentitas;
    }

    public String getNamaPerusahaan() {
        return this.namaPerusahaan;
    }

    public String getNoIzinUsaha() {
        return this.noIzinUsaha;
    }

    public void informasiRekening() {
        System.out.println("Nomor Rekening   : " + this.noRekening);
        System.out.println("Saldo            : " + this.saldo);
        if (this.namaPerusahaan != null && this.noIzinUsaha != null) {
            System.out.println("Nama Perusahaan  : " + this.namaPerusahaan);
            System.out.println("Nomor Izin Usaha : " + this.noIzinUsaha);
        }
        System.out.println("Nama Pemilik     : " + this.namaPemilik);
        System.out.println("Kartu Identitas  : " + this.kartuIdentitas);
    }
}

class Bankers {
    private ArrayList<Rekening> arrRekening = new ArrayList<>();
    private int noItem = 0;

    public void buatRekening(String noRekening, double saldo, String namaPemilik, String kartuIdentitas) {
        System.out.println("\n=== Pembuatan Rekening Perorangan ===");
        arrRekening.add(new Rekening(noRekening, saldo, namaPemilik, kartuIdentitas));
        arrRekening.get(noItem).informasiRekening();
        System.out.println("--- Rekening berhasil dibuat ---");
        noItem++;
    }

    public void buatRekening(String noRekening, double saldo, String namaPerusahaan, String noIzinUsaha,
            String namaPemilik, String kartuIdentitas) {
        System.out.println("\n=== Pembuatan Rekening Korporat ===");
        arrRekening.add(new Rekening(noRekening, saldo, namaPerusahaan, noIzinUsaha, namaPemilik, kartuIdentitas));
        arrRekening.get(noItem).informasiRekening();
        System.out.println("--- Rekening berhasil dibuat ---");
        noItem++;
    }

    public void infoRekening(String noRekening) {
        System.out.println("\n=== Informasi Rekening ===");
        boolean ketemu = false;
        if (!arrRekening.isEmpty()) {
            for (Rekening rekening : arrRekening) {
                if (rekening.getNoRekening().equals(noRekening)) {
                    rekening.informasiRekening();
                    ketemu = true;
                    break;
                }
            }
            if (!ketemu) {
                System.out.println("Rekening dengan no " + noRekening + " tidak ditemukan");
            }
        } else {
            System.out.println("Belum ada rekening yang didaftarkan");
        }
    }

    public void infoSemuaRekening() {
        System.out.println("\n=== Informasi Semua Rekening ===");
        if (!arrRekening.isEmpty()) {
            for (Rekening rekening : arrRekening) {
                rekening.informasiRekening();
                System.out.println();
            }
        } else {
            System.out.println("Belum ada rekening yang didaftarkan");
        }
    }

    public void transfer(String rekeningPengirim, String[] rekeningPenerima, double jumlahTransfer) {
        System.out.println("\n=== Transfer Antar Rekening ===");
        Rekening pengirim = null;
        ArrayList<Rekening> penerima = new ArrayList<>();

        for (Rekening rekening : arrRekening) {
            if (rekening.getNoRekening().equals(rekeningPengirim)) {
                pengirim = rekening;
                break;
            }
        }

        if (pengirim == null) {
            System.out.println("Rekening pengirim tidak ditemukan");
            return;
        }

        int count = 0;
        for (String noRekening : rekeningPenerima) {
            if (count >= 3) {
                System.out.println("Maksimal transfer hanya ke tiga rekening");
                break;
            } else {
                for (Rekening rekening : arrRekening) {
                    if (rekening.getNoRekening().equals(noRekening)) {
                        penerima.add(rekening);
                        count++;
                    }
                }
            }
        }

        double totalTransfer = jumlahTransfer * penerima.size();
        if (pengirim.getSaldo() >= totalTransfer) {
            System.out.println("\n--- Rekening Pengirim ---");
            pengirim.informasiRekening();
            pengirim.setSaldo(pengirim.getSaldo() - totalTransfer);
            System.out.println("-----------------------------");
            System.out.println("Saldo anda sekarang : " + pengirim.getSaldo());
            int no = 1;
            for (Rekening rekening : penerima) {
                System.out.println("\n--- Rekening Penerima " + no + " ---");
                rekening.informasiRekening();
                rekening.setSaldo(rekening.getSaldo() + jumlahTransfer);
                System.out.println("-----------------------------");
                System.out.println("Saldo penerima sekarang : " + rekening.getSaldo());
                no++;
            }
            System.out.println("--- Transfer berhasil ---");
        } else {
            System.out.println("--- Transfer gagal, saldo tidak mencukupi ---");
        }
    }
}

class DriverBankers {
    public static void main(String[] args) {
        Bankers b = new Bankers();

        b.buatRekening("123456", 750000, "Jake", "1234567890");
        b.buatRekening("654321", 600000, "Jane", "1234509876");
        b.buatRekening("789012", 500000, "John", "1230987654");

        b.buatRekening("109876", 1500000, "Indofood", "1A2B345", "Rose", "0987654321");
        b.buatRekening("678901", 2000000, "Ezypay", "3A4B567", "Rey", "0987612345");

        b.infoRekening("109876");
        b.infoRekening("001122");

        String[] rekeningPenerima1 = { "123456", "654321", "789012", "109876" };
        b.transfer("678901", rekeningPenerima1, 100000);

        String[] rekeningPenerima2 = { "789012", "654321" };
        b.transfer("109876", rekeningPenerima2, 150000);

        String[] rekeningPenerima3 = { "678901" };
        b.transfer("123456", rekeningPenerima3, 1000000);

        b.infoSemuaRekening();
    }
}