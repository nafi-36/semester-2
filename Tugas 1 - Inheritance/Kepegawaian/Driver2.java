import java.util.ArrayList;

class Driver2 {
    public static void main(String[] args) {
        ArrayList<Pegawai> ListPegawai = new ArrayList<>();

        int gajiPokok = 1000000;
        int tunjanganTransport = 50000;

        ListPegawai.add(new Manajer("Tono", gajiPokok, 23, tunjanganTransport));
        ListPegawai.add(new Manajer("Joko", gajiPokok, 23, tunjanganTransport));
        ListPegawai.add(new Direktur("Budi", gajiPokok, 24, tunjanganTransport));
        ListPegawai.add(new Staf("Tini", gajiPokok, 20, tunjanganTransport));
        ListPegawai.add(new Staf("Tini", gajiPokok, 20, tunjanganTransport));

        int no = 1;
        for (Pegawai pegawai : ListPegawai) {
            System.out.println(no + ". Nama : " + pegawai.getNama());
            if (pegawai instanceof Direktur) {
                Direktur dir = (Direktur) pegawai;
                System.out.println("   Status : Direktur");
                System.out.println("   Gaji pokok : " + dir.getGajiPokok()*4);
                System.out.println("   Tunjangan transport : " + dir.getTunjanganTransport());
                System.out.println("   Tunjangan kesehatan : " + dir.getTunjanganKesehatan());
                System.out.println("   Tunjangan bensin : " + dir.getTunjunganBensin());
                dir.hitungGaji(); 
            } else if (pegawai instanceof Manajer) {
                Manajer man = (Manajer) pegawai;
                System.out.println("   Status : Manajer");
                System.out.println("   Gaji pokok : " + man.getGajiPokok()*2);
                System.out.println("   Tunjangan transport : " + man.getTunjanganTransport());
                System.out.println("   Tunjangan kesehatan : " + man.getTunjanganKesehatan());
                man.hitungGaji();
            } else {
                Staf sta = (Staf) pegawai;
                System.out.println("   Status : Staf");
                System.out.println("   Gaji pokok : " + sta.getGajiPokok());
                System.out.println("   Tunjangan transport : " + sta.getTunjanganTransport());
                sta.hitungGaji();
            }
            System.out.println("==============================");
            no++;
        }
    }
}