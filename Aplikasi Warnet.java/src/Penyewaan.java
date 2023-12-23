public class Penyewaan {
    Komputer komputer;
    String namaPelanggan;
    int jamSewa;

    Penyewaan(Komputer komputer, String namaPelanggan, int jamSewa) {
        this.komputer = komputer;
        this.namaPelanggan = namaPelanggan;
        this.jamSewa = jamSewa;
        komputer.setTersedia(false); // Komputer tidak lagi tersedia setelah disewa
    }

    double hitungBiaya() {
        return komputer.tarifPerJam * jamSewa;
    }
}

