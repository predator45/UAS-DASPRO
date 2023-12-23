import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Warnet {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menyiapkan beberapa komputer
        List<Komputer> daftarKomputer = new ArrayList<>();
        daftarKomputer.add(new Komputer("K01", 5000));
        daftarKomputer.add(new Komputer("K02", 3000));

        // Membuat objek untuk menyimpan riwayat penyewaan
        RiwayatPenyewaan riwayatPenyewaan = new RiwayatPenyewaan();

        System.out.println("SELAMAT DATANG DI WARNET!");
        System.out.println("-------------");

        do {
            // Menyewa komputer
            System.out.print("Masukkan nama pelanggan: ");
            String namaPelanggan = scanner.nextLine();

            // Menampilkan daftar komputer yang tersedia
            System.out.println("Daftar Komputer Tersedia:");
            for (int i = 0; i < daftarKomputer.size(); i++) {
                Komputer komputer = daftarKomputer.get(i);
                System.out.println((i + 1) + ". " + komputer.nomorKomputer + " - Tarif : Rp " + komputer.tarifPerJam + "/jam");
            }

            // Memilih komputer untuk disewa
            System.out.print("Pilih nomor komputer yang akan disewa: ");
            int nomorPilihan = scanner.nextInt();

            if (nomorPilihan < 1 || nomorPilihan > daftarKomputer.size()) {
                System.out.println("Nomor komputer tidak valid. Program berhenti.");
                return;
            }

            Komputer komputerPilihan = daftarKomputer.get(nomorPilihan - 1);

            // Memasukkan durasi penyewaan
            System.out.print("Masukkan durasi penyewaan (jam): ");
            int jamSewa = scanner.nextInt();

            // Menanyakan waktu tambahan kepada pelanggan
            System.out.print("Apakah Anda ingin menambah waktu penyewaan? (Ya/Tidak): ");
            scanner.nextLine(); // Consuming newline character
            String tambahWaktu = scanner.nextLine();

            if (tambahWaktu.equalsIgnoreCase("Ya")) {
                System.out.print("Masukkan tambahan waktu penyewaan (jam): ");
                int tambahanWaktu = scanner.nextInt();
                jamSewa += tambahanWaktu;
            }

            // Membuat objek penyewaan berdasarkan input pengguna
            Penyewaan penyewaan = new Penyewaan(komputerPilihan, namaPelanggan, jamSewa);

            // Menambahkan penyewaan ke riwayat
            riwayatPenyewaan.tambahPenyewaan(penyewaan);

            // Menampilkan informasi penyewaan
            System.out.println("\nTerima kasih!");
            System.out.println("Pelanggan: " + penyewaan.namaPelanggan);
            System.out.println("Nomor Komputer: " + penyewaan.komputer.nomorKomputer);
            System.out.println("Durasi Sewa: " + penyewaan.jamSewa + " jam");
            System.out.println("Biaya Total: Rp " + penyewaan.hitungBiaya());
            System.out.println("-------------");

            // Mengembalikan komputer dan memperbarui status ketersediaannya
            komputerPilihan.setTersedia(true);

            // Menampilkan riwayat penyewaan
            riwayatPenyewaan.tampilkanRiwayat();

            // Bertanya apakah ingin menyewa lagi
            System.out.print("Apakah Anda ingin menyewa lagi? (Ya/Tidak): ");
            scanner.nextLine(); // Consuming newline character
        } while (scanner.nextLine().equalsIgnoreCase("Ya"));

        // Menampilkan total pendapatan
        System.out.println("TOTAL PENDAPATAN: Rp " + riwayatPenyewaan.hitungTotalPendapatan());

        // Menutup scanner
        scanner.close();
    }
}

