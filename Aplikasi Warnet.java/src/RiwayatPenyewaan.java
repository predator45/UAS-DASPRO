import java.util.ArrayList;
import java.util.List;

public class RiwayatPenyewaan {
    List<Penyewaan> riwayat;

    RiwayatPenyewaan() {
        this.riwayat = new ArrayList<>();
    }

    void tambahPenyewaan(Penyewaan penyewaan) {
        riwayat.add(penyewaan);
    }

    void tampilkanRiwayat() {
        System.out.println("RIWAYAT PENYEWAAN");
        for (Penyewaan penyewaan : riwayat) {
            System.out.println("Pelanggan: " + penyewaan.namaPelanggan);
            System.out.println("Nomor Komputer: " + penyewaan.komputer.nomorKomputer);
            System.out.println("Durasi Sewa: " + penyewaan.jamSewa + " jam");
            System.out.println("Biaya Total: Rp " + penyewaan.hitungBiaya());
            System.out.println("-------------");
        }
    }

    double hitungTotalPendapatan() {
        double total = 0;
        for (Penyewaan penyewaan : riwayat) {
            total += penyewaan.hitungBiaya();
        }
        return total;
    }
}


