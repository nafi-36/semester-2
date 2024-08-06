import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Gojek {
    ArrayList<Member> members = new ArrayList<>();
    public static void main(String[] args) {
        new Gojek().runThis();
    }

    void addDriver(String id, String nama, String telepon, String platNo, String jenisKendaraan, double saldo) {
        System.out.println("\n===== Penambahan Driver =====");
        members.add(new Driver(id, nama, telepon, platNo, jenisKendaraan, saldo));
        System.out.println(members.get(members.size() - 1).toString());
    }

    void addCustomer(String id, String nama, String telepon, double saldo) {
        System.out.println("\n===== Penambahan Customer =====");
        members.add(new Customer(id, nama, telepon, saldo));
        System.out.println(members.get(members.size() - 1).toString());
    }

    int cekId(String id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    void topUpSaldo(String id, double saldo) {
        System.out.println("\n===== Top Up Saldo =====");
        int idx = cekId(id);
        if (idx != -1) {
            System.out.println("----- Data awal -----");
            System.out.println(members.get(idx).toString());
            members.get(idx).setSaldo(members.get(idx).getSaldo() + saldo);
            System.out.println("----- Data akhir -----");
            System.out.println(members.get(idx).toString());
        } else {
            System.out.println("ID : " + id + ". tidak ditemukan");
        }
    }

    void viewCustomer(String id) {
        System.out.println("\n===== View Data Customer =====");
        int idx = cekId(id);
        if (idx != -1 && members.get(idx) instanceof Customer) {
            System.out.println(members.get(idx).toString());
        } else if (idx != -1 && members.get(idx) instanceof Driver) {
            System.out.println("ID : " + id + ". Bukan Customer");
        } else {
            System.out.println("ID : " + id + ". tidak ditemukan");
        }
    }

    void viewDriver(String id) {
        System.out.println("\n===== View Data Driver =====");
        int idx = cekId(id);
        if (idx != -1 && members.get(idx) instanceof Driver) {
            System.out.println(members.get(idx).toString());
        } else if (idx != -1 && members.get(idx) instanceof Customer) {
            System.out.println("ID : " + id + ". Bukan Driver");
        } else {
            System.out.println("ID : " + id + ". tidak ditemukan");
        }
    }

    void transaksi(String idDriver, String idCustomer, double tarif) {
        System.out.println("\n===== Transaksi =====");
        int idxDriver = cekId(idDriver);
        int idxCustomer = cekId(idCustomer);
        if (idxDriver != -1 && idxCustomer != -1 && members.get(idxDriver) instanceof Driver
                && members.get(idxCustomer) instanceof Customer) {
            if (members.get(idxCustomer).getSaldo() >= tarif) {
                System.out.println("Besaran transaksi : " + tarif);
                System.out.println("----- Data lama -----");
                System.out.println(members.get(idxDriver).toString());
                System.out.println(members.get(idxCustomer).toString());
                members.get(idxDriver).setSaldo(members.get(idxDriver).getSaldo() + tarif);
                members.get(idxCustomer).setSaldo(members.get(idxCustomer).getSaldo() - tarif);
                System.out.println("----- Data baru -----");
                System.out.println(members.get(idxDriver).toString());
                System.out.println(members.get(idxCustomer).toString());
                System.out.println("Transaksi selesai dilaksanakan");
            } else {
                System.out.println("Saldo customer tidak mencukupi");
            }
        } else {
            System.out.println("Terdapat kesalahan id");
        }
    }

    void viewTop5Driver() {
        System.out.println("\n===== TOP 5 Driver by Saldo =====");
        ArrayList<Driver> drivers = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof Driver) {
                drivers.add((Driver) member);
            }
        }
        Collections.sort(drivers, new Comparator<Driver>() {
            public int compare(Driver d1, Driver d2) {
                return Double.compare(d2.getSaldo(), d1.getSaldo());
            }
        });
        for (int i = 0; i < Math.min(5, drivers.size()); i++) {
            System.out.println((i + 1) + ". " + drivers.get(i).getNama() + " - Saldo : " + drivers.get(i).getSaldo());
        }
    }

    void viewTop5Customer() {
        System.out.println("\n===== TOP 5 Customer by Saldo =====");
        ArrayList<Customer> customers = new ArrayList<>();
        for (Member member : members) {
            if (member instanceof Customer) {
                customers.add((Customer) member);
            }
        }
        Collections.sort(customers, new Comparator<Customer>() {
            public int compare(Customer c1, Customer c2) {
                return Double.compare(c2.getSaldo(), c1.getSaldo());
            }
        });
        for (int i = 0; i < Math.min(5, customers.size()); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getNama() + " - Saldo : " + customers.get(i).getSaldo());
        }
    }

    void runThis() {
        addDriver("1", "Becky", "0811", "D 1 A", "Motor", 100000);
        addDriver("2", "Adrian", "0812", "B 15 A", "Motor", 50000);
        addDriver("3", "Begra", "0813", "J 45A LHO", "Motor", 0);

        addCustomer("4", "Eva", "0814", 100000);
        addCustomer("5", "Celia", "0815", 0);
        addCustomer("6", "Latjuba", "0816", 200000);
        addCustomer("7", "Lesmana", "0817", 0);

        topUpSaldo("1", 150000);
        topUpSaldo("3", 50000);
        topUpSaldo("4", 250000);
        topUpSaldo("5", 450000);
        topUpSaldo("6", 150000);
        topUpSaldo("9", 150000);

        viewDriver("1");
        viewDriver("3");
        viewDriver("4");

        viewCustomer("1");
        viewCustomer("4");
        viewCustomer("5");
        viewCustomer("8");

        transaksi("1", "4", 50000);
        transaksi("3", "5", 50000);
        transaksi("4", "5", 50000);
        transaksi("1", "2", 50000);

        viewTop5Driver();
        viewTop5Customer();
    }
}