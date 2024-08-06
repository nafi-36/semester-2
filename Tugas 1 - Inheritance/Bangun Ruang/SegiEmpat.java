class SegiEmpat {
    protected double panjang, lebar;

    public SegiEmpat() {
        panjang = 0;
        lebar = 0;
    }

    public void setPanjang(double p) {
        panjang = p;
    } 

    public void setLebar(double l) {
        lebar = l;
    } 

    public double Luas() {
        return (panjang * lebar);
    }

    public double Keliling() {
        return (2 * (panjang + lebar));
    }
}