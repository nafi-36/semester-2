import java.util.ArrayList;
import java.util.Scanner;

public class Driver3 {
    Scanner scn = new Scanner(System.in);
    ArrayList<Lomba> kelompokLomba = new ArrayList<>();

    public static void main(String[] args) {
        Driver3 d3 = new Driver3();
        d3.menu();
    }

    private void menu() {
        boolean run = true;
        do {
            System.out.println("\n===== TUMBAS APP =====");
            System.out.println("1. Pendaftaran kelompok");
            System.out.println("2. Input nilai hasil");
            System.out.println("3. Cek kelompok dan nilai");
            System.out.println("4. Cek semua kelompok dan nilai rata-rata");
            System.out.println("5. Keluar dari aplikasi");
            System.out.print("Pilih [1-5] : ");
            int jawab = scn.nextInt();
            switch (jawab) {
                case 1:
                    pendaftaranKelompok();
                    break;
                case 2:
                    inputNilai();
                    break;
                case 3:
                    informasiKelompok();
                    break;
                case 4:
                    informasiSemuaKelompok();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    run = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    run = true;
                    break;
            }
        } while (run == true);
    }

    public void pendaftaranKelompok() {
        System.out.println("\n===== Pendaftaran Kelompok =====");
        String id = "k" + (kelompokLomba.size() + 1);
        System.out.print("Masukkan nama kelompok : ");
        String namaKelompok = scn.next();
        for (Lomba kelompok : kelompokLomba) {
            if (kelompok.getNamaKelompok().equals(namaKelompok)) {
                System.out.println("Nama sudah digunakan, masukkan nama yang berbeda");
                return;
            }
        }
        System.out.println("Kategori lomba : 1. UI/UX");
        System.out.println("                 2. Algoritma");
        System.out.println("                 3. Data Processing");
        System.out.print("Pilih kategori lomba [1-3] : ");
        int pilih = scn.nextInt();
        String kategori = "";
        if (pilih == 1) {
            kategori = "UI/UX";
            kelompokLomba.add(new UIUX(id, namaKelompok, kategori));
        } else if (pilih == 2) {
            kategori = "Algoritma";
            kelompokLomba.add(new Algoritma(id, namaKelompok, kategori));
        } else if (pilih == 3) {
            kategori = "Data Processing";
            kelompokLomba.add(new DataProcessing(id, namaKelompok, kategori));
        } else {
            System.out.println("Pilihan tidak valid");
            return;
        }
        System.out.println("Kelompok berhasil didaftarkan");
    }

    public void inputNilai() {
        System.out.println("\n===== Penilaian Lomba =====");
        if (kelompokLomba.isEmpty()) {
            System.out.println("Belum ada kelompok yang terdaftar");
            return;
        }
        System.out.print("Masukkan id kelompok : ");
        String id = scn.next();
        Lomba kelompok = cariIdKelompok(id);
        if (kelompok == null) {
            System.out.println("Kelompok tidak ditemukan");
            return;
        }
        if (kelompok instanceof UIUX) {
            UIUX uiux = (UIUX) kelompok;
            System.out.print("Nilai penjelasan latar belakang dan target produk [1-100] : ");
            int penjelasanProduk = scn.nextInt();
            System.out.print("Nilai skenario penggunaan [1-100] : ");
            int skenarioPenggunaan = scn.nextInt();
            System.out.print("Nilai desain  [1-100] : ");
            int desain = scn.nextInt();
            System.out.print("Nilai konsistensi [1-100] : ");
            int konsistensi = scn.nextInt();
            if (!validNilai(penjelasanProduk) || !validNilai(skenarioPenggunaan) || !validNilai(desain) || !validNilai(konsistensi)) {
                System.out.println("Nilai harus dalam rentang 1-100");
                return;
            }
            uiux.setSkenarioPenggunaan(skenarioPenggunaan);
            uiux.setPenjelasanProduk(penjelasanProduk);
            uiux.setDesain(desain);
            uiux.setKonsistensi(konsistensi);
        } else if (kelompok instanceof Algoritma) {
            Algoritma algoritma = (Algoritma) kelompok;
            System.out.print("Nilai ketepatan hasil [1-100] : ");
            int ketepatanHasil = scn.nextInt();
            System.out.print("Nilai waktu eksekusi [1-100] : ");
            int waktuEksekusi = scn.nextInt();
            System.out.print("Nilai pemanfaatan resource [1-100] : ");
            int pemanfaatanResource = scn.nextInt();
            if (!validNilai(ketepatanHasil) || !validNilai(waktuEksekusi) || !validNilai(pemanfaatanResource)) {
                System.out.println("Nilai harus dalam rentang 1-100");
                return;
            }
            algoritma.setKetepatanHasil(ketepatanHasil);
            algoritma.setWaktuEksekusi(waktuEksekusi);
            algoritma.setPemanfaatanResource(pemanfaatanResource);
        } else if (kelompok instanceof DataProcessing) {
            DataProcessing dataProcessing = (DataProcessing) kelompok;
            System.out.print("Nilai ketepatan hasil [1-100] : ");
            int ketepatanHasil = scn.nextInt();
            System.out.print("Nilai waktu eksekusi [1-100] : ");
            int waktuEksekusi = scn.nextInt();
            System.out.print("Nilai pemanfaatan resource [1-100] : ");
            int pemanfaatanResource = scn.nextInt();
            if (!validNilai(ketepatanHasil) || !validNilai(waktuEksekusi) || !validNilai(pemanfaatanResource)) {
                System.out.println("Penilaian gagal, nilai harus dalam rentang 1-100");
                return;
            }
            dataProcessing.setWaktuEksekusi(waktuEksekusi);
            dataProcessing.setKetepatanHasil(ketepatanHasil);
            dataProcessing.setPemanfaatanResource(pemanfaatanResource);
        } else {
            System.out.println("Kategori lomba tidak valid");
        }
        System.out.println("Penilaian berhasil");
    }

    public void informasiKelompok() {
        System.out.println("\n===== Informasi Nilai Kelompok =====");
        if (kelompokLomba.isEmpty()) {
            System.out.println("Belum ada kelompok yang terdaftar");
            return;
        }
        System.out.print("Masukkan nama kelompok : ");
        String nama = scn.next().toLowerCase();
        Lomba kelompok = cariNamaKelompok(nama);
        if (kelompok == null) {
            System.out.println("Kelompok tidak ditemukan");
            return;
        }
        System.out.println("--- Informasi Kelompok ---");
        System.out.println("Nama kelompok : " + kelompok.getNamaKelompok());
        System.out.println("Kategori lomba : " + kelompok.getKategori());
        System.out.println("--- Hasil Perolehan Nilai ---");
        if (kelompok.getKategori().equals("UI/UX")) {
            UIUX uiux = (UIUX) kelompok;
            System.out.println("1. Penjelasan latar belakang dan target produk : " + uiux.getPenjelasanProduk());
            System.out.println("2. Skenario penggunaan : " + uiux.getSkenarioPenggunaan());
            System.out.println("3. Desain : " + uiux.getDesain());
            System.out.println("4. Konsistensi : " + uiux.getKonsistensi());
        } else if (kelompok.getKategori().equals("Algoritma")) {
            Algoritma algoritma = (Algoritma) kelompok;
            System.out.println("1. Ketepatan hasil : " + algoritma.getKetepatanHasil());
            System.out.println("2. Waktu eksekusi : " + algoritma.getWaktuEksekusi());
            System.out.println("3. Pemanfaatan resource : " + algoritma.getPemanfatanResource());
        } else if (kelompok.getKategori().equals("Data Processing")) {
            DataProcessing dataProcessing = (DataProcessing) kelompok;
            System.out.println("1. Ketepatan hasil : " + dataProcessing.getKetepatanHasil());
            System.out.println("2. Waktu eksekusi : " + dataProcessing.getWaktuEksekusi());
            System.out.println("3. Pemanfaatan resource : " + dataProcessing.getPemanfatanResource());
        }
    }

    public void informasiSemuaKelompok() {
        System.out.println("\n===== Informasi Rata-Rata Semua Kelompok =====");
        if (kelompokLomba.isEmpty()) {
            System.out.println("Belum ada kelompok yang terdaftar");
            return;
        }
        int no = 1;
        for (Lomba kelompok : kelompokLomba) {
            System.out.println(no + ". " + "Nama kelompok : " + kelompok.getNamaKelompok());
            System.out.println("   Kategori lomba : " + kelompok.getKategori());
            if (kelompok instanceof UIUX) {
                UIUX uiux = (UIUX) kelompok;
                System.out.println("   Nilai rata-rata : " + uiux.hitungRataRata());
            } else if (kelompok instanceof Algoritma) {
                Algoritma algoritma = (Algoritma) kelompok;
                System.out.println("   Nilai rata-rata : " + algoritma.hitungRataRata());
            } else if (kelompok instanceof DataProcessing) {
                DataProcessing dataProcessing = (DataProcessing) kelompok;
                System.out.println("   Nilai rata-rata : " + dataProcessing.hitungRataRata());
            }
            no++;
        }
    }

    public Lomba cariIdKelompok(String id) {
        for (Lomba kelompok : kelompokLomba) {
            if (kelompok.getId().equals(id)) {
                return kelompok;
            }
        }
        return null;
    }

    public Lomba cariNamaKelompok(String nama) {
        for (Lomba kelompok : kelompokLomba) {
            if (kelompok.getNamaKelompok().toLowerCase().contains(nama)) {
                return kelompok;
            }
        }
        return null;
    }

    public boolean validNilai(int nilai) {
        return nilai >= 1 && nilai <= 100;
    }
}