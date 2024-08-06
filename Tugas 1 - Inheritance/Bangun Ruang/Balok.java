class Balok extends SegiEmpat {
    protected double tinggi;

    public Balok() {
        super();
        tinggi = 0;
    }

    public void setTinggi(double t) {
        tinggi = t;
    }

    public double Volume() {
        return (panjang * lebar * tinggi);
    }
}