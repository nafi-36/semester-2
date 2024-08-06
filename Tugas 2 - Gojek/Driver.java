class Driver extends Member{
    protected String platNo;
    protected String jenisKendaraan;

    public Driver(String id, String nama, String telepon, String platNo, String jenisKendaraan, Double saldo) {
        super(id, nama, telepon, saldo);
        this.platNo = platNo;
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getPlatNo() {
        return platNo;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDriver{platNo=" + platNo + ", jenisKendaraan=" + jenisKendaraan + "}";
    }
}