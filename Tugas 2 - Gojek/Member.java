class Member {
    protected String id;
    protected String nama;
    protected String telepon;
    protected Double saldo;
    
    public Member(String id, String nama, String telepon, double saldo) {
        this.id = id;
        this.nama = nama;
        this.telepon = telepon;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Member{id=" + id + ", nama=" + nama + ", saldo=" + saldo + ", telepon=" + telepon + "}";
    }
}
