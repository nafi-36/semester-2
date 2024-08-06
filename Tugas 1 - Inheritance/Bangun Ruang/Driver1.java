import java.util.ArrayList;

class Driver1 {
    public static void main(String[] args) {
        SegiEmpat kotak = new SegiEmpat();
        BujurSangkar bujur = new BujurSangkar();
        Kubus box = new Kubus();
        Balok kayu = new Balok();

        ArrayList<SegiEmpat> BangunList = new ArrayList<>();

        kotak.setPanjang(21);
        kotak.setLebar(4);
        BangunList.add(kotak);

        bujur.setPanjang(8);
        bujur.setLebar(3);
        BangunList.add(bujur);

        box.setTinggi(10);
        BangunList.add(box);

        kayu.setPanjang(17);
        kayu.setLebar(8);
        kayu.setTinggi(45);
        BangunList.add(kayu);

        System.out.println("===== List Bangun =====");
        for(SegiEmpat bangun : BangunList) {
            if (bangun instanceof Kubus) {
                Kubus kbs = (Kubus) bangun;
                System.out.println("Kubus - Volume = " + kbs.Volume());
            } else if (bangun instanceof Balok) {
                Balok blk = (Balok) bangun;
                System.out.println("Balok - Volume = " + blk.Volume());
            } else {
                System.out.println("Segi Empat - Luas = " + bangun.Luas() + " - Keliling = " + bangun.Keliling());
            }
        }
    }
}