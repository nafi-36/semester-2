class Kubus extends SegiEmpat{
    protected double tinggi;

    public Kubus() {
        super();
        tinggi = 0;
    }

    public void setTinggi(double t) {
        tinggi = t;
    }

    public double Volume() {
        return (tinggi * tinggi * tinggi);
    }
}
